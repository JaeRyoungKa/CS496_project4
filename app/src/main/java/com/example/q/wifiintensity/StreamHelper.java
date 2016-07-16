package com.example.q.wifiintensity;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by q on 2016-07-05.
 */
public class StreamHelper {

    public static String readIt(InputStream stream) throws IOException {
        String ret = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"));
        String text;
        while ((text = reader.readLine()) != null) {
            ret += text;
        }
        return ret;
    }

}
