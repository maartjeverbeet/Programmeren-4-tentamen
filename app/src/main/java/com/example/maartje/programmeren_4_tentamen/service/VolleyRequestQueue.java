package com.example.maartje.programmeren_4_tentamen.service;

import android.content.Context;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;

/**
 * Created by maartje on 16-6-2017.
 */

public class VolleyRequestQueue {
    private static VolleyRequestQueue mInstance;
    private RequestQueue mRequestQueue;
    private static Context mCtx;

    /**
     * private constructor - kan niet van 'buiten af' worden aangeroepen
     * Deze constructie hoort bij het Singleton pattern.
     *
     * @param context
     */
    private VolleyRequestQueue(Context context) {
        mCtx = context;
        mRequestQueue = getRequestQueue();
    }

    /**
     * Static methode die één enkele instantie van deze class beheert.
     *
     * @param context
     * @return
     */
    //constructor
    // als instance null is maakt hij een nieuwe aan
    // is hij niet meer nul krijg je de bestaande waarde terug.
    public static synchronized VolleyRequestQueue getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new VolleyRequestQueue(context);
        }
        return mInstance;
    }

    //wachtrij opvragen
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.

            Cache cache = new DiskBasedCache(mCtx.getCacheDir(), 10 * 1024 * 1024);
            Network network = new BasicNetwork(new HurlStack());
            // mRequestQueue = Volley.newRequestQueue(mCtx.getApplicationContext());
            mRequestQueue = new RequestQueue(cache, network);
            mRequestQueue.start();
        }
        return mRequestQueue;
    }

    //request toevoegen aan de wachtrij
    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
