package com.yousufcsebd.topjournals;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.yousufcsebd.topjournals.adapter.ImageAdapter;

public class SportsFragment extends Fragment {

    private GridView gridView;

    public SportsFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), sportsName, sportsIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, sportsLink[position])
                        .putExtra(PopularFragment.NP_NAME, sportsName[position])
                );

            }
        });


        return rootView;
    }

    private String[] sportsName = {
            "Sky Sports",
            "ESPN",
            "Cricbuzz",
            "ESPN Cricinfo",
            "Bangla Cricket",
            "Bangladesh Cricket",
            "Bangladesher Khela",
            "Khelar Jagat",
            "BCB",
            "ICC"
    };
    private String[] sportsLink = {
            "http://www.skysports.com/",
            "http://espn.go.com/",
            "http://www.cricbuzz.com/",
            "http://www.espncricinfo.com/",
            "http://banglacricket.com/",
            "http://bangladeshcricket.com/",
            "http://bangladesherkhela.com/",
            "http://www.khelarjagat.com/",
            "http://www.tigercricket.com.bd/",
            "http://www.icc-cricket.com/"
    };
    private int[] sportsIcon = {
            R.drawable.skysport,
            R.drawable.espn,
            R.drawable.cricbuzz,
            R.drawable.espncric,
            R.drawable.bangla_criket,
            R.drawable.ban_cricket,
            R.drawable.ban_khela,
            R.drawable.k_jagat,
            R.drawable.ban_cc,
            R.drawable.icc
    };

}
