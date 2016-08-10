package com.yousufcsebd.topjournals;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.yousufcsebd.topjournals.adapter.ImageAdapter;

public class PopularFragment extends Fragment {
    RelativeLayout prl;
    public static final String SITE_NAME = "site_name";
    public static final String NP_NAME = "newspaper_name";
    private GridView gridView;
    public PopularFragment() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_popular, container, false);

        // init
        prl = (RelativeLayout) rootView.findViewById(R.id.prl);
        gridView = (GridView) rootView.findViewById(R.id.popularGridView);
        gridView.setAdapter(new ImageAdapter(getActivity(), popularName, popularIcon));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                startActivity(new Intent(getActivity(), WebActivity.class)
                        .putExtra(PopularFragment.SITE_NAME, popularLink[position])
                        .putExtra(PopularFragment.NP_NAME, popularName[position])
                );

            }
        });


        return rootView;
    }


    private String[] popularName = {
            "Bangladesh Pratidin",
            "Protham Alo",
            "BD News 24",
            "BBC Bangla",
            "Kaler Kantho",
            "Jugantor",
            "Amar Desh",
            "Ittefaq",
            "Amader Shomoy",
            "Samokal",
            "Janakantha",
            "Anando Bazar",
            "Inqilab",
            "Naya Diganta",
            "Bonik Batra",
            "Alokito Bangladesh",
            "Jai Jai Din",
            "Manab Zamin",
            "Sangbad Konika",
            "Daily Sangram",
            "Amar Sangbad",
            "Manab Kantha",
            "Daily Dinkal",
            "Protidiner Sangbad",
            "Sangbad Protidin",
            "Suprobhat Bangladesh"


    };

    private String[] popularLink = {
            "http://www.bd-pratidin.com/",
            "http://www.prothom-alo.com/",
            "http://bangla.bdnews24.com/",
            "http://www.bbc.com/bengali",
            "http://www.kalerkantho.com/index.php",
            "http://www.jugantor.com/",
            "http://www.amardeshonline.com/",
            "http://www.ittefaq.com.bd/",
            "http://www.dainikamadershomoy.com/",
            "http://bangla.samakal.net/",
            "https://www.dailyjanakantha.com/",
            "http://www.anandabazar.com/",
            "https://www.dailyinqilab.com/",
            "http://www.dailynayadiganta.com/",
            "http://www.bonikbarta.com/",
            "http://www.alokitobangladesh.com/",
            "http://www.jjdin.com/",
            "http://www.mzamin.com/",
            "http://www.sangbadkonika.com/",
            "http://www.dailysangram.com/",
            "http://www.amar-sangbad.com/",
            "http://www.manobkantha.com/",
            "http://www.dailydinkal.net/",
            "http://www.protidinersangbad.com/",
            "http://www.sangbadprotidin.com/",
            "http://suprobhat.com/"


    };

    private int[] popularIcon = {
            R.drawable.bangladeshprotidin,
            R.drawable.protham_alo,
            R.drawable.bdnews24,
            R.drawable.bbc_bangla,
            R.drawable.kalerkantha,
            R.drawable.jugantar,
            R.drawable.amardesh,
            R.drawable.ittefaq,
            R.drawable.amadersomoy,
            R.drawable.shomokal,
            R.drawable.janokantha,
            R.drawable.anandabazar,
            R.drawable.inqulib,
            R.drawable.noyadiganta,
            R.drawable.bonikbatra,
            R.drawable.alokitobangladesh,
            R.drawable.jaijaidin,
            R.drawable.manab_zamin,
            R.drawable.sangbad_konika,
            R.drawable.dailysangram,
            R.drawable.amar_sangbad,
            R.drawable.manabkantha,
            R.drawable.dinkal,
            R.drawable.protidinersongbad,
            R.drawable.songbadprotidin,
            R.drawable.suprobhat
    };



}


