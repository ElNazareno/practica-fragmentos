package com.example.practicaaa;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageButton;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link otro_apk_fragment#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class otro_apk_fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment otro_apk_fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static otro_apk_fragment newInstance(String param1, String param2) {
        otro_apk_fragment fragment = new otro_apk_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public otro_apk_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    View view;
    ImageButton yt,gml;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_otro_apk_fragment,container,false);
        yt=view.findViewById(R.id.imgbtnYoutube);
        gml=view.findViewById(R.id.imgbtnGmail);
        yt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView myWebView = view.findViewById(R.id.imgbtnYoutube);
                myWebView.loadUrl("http://www.youtube.com");
            }
        });
        gml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri tap = Uri.parse("com.google.android.gm");
                Intent intent = new Intent(Intent.ACTION_VIEW,tap);
                startActivity(intent);
            }
        });
        return view;

    }
}
/*
 binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent face = getPackageManager().getLaunchIntentForPackage("com.google.android.gm");
                startActivity(face);
            }
        });
* */

