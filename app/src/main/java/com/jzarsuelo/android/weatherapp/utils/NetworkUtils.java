package com.jzarsuelo.android.weatherapp.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Utility class to check if the device have internet connection
 */

public class NetworkUtils {

    /**
     * Prevent creating an instance of this class
     */
    private NetworkUtils() {
    }

    public static boolean isNetworkConnected(Context context) {

        ConnectivityManager cm =
                (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();

        return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
    }
}
