package com.example.retrofitexercise;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Async extends AsyncTask<String,Void,String> {
    @Override
    protected String doInBackground(String... strings) {
        HttpURLConnection httpURLConnection = null ;
        BufferedReader bufferedReader = null ;
        try {

            URL url = new URL(strings[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.connect();

            InputStream inputStream = httpURLConnection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            String nextLine;
            StringBuffer data = new StringBuffer();

            while ((nextLine = bufferedReader.readLine())!=null){
                data.append(nextLine);
            }

            return data.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(httpURLConnection!=null){
                httpURLConnection.disconnect();
            }
        }
        return null;
    }
}
