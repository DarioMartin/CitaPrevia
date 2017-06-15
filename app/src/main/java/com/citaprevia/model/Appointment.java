package com.citaprevia.model;


import java.util.Calendar;

/**
 * Created by dariomartin on 13/6/17.
 */

public class Appointment {

    private Calendar calendar;
    private String userId;
    private String notes;


    public Appointment() {
    }

    public Appointment(Calendar calendar, String userId) {
        this.calendar = calendar;
        this.userId = userId;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
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
