package com.supermeetup.supermeetup.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;
import android.view.View;

import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.EventAdapter;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityRecommendeventsBinding;
import com.supermeetup.supermeetup.dialog.CategoryDialog;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.network.MeetupClient;

import org.parceler.Parcels;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Irene on 10/17/17.
 */

public class RecommendEventsActivity extends AppCompatActivity {

    private ActivityRecommendeventsBinding mBinding;
    private Category mCurrentCategory;
    private ArrayList<Category> mCategories;
    private LoadingDialog mLoadingDialog;
    private MeetupClient meetupClient;
    private Location mLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        meetupClient = MeetupApp.getRestClient(this);
        mLocation = Util.readLocation(this, Util.KEY_LOCATION);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recommendevents);
        mBinding.recommendeventsList.setLayoutManager(new LinearLayoutManager(this));
        mLoadingDialog = new LoadingDialog(this);
        mBinding.recommendeventsList.setAdapter(new EventAdapter(null));
        updateUI(getIntent());
        mBinding.recommendeventsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mBinding.recommendeventsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CategoryDialog categoryDialog = new CategoryDialog(RecommendEventsActivity.this, mCategories);
                categoryDialog.show();
            }
        });

    }

    private void updateUI(Intent intent){
        mCurrentCategory = Parcels.unwrap(intent.getParcelableExtra(Util.EXTRA_CATEGORY));
        mCategories = Parcels.unwrap(intent.getParcelableExtra(Util.EXTRA_CATEGORYLIST));
        if(mCurrentCategory == null || mCategories == null || mCategories.size() == 0){
            finish();
        }
        mBinding.recommendeventsCategoryIcon.setImageResource(Util.getCategoryIcon(this, mCurrentCategory.getId()));
        mBinding.recommendeventsCategoryName.setText(mCurrentCategory.getName());
        loadRecommendEvents();
    }

    private void setEventList(ArrayList<Event> events){
        ((EventAdapter) mBinding.recommendeventsList.getAdapter()).setEvents(events, false);
        mBinding.recommendeventsList.scrollToPosition(0);
    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        updateUI(intent);
    }

    private void loadRecommendEvents(){
        mLoadingDialog.setMessage(Util.getString(this, R.string.load_event));
        mLoadingDialog.show();
        meetupClient.recommendedEvents(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                ArrayList<Event> events = response.body();
                if(events != null){
                    setEventList(events);
                }
                mLoadingDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                mLoadingDialog.dismiss();
                Log.e("finderror", "Recommended event request error: " + t.toString());
            }
        }, Util.DEFAULT_FIELDS, mLocation.getLatitude(), mLocation.getLongitude(), null, null, (int)mCurrentCategory.getId());
    }

}
