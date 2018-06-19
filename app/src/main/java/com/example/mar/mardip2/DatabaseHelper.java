package com.example.mar.mardip2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.mar.mardip2.HealthIndicators.BloodPressure;
import com.example.mar.mardip2.HealthIndicators.Pulse;
import com.example.mar.mardip2.HealthIndicators.Sugar;
import com.example.mar.mardip2.HealthIndicators.Weight;
import com.example.mar.mardip2.MedRecord.MedRecord;
import com.github.sundeepk.compactcalendarview.CompactCalendarView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "medRecordsManager";
    private static final String TABEL_MEDRECORDS = "medRecords";
    private static final String KEY_ID = "id";
    private static final String KEY_DOC_SPECIAL = "doc_special";
    private static final String KEY_DATE = "date";
    private static final String KEY_VISIT_NUM = "visit_num";
    private static final String KEY_DOC_NAME = "doc_name";
    private static final String KEY_HOSPITAL = "hospital";
    private static final String KEY_DIAGNOS = "diagnos";
    private static final String KEY_TREATMENT = "treatment";
    private static final String KEY_MEDICATION = "medication";
    private static final String KEY_REFERRAL = "referral";

    private static final String TABLE_WEIGHT = "weight";
    private static final String KEY_VALUE = "value";

    private static final String TABLE_BLOOD_PRESSURE = "bloodPressure";

    private static final String TABLE_PULSE = "pulse";

    private static final String TABLE_SUGAR = "sugar";

    private static final String TABLE_CALENDAR = "calendar";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_MED_RECORDS_TABLE = "CREATE TABLE " + TABEL_MEDRECORDS + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DOC_SPECIAL + " TEXT, "
                + KEY_DATE + " TEXT, "
                + KEY_VISIT_NUM + " INT, "
                + KEY_DOC_NAME + " TEXT, "
                + KEY_HOSPITAL + " TEXT, "
                + KEY_DIAGNOS + " TEXT, "
                + KEY_TREATMENT + " TEXT, "
                + KEY_MEDICATION + " TEXT, "
                + KEY_REFERRAL + " TEXT" + ")";

        db.execSQL(CREATE_MED_RECORDS_TABLE);


        String CREATE_HEALTH_IND_WEIGHT_TABLE = "CREATE TABLE " + TABLE_WEIGHT + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_VALUE + " TEXT" + ")";

        db.execSQL(CREATE_HEALTH_IND_WEIGHT_TABLE);


        String CREATE_BLOOD_PRESSURE_TABLE = "CREATE TABLE " + TABLE_BLOOD_PRESSURE + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_VALUE + " TEXT" + ")";

        db.execSQL(CREATE_BLOOD_PRESSURE_TABLE);


        String CREATE_PULSE_TABLE = "CREATE TABLE " + TABLE_PULSE + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_VALUE + " TEXT" + ")";

        db.execSQL(CREATE_PULSE_TABLE);


        String CREATE_SUGAR_TABLE = "CREATE TABLE " + TABLE_SUGAR + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_DATE + " TEXT, "
                + KEY_VALUE + " TEXT" + ")";

        db.execSQL(CREATE_SUGAR_TABLE);

        String CREATE_CALENDAR_TABLE = "CREATE TABLE " + TABLE_CALENDAR + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, "
                + KEY_VALUE + " BLOB,"
                + KEY_DATE + " TEXT" + ")";

        db.execSQL(CREATE_CALENDAR_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABEL_MEDRECORDS);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WEIGHT);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_BLOOD_PRESSURE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PULSE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SUGAR);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CALENDAR);

        onCreate(db);
    }

    //=========================================================================

    public void addMedRecord(String doc_special, String date, int visit_num, String doc_name,
                             String hospital, String diagnos, String treatment, String medication,
                             String referral) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DOC_SPECIAL, doc_special);
        values.put(KEY_DATE, date);
        values.put(KEY_VISIT_NUM, visit_num);
        values.put(KEY_DOC_NAME,doc_name);
        values.put(KEY_HOSPITAL, hospital);
        values.put(KEY_DIAGNOS, diagnos);
        values.put(KEY_TREATMENT, treatment);
        values.put(KEY_MEDICATION, medication);
        values.put(KEY_REFERRAL, referral);

        db.insert(TABEL_MEDRECORDS, null, values);
        db.close();

    }

    public List<MedRecord> getAllMedRecords() {
        List<MedRecord> medRecordList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABEL_MEDRECORDS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                MedRecord medRecord = new MedRecord();

                medRecord.setId(Integer.parseInt(cursor.getString(0)));
                medRecord.setDoc_special(cursor.getString(1));
                medRecord.setDate(cursor.getString(2));
                medRecord.setVisit_num(Integer.parseInt(cursor.getString(3)));
                medRecord.setDoc_name(cursor.getString(4));
                medRecord.setDoc_hospital(cursor.getString(5));
                medRecord.setDoc_diagnos(cursor.getString(6));
                medRecord.setDoc_treatment(cursor.getString(7));
                medRecord.setDoc_medication(cursor.getString(8));
                medRecord.setDoc_referral(cursor.getString(9));

                medRecordList.add(medRecord);
            } while (cursor.moveToNext());
        }

        return medRecordList;
    }

    public void deleteMedRecord(MedRecord medRecord) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABEL_MEDRECORDS, KEY_ID + "=?",
                new String[]{String.valueOf(medRecord.getId())});
        db.close();
    }

    public void deleteMedRecord(int medRecordID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABEL_MEDRECORDS, KEY_ID + "=?", new String[]{String.valueOf(medRecordID)});
        db.close();
    }


    //=========================================================================


    public void addWeight(String date, String value) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, date);
        values.put(KEY_VALUE, value);

        db.insert(TABLE_WEIGHT, null, values);
        db.close();

    }

    public List<Weight> getAllWeights() {
        List<Weight> weightList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_WEIGHT;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Weight weight = new Weight();

                weight.setId(Integer.parseInt(cursor.getString(0)));
                weight.setDate(cursor.getString(1));
                weight.setValue(cursor.getString(2));

                weightList.add(weight);
            } while (cursor.moveToNext());
        }

        return weightList;
    }

    public void deleteWeight(int weightID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WEIGHT, KEY_ID + "=?", new String[]{String.valueOf(weightID)});
        db.close();
    }

    public void deleteWeight(Weight weight) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_WEIGHT, KEY_ID + "=?", new String[]{String.valueOf(weight.getId())});
        db.close();
    }

    //=========================================================================

    public void addBloodPressure(String date, String value) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, date);
        values.put(KEY_VALUE, value);

        db.insert(TABLE_BLOOD_PRESSURE, null, values);
        db.close();

    }

    public List<BloodPressure> getAllBloodPressure() {
        List<BloodPressure> bloodPressureList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_BLOOD_PRESSURE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                BloodPressure bloodPressure = new BloodPressure();

                bloodPressure.setId(Integer.parseInt(cursor.getString(0)));
                bloodPressure.setDate(cursor.getString(1));
                bloodPressure.setValue(cursor.getString(2));

                bloodPressureList.add(bloodPressure);
            } while (cursor.moveToNext());
        }

        return bloodPressureList;
    }

    public void deleteBloodPressure(int bloodPressureID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BLOOD_PRESSURE, KEY_ID + "=?", new String[]{String.valueOf(bloodPressureID)});
        db.close();
    }

    public void deleteBloodPressure(BloodPressure bloodPressure) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_BLOOD_PRESSURE, KEY_ID + "=?", new String[]{String.valueOf(bloodPressure.getId())});
        db.close();
    }

    //=========================================================================

    public void addPulse(String date, String value) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, date);
        values.put(KEY_VALUE, value);

        db.insert(TABLE_PULSE, null, values);
        db.close();

    }

    public List<Pulse> getAllPulse() {
        List<Pulse> pulsesList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_PULSE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Pulse pulse = new Pulse();

                pulse.setId(Integer.parseInt(cursor.getString(0)));
                pulse.setDate(cursor.getString(1));
                pulse.setValue(cursor.getString(2));

                pulsesList.add(pulse);
            } while (cursor.moveToNext());
        }

        return pulsesList;
    }

    public void deletePulse(int pulseID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PULSE, KEY_ID + "=?", new String[]{String.valueOf(pulseID)});
        db.close();
    }

    public void deletePulse(Pulse pulse) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PULSE, KEY_ID + "=?", new String[]{String.valueOf(pulse.getId())});
        db.close();
    }

    //=========================================================================

    public void addSugar(String date, String value) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_DATE, date);
        values.put(KEY_VALUE, value);

        db.insert(TABLE_SUGAR, null, values);
        db.close();

    }

    public List<Sugar> getAllSugar() {
        List<Sugar> sugarList = new ArrayList<>();

        String selectQuery = "SELECT * FROM " + TABLE_SUGAR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Sugar sugar = new Sugar();

                sugar.setId(Integer.parseInt(cursor.getString(0)));
                sugar.setDate(cursor.getString(1));
                sugar.setValue(cursor.getString(2));

                sugarList.add(sugar);
            } while (cursor.moveToNext());
        }

        return sugarList;
    }

    public void deleteSugar(int sugarID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUGAR, KEY_ID + "=?", new String[]{String.valueOf(sugarID)});
        db.close();
    }

    public void deleteSugar(Sugar sugar) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUGAR, KEY_ID + "=?", new String[]{String.valueOf(sugar.getId())});
        db.close();
    }

    //=========================================================================

    public void addCalendar(CompactCalendarView compactCalendarView, String date) {

        Gson gson = new Gson();

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        byte[] mByte = gson.toJson(compactCalendarView).getBytes();
        values.put(KEY_VALUE, mByte);
        values.put(KEY_DATE, date);

        db.insert(TABLE_CALENDAR, null, values);
        db.close();

    }

    public CompactCalendarView getCalendar() {
        CompactCalendarView compactCalendarView;

        String selectQuery = "SELECT * FROM " + TABLE_CALENDAR;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        cursor.moveToFirst();

        byte[] blob = cursor.getBlob(cursor.getColumnIndex(KEY_VALUE));
        String json = new String(blob);
        Gson gson = new Gson();

        compactCalendarView = gson.fromJson(json, CompactCalendarView.class);

        return compactCalendarView;
    }

    public void addCalendarHelper(CompactCalendarView compactCalendarView, String date) {
        SQLiteDatabase db = this.getWritableDatabase();

        String count = "SELECT count(*) FROM " + TABLE_CALENDAR;
        Cursor mcursor = db.rawQuery(count, null);
        mcursor.moveToFirst();
        int icount = mcursor.getInt(0);



        if (icount == 0) {
            addCalendar(compactCalendarView, date);
        } else {

            String selectQuery = "SELECT * FROM " + TABLE_CALENDAR;
            Cursor cursor = db.rawQuery(selectQuery, null);
            cursor.moveToFirst();
            String dateOld = cursor.getString(2);

            if (Long.getLong(dateOld) < Long.getLong(date)) {
                Gson gson = new Gson();

                ContentValues values = new ContentValues();
                values.put(KEY_VALUE, gson.toJson(compactCalendarView).getBytes());
                values.put(KEY_DATE, date);

                db.update(TABLE_CALENDAR, values,"id = 1",null);
                db.close();
            }
        }
    }

    /*public void deleteSugar(int sugarID) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUGAR, KEY_ID + "=?", new String[]{String.valueOf(sugarID)});
        db.close();
    }

    public void deleteSugar(Sugar sugar) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_SUGAR, KEY_ID + "=?", new String[]{String.valueOf(sugar.getId())});
        db.close();
    }*/

}
