package com.yousufcsebd.topjournals;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Yousuf on 23-07-16.
 */
public class L {
    public static void d(String s) {
        Log.d("www.d.com", s);
    }

    public static void t(Context c, String m) {
        Toast.makeText(c, m, Toast.LENGTH_LONG).show();
    }

    public static void ts(Context c, String m) {
        final Toast toast = Toast.makeText(c, m, Toast.LENGTH_SHORT);
        toast.show();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                toast.cancel();
            }
        }, 200);
    }
}
