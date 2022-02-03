package com.zeroXmohamed.TN19.fragment;


import android.annotation.SuppressLint;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.zeroXmohamed.TN19.R;
import com.zeroXmohamed.TN19.Splash;
import com.zeroXmohamed.TN19.StockService;

import java.util.Locale;

public class StatFragment extends Fragment {

    private static final String TAG = StatFragment.class.getSimpleName();
    int n=1;

    // url to fetch shopping items
    private static final String URL = "https://www.worldometers.info/coronavirus/";
    int i=0;
    //private RecyclerView recyclerView;
    private TextView mise,c,d,r,total,Nc,de,Nde,tR,cA,crit,t1m;
    private WebView siteView;
    private SwipeRefreshLayout ref;
    private ProgressBar l,l1,l2,l3,l4,l5,l6,l7;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }


    @SuppressLint("WrongViewCast")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

//
//        Fragment currentFragment = getFragmentManager().findFragmentByTag("fragg");
//        FragmentTransaction fragTransaction = getFragmentManager().beginTransaction();
//        fragTransaction.detach(currentFragment);
//        fragTransaction.attach(currentFragment);
//        fragTransaction.commit();
        SharedPreferences e = getContext().getSharedPreferences("Settings", Splash.MODE_PRIVATE);
        String language = e.getString("My_Lang", "My_Lang");
        //String languageToLoad  = "ar"; // your language
        Log.d("sdsdfsdfdsf", language);

        View view = inflater.inflate(R.layout.fragment_stat, container, false);

        if (language.equals("ar")) {
             view = inflater.inflate(R.layout.fragment_stat_ar, container, false);
        }



        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getContext().getResources().updateConfiguration(config,
                getContext().getResources().getDisplayMetrics());




        mise = (TextView) view.findViewById(R.id.maj);
        ref=view.findViewById(R.id.str);
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
        ref.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.detach(StatFragment.this).attach(StatFragment.this).commit();            }
        });
        if (i == 0){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(StatFragment.this).attach(StatFragment.this).commit();}
        i++;
        siteView = (WebView) view.findViewById(R.id.wb);
        WebSettings webSettings = siteView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
      webSettings.setDomStorageEnabled(true);
       WebView.setWebContentsDebuggingEnabled(true);
       // JSInterface api = new JSInterface();
       // siteView.addJavascriptInterface(api, "api");





        ////////////////notification

//        c.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void afterTextChanged(Editable s) {        getActivity().startService(new Intent(getActivity(), StockService.class));
//            }
//
//
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start,
//                                      int before, int count) {
//                getActivity().startService(new Intent(getActivity(), StockService.class));
//
//            }
//        });
//













      siteView.getSettings().setBuiltInZoomControls(true);
       siteView.getSettings().setUseWideViewPort(true);
        siteView.setInitialScale(100);
        siteView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String imgDataUrl= consoleMessage.message();


                if (imgDataUrl.contains("found at: ")) {
                    int aa=Integer.parseInt(imgDataUrl.substring(10));
                    Log.d("testsd", String.valueOf(aa+1));
                    SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("index", aa+1); // Storing integer
                    editor.commit(); // commit changes

                }
                return super.onConsoleMessage(consoleMessage);
            }
        });
        siteView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageFinished(WebView view, String url) {
                SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode
                SharedPreferences.Editor editor = pref.edit();
                int pos = pref.getInt("index", -1); // getting Integer
                Log.d("hhhh", String.valueOf(pos));
                //maj date
                siteView.evaluateJavascript("document.querySelector(\"#page-top+ div , .maincounter-number , #maincounter-wrap+ #maincounter-wrap h1 , #maincounter-wrap:nth-child(7) h1\").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String s) {
                        String a = s.replaceAll("^\"|\"$", "");

                        mise.setText(a.substring(14, a.length()));
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
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.d("aldjsklqsjnd", String.valueOf(pos));
                //cas total TN
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td.sorting_1\").innerText", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l.setVisibility(View.GONE);
                            total.setText("0");

                        } else {
                            l.setVisibility(View.GONE);
                            total.setText(z.replaceAll("^\"|\"$", ""));
                            // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                        }

                    }
                });
                //NV Cas


                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(3)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l1.setVisibility(View.GONE);
                            Nc.setText("0");
                        } else {
                            l1.setVisibility(View.GONE);
                            Nc.setText(z.replaceAll("^\"|\"$", ""));
                            // Toast.makeText(getContext(), s, Toast.LENGTH_LONG).show();
                        }

                    }
                });
                //Tot death
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(4)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l2.setVisibility(View.GONE);
                            de.setText("0");

                        } else {
                            de.setText(z.replaceAll("^\"|\"$", ""));
                            l2.setVisibility(View.GONE);
                        }
                    }
                });
                //New Death
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(5)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l3.setVisibility(View.GONE);
                            Nde.setText("0");
                        } else {
                            l3.setVisibility(View.GONE);
                            Nde.setText(z.replaceAll("^\"|\"$", ""));
                        }
                    }
                });
                //Total rec
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(6)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l4.setVisibility(View.GONE);
                            tR.setText("0");
                        } else {
                            l4.setVisibility(View.GONE);
                            tR.setText(z.replaceAll("^\"|\"$", ""));
                        }
                    }
                });
                //Active cases
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(7)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l5.setVisibility(View.GONE);
                            cA.setText("0");
                        } else {
                            l5.setVisibility(View.GONE);
                            cA.setText(z.replaceAll("^\"|\"$", ""));
                        }
                    }
                });
                //Cri
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(8)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l6.setVisibility(View.GONE);
                            crit.setText("0");
                        } else {
                            l6.setVisibility(View.GONE);
                            crit.setText(z.replaceAll("^\"|\"$", ""));
                        }
                    }
                });
                //tot/1m
                siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + pos + ") > td:nth-child(9)\").innerText\n", new ValueCallback<String>() {
                    @Override
                    public void onReceiveValue(String z) {
                        if (z.equals("\"\"")) {
                            l7.setVisibility(View.GONE);
                            t1m.setText("0");
                        } else {
                            l7.setVisibility(View.GONE);
                            t1m.setText(z.replaceAll("^\"|\"$", ""));
                        }
                    }
                });


                //check
                view.evaluateJavascript("{function findMatchingRow(word) {\n" +
                        "                              const found = []\n" +
                        "                              const trList = document.querySelectorAll('#main_table_countries_today > tbody > tr')\n" +
                        "                              trList.forEach((tr, i) => {\n" +
                        "                               if(tr.textContent.match(word)) {\n" +
                        "                                  found.push({index: i, content: tr.textContent})\n" +
                        "                            }\n" +
                        "                              })\n" +
                        "                              return found\n" +
                        "                            }\n" +
                        "                            \n" +
                        "                            const matches = findMatchingRow('Tunisia')\n" +
                        "                            console.log(matches)\n" +
                        "                                                        if(matches.length > 0) {\n" +
                        "                           console.log('found at:', matches.map(m => m.index))}\n" +
                        "}", null);

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


}