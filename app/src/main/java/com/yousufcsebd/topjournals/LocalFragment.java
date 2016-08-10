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

public class LocalFragment extends Fragment {

    private GridView gridView;

    public LocalFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), localName, localIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, localLink[position])
                        .putExtra(PopularFragment.NP_NAME, localName[position])
                );

            }
        });


        return rootView;
    }

    private String[] localName = {
            "Dainik Azadi",
            "Chittagonj Daily",
            "Rangpur News24",
            "Mymensingh Barta",
            "Parbatta News",
            "Daily Sylhet",
            "Sylhet Express",
            "Khulna News",
            "Bogra Sangbad",
            "Ajker Barishal",
            "Barishal Today",
            "Comilla Barta",
            "Rajshahi News 24",
            "Probaha Khulna"
    };
    private String[] localLink = {
            "http://www.dainikazadi.org/index1.php",
            "http://chittagongdaily.com/",
            "http://rangpurnews24.com/",
            "http://www.mymensinghbarta.com/",
            "http://parbattanews.com/",
            "http://dailysylhet.com/",
            "http://www.sylhetexpress.com/news/index.php",
            "http://www.khulnanews.com/",
            "http://www.bograsangbad.com/",
            "http://www.ajkerbarisal.com/",
            "http://www.barisaltoday.com/",
            "http://www.comillarbarta.com/",
            "http://www.rajshahinews24.com/",
            "http://www.dailyprobaha.com.bd/",

    };

    private int[] localIcon = {
            R.drawable.azadi,
            R.drawable.ct_daily,
            R.drawable.rpnews,
            R.drawable.mm_barta,
            R.drawable.parboto_news,
            R.drawable.d_sylhet,
            R.drawable.s_express,
            R.drawable.khulna_news,
            R.drawable.bogura_sangbad,
            R.drawable.ajkerbarishal,
            R.drawable.barishaltoday,
            R.drawable.comillabarta,
            R.drawable.rashahi,
            R.drawable.probaho

    };
}
