package com.example.mar.mardip2.MedRecord;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.mar.mardip2.DatabaseHelper;
import com.example.mar.mardip2.MainActivity;
import com.example.mar.mardip2.R;

public class AddMedRecordActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_med_record);

        final DatabaseHelper db = new DatabaseHelper(this);

        final EditText var1 = (EditText) findViewById(R.id.editText);
        final EditText var2 = (EditText) findViewById(R.id.editText2);
        final EditText var3 = (EditText) findViewById(R.id.editText3);
        final EditText var4 = (EditText) findViewById(R.id.editText4);
        final EditText var5 = (EditText) findViewById(R.id.editText5);
        final EditText var6 = (EditText) findViewById(R.id.editText6);
        final EditText var7 = (EditText) findViewById(R.id.editText7);
        final EditText var8 = (EditText) findViewById(R.id.editText8);
        final EditText var9 = (EditText) findViewById(R.id.editText9);

        Button fab = (Button) findViewById(R.id.button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //      .setAction("Action", null).show();

                db.addMedRecord(var1.getText().toString(),
                                var2.getText().toString(),
                                Integer.parseInt(var3.getText().toString()),
                                var4.getText().toString(),
                                var5.getText().toString(),
                                var6.getText().toString(),
                                var7.getText().toString(),
                                var8.getText().toString(),
                                var9.getText().toString());

                Intent intent = new Intent(AddMedRecordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
