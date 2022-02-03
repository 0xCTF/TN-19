package com.zeroXmohamed.TN19.fragment;


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.webkit.ConsoleMessage;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;
import com.zeroXmohamed.TN19.R;
import com.zeroXmohamed.TN19.Splash;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.getSystemService;


public class ChercheFragment extends Fragment {

    private SearchView searchView;

    private ListView simpleList;
    private LinearLayout a,z,e,y,lst;
    private static final String TAG = StatFragment.class.getSimpleName();
    int n=-1;
    private SearchView search;
    // url to fetch shopping items
    private static final String URL = "https://www.worldometers.info/coronavirus/";
    int j=0;
    private RecyclerView recyclerView;
    private TextView mise,c,d,r,total,Nc,de,Nde,tR,cA,crit,t1m,titre;
    private WebView siteView;
    private ProgressBar l,l1,l2,l3,l4,l5,l6,l7,lo;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SharedPreferences ee = getContext().getSharedPreferences("Settings", Splash.MODE_PRIVATE);
        String language = ee.getString("My_Lang", "My_Lang");

        View view = inflater.inflate(R.layout.fragment_cherche, container,
                false);



        if (language.equals("ar")) {
             view = inflater.inflate(R.layout.fragment_cherche_ar, container,
                    false);        }



        simpleList= view.findViewById(R.id.ListC);
        searchView=view.findViewById(R.id.cher);
        a=view.findViewById(R.id.lin1);
        z=view.findViewById(R.id.lin2);
        e=view.findViewById(R.id.lin3);
        y=view.findViewById(R.id.lin4);
        lst=view.findViewById(R.id.lst1);
        search=view.findViewById(R.id.cher);
        lo=view.findViewById(R.id.loadin);
        lo.setVisibility(View.VISIBLE);
        searchView.setVisibility(View.GONE);
        lst.setVisibility(View.VISIBLE);
        a.setVisibility(View.GONE);
        z.setVisibility(View.GONE);
        e.setVisibility(View.GONE);
        y.setVisibility(View.GONE);



        search.setOnQueryTextFocusChangeListener(new View.OnFocusChangeListener() {
            @SuppressLint("NewApi")
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    lst.setVisibility(View.VISIBLE);
                    titre.setText("Choisissez un pays");
                    a.setVisibility(View.GONE);
                    z.setVisibility(View.GONE);
                    e.setVisibility(View.GONE);
                    y.setVisibility(View.GONE);
                }
            }
        });


        de = (TextView) view.findViewById(R.id.dead1);
        Nde = (TextView) view.findViewById(R.id.Ndead1);
        tR = (TextView) view.findViewById(R.id.Totrec1);
        cA = (TextView) view.findViewById(R.id.act1);
        crit = (TextView) view.findViewById(R.id.cri1);
        t1m = (TextView) view.findViewById(R.id.tot1m1);
        r = (TextView) view.findViewById(R.id.Totrec1);
        Nc = (TextView) view.findViewById(R.id.casN1);
        total = (TextView) view.findViewById(R.id.tot1);
        l=view.findViewById(R.id.l1);
        l1=view.findViewById(R.id.l2);
        l2=view.findViewById(R.id.l3);
        l3=view.findViewById(R.id.l4);
        l4=view.findViewById(R.id.l5);
        l5=view.findViewById(R.id.l6);
        l6=view.findViewById(R.id.l7);
        l7=view.findViewById(R.id.l8);
        titre=view.findViewById(R.id.title);
        siteView = (WebView) view.findViewById(R.id.wb);
        WebSettings webSettings = siteView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        webSettings.setDomStorageEnabled(true);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }

        siteView.getSettings().setBuiltInZoomControls(true);
        siteView.getSettings().setUseWideViewPort(true);
        siteView.setInitialScale(100);
        siteView.setWebChromeClient(new WebChromeClient() {
            ArrayList<String> array_list = new ArrayList<>();
            ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_list_item_1, array_list);

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessag) {
                String imgDataUr= consoleMessag.message();

                if (imgDataUr.contains("heyyes")) {
                    String a=imgDataUr.substring(6);

                    array_list.add(a);

                    lo.setVisibility(View.GONE);
                    lst.setVisibility(View.VISIBLE);
                    searchView.setVisibility(View.VISIBLE);

               }

                if (imgDataUr.contains("found at: ")) {
                    int aa=Integer.parseInt(imgDataUr.substring(10));
                    Log.d("sdsdzzzz", String.valueOf(aa+1));
                    SharedPreferences pref = getContext().getSharedPreferences("MyPre", 0); // 0 - for private mode
                    SharedPreferences.Editor editor = pref.edit();
                    editor.putInt("index", aa+1); // Storing integer
                    editor.commit(); // commit changes

                    int win = pref.getInt("index", -1); // getting Integer
                    Log.d("indexs7i7", String.valueOf(win));
                    Log.d("houni11", String.valueOf(win));


                    //cas total TN
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td.sorting_1\").innerText", new ValueCallback<String>() {
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


                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(3)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(4)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(5)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(6)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(7)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(8)\").innerText\n", new ValueCallback<String>() {
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
                    siteView.evaluateJavascript("document.querySelector(\"#main_table_countries_today > tbody:nth-child(2) > tr:nth-child(" + win + ") > td:nth-child(9)\").innerText\n", new ValueCallback<String>() {
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
                }


                simpleList.setAdapter(arrayAdapter);
                search.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        lst.setVisibility(View.VISIBLE);
                        a.setVisibility(View.GONE);
                        z.setVisibility(View.GONE);
                        e.setVisibility(View.GONE);
                        y.setVisibility(View.GONE);
                        arrayAdapter.getFilter().filter(newText);
                        return true;
                    }
                });

                return super.onConsoleMessage(consoleMessag);
            }

        });


        siteView.setWebViewClient(new WebViewClient() {



            @Override
            public void onPageFinished(final WebView view, String url) {

                    final SharedPreferences pre = getContext().getSharedPreferences("MyPre", 0); // 0 - for private mode

                    Log.d("houni","sdsd");

                    //count

//                    view.evaluateJavascript("const selector = \"#main_table_countries > tbody:nth-child(2) > tr > td:nth-child(1)\";\n" +
//                            "var i=0;\n" +
//                            "document.querySelectorAll(selector).forEach(el => console.log(\"count\",i+=1));", null);


                    //check country list
                    view.evaluateJavascript("{const selector =\"#main_table_countries_today > tbody:nth-child(2) > tr > td:nth-child(1)\";\n" +
                            "document.querySelectorAll(selector).forEach(el => console.log(\"heyyes\"+el.textContent.trim()))}", null);

                    simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                        @Override
                        public void onItemClick(AdapterView<?> arg0, View arg1,
                                                int position, long arg3) {
                            SharedPreferences pref = getContext().getSharedPreferences("MyPre", 0); // 0 - for private mode
                            SharedPreferences.Editor editor = pref.edit();
                            pref.edit().clear().apply();
                            String ii= (String) ((TextView) arg1).getText();
                            editor.putString("i", ii ); // Storing integer
                           // Toast.makeText(getContext(), ii, Toast.LENGTH_SHORT).show();
                            String listItem = (String)arg0.getItemAtPosition(position);
                            titre.setText("Statistiques "+listItem);
                            editor.commit();
                            lst.setVisibility(View.GONE);
                            simpleList.clearFocus();
                            InputMethodManager in = (InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                            in.hideSoftInputFromWindow(simpleList.getWindowToken(), 0);
                            a.setVisibility(View.VISIBLE);
                            z.setVisibility(View.VISIBLE);
                            e.setVisibility(View.VISIBLE);
                            y.setVisibility(View.VISIBLE);

                            String pos = pref.getString("i", null); // getting Integer
                            Log.d("houni",pos);

                            //   SharedPreferences pref = getContext().getSharedPreferences("MyPref", 0); // 0 - for private mode

                            //ism country

                            view.evaluateJavascript("{function findMatchingRow(word) {\n" +
                                    "  const found = []\n" +
                                    "  const trList = document.querySelectorAll('#main_table_countries_today > tbody > tr')\n" +
                                    "  trList.forEach((tr, i) => {\n" +
                                    "    if(tr.textContent.match(word)) {\n" +
                                    "      found.push({index: i, content: tr.textContent})\n" +
                                    "    }\n" +
                                    "  })\n" +
                                    "  return found\n" +
                                    "}\n" +
                                    "\n" +
                                    "const matches = findMatchingRow('"+pos+"')\n" +
                                    "console.log(matches)\n" +
                                    "\n" +
                                    "if(matches.length > 0) {\n" +
                                    "  console.log('found at:', matches.map(m => m.index))\n" +
                                    "}}",null);

                            //houni n7ot id mte3 chrome ism lcountry
                           // SharedPreferences pre = getContext().getSharedPreferences("MyPre", 0); // 0 - for private mode


                }
            }


            );
                }



        });

        // Load URL
        siteView.loadUrl(URL);

        return view;
    }


}
