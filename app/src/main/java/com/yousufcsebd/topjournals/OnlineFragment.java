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

public class OnlineFragment extends Fragment {
    private GridView gridView;
	
	public OnlineFragment(){}
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), onlineName, onlineIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, onlineLink[position])
                        .putExtra(PopularFragment.NP_NAME, onlineName[position])
                );

            }
        });


        return rootView;
    }




    private String[] onlineName = {
            "BBC Bangla",
            "BD News 24",
            "Poriborton",
            "NTV",
            "BD Live 24",
            "CNN Bangla",
            "Shirsho News",
            "Bangla News 24",
            "Dhaka Times 24",
            "Sorboshes",
            "Notun Batra",
            "Go News 24",
            "Breaking News BD",
            "Bangla Mail 24",
            "Somoy News",
            "ABC News 24",
            "Bangla Tribune",
            "Boichitra 24",
            "Jago News 24",
            "Barta Bangla",
            "BBC 24 News",
            "Prothom Barta"
    };

    private String[] onlineLink = {
            "http://www.bbc.com/bengali",
            "http://bangla.bdnews24.com/",
            "http://poriborton.com/",
            "http://www.ntvbd.com/",
            "http://www.bd24live.com/bn/",
            "http://cnnbangladesh.com/",
            "http://www.sheershanewsbd.com/",
            "http://www.banglanews24.com/",
            "http://www.dhakatimes24.com/",
            "http://www.sorboshes.com/",
            "http://www.natunbarta.com/",
            "http://www.gonews24.com/",
            "http://www.breakingnewsbd.online/",
            "http://www.banglamail24.com/",
            "http://www.shomoynews.com/",
            "http://www.abnews24.com/",
            "http://www.banglatribune.com/",
            "http://bichitra24.com/bangla/",
            "http://en.jagonews24.com/",
            "http://bartabangla.com/",
            "http://www.bbc24news.com/",
            "http://prothombarta.com/"
    };

    private int[] onlineIcon = {
            R.drawable.bbc_bangla,
            R.drawable.bd_news24,
            R.drawable.poribortan,
            R.drawable.ntv,
            R.drawable.bdlive24,
            R.drawable.cnn_bd,
            R.drawable.sirsho_news,
            R.drawable.bangla_news24,
            R.drawable.dhakatimes24,
            R.drawable.sorboses,
            R.drawable.natunbarta,
            R.drawable.gonews,
            R.drawable.breaking_newsbd,
            R.drawable.bangla_mail24,
            R.drawable.somoynews,
            R.drawable.abcnews,
            R.drawable.banglatribune,
            R.drawable.bchitra,
            R.drawable.jago_news,
            R.drawable.bartabangla,
            R.drawable.bbc24,
            R.drawable.protham_barta
    };


}
