package com.example.mar.mardip2.MedRecord;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.mar.mardip2.DatabaseHelper;
import com.example.mar.mardip2.MainActivity;
import com.example.mar.mardip2.R;

public class MedRecordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_med_record);

        //DatabaseHelper db = new DatabaseHelper(this);

        //final ArrayList<MedRecord> medRecordArrayList = (ArrayList) db.getAllMedRecords();

        final TextView var1 = (TextView) findViewById(R.id.textView2);
        final TextView var2 = (TextView) findViewById(R.id.textView3);
        final TextView var3 = (TextView) findViewById(R.id.textView4);
        final TextView var4 = (TextView) findViewById(R.id.textView5);
        final TextView var5 = (TextView) findViewById(R.id.textView6);
        final TextView var6 = (TextView) findViewById(R.id.textView7);
        final TextView var7 = (TextView) findViewById(R.id.textView8);
        final TextView var8 = (TextView) findViewById(R.id.textView9);
        final TextView var9 = (TextView) findViewById(R.id.textView10);

        final int ID = this.getIntent().getExtras().getInt("ID");
        var1.setText(this.getIntent().getExtras().getString("special"));
        var2.setText(this.getIntent().getExtras().getString("date"));
        var3.setText(this.getIntent().getExtras().getString("Visit_num"));
        var4.setText(this.getIntent().getExtras().getString("Doc_name"));
        var5.setText(this.getIntent().getExtras().getString("hospital"));
        var6.setText(this.getIntent().getExtras().getString("diagnos"));
        var7.setText(this.getIntent().getExtras().getString("treatment"));
        var8.setText(this.getIntent().getExtras().getString("medication"));
        var9.setText(this.getIntent().getExtras().getString("referral"));

        final Context context = this;

        Button btn2 = (Button) findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = new DatabaseHelper(context);

                db.deleteMedRecord(ID);

                Intent intent = new Intent(MedRecordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
