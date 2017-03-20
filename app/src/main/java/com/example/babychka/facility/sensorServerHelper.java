package com.example.babychka.facility;

import android.content.Context;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by Alec on 2017-03-18.
 */

public class sensorServerHelper {
    private int counter;    //Contains the lastest number of entries returned by the sensor
    private String url= "http://192.168.0.110:80";  //URL of the server.
    private RequestQueue queue; //RequestQueue initilization

    public void receive(Context context){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        String buffer = "";
                        for (int i=0; i<response.length(); i++) {
                            if(Character.isDigit(response.charAt(i)))
                            {
                                buffer += ""+response.charAt(i);
                            }
                        }
                        counter = Integer.parseInt(buffer);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        getRequestQueue(context).add(stringRequest);
    }
    public RequestQueue getRequestQueue(Context context) {
        if (queue == null) {
            Cache cache = new DiskBasedCache(context.getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            queue = new RequestQueue(cache, network);
            // Don't forget to start the volley request queue
            queue.start();
        }
        return queue;
    }
    public int getCounter()
    {
        return counter;
    }
}
