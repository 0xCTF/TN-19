package com.zeroXmohamed.TN19.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.widget.ContentLoadingProgressBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JavascriptInterface;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

import com.zeroXmohamed.TN19.Movie;
import com.zeroXmohamed.TN19.app.MyApplication;
import com.zeroXmohamed.TN19.R;

public class StoreFragment extends Fragment {

    private static final String TAG = StoreFragment.class.getSimpleName();

    // url to fetch shopping items
    private static final String URL = "https://www.worldometers.info/coronavirus/";

    private RecyclerView recyclerView;
    private TextView mise,c,d,r,total,Nc,de,Nde,tR,cA,crit,t1m;
    private WebView siteView;
    private ProgressBar l,l1,l2,l3,l4,l5,l6,l7;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

    }

    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


     /*   class JSInterface {
            @JavascriptInterface

            public void getNom(String nomEtd) {

                Toast.makeText(getContext(),nomEtd, Toast.LENGTH_LONG).show();
                SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0);

                SharedPreferences.Editor editor = pref.edit();
                editor.putString("nom", nomEtd);
                editor.commit();
            }}*/

        // Inflate the layout for this fragment
//        siteView = (WebView) recyclerView.findViewById(R.id.wb);

        View view = inflater.inflate(R.layout.fragment_store, container, false);
        mise = (TextView) view.findViewById(R.id.maj);
        c = (TextView) view.findViewById(R.id.cas);
        d = (TextView) view.findViewById(R.id.death);
        Nc = (TextView) view.findViewById(R.id.casN);
        de = (TextView) view.findViewById(R.id.dead);
        Nde = (TextView) view.findViewById(R.id.Ndead);
        tR = (TextView) view.findViewById(R.id.Totrec);
        cA = (TextView) view.findViewById(R.id.act);
        crit = (TextView) view.findViewById(R.id.cri);
        t1m = (TextView) view.findViewById(R.id.tot1m);

        r = (TextView) view.findViewById(R.id.recover);
        total = (TextView) view.findViewById(R.id.tot);
        l=view.findViewById(R.id.loadingPanel);
        l1=view.findViewById(R.id.loadingPanel1);
        l2=view.findViewById(R.id.loadingPanel12);
        l3=view.findViewById(R.id.loadingPanel3);
        l4=view.findViewById(R.id.loadingPanel4);
        l5=view.findViewById(R.id.loadingPanel5);
        l6=view.findViewById(R.id.loadingPanel6);
        l7=view.findViewById(R.id.loadingPanel7);

        siteView = (WebView) view.findViewById(R.id.wb);
        WebSettings webSettings = siteView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
      webSettings.setDomStorageEnabled(true);
       WebView.setWebContentsDebuggingEnabled(true);
       // JSInterface api = new JSInterface();
       // siteView.addJavascriptInterface(api, "api");
      siteView.getSettings().setBuiltInZoomControls(true);
       siteView.getSettings().setUseWideViewPort(true);
        siteView.setInitialScale(100);
        siteView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Log.d("yowyow", consoleMessage.message());
                               /* byte[] decodedString = Base64.decode(imgDataUrl, Base64.DEFAULT);
                Bitmap bitMap = BitmapFactory.decodeByteArray(decodedString, 0, decodedString.length);

                imageView1.setImageBitmap(bitMap);*/

                return super.onConsoleMessage(consoleMessage);
            }
        });
        siteView.setWebViewClient(new WebViewClient() {



            @Override
            public void onPageFinished(final WebView view, final String url) {
               //maj date
                siteView.evaluateJavascript("document.querySelector(\"#page-top+ div , .maincounter-number , #maincounter-wrap+ #maincounter-wrap h1 , #maincounter-wrap:nth-child(7) h1\").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {
                        String a=s.replaceAll("^\"|\"$", "");

                        mise.setText(a.substring(14,a.length()));
                       // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

                    }
                });
                //N cas
                siteView.evaluateJavascript("document.querySelector(\"#maincounter-wrap > div > span\").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String h) {
                        c.setText(h.replaceAll("^\"|\"$", ""));
                       // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

                    }
                });
                //N morts
                siteView.evaluateJavascript("document.querySelector(\"#maincounter-wrap:nth-child(9) div   \").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String a) {
                        d.setText(a.replaceAll("^\"|\"$", ""));
                     //   Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

                    }
                });
                //N recovered
                siteView.evaluateJavascript("document.querySelector(\"#maincounter-wrap:nth-child(10) div   \").innerText", new ValueCallback<String>() {
                    @Override

                    public void onReceiveValue(String b) {
                        r.setText(b.replaceAll("^\"|\"$", ""));
                    //    Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();

                    }
                });
                //cas total TN
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(81) > td.sorting_1\").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l.setVisibility(View.GONE);
                            total.setText("0");

                        }else{
                            l.setVisibility(View.GONE);
                            total.setText(z.replaceAll("^\"|\"$", ""));
                            // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                        }

                    }
                });
                //NV Cas
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(3)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")) {
                            l1.setVisibility(View.GONE);
                            Nc.setText("0 ");
                        }else{
                            l1.setVisibility(View.GONE);
                            Nc.setText(z.replaceAll("^\"|\"$", ""));
                            // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                        }

                    }
                });
                //Tot death
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(4)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l2.setVisibility(View.GONE);
                            de.setText("0");

                        }else{
                            de.setText(z.replaceAll("^\"|\"$", ""));
                            l2.setVisibility(View.GONE);
                    }}
                });
                //New Death
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(5)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l3.setVisibility(View.GONE);
                            Nde.setText("0");
                        }else{
                            l3.setVisibility(View.GONE);
                            Nde.setText(z.replaceAll("^\"|\"$", ""));
                    }}
                });
                //Total rec
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(6)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l4.setVisibility(View.GONE);
                            tR.setText("0");
                        }else{
                            l4.setVisibility(View.GONE);
                            tR.setText(z.replaceAll("^\"|\"$", ""));
                        }}
                });
                //Active cases
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(7)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l5.setVisibility(View.GONE);
                            cA.setText("0");
                        }else{
                            l5.setVisibility(View.GONE);
                            cA.setText(z.replaceAll("^\"|\"$", ""));
                        }}
                });
                //Cri
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(8)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l6.setVisibility(View.GONE);
                            crit.setText("0");
                        }else{
                            l6.setVisibility(View.GONE);
                            crit.setText(z.replaceAll("^\"|\"$", ""));
                        }}
                });
                //tot/1m
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries > tbody:nth-child(2) > tr:nth-child(79) > td:nth-child(9)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if(z.equals("\"\"")){
                            l7.setVisibility(View.GONE);
                            t1m.setText("0");
                        }else{
                            l7.setVisibility(View.GONE);
                            t1m.setText(z.replaceAll("^\"|\"$", ""));
                        }}
                });
            }
        });

        // mWebView settings...

        // Load URL
        siteView.loadUrl(URL);
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        String date=pref.getString("res", null); // getting String

        return view;

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void init() {

        /*openURL();
       mise = view.findViewById(R.id.maj);
        SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        String date=pref.getString("nom", null); // getting String
        Toast.makeText(getContext(), date, Toast.LENGTH_LONG).show();
        mise.setText(date);*/
    }
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void openURL() {
        //siteView.setVisibility(View.GONE);
//
//        WebSettings webSettings = siteView.getSettings();
//        webSettings.setJavaScriptEnabled(true);
//        webSettings.setAllowUniversalAccessFromFileURLs(true);
//        webSettings.setDomStorageEnabled(true);
//        WebView.setWebContentsDebuggingEnabled(true);
//
//        siteView.getSettings().setBuiltInZoomControls(true);
//        siteView.getSettings().setUseWideViewPort(true);
//        siteView.setInitialScale(100);
//        JSInterface api = new JSInterface();
//        siteView.addJavascriptInterface(api, "api");
//        siteView.setWebViewClient(new WebViewClient() {
//            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
//            @Override
//            public void onPageFinished(final WebView view, String url) {
//
//                siteView.loadUrl("javascript:api.getDate(document.querySelector(\"#_5b7c80a619-199-2 > div:nth-child(2) > div.col-md-8 > div > div:nth-child(5)\").innerText)");
//
//
//
//
//
//            }
//
//        });
//        siteView.loadUrl(URL);
//
//    }


}}