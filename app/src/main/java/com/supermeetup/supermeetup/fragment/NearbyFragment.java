package com.supermeetup.supermeetup.fragment;

import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.NearbyAdapter;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.FragmentNearbyBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.network.MeetupClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Irene on 10/17/17.
 */

public class NearbyFragment extends Fragment {

    private static NearbyFragment mFragment;
    private Location mLocation;

    public static NearbyFragment getInstance(Location location){
        if(mFragment == null){
            mFragment = new NearbyFragment();
        }
        mFragment.setLocation(location);
        return mFragment;
    }

    private FragmentNearbyBinding mNearbyBinding;
    private LoadingDialog mLoadingDialog;

    private MeetupClient meetupClient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mNearbyBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_nearby, container, false);
        View view = mNearbyBinding.getRoot();
        mLoadingDialog = new LoadingDialog(getActivity());
        mNearbyBinding.nearbyListview.setLayoutManager(new LinearLayoutManager(getActivity()));
        mNearbyBinding.nearbyListview.setAdapter(new NearbyAdapter(getActivity()));

        mNearbyBinding.nearbySearchlayout.searchview.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
//                binding.homeNavigation.setSelectedItemId(R.id.navigation_find);
//                mCurrentTabId = R.id.navigation_find;
//                mQuery = binding.homeSearchview.getQuery().toString();
//                Util.hideSoftKeyboard(HomeActivity.this);
//                loadContent();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        meetupClient = MeetupApp.getRestClient(getActivity());
        loadCategories();
        return view;
    }

    public void setLocation(Location location){
        mLocation = location;
    }

    private void loadCategories(){
        mLoadingDialog.setMessage(Util.getString(getActivity(), R.string.load_category));
        mLoadingDialog.show();

        meetupClient.findTopicCategories(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                int statusCode = response.code();
                ArrayList<Category> categories = response.body();
                if(categories != null){
                    setCategoryList(categories);
                }
                loadRecommendEvents();
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find topic categories request error: " + t.toString());
            }
        }, null, null, null, null);

    }

    private void loadRecommendEvents(){
        mLoadingDialog.setMessage(Util.getString(getActivity(), R.string.load_event));
        meetupClient.recommendedEvents(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                int statusCode = response.code();
                ArrayList<Event> events = response.body();
                statusCode = 0;
                if(events != null){
                    setEventList(events);
                }
                mLoadingDialog.dismiss();
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Recommended event request error: " + t.toString());
            }
        }, Util.FIELDS_DEFAULT, mLocation.getLatitude(), mLocation.getLongitude(), null, null, null);
    }


    private void setCategoryList(ArrayList<Category> categories){
        ((NearbyAdapter) mNearbyBinding.nearbyListview.getAdapter()).setCategories(categories);
    }

    private void setEventList(ArrayList<Event> events){
        ((NearbyAdapter) mNearbyBinding.nearbyListview.getAdapter()).setEvents(events);
    }
}
