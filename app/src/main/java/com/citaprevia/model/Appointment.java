package com.citaprevia.model;

import java.util.Date;

/**
 * Created by dariomartin on 13/6/17.
 */

public class Appointment {

    private Date date;
    private String notes;
    private String id;

    public Appointment(String id, Date date) {
        this.date = date;
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
