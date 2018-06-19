package com.example.mar.mardip2.HealthIndicators;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.mar.mardip2.HealthIndicators.History.HealthIndicatorHist;
import com.example.mar.mardip2.R;

import java.util.ArrayList;

public class HealthIndicatorsActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_indicators);

        final ArrayList<HealthIndicator> healthIndicatorList = new ArrayList<>(4);

        healthIndicatorList.add(new HealthIndicator(getString(R.string.Weight), R.drawable.weight));
        healthIndicatorList.add(new HealthIndicator(getString(R.string.Blood_pressure), R.drawable.blood));
        healthIndicatorList.add(new HealthIndicator(getString(R.string.Pulse), R.drawable.pulse));
        healthIndicatorList.add(new HealthIndicator(getString(R.string.Sugar), R.drawable.sugar));

        mListView = (ListView) findViewById(R.id.healind_list_view);

        HealthIndicatorsAdapter adapter = new HealthIndicatorsAdapter(this, healthIndicatorList);
        mListView.setAdapter(adapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                HealthIndicator selectedHealthIndicator = healthIndicatorList.get(position);

                // 2

                Intent detailIntent = new Intent(context, HealthIndicatorHist.class);

                // 3
                detailIntent.putExtra ("healthIndicator", selectedHealthIndicator.getTitle());

                // 4
                startActivity(detailIntent);
            }

        });

    }
}
