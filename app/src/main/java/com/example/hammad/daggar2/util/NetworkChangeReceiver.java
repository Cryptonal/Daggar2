package com.example.hammad.daggar2.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import timber.log.Timber;

public class NetworkChangeReceiver extends BroadcastReceiver {

    public static ConnectivityReceiverListener connectivityReceiverListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (connectivityReceiverListener != null) {
            if (NetworkUtils.isNetworkConnected(context)) {
                // Do something
                connectivityReceiverListener.onNetworkConnectionChanged(true);
                Timber.d("Network Available");
            } else {
                connectivityReceiverListener.onNetworkConnectionChanged(false);
                Timber.d("Network Not Available");
            }
        }
    }

    public interface ConnectivityReceiverListener {
        void onNetworkConnectionChanged(boolean isConnected);
    }

}
