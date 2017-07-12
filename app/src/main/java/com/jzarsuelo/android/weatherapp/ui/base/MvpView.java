package com.jzarsuelo.android.weatherapp.ui.base;

/**
 * Created by Pao on 12/7/17.
 */

public interface MvpView {

    /**
     * Helper method to display error messages
     *
     * @param message Message to display
     */
    void onError(String message);

    /**
     * Helper method to display messages
     *
     * @param message Message to display
     */
    void showMessage(String message);

    /**
     * Helper method to display no network message
     */
    void showNoNetworkMessage();

    /**
     * Helper method to setup the view
     */
    void setUp();

    /**
     * Helper method to display the ProgressBar
     */
    void showLoading();

    /**
     * Helper method to hide the ProgressBar
     */
    void hideLoading();

    /**
     * Helper method to check if the device is currently connected to internet
     */
    boolean isNetworkConnected();
}
