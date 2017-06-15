package com.citaprevia.views;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;

import com.citaprevia.dariomartin.R;
import com.citaprevia.model.Appointment;
import com.citaprevia.persistence.DbHelper;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Calendar;


/**
 * Created by dariomartin on 13/6/17.
 */

public class NewAppointmentFragment extends Fragment implements DatePicker.OnDateChangedListener {


    private Button newAppointmentButton;
    private DatePicker datePicker;

    public NewAppointmentFragment() {
    }

    public static NewAppointmentFragment newInstance() {
        NewAppointmentFragment fragment = new NewAppointmentFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_appointment, container, false);


        Calendar calendar = Calendar.getInstance();
        datePicker = (DatePicker) view.findViewById(R.id.date_picker);
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), this);

        newAppointmentButton = (Button) view.findViewById(R.id.new_appointment_button);
        newAppointmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createNewAppointment();
            }
        });

        return view;
    }

    private void createNewAppointment() {

    }

    @Override
    public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, monthOfYear, dayOfMonth);

        FirebaseAuth auth = FirebaseAuth.getInstance();

        Appointment appointment = new Appointment(calendar, auth.getCurrentUser().getUid());

        DbHelper dbHelper = DbHelper.getInstance();
        dbHelper.addNewAppointment(appointment);

    }
}
