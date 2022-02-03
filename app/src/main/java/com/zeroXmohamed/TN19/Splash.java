package com.zeroXmohamed.TN19;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
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
import java.util.Locale;

import javax.net.ssl.HttpsURLConnection;

public class Splash extends AppCompatActivity {
    Animation anim;
    int i=0;
    ImageView imageView;
    TextView u,u1,u2,u3,u4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        int i=0;
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
        //********************************************************************************************************************************

        //********************************************************************************************************************************

       // imageView.startAnimation(anim);
        showChangeLanguageDialog();
    }

    private void showChangeLanguageDialog() {
        final String[] listLang={"Francais","العربية","English"};
        AlertDialog.Builder onBuilder=new AlertDialog.Builder(Splash.this);
        onBuilder.setTitle(" Choose Language   \n  إختر اللغة");
        onBuilder.setCancelable(false);
        //onBuilder.setCanceledOnTouchOutside(false);

        onBuilder.setSingleChoiceItems(listLang, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(which==0){
                    setLocale("en-us");
                    recreate();
                    Intent intent=new Intent(Splash.this,Splash2.class);
                    startActivity(intent);
                }
                else if(which==1){

                    setLocale("ar");
                    recreate();
                    Intent intent=new Intent(Splash.this,Splash2.class);
                    startActivity(intent);
                }
                else if(which==2){

                    setLocale("en");
                    recreate();
                    Intent intent=new Intent(Splash.this,Splash2.class);
                    startActivity(intent);
                }

                dialog.dismiss();
            }
        });
        AlertDialog mDialog=onBuilder.create();
        if(i==0) {

            mDialog.show();
            i++;
        }

    }

    private void setLocale(String lang) {
        Locale locale= new Locale(lang);
        Locale.setDefault(locale);
        Configuration config=new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration(config,getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor=getSharedPreferences("Settings",MODE_PRIVATE).edit();
        editor.putString("My_Lang",lang);
        editor.commit();

    }

    public void loadLocale(){
        SharedPreferences editor=getSharedPreferences("Settings",Splash.MODE_PRIVATE);
        String language=editor.getString("My_Lang","My_Lang");
        Log.d("hahahahahahdhjzshsdj",language);
        setLocale(language);


    }

}