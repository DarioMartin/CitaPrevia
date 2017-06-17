package com.citaprevia.model;


import java.util.Calendar;

/**
 * Created by dariomartin on 13/6/17.
 */

public class Appointment {

    private long date;
    private String userId;
    private String notes;


    public Appointment() {
    }

    public Appointment(long date, String userId) {
        this.date = date;
        this.userId = userId;
    }

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }


}
