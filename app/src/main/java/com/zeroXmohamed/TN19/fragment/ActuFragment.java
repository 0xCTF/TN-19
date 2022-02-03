package com.zeroXmohamed.TN19.fragment;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.zeroXmohamed.TN19.R;


public class ActuFragment extends Fragment {


    // url to fetch shopping items
    private static final String URL = "https://arcg.is/1KqGDa";

    private ProgressBar loading;
    private TextView t;
    private WebView siteView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.fragment_tn, container, false);
        t = (TextView) view.findViewById(R.id.tn);
        loading=view.findViewById(R.id.charge);
        siteView = (WebView) view.findViewById(R.id.www);
        WebSettings webSettings = siteView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        WebView.setWebContentsDebuggingEnabled(true);
        // JSInterface api = new JSInterface();
        // siteView.addJavascriptInterface(api, "api");
        siteView.getSettings().setBuiltInZoomControls(false);
        siteView.getSettings().setUseWideViewPort(true);
        siteView.setInitialScale(90);
//        siteView.setWebChromeClient(new WebChromeClient() {
//            @Override
//            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
//                String imgDataUrl= consoleMessage.message();
//
//                if (imgDataUrl.contains("found at: ")) {
//                    int aa=Integer.parseInt(imgDataUrl.substring(10));
//                    Log.d("testsd", String.valueOf(aa+1));
//                    SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
//                    SharedPreferences.Editor editor = pref.edit();
//                    editor.putInt("index", aa+1); // Storing integer
//                    editor.commit(); // commit changes
//
//                }
//                return super.onConsoleMessage(consoleMessage);
//            }
//        });
        siteView.setVisibility(View.GONE);

        siteView.setWebViewClient(new WebViewClient() {

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)

            @Override
            public void onLoadResource(WebView view, String url) {

                if (url.contains("World_Basemap")) {
                siteView.evaluateJavascript("document.querySelector(\"#ember31\").remove();\n" +
                        "document.querySelector(\"#ember77\").remove();\n" +
                        "document.querySelector(\"#ember82\").click();\n" +
                        "document.querySelector(\"#ember68\").click();\n" +
                        "document.querySelector(\"#ember53\").remove();\n" +
                        "document.querySelector(\"#ember91\").remove();", null);

                loading.setVisibility(View.GONE);
                siteView.setVisibility(View.VISIBLE);
            }}


        });

        // mWebView settings...

        // Load URL
        siteView.loadUrl(URL);

        return view;

    }


}
