package com.zeroXmohamed.TN19;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.TextView;

import com.zeroXmohamed.TN19.fragment.ActuFragment;
import com.zeroXmohamed.TN19.fragment.ChercheFragment;
import com.zeroXmohamed.TN19.fragment.ConsFragment;
import com.zeroXmohamed.TN19.fragment.UrgenceFragment;
import com.zeroXmohamed.TN19.fragment.StatFragment;
import com.zeroXmohamed.TN19.helper.BottomNavigationBehavior;

public class MainActivity extends AppCompatActivity {

    private ActionBar toolbar;
    private TextView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = getSupportActionBar();













//        Intent serviceIntent = new Intent(this,StockService.class);
//        getApplicationContext().startService(serviceIntent);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // attaching bottom sheet behaviour - hide / show on scroll
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) navigation.getLayoutParams();
        layoutParams.setBehavior(new BottomNavigationBehavior());


//Remove notification bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // attaching bottom sheet behaviour - hide / show on scroll


        // load the store fragment by default
//        toolbar.setTitle("Statistiques");
        loadFragment(new StatFragment());
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_shop:
              //      toolbar.setTitle("Statistiques");
                    fragment = new StatFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_search:
                    //      toolbar.setTitle("Statistiques");
                    fragment = new ChercheFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_gifts:
//                    toolbar.setTitle("Actualités");
                    fragment = new ActuFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_cart:
                 //   toolbar.setTitle("Conseils");
                    fragment = new ConsFragment();
                    loadFragment(fragment);
                    return true;
                case R.id.navigation_profile:
                //    toolbar.setTitle("Urgence");
                    fragment = new UrgenceFragment();
                    loadFragment(fragment);
                    return true;
            }

            return false;
        }
    };

    /**
     * loading fragment into FrameLayout
     *
     * @param fragment
     */
    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }













}
