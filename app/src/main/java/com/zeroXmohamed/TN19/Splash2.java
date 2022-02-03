package com.zeroXmohamed.TN19;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

public class Splash2 extends AppCompatActivity {
    Animation anim;
    ImageView imageView;
    TextView u,u1,u2,u3,u4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        u=findViewById(R.id.update);
        u1=findViewById(R.id.update1);
        u2=findViewById(R.id.update2);
        u3=findViewById(R.id.update3);
        u4=findViewById(R.id.update4);

        imageView=(ImageView)findViewById(R.id.imageView2); // Declare an imageView to show the animation.
        anim = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in); // Create the animation.
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                // HomeActivity.class is the activity to go after showing the splash screen.
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        imageView.startAnimation(anim);

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });

        //update1
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update1.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u1.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });


        //update2
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update2.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u2.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });
        //update3
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update3.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u3.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });

        //update4
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try
                {

                    URL url = new URL("https://www.0xmohamed.ml/update4.txt");//my app link change it

                    HttpsURLConnection uc = (HttpsURLConnection) url.openConnection();
                    BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
                    String line;
                    final StringBuilder lin2 = new StringBuilder();
                    while ((line = br.readLine()) != null)
                    {
                        lin2.append(line);
                    }
                    Log.d("texts", "onClick: "+lin2);
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            u4.setText(lin2);

                        }
                    });
                } catch (IOException e)
                {
                    Log.d("texts", "onClick: "+e.getLocalizedMessage());
                    e.printStackTrace();
                }
            }
        }).start();
        runOnUiThread(new Runnable() {

            @Override
            public void run() {

                // Stuff that updates the UI

            }
        });
    }


}