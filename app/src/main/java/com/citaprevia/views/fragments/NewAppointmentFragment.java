package com.citaprevia.views.fragments;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.citaprevia.dariomartin.R;
import com.citaprevia.model.Appointment;
import com.citaprevia.persistence.DbHelper;
import com.citaprevia.presenters.NewAppointmentPresenter;
import com.citaprevia.views.interfaces.NewAppointmentView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by dariomartin on 13/6/17.
 */

public class NewAppointmentFragment extends Fragment implements NewAppointmentView, DatePickerDialog.OnDateSetListener {

    private TextView date;
    private NewAppointmentPresenter presenter;
    private LinearLayout availableTimesList;
    private Button confirmButton;
    private View.OnClickListener onAvailableTimeClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            createNewAppointment();
        }
    };

    private Calendar selectedDay;


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

        date = (TextView) view.findViewById(R.id.date);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        availableTimesList = (LinearLayout) view.findViewById(R.id.available_times_list);

        confirmButton = (Button) view.findViewById(R.id.confirm_button);

        presenter = new NewAppointmentPresenter(this);

        selectedDay = presenter.getNextAvailableDate();
        updateDate();
        return view;
    }

    private void createNewAppointment() {
        FirebaseAuth auth = FirebaseAuth.getInstance();

        Appointment appointment = new Appointment(selectedDay.getTimeInMillis(), auth.getCurrentUser().getUid());

        DbHelper dbHelper = DbHelper.getInstance();
        dbHelper.addNewAppointment(appointment);
    }

    private void showDatePicker() {
        int year = selectedDay.get(Calendar.YEAR);
        int month = selectedDay.get(Calendar.MONTH);
        int day = selectedDay.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
        datePickerDialog.show();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        selectedDay = Calendar.getInstance();
        selectedDay.set(year, month, dayOfMonth);
        updateDate();
    }

    @Override
    public void showAvailableTimes(ArrayList<Calendar> availableTimes) {

        if (availableTimes.isEmpty()) {
            //setVisibility(GONE);
            return;
        }

        LayoutInflater inflater = LayoutInflater.from(getContext());

        availableTimesList.removeAllViews();

        for (int i = 0; i < availableTimes.size(); i++) {
            View item = inflater.inflate(R.layout.date_item, null, false);
            TextView videoName = (TextView) item.findViewById(R.id.date);
            videoName.setText(DateUtils.formatDateTime(getActivity(), availableTimes.get(i).getTimeInMillis(), DateUtils.FORMAT_SHOW_TIME));
            item.setTag(i);
            item.setOnClickListener(onAvailableTimeClickListener);
            availableTimesList.addView(item);
        }

    }

    private void updateDate() {
        date.setText(DateUtils.formatDateTime(getContext(), selectedDay.getTimeInMillis(), DateUtils.FORMAT_ABBREV_ALL));
        presenter.getAvailableHours(selectedDay);
    }
}
