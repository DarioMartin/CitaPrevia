package com.citaprevia;

import com.citaprevia.model.Appointment;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by dariomartin on 13/6/17.
 */

public class MockAppointments {


    public static ArrayList<Appointment> getAppointments(int n){
        ArrayList<Appointment> appointments = new ArrayList<>();

        for(int i=0; i<n; i++){
            appointments.add(new Appointment(String.valueOf(i+1), new Date()));
        }

        return appointments;
    }
}
