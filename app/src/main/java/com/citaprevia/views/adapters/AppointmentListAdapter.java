package com.citaprevia.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citaprevia.dariomartin.R;
import com.citaprevia.model.Appointment;
import com.citaprevia.views.fragments.AppointmentsFragment;

import java.util.ArrayList;
import java.util.List;


public class AppointmentListAdapter extends RecyclerView.Adapter<AppointmentListAdapter.AppointmentViewHolder> {

    private final List<Appointment> appointments;
    private final AppointmentsFragment.OnListFragmentInteractionListener mListener;

    public AppointmentListAdapter(AppointmentsFragment.OnListFragmentInteractionListener listener) {
        this.appointments = new ArrayList<>();
        mListener = listener;
    }

    @Override
    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.appointement_list_item, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AppointmentViewHolder holder, int position) {

        holder.appointment = appointments.get(position);
        holder.setDate(appointments.get(position).getDate());
        holder.mContentView.setText(appointments.get(position).getNotes());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.appointment);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return appointments.size();
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
        notifyDataSetChanged();
    }

    public class AppointmentViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView date;
        public final TextView mContentView;
        private final Context context;
        public Appointment appointment;

        public AppointmentViewHolder(View view) {
            super(view);
            mView = view;
            date = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.date);
            context = view.getContext();
        }

        public void setDate(long dateInMills) {
            date.setText(DateUtils.formatDateTime(context, dateInMills, DateUtils.FORMAT_SHOW_DATE | DateUtils.FORMAT_SHOW_TIME));
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
