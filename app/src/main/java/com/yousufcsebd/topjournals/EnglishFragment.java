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

public class EnglishFragment extends Fragment {

    private GridView gridView;

    public EnglishFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), englishName, englishIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, englishLink[position])
                        .putExtra(PopularFragment.NP_NAME, englishName[position])
                );

            }
        });


        return rootView;
    }


    private String[] englishName = {
            "Daily Sun",
            "The Independent",
            "New Age",
            "Bangladesh News",
            "News Today",
            "Daily Star",
            "Bangladesh Today",
            "Dhaka Tribune",
            "New Nation",
            "Daily Observer",
            "Holiday",
            "Peoples Time",
            "Financial Express",
            "The New York Times",
    };

    private String[] englishLink = {
            "http://www.daily-sun.com/",
            "http://www.theindependentbd.com/",
            "http://newagebd.net/",
            "http://www.independent-bangladesh.com/",
            "http://www.newstoday.com.bd/",
            "http://www.thedailystar.net/",
            "http://thebangladeshtoday.com/",
            "http://www.dhakatribune.com/",
            "http://thedailynewnation.com/",
            "http://www.observerbd.com/",
            "http://www.weeklyholiday.net/",
            "http://dailypeoplestime.com/",
            "http://www.thefinancialexpress-bd.com/",
            "http://www.nytimes.com/"
    };

    private int[] englishIcon = {
            R.drawable.daily_sun,
            R.drawable.the_independent,
            R.drawable.new_agebd,
            R.drawable.bangladesh_news,
            R.drawable.newstoday,
            R.drawable.thedailystar,
            R.drawable.bangladesh_today,
            R.drawable.dhaka_tribune,
            R.drawable.new_nation,
            R.drawable.daily_observer,
            R.drawable.holiday,
            R.drawable.peoples_time,
            R.drawable.thefinancialexpress,
            R.drawable.newworktimes,


    };

}
