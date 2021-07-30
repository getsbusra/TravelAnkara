package com.example.travelAnkara.Model;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public class HttpHandler {

    public HttpHandler() {

    }

    public String makeServiceCall(String requestUrl) {
        String response = null;


        try {
            URL url = new URL(requestUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            InputStream in = new BufferedInputStream(connection.getInputStream());
            response = convertStreamToString(in);


        }catch (MalformedURLException e) {
            Log.e("ERROR","MalFormedException: " + e.getMessage());

        }catch(IOException e) {
            Log.e("ERROR","IOException: " + e.getMessage());

        }catch(Exception e) {
            Log.e("ERROR","Exception: " + e.getMessage());

        }
        return response;
    }

    private String convertStreamToString(InputStream in) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder stringBuilder = new StringBuilder();
        String line;

        try{
            while((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

        }catch(IOException e) {
            Log.e("Error","convertStreamToString" + e.getMessage());

        }finally{
            try{
                in.close();
            }catch(Exception e) {
                Log.e("Error","convertStreamToString: " + e.getMessage());

            }

        }

        return stringBuilder.toString();
    }
}
