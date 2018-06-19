package com.example.mar.mardip2.MedRecord;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mar.mardip2.MedRecord.MedRecord;
import com.example.mar.mardip2.R;

import java.util.ArrayList;

public class MedRecordsAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<MedRecord> mDataSource;

    public MedRecordsAdapter(Context context, ArrayList<MedRecord> items) {
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
        View rowView = mInflater.inflate(R.layout.list_item_med_records, parent, false);

        // Get title element
        TextView titleTextView =
                (TextView) rowView.findViewById(com.example.mar.mardip2.R.id.recipe_list_title);

        // Get subtitle element
        TextView subtitleTextView =
                (TextView) rowView.findViewById(com.example.mar.mardip2.R.id.recipe_list_subtitle);

        // Get detail element
        TextView detailTextView =
                (TextView) rowView.findViewById(com.example.mar.mardip2.R.id.recipe_list_detail);

        // Get thumbnail element
        ImageView thumbnailImageView =
                (ImageView) rowView.findViewById(com.example.mar.mardip2.R.id.recipe_list_thumbnail);

        // 1
        MedRecord medRecord = (MedRecord) getItem(position);

        // 2
        titleTextView.setText(medRecord.getDoc_special());
        subtitleTextView.setText(medRecord.getDoc_name());
        detailTextView.setText(medRecord.getDate());

        // 3
        //Picasso.with(mContext).load(recipe.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);
        thumbnailImageView.setImageResource(R.drawable.record);

        return rowView;
    }

}
