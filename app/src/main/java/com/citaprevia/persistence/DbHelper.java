package com.citaprevia.persistence;

import com.citaprevia.model.Appointment;
import com.citaprevia.model.User;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by dariomartin on 15/6/17.
 */

public class DbHelper {

    private static DbHelper instance;

    DatabaseReference database = FirebaseDatabase.getInstance().getReference();

    private DbHelper() {
        database = FirebaseDatabase.getInstance().getReference();
    }

    public static DbHelper getInstance() {
        if (instance == null) {
            instance = new DbHelper();
        }
        return instance;
    }

    public void addUser(String userId, User user) {
        database.child("users").child(userId).setValue(user);
    }


    public void addNewAppointment(Appointment appointment) {
        database.child("appointments").child(String.valueOf(appointment.getCalendar().getTimeInMillis())).setValue(appointment);
    }
}
