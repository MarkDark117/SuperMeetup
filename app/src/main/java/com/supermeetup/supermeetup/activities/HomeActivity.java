package com.supermeetup.supermeetup.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.databinding.ActivityHomeBinding;
import com.supermeetup.supermeetup.model.OpenEvent;
import com.supermeetup.supermeetup.network.MeetupClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private MeetupClient meetupClient;
    private Handler handler = new Handler();
    private Long lastMTime;
    private Runnable streamOpenEvent = new Runnable() {
        @Override
        public void run() {
            meetupClient.streamOpenEvents(streamOpenEventCallback, lastMTime);
            // Repeat this the same runnable code block again another .05 seconds
            // 'this' is referencing the Runnable object
            handler.postDelayed(this, 500);
        }
    };

    private Callback<OpenEvent> streamOpenEventCallback = new Callback<OpenEvent>() {
        @Override
        public void onResponse(Call<OpenEvent> call, Response<OpenEvent> response) {
            //int statusCode = response.code();
            if (response.isSuccessful()) {
                OpenEvent openEvent = response.body();
                // Update mtime
                lastMTime = openEvent.getMtime() + 1;
                processNewOpenEvent(openEvent);
            }
        }

        @Override
        public void onFailure(Call<OpenEvent> call, Throwable t) {
            // Log error here since request failed
            Log.e("stream open events", "Recommended event request error: " + t.toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        meetupClient = MeetupApp.getRestClient(this);
        handler.post(streamOpenEvent);
        /*
        // test findEvent
        meetupClient.findEvent(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                int statusCode = response.code();
                ArrayList<Event> events = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find event request error: " + t.toString());
            }
        }, null, null, null, 0.5f, null);
        */

        /*
        // test findTopicCategories
        meetupClient.findTopicCategories(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                int statusCode = response.code();
                ArrayList<Category> categories = response.body();
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find topic categories request error: " + t.toString());
            }
        }, null, null, null, null);
        */

        /*
        meetupClient.recommendedEvents(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                int statusCode = response.code();
                ArrayList<Event> categories = response.body();
                statusCode = 0;
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Recommended event request error: " + t.toString());
            }
        }, null, null, null, null, null, null);
        */
    }

    private void processNewOpenEvent(@NonNull OpenEvent openEvent) {
        // Do something with openEvent
    }

    private void stopOpenEventStream() {
        handler.removeCallbacks(streamOpenEvent);
    }
}
