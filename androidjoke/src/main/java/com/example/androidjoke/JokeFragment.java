package com.example.androidjoke;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class JokeFragment extends Fragment {

    public static final String JOKE_KEY = "joke";

    public JokeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_joke, container, false);
        Intent intent = getActivity().getIntent();
        if (intent.hasExtra(JOKE_KEY)){
            String joke = intent.getStringExtra(JOKE_KEY);
            TextView textView = view.findViewById(R.id.tv_joke);
            textView.setText(joke);
            Log.d("JOKE LIBRARY", "Ci siamo! " + joke);
        }
        return view;
    }

}
