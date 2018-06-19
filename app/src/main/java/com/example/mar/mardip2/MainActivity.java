package com.example.mar.mardip2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.CalendarView;
import android.widget.ListView;

import com.example.mar.mardip2.HealthIndicators.HealthIndicatorsActivity;
import com.example.mar.mardip2.MedRecord.AddMedRecordActivity;
import com.example.mar.mardip2.MedRecord.MedRecord;
import com.example.mar.mardip2.MedRecord.MedRecordActivity;
import com.example.mar.mardip2.MedRecord.MedRecordsAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, AddMedRecordActivity.class);
                startActivity(intent);
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(this);

        DatabaseHelper db = new DatabaseHelper(this);

        mListView = (ListView) findViewById(R.id.list_view);

        // 1
        final ArrayList<MedRecord> medRecordArrayList = (ArrayList) db.getAllMedRecords();
        // 2
        /*String[] listItems = new String[medRecordArrayList.size()];
        // 3
        for(int i = 0; i < medRecordArrayList.size(); i++) {
            MedRecord medRecord = medRecordArrayList.get(i);
            listItems[i] = medRecord.getDoc_special() + " | " + medRecord.getDoc_name() + " | "
                                + medRecord.getDate() + " | " + medRecord.getVisit_num();
        }*/
        // 4
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        //mListView.setAdapter(adapter);

        MedRecordsAdapter adapter = new MedRecordsAdapter(this, medRecordArrayList);
        mListView.setAdapter(adapter);

        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 1
                MedRecord selectedMedRecord = medRecordArrayList.get(position);

                // 2
                Intent detailIntent = new Intent(context, MedRecordActivity.class);

                // 3
                detailIntent.putExtra("ID",         selectedMedRecord.getId());
                detailIntent.putExtra("special",    selectedMedRecord.getDoc_special());
                detailIntent.putExtra("date",       selectedMedRecord.getDate());
                detailIntent.putExtra("Visit_num",  String.valueOf(selectedMedRecord
                                                                                .getVisit_num()));
                detailIntent.putExtra("Doc_name",   selectedMedRecord.getDoc_name());
                detailIntent.putExtra("hospital",   selectedMedRecord.getDoc_hospital());
                detailIntent.putExtra("diagnos",    selectedMedRecord.getDoc_diagnos());
                detailIntent.putExtra("treatment",  selectedMedRecord.getDoc_treatment());
                detailIntent.putExtra("medication", selectedMedRecord.getDoc_medication());
                detailIntent.putExtra("referral",   selectedMedRecord.getDoc_referral());

                // 4
                startActivity(detailIntent);
            }

        });
    }

    @Override
    public void onBackPressed() {
        //default code
        /*DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }*/

        Intent intend = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intend);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.med_rec) {
            // Handle the camera action
        } else if (id == R.id.anal) {

            startActivity(new Intent(MainActivity.this, AnalActivity.class));

        } else if (id == R.id.calen) {

            startActivity(new Intent(MainActivity.this, CalendarActivity.class));

        } else if (id == R.id.heal_ind) {

            startActivity(new Intent(MainActivity.this, HealthIndicatorsActivity.class));

        } else if (id == R.id.symp) {

            startActivity(new Intent(MainActivity.this, Symptoms.class));

        } else if (id == R.id.logout) {

            onBackPressed();

        } else if (id == R.id.addprof) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
