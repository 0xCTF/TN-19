package com.zeroXmohamed.TN19.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zeroXmohamed.TN19.R;

public class UrgenceFragment extends Fragment {

    private TextView u1,u2,u3,u4,u5;
    public UrgenceFragment() {
        // Required empty public constructor
    }

    public static UrgenceFragment newInstance(String param1, String param2) {
        UrgenceFragment fragment = new UrgenceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_urgence, container,
                false);
        u1=view.findViewById(R.id.textView4);
        u2=view.findViewById(R.id.textView5);
        u3=view.findViewById(R.id.textView6);
        u4=view.findViewById(R.id.textView7);
        u5=view.findViewById(R.id.textView8);

        u1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "190";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(uri.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }
        });
        u2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "80101919";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(uri.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }        });
        u3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "71284547";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(uri.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }        });
        u4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "71284560";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(uri.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }        });
        u5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = "71284562";
                Intent callIntent = new Intent(Intent.ACTION_DIAL);
                callIntent.setData(Uri.parse("tel:"+Uri.encode(uri.trim())));
                callIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(callIntent);
            }        });

        return view;
    }

}
