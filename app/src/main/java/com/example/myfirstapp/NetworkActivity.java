package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NetworkActivity extends AppCompatActivity implements DownloadCallback {

    // Keep a reference to the NetworkFragment, which owns the AsyncTask object
    // that is used to execute network ops.
    private NetworkFragment networkFragment;

    // Boolean telling us whether a download is in progress, so we don't trigger overlapping
    // downloads with consecutive button clicks.
    private boolean downloading = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //...
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        networkFragment = NetworkFragment.getInstance(getSupportFragmentManager(), "http://demo5614099.mockable.io/timeline");
    }

    /** Called when the user taps the Send button */
    public void doRequest(View view) {
        startDownload();
    }
    private void startDownload() {
        if (!downloading && networkFragment != null) {
            // Execute the async download.
            networkFragment.startDownload();
            downloading = true;
        }
    }

    @Override
    public void updateFromDownload(Object result) {
        TextView textView = findViewById(R.id.responseText);
        textView.setText((String)result);
    }

    @Override
    public NetworkInfo getActiveNetworkInfo() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo;
    }

    @Override
    public void onProgressUpdate(int progressCode, int percentComplete) {
        switch(progressCode) {
            // You can add UI behavior for progress updates here.
            case Progress.ERROR:
            //...
                break;
            case Progress.CONNECT_SUCCESS:
          //  ...
                break;
            case Progress.GET_INPUT_STREAM_SUCCESS:
            //...
                break;
            case Progress.PROCESS_INPUT_STREAM_IN_PROGRESS:
            //...
                break;
            case Progress.PROCESS_INPUT_STREAM_SUCCESS:
            //...
                break;
        }
    }

    @Override
    public void finishDownloading() {
        downloading = false;
        if (networkFragment != null) {
            networkFragment.cancelDownload();
        }
    }
}
