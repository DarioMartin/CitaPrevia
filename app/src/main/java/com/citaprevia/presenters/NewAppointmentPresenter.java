package com.citaprevia.presenters;

import com.citaprevia.views.interfaces.NewAppointmentView;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by dariomartin on 17/6/17.
 */

public class NewAppointmentPresenter {
    private final NewAppointmentView view;

    public NewAppointmentPresenter(NewAppointmentView view) {
        this.view = view;
    }

    public void getAvailableHours(Calendar selectedDay) {
        ArrayList<Calendar> availableHours = new ArrayList<>();

        int firstHour = 10;
        int lastHour = 19;
        int interval = 30;

        for (int hour = firstHour; hour < lastHour; hour++) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(selectedDay.get(selectedDay.YEAR),
                    selectedDay.get(selectedDay.MONTH),
                    selectedDay.get(selectedDay.DAY_OF_MONTH),
                    hour,
                    0);
            availableHours.add(calendar);
        }

        view.showAvailableTimes(availableHours);
    }

    public Calendar getNextAvailableDate() {
        return Calendar.getInstance();
    }
}
