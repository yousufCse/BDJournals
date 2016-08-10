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

public class OthersFragment extends Fragment {

    private GridView gridView;

    public OthersFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), othersName, otherIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, othersLink[position])
                        .putExtra(PopularFragment.NP_NAME, othersName[position])
                );
            }
        });


        return rootView;
    }

    private String[] othersName = {
            "bdjobs.com",
            "EverJobs",
            "Dhaka Jobs",
            "Daily Jobsnews",
            "All Newspaper Jobs",
            "Bangla Hadith",
            "Islamic Blog",
            "Islami Bangladesh",
            "BD Stall",
            "Mobile Price",
            "India BIX",
            "Techtunes",
            "Priyo Tech",
            "Tunerpage",
            "Sastha Bangla",
            "Health Barta"
    };

    private String[] othersLink = {
            "http://www.bdjobs.com/",
            "https://www.everjobs.com.bd/",
            "http://dhaka-jobs.com/",
            "http://www.epaper.jobsnews24.com/",
            "http://alljobsbd.blogspot.com/",
            "http://www.hadithbd.com/",
            "http://preachingauthenticislaminbangla.blogspot.com/",
            "http://www.islamibd.com/",
            "http://www.bdstall.com/",
            "http://www.mobiledokan.com/",
            "http://www.indiabix.com/",
            "http://www.techtunes.com.bd/",
            "http://tech.priyo.com/",
            "http://tunerpage.com/",
            "http://www.sasthabangla.com/",
            "http://www.healthbarta.com/"

    };

    private int[] otherIcon = {
            R.drawable.bdjobs,
            R.drawable.erverjobs,
            R.drawable.dhakajobs,
            R.drawable.dailyjobsnews,
            R.drawable.allnewspaperjobs,
            R.drawable.banglahadith,
            R.drawable.islamicblog,
            R.drawable.islamibd,
            R.drawable.bdstall,
            R.drawable.mobiledokan,
            R.drawable.indiabix,
            R.drawable.techtunes,
            R.drawable.priyotech,
            R.drawable.tunerpage,
            R.drawable.sastobangla,
            R.drawable.healthbarta,

    };
}
