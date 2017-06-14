package com.citaprevia.views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.citaprevia.dariomartin.citaprevia.model.Appointment;
import com.citaprevia.dariomartin.R;
import com.citaprevia.dariomartin.citaprevia.views.AppointmentsFragment;
import com.citaprevia.dariomartin.citaprevia.views.UserFragment;

public class MainActivity extends AppCompatActivity implements AppointmentsFragment.OnListFragmentInteractionListener {

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_appointment:
                    setFragment(AppointmentsFragment.newInstance(""));
                    return true;
                case R.id.navigation_add:
                    setFragment(AppointmentsFragment.newInstance(""));
                    return true;
                case R.id.navigation_profile:
                    setFragment(UserFragment.newInstance(""));
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    protected void setFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction =
                fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_containerone, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onListFragmentInteraction(Appointment appointment) {

    }
}
