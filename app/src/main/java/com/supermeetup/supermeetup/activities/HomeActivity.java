package com.supermeetup.supermeetup.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import android.util.Log;

import com.crashlytics.android.Crashlytics;
import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.CategoryAdapter;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityHomeBinding;
import com.supermeetup.supermeetup.fakedata.FakeData;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.network.MeetupClient;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private MeetupClient meetupClient;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_nearby:
                    //binding.text.setText(R.string.navigation_nearby);
                    return true;
                case R.id.navigation_find:
                    //binding.text.setText(R.string.navigation_find);
                    return true;
                case R.id.navigation_new:
                    //binding.text.setText(R.string.navigation_new);
                    return true;
                case R.id.navigation_shake:
                    //binding.text.setText(R.string.navigation_shake);
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.homeNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Util.disableBottomNavigationViewShiftMode(binding.homeNavigation);
        binding.homeListview.setLayoutManager(new LinearLayoutManager(this));
        binding.homeListview.setAdapter(new CategoryAdapter(this, FakeData.getCategories()));

        meetupClient = MeetupApp.getRestClient(this);

        meetupClient.findEvent(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                int statusCode = response.code();
                ArrayList<Event> events = response.body();
                for(Event e : events){
                    Log.i("irene", e.getName());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find event request error: " + t.toString());
            }
        });

        Fabric.with(this, new Crashlytics());
    }
}
