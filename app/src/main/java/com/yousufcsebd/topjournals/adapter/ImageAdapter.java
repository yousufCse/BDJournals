package com.yousufcsebd.topjournals.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.yousufcsebd.topjournals.R;

/**
 * Created by Yousuf on 26-07-16.
 */
public class ImageAdapter extends BaseAdapter{
        private Context mContext;
        private String[] newspaperName;
        private int[] newspaperIcon;

        public ImageAdapter(Context c, String[] newspaperName, int[] newspaperIcon) {
            mContext = c;
            this.newspaperName = newspaperName;
            this.newspaperIcon = newspaperIcon;
        }

        public int getCount() {
            return newspaperName.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        // create a new ImageView for each item referenced by the Adapter
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_grid_layout, parent, false);
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imageView);
            TextView textView = (TextView) convertView.findViewById(R.id.textView);


            imageView.setImageResource(newspaperIcon[position]);
            textView.setText(newspaperName[position]);
            return convertView;
        }

    }
