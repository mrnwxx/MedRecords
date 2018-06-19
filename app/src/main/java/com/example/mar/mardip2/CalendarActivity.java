package com.example.mar.mardip2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.github.sundeepk.compactcalendarview.domain.Event;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class CalendarActivity extends AppCompatActivity {

    CompactCalendarView compactCalendarView;
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMMM- yyyy", Locale.getDefault());

    private Date mDateClicked = getCurrentDate();

    ArrayList<String> descriptions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        final EditText eventDescriptionEditText = findViewById(R.id.event_description_editText);
        Button addEventBtn = findViewById(R.id.add_event_btn);
        final ListView eventsListView = findViewById(R.id.events_listView);
        EditText eventDiscriptionEdit = findViewById(R.id.event_description_editText);
        final Context context = getApplicationContext();

        final DatabaseHelper db = new DatabaseHelper(this);

        //compactCalendarView = db.getCalendar();

        //final android.support.v7.app.ActionBar actionBar = getActionBar();
        //actionBar.setDisplayHomeAsUpEnabled(false);
        //actionBar.setTitle(null);

        compactCalendarView = findViewById(R.id.compactcalendar_view);
        compactCalendarView.setUseThreeLetterAbbreviation(true);

        //Event event = new Event(Color.RED, 1529314057000L, "Event 3rd parameter");
        //Event event1 = new Event();

        //compactCalendarView.addEvent(event);

        //Event event = new Event(Color.RED, 1529247688000L, "description......");
        //compactCalendarView.addEvent(event);
        //event = new Event(Color.RED, 1529338649000L, "qwe");
        //compactCalendarView.addEvent(event);

        //compactCalendarView.get

        //long mlong = compactCalendarView.getDrawingTime();

        //db.addCalendarHelper(compactCalendarView, String.valueOf(getCurrentDate().getTime()));

        //compactCalendarView = db.getCalendar();

        for (Event ev : compactCalendarView.getEvents(getCurrentDate()))
        {
            descriptions.add(ev.getData().toString());
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, descriptions);

        eventsListView.setAdapter(adapter);

        compactCalendarView.setListener(new CompactCalendarView.CompactCalendarViewListener() {
            @Override
            public void onDayClick(Date dateClicked) {
                //Context context = getApplicationContext();

                /*if (dateClicked.toString().compareTo("Mon Jun 18 00:00:00 EDT 2018") == 0) {
                    Toast.makeText(context, "Description of an event", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "No event", Toast.LENGTH_SHORT).show();
                }*/

                descriptions.clear();

                for (Event ev : compactCalendarView.getEvents(dateClicked))
                {
                    descriptions.add(ev.getData().toString());
                }
                ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, descriptions);

                eventsListView.setAdapter(adapter);

                mDateClicked = dateClicked;
            }

            @Override
            public void onMonthScroll(Date firstDayOfNewMonth) {
                //actionBar.setTitle(dateFormatMonth);
            }
        });

        addEventBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String description = eventDescriptionEditText.getText().toString();

                if (!description.equals("")) {
                    long timeInMilliseconds = 0;

                    //mDateClicked.setMinutes(55);

                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");
                        Date mDate = sdf.parse(mDateClicked.toString());
                        timeInMilliseconds = mDate.getTime();
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }


                    Event event = new Event(Color.RED, timeInMilliseconds, description);
                    compactCalendarView.addEvent(event);

                    //descriptions.clear();
                    descriptions.add(description);
                    ArrayAdapter adapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, descriptions);

                    eventsListView.setAdapter(adapter);

                    eventDescriptionEditText.setText("");

                    //db.addCalendarHelper(compactCalendarView,String.valueOf(getCurrentDate().getTime()));
                } else {
                    Toast.makeText(context, "Description is empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //db.addCalendarHelper(compactCalendarView, String.valueOf(getCurrentDate().getTime()));
    }

    public Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        //SimpleDateFormat mdformat = new SimpleDateFormat("yyyy / MM / dd ");
        //String strDate = "Current Date : " + mdformat.format(calendar.getTime());
        return calendar.getTime();
    }
}
