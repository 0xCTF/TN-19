package com.zeroXmohamed.TN19.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zeroXmohamed.TN19.R;

public class ConsFragment extends Fragment {

    public ConsFragment() {
        // Required empty public constructor
    }

    public static ConsFragment newInstance(String param1, String param2) {
        ConsFragment fragment = new ConsFragment();
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
        return inflater.inflate(R.layout.fragment_cons, container, false);
    }
}
