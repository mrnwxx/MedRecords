package com.example.mar.mardip2.HealthIndicators;

public class BloodPressure {

    private int id;
    private String date;
    private String value;

    public BloodPressure() {
    }

    public BloodPressure(int id, String date, String value) {
        this.id = id;
        this.date = date;

        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
