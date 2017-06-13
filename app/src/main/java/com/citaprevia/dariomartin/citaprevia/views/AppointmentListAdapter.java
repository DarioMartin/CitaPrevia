package com.citaprevia.dariomartin.citaprevia.views;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citaprevia.dariomartin.citaprevia.R;
import com.citaprevia.dariomartin.citaprevia.model.Appointment;
import com.citaprevia.dariomartin.citaprevia.views.AppointmentsFragment.OnListFragmentInteractionListener;

import java.util.List;

public class AppointmentListAdapter extends RecyclerView.Adapter<AppointmentListAdapter.AppointmentViewHolder> {

    private final List<Appointment> appointments;
    private final OnListFragmentInteractionListener mListener;

    public AppointmentListAdapter(List<Appointment> appointments, OnListFragmentInteractionListener listener) {
        this.appointments = appointments;
        mListener = listener;
    }

    @Override
    public AppointmentViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item, parent, false);
        return new AppointmentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AppointmentViewHolder holder, int position) {
        holder.appointment = appointments.get(position);
        holder.mIdView.setText(appointments.get(position).getDate().toString());
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

    public class AppointmentViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mContentView;
        public Appointment appointment;

        public AppointmentViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (TextView) view.findViewById(R.id.date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.getText() + "'";
        }
    }
}
