package com.example.mar.mardip2.MedRecord;

public class MedRecord {

    int id;
    String doc_special;
    String date;
    int visit_num;
    String doc_name;
    String doc_hospital;
    String doc_diagnos;
    String doc_treatment;
    String doc_medication;
    String doc_referral;


    public MedRecord(){

    }

    public MedRecord(int id, String doc_special, String date, int visit_num, String doc_name, String doc_hospital, String doc_diagnos, String doc_treatment, String doc_medication, String doc_referral){
        this.id = id;
        this.doc_special = doc_special;
        this.date = date;
        this.visit_num = visit_num;
        this.doc_name = doc_name;
        this.doc_hospital = doc_hospital;
        this.doc_diagnos = doc_diagnos;
        this.doc_treatment = doc_treatment;
        this.doc_medication = doc_medication;
        this.doc_referral = doc_referral;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDoc_special() {
        return doc_special;
    }

    public void setDoc_special(String doc_special) {
        this.doc_special = doc_special;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getVisit_num() {
        return visit_num;
    }

    public void setVisit_num(int visit_num) {
        this.visit_num = visit_num;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public String getDoc_hospital() {
        return doc_hospital;
    }

    public void setDoc_hospital(String doc_hospital) {
        this.doc_hospital = doc_hospital;
    }

    public String getDoc_diagnos() {
        return doc_diagnos;
    }

    public void setDoc_diagnos(String doc_diagnos) {
        this.doc_diagnos = doc_diagnos;
    }

    public String getDoc_treatment() {
        return doc_treatment;
    }

    public void setDoc_treatment(String doc_treatment) {
        this.doc_treatment = doc_treatment;
    }

    public String getDoc_medication() {
        return doc_medication;
    }

    public void setDoc_medication(String doc_medication) {
        this.doc_medication = doc_medication;
    }

    public String getDoc_referral() {
        return doc_referral;
    }

    public void setDoc_referral(String doc_referral) {
        this.doc_referral = doc_referral;
    }
}
