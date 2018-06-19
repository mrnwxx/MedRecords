package com.example.mar.mardip2.HealthIndicators.History;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.mar.mardip2.HealthIndicators.BloodPressure;
import com.example.mar.mardip2.HealthIndicators.Pulse;
import com.example.mar.mardip2.HealthIndicators.Sugar;
import com.example.mar.mardip2.HealthIndicators.Weight;
import com.example.mar.mardip2.R;

import java.util.ArrayList;

public class HealIndHistAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<?> mDataSource;

    public HealIndHistAdapter(Context context, ArrayList<?> items) {
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
        View rowView = mInflater.inflate(R.layout.list_item_health_indicator_hist, parent, false);


        TextView leftTextView =
                (TextView) rowView.findViewById(com.example.mar.mardip2.R.id.health_indicator_hist_list_leftCenter);

        TextView rightTextView =
                (TextView) rowView.findViewById(R.id.health_indicator_hist_list_rightCenter);

        String str = getItem(position).getClass().getName();
        switch (str) {
            case "com.example.mar.mardip2.HealthIndicators.Weight":
                Weight weight = (Weight) getItem(position);

                leftTextView.setText(weight.getDate());
                rightTextView.setText(String.valueOf(weight.getValue()));
                break;

            case "com.example.mar.mardip2.HealthIndicators.BloodPressure":
                BloodPressure bloodPressure = (BloodPressure) getItem(position);

                leftTextView.setText(bloodPressure.getDate());
                rightTextView.setText(bloodPressure.getValue());
                break;

            case "com.example.mar.mardip2.HealthIndicators.Pulse":
                Pulse pulse = (Pulse) getItem(position);

                leftTextView.setText(pulse.getDate());
                rightTextView.setText(String.valueOf(pulse.getValue()));
                break;

            case "com.example.mar.mardip2.HealthIndicators.Sugar":
                Sugar sugar = (Sugar) getItem(position);

                leftTextView.setText(sugar.getDate());
                rightTextView.setText(String.valueOf(sugar.getValue()));
                break;
        }

        return rowView;
    }

}
