package com.example.mar.mardip2.HealthIndicators;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mar.mardip2.R;

import java.util.ArrayList;

public class HealthIndicatorsAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<HealthIndicator> mDataSource;

    public HealthIndicatorsAdapter(Context context, ArrayList<HealthIndicator> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    //2
    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    //3
    @Override
    public long getItemId(int position) {
        return position;
    }

    //4
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for row item
        View rowView = mInflater.inflate(R.layout.list_item_health_indicator, parent, false);


        TextView titleTextView =
                (TextView) rowView.findViewById(com.example.mar.mardip2.R.id.healind_list_title);

        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(com.example.mar.mardip2.R.id.recipe_list_icon);


        HealthIndicator healthIndicator = (HealthIndicator) getItem(position);

        titleTextView.setText((String) String.valueOf(healthIndicator.getTitle()));

        thumbnailImageView.setImageResource(healthIndicator.getIcon());

        return rowView;
    }
}
