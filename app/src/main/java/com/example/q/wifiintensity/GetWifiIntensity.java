package com.example.q.wifiintensity;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by q on 2016-07-16.
 */
public class GetWifiIntensity extends AppCompatActivity {
    WifiManager wifi;
    String placeinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.get_wifi);

// Assume thisActivity is the current activity
        int permissionCheck = ContextCompat.checkSelfPermission(GetWifiIntensity.this,Manifest.permission.ACCESS_COARSE_LOCATION);
        // No explanation needed, we can request the permission.

        ActivityCompat.requestPermissions(GetWifiIntensity.this,new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},2);

        Intent intent= new Intent(this.getIntent());
        placeinfo = intent.getStringExtra("place");
        TextView current_session = (TextView) findViewById(R.id.current_session);
        current_session.setText(placeinfo);

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 2: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Button gauge = (Button) findViewById(R.id.gauge);
                    gauge.setOnClickListener(new View.OnClickListener(){
                        public void onClick(View v){
                            Toast.makeText(GetWifiIntensity.this,"접속중입니다.",Toast.LENGTH_SHORT).show();
                            initializeWiFiListener();
                        }
                    });

                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    private void initializeWiFiListener(){
        String connectivity_context = Context.WIFI_SERVICE;
        wifi = (WifiManager)getSystemService(connectivity_context);

        if(!wifi.isWifiEnabled()){
            if(wifi.getWifiState() != WifiManager.WIFI_STATE_ENABLING){
                wifi.setWifiEnabled(true);
            }
        }
        wifi.startScan();
        registerReceiver(new BroadcastReceiver(){

            @Override
            public void onReceive(Context context, Intent intent) {
         //       WifiInfo info = wifi.getConnectionInfo();
                List list = wifi.getScanResults();

                JSONObject obj = new JSONObject();
                try {
                    JSONArray jArray = new JSONArray();//배열이 필요할때
                    for (int i = 0; i < list.size(); i++)//배열
                    {
                        JSONObject sObject = new JSONObject();//배열 내에 들어갈 json
                        ScanResult temp = (ScanResult) list.get(i);
                        sObject.put("BSSID", temp.BSSID);
                        sObject.put("level", temp.level);
                        jArray.put(sObject);
                    }
                    obj.put("data", jArray);//배열을 넣음
                    obj.put("zone", Integer.parseInt(placeinfo)); // String to Integer

                    new SendMSGTask().execute(obj);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

        }, new IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION));
    }

    public class SendMSGTask extends AsyncTask<JSONObject, Void, Void> {

        String rawURL;

        @Override
        protected Void doInBackground(JSONObject... params) {

            rawURL = "http://oortcloud.ddns.net:8080";
            putJSON(params[0]);

            return null;
        }

        public void putJSON(JSONObject jobj) {
            OutputStream os = null;
            InputStream is = null;

            int len = 0;
            try {
                len = jobj.toString().getBytes("UTF-8").length;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            try {
                URL url = new URL(rawURL);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(5000 /* milliseconds */);
                conn.setConnectTimeout(1000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoOutput(true);
                conn.setFixedLengthStreamingMode(len);
                os = conn.getOutputStream();
                OutputStreamWriter wrt = new OutputStreamWriter(os, "UTF-8");
                Log.i("LogCat", "[SEND]ENCODING: " + wrt.getEncoding());
                Log.i("LogCat", "[SEND]JSON RAW: " + jobj.toString());
                wrt.write(jobj.toString());
                wrt.flush();
                conn.connect();
                int response = conn.getResponseCode();
                is = conn.getInputStream();
                String contentAsString = StreamHelper.readIt(is);
                Log.i("LogCat", "[SEND]RESPOND : " + contentAsString);
                os.close();
                is.close();
            } catch (MalformedURLException e) {
                Log.i("LogCat", "[SEND]FAILED TO CONNECT by MalformedURLException");
            } catch (IOException e) {
                Log.i("LogCat", "[SEND]FAILED TO CONNECT by IOException");
                Log.i("LogCat", e.toString());
            }
        }

    }
}
