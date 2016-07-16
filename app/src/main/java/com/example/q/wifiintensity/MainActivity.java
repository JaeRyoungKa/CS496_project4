package com.example.q.wifiintensity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intent = new Intent(this,GetWifiIntensity.class);

        Button Button00 = (Button) findViewById(R.id.button00);
        Button Button01 = (Button) findViewById(R.id.button01);
        Button Button02 = (Button) findViewById(R.id.button02);
        Button Button03 = (Button) findViewById(R.id.button03);
        Button Button10 = (Button) findViewById(R.id.button10);
        Button Button13 = (Button) findViewById(R.id.button13);
        Button Button20 = (Button) findViewById(R.id.button20);
        Button Button23 = (Button) findViewById(R.id.button23);
        Button Button30 = (Button) findViewById(R.id.button30);
        Button Button33 = (Button) findViewById(R.id.button33);
        Button Button40 = (Button) findViewById(R.id.button40);
        Button Button41 = (Button) findViewById(R.id.button41);
        Button Button42 = (Button) findViewById(R.id.button42);
        Button Button43 = (Button) findViewById(R.id.button43);
        Button Button50 = (Button) findViewById(R.id.button50);
        Button Button53 = (Button) findViewById(R.id.button53);
        Button Button60 = (Button) findViewById(R.id.button60);
        Button Button63 = (Button) findViewById(R.id.button63);
        Button Button70 = (Button) findViewById(R.id.button70);
        Button Button71 = (Button) findViewById(R.id.button71);
        Button Button72 = (Button) findViewById(R.id.button72);
        Button Button73 = (Button) findViewById(R.id.button73);
        Button Button80 = (Button) findViewById(R.id.button80);
        Button Button83 = (Button) findViewById(R.id.button83);
        Button Button90 = (Button) findViewById(R.id.button90);
        Button Button93 = (Button) findViewById(R.id.button93);
        Button Button100 = (Button) findViewById(R.id.button100);
        Button Button101 = (Button) findViewById(R.id.button101);
        Button Button102 = (Button) findViewById(R.id.button102);
        Button Button103 = (Button) findViewById(R.id.button103);

        Button00.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","00"); startActivity(intent);}});
        Button01.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","01"); startActivity(intent);}});
        Button02.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","02"); startActivity(intent);}});
        Button03.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","03"); startActivity(intent);}});
        Button10.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","10"); startActivity(intent);}});
        Button13.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","13"); startActivity(intent);}});
        Button20.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","20"); startActivity(intent);}});
        Button23.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","23"); startActivity(intent);}});
        Button30.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","30"); startActivity(intent);}});
        Button33.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","33"); startActivity(intent);}});
        Button40.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","40"); startActivity(intent);}});
        Button41.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","41"); startActivity(intent);}});
        Button42.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","42"); startActivity(intent);}});
        Button43.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","43"); startActivity(intent);}});
        Button50.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","50"); startActivity(intent);}});
        Button53.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","53"); startActivity(intent);}});
        Button60.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","60"); startActivity(intent);}});
        Button63.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","63"); startActivity(intent);}});
        Button70.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","70"); startActivity(intent);}});
        Button71.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","71"); startActivity(intent);}});
        Button72.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","72"); startActivity(intent);}});
        Button73.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","73"); startActivity(intent);}});
        Button80.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","80"); startActivity(intent);}});
        Button83.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","83"); startActivity(intent);}});
        Button90.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","90"); startActivity(intent);}});
        Button93.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","93"); startActivity(intent);}});
        Button100.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","100"); startActivity(intent);}});
        Button101.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","101"); startActivity(intent);}});
        Button102.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","102"); startActivity(intent);}});
        Button103.setOnClickListener(new View.OnClickListener() {public void onClick(View v) {intent.putExtra("place","103"); startActivity(intent);}});


    }
}
