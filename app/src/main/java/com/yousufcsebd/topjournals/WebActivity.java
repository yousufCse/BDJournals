package com.yousufcsebd.topjournals;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

public class WebActivity extends Activity {
    private WebView webView;
    private ProgressBar progress;
    private TextView tvPercent;
    private TextView tvPaperName;
    private String url;
    private String newspapwerName;
    private boolean isOnline;

    android.app.FragmentManager manager;
    MyAlertDialog alertDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getActionBar().hide();



        manager = getFragmentManager();
        alertDialog = new MyAlertDialog();


        // init
        tvPercent = (TextView) findViewById(R.id.tvPercent);
        tvPaperName = (TextView) findViewById(R.id.tvPaperName);
        webView = (WebView) findViewById(R.id.webView);

        progress = (ProgressBar) findViewById(R.id.progressBar);
        progress.setMax(100);
        progress.setBackgroundColor(Color.WHITE);


        Intent i = getIntent();
        url = i.getStringExtra(PopularFragment.SITE_NAME); // get site name
        newspapwerName = i.getStringExtra(PopularFragment.NP_NAME); // get newspaper name
        tvPaperName.setText(newspapwerName.toUpperCase());


//        L.d("Websites" + url);

        isOnline = haveInternet();

        if (!isOnline) {
            alertDialog.show(manager, "MYDialog");
        } else {
            loadBrowser();
        }


    }

    // load url
    private void loadBrowser() {
        webView.setWebViewClient(new MyWebViewClient());
        webView.setWebChromeClient(new MyWebChromeClient());
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(true);
        webView.setInitialScale(1);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setUseWideViewPort(true);

        webView.loadUrl(url);
        progress.setProgress(0);
        // other code
        webView.getSettings().setAllowFileAccess(true);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setAllowFileAccess(true);
        webSettings.setTextSize(WebSettings.TextSize.NORMAL);

    }

    // WebViewClient Class
    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            progress.setVisibility(View.VISIBLE);
            tvPercent.setVisibility(View.VISIBLE);
            progress.bringToFront();
            tvPercent.bringToFront();
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            progress.setVisibility(View.INVISIBLE);
            tvPercent.setVisibility(View.INVISIBLE);
        }
    }

    // WebVeiw Chrome Class
    private class MyWebChromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            setValue(newProgress);
            super.onProgressChanged(view, newProgress);
        }
    }

    // setValue method
    public void setValue(int progress) {
        this.progress.setProgress(progress);
        if (progress < 90)
            tvPercent.setText("Loading " + progress + "%");
        else tvPercent.setText("Loading Done");
    }


    // button back click
    public void btnBackClick(View v) {
        webView.goBack();
        L.ts(this, "Backward");
    }

    // button forward click
    public void btnForwordClick(View v) {
        webView.goForward();
        L.ts(this, "Forward");

    }

    // button reload click
    public void btnRefreshClick(View v) {
        boolean isNetOn = haveInternet();
        if (!isNetOn) {
            alertDialog.show(manager, "MYALERTDIALOG");
        } else {
            webView.reload();
            L.ts(this, "Reloading");
        }
    }

    // button stop click
    public void btnStopClick(View view) {
        webView.stopLoading();
        L.ts(this, "Stop loading");

    }

    // button back click
    public void btnHomeClick(View v) {
        finish();
        L.ts(this, "Home");

    }

    // internet connection check
    private boolean haveInternet() {
        NetworkInfo info = ((ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo();
        if (info == null || !info.isConnected()) {
            return false;
        }
        if (info.isRoaming()) {
            // here is the roaming option you can change it if you want to disable internet while roaming, just return false
            return true;
        }
        return true;
    } // end


    @SuppressLint("ValidFragment")
    public  class MyAlertDialog extends DialogFragment {
        public MyAlertDialog(){

        }

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {

            AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
            builder.setTitle("No Internet Connection");
            builder.setCancelable(true);

            builder.setPositiveButton("SETTINGS", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent = new Intent(Settings.ACTION_SETTINGS);
                    startActivity(intent);
                }
            });

            builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dismiss();
                    finish();
//                    finishActivityMe();
                }
            });

            Dialog dialog = builder.create();
            return dialog;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (haveInternet()){
//            loadBrowser();
        } else {
            android.app.FragmentManager m = getFragmentManager();
            alertDialog = new MyAlertDialog();
            alertDialog.show(m, "MYALERTDIALOG");

        }
    }

    // back button press
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()) {
            webView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }




    @Override
    protected void onDestroy() {
        super.onDestroy();
        webView.clearHistory();
        webView.clearCache(true);
//        L.d("clear history and cache");
    }

    // save state
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        webView.saveState(outState);
    }

    // restore state
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    // finish
    private void finishActivityMe() {
        finish();
    }


}
