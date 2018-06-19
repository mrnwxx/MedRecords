package com.example.mar.mardip2.HealthIndicators.History;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.mar.mardip2.DatabaseHelper;
import com.example.mar.mardip2.HealthIndicators.BloodPressure;
import com.example.mar.mardip2.HealthIndicators.Pulse;
import com.example.mar.mardip2.HealthIndicators.Sugar;
import com.example.mar.mardip2.HealthIndicators.Weight;
import com.example.mar.mardip2.R;

import java.util.ArrayList;
import java.util.List;

public class HealthIndicatorHist extends AppCompatActivity {

    ListView mListView;
    EditText var1;
    EditText var2;
    String str1;
    String str2;

    List<Weight> weightArrayList;
    List<BloodPressure> bloodPressureArrayList;
    List<Pulse> pulseArrayList;
    List<Sugar> sugarArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final String healthIndicator = this.getIntent().getExtras().getString("healthIndicator");
        final Context context = this;
        final LayoutInflater inflater = this.getLayoutInflater();

        setTitle(healthIndicator);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_indicator_hist);

        final DatabaseHelper db = new DatabaseHelper(this);

        weightArrayList = db.getAllWeights();
        bloodPressureArrayList = db.getAllBloodPressure();
        pulseArrayList = db.getAllPulse();
        sugarArrayList = db.getAllSugar();

        //final EditText var1 = findViewById(R.id.health_indicator_hist_date);
        //final EditText var2 = findViewById(R.id.health_indicator_hist_value);

        mListView = (ListView) findViewById(R.id.health_indicator_hist_list);

        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete record?")
                .setMessage(foo(healthIndicator, position))
                .setPositiveButton("Delete" ,new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        HealIndHistAdapter adapter = null;

                        //var1 = findViewById(R.id.health_indicator_hist_date);
                        //var2 = findViewById(R.id.health_indicator_hist_value);

                        switch (healthIndicator) {
                            case "Weight":
                                //str1 = var1.getText().toString();
                                //str2 = var2.getText().toString();
                                //db.addWeight(str1, str2);

                                db.deleteWeight(weightArrayList.get(position));

                                weightArrayList = db.getAllWeights();

                                adapter = new HealIndHistAdapter(context,
                                        (ArrayList<Weight>) weightArrayList);

                                break;

                            case "Blood pressure":
                                //db.addBloodPressure(var1.getText().toString(),
                                //        var2.getText().toString());

                                db.deleteBloodPressure(bloodPressureArrayList.get(position));

                                bloodPressureArrayList = db.getAllBloodPressure();

                                adapter = new HealIndHistAdapter(context,
                                        (ArrayList<BloodPressure>)bloodPressureArrayList);

                                break;

                            case "Pulse":
                                //db.addPulse(var1.getText().toString(),var2.getText().toString());

                                db.deletePulse(pulseArrayList.get(position));

                                pulseArrayList = db.getAllPulse();

                                adapter = new HealIndHistAdapter(context,
                                        (ArrayList<Pulse>) pulseArrayList);

                                break;

                            case "Sugar":
                                //db.addSugar(var1.getText().toString(),var2.getText().toString());

                                db.deleteSugar(sugarArrayList.get(position));

                                sugarArrayList = db.getAllSugar();

                                adapter = new HealIndHistAdapter(context,
                                        (ArrayList<Sugar>) sugarArrayList);

                                break;

                            //default: adapter = null;
                        }


                        mListView.setAdapter(adapter);
                    }

                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        //LoginDialogFragment.this.getDialog().cancel();
                        //onBackPressed();
                    }
                });

                builder.create();
                builder.show();

                return false;
            }
        });

        HealIndHistAdapter adapter = null;

        switch (healthIndicator) {
            case "Weight":
                List<Weight> weightArrayList = db.getAllWeights();
                adapter = new HealIndHistAdapter(this, (ArrayList<Weight>) weightArrayList);
                break;

            case "Blood pressure":
                List<BloodPressure> bloodPressureList = db.getAllBloodPressure();
                adapter = new HealIndHistAdapter(this, (ArrayList<BloodPressure>) bloodPressureList);
                break;

            case "Pulse":
                List<Pulse> pulseList = db.getAllPulse();
                adapter = new HealIndHistAdapter(this, (ArrayList<Pulse>) pulseList);
                break;

            case "Sugar":
                List<Sugar> sugarList = db.getAllSugar();
                adapter = new HealIndHistAdapter(this, (ArrayList<Sugar>) sugarList);
                break;

            //default: adapter = null;
        }


        mListView.setAdapter(adapter);



        Button fab = findViewById(R.id.add_health_ind_hist);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();

                /*AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);

                // Set up the input
                final EditText input = new EditText(context);

                // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
                input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

                alertDialogBuilder.setView(input);
                alertDialogBuilder.setTitle("Add record");

                // Set up the buttons
                alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //m_Text = input.getText().toString();
                    }
                });
                alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                alertDialogBuilder.show();*/

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                // Get the layout inflater
                //LayoutInflater inflater = this.getLayoutInflater();

                View mView = inflater.inflate(R.layout.dialog_add_heal_hist, null);

                var1 = mView.findViewById(R.id.health_indicator_hist_date);
                var2 = mView.findViewById(R.id.health_indicator_hist_value);

                // Inflate and set the layout for the dialog
                // Pass null as the parent view because its going in the dialog layout
                builder.setView(mView)
                        // Add action buttons
                        .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int id) {
                                HealIndHistAdapter adapter = null;

                                //var1 = findViewById(R.id.health_indicator_hist_date);
                                //var2 = findViewById(R.id.health_indicator_hist_value);

                                switch (healthIndicator) {
                                    case "Weight":
                                        str1 = var1.getText().toString();
                                        str2 = var2.getText().toString();
                                        db.addWeight(str1, str2);

                                        weightArrayList = db.getAllWeights();

                                        adapter = new HealIndHistAdapter(context,
                                                (ArrayList<Weight>) db.getAllWeights());

                                        break;

                                    case "Blood pressure":
                                        db.addBloodPressure(var1.getText().toString(),
                                                var2.getText().toString());

                                        bloodPressureArrayList =
                                                db.getAllBloodPressure();

                                        adapter = new HealIndHistAdapter(context,
                                                (ArrayList<BloodPressure>)bloodPressureArrayList);

                                        break;

                                    case "Pulse":
                                        db.addPulse(var1.getText().toString(),var2.getText().toString());

                                        pulseArrayList = db.getAllPulse();

                                        adapter = new HealIndHistAdapter(context,
                                                (ArrayList<Pulse>) pulseArrayList);

                                        break;

                                    case "Sugar":
                                        db.addSugar(var1.getText().toString(),var2.getText().toString());

                                        sugarArrayList = db.getAllSugar();

                                        adapter = new HealIndHistAdapter(context,
                                                (ArrayList<Sugar>) sugarArrayList);

                                        break;

                                    //default: adapter = null;
                                }


                                mListView.setAdapter(adapter);
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //LoginDialogFragment.this.getDialog().cancel();
                                //onBackPressed();
                            }
                        });
                builder.create();
                builder.show();

            }
        });

        //var1 = findViewById(R.id.health_indicator_hist_date);
        //var2 = findViewById(R.id.health_indicator_hist_value);
    }

    private String foo(String healthIndicator, int position) {
        String str1, str2;

        switch (healthIndicator) {
            case "Weight":
                str1 = weightArrayList.get(position).getDate();
                str2 = weightArrayList.get(position).getValue();
                break;

            case "Blood pressure":
                str1 = bloodPressureArrayList.get(position).getDate();
                str2 = bloodPressureArrayList.get(position).getValue();
                break;

            case "Pulse":
                str1 = pulseArrayList.get(position).getDate();
                str2 = pulseArrayList.get(position).getValue();
                break;

            case "Sugar":
                str1 = sugarArrayList.get(position).getDate();
                str2 = sugarArrayList.get(position).getValue();
                break;

            default: return "This record will be deleted permanently";
        }

        return str1 + "   -   " + str2;
    }


}
