package com.supermeetup.supermeetup.fragment;

import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.EventAdapter;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.FragmentNewBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.model.OpenEvent;
import com.supermeetup.supermeetup.model.Venue;
import com.supermeetup.supermeetup.network.MeetupClient;

import java.util.ArrayList;
import java.util.LinkedList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Irene on 10/21/17.
 */

public class NewFragment extends Fragment {

    private static NewFragment mFragment;

    public static NewFragment getInstance(){
        if(mFragment == null){
            mFragment = new NewFragment();
        }

        return mFragment;
    }

    private FragmentNewBinding mNewBinding;
    private MeetupClient meetupClient;
    private GoogleMap mGoogleMap;
    private LoadingDialog mLoadingDialog;
    private LinkedList<OpenEvent> mEvents = new LinkedList<>();
    private Handler mHandler = new Handler();
    private Runnable mLoadData = new Runnable() {
        @Override
        public void run() {
            loadOpenEvent();
            mHandler.postDelayed(this, 500);
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mNewBinding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_new, container, false);
        View view = mNewBinding.getRoot();
        meetupClient = MeetupApp.getRestClient(getActivity());
        mLoadingDialog = new LoadingDialog(getActivity());
        mLoadingDialog.setMessage(Util.getString(getActivity(), R.string.load_event));
        mNewBinding.newMap.onCreate(savedInstanceState);
        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            e.printStackTrace();
        }

        return view;
    }

    private void loadOpenEvent(){
        meetupClient.streamOpenEvents(new Callback<OpenEvent>() {
            @Override
            public void onResponse(Call<OpenEvent> call, Response<OpenEvent> response) {
                int statusCode = response.code();
                OpenEvent openEvent = response.body();
                if(openEvent != null && openEvent.isVisible()){
                    addEvent(openEvent);
                }
            }

            @Override
            public void onFailure(Call<OpenEvent> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find event request error: " + t.toString());
            }
        }, null);
    }

    private void addEvent(OpenEvent event){
        mEvents.add(event);
        if(mEvents.size() == 10){
            mEvents.remove(0);
        }
        setMap();
    }

    private void setMap(){

        mNewBinding.newMap.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap mMap) {
                mGoogleMap = mMap;
                if(mLoadingDialog.isShowing()) {
                    mLoadingDialog.dismiss();
                }
                // For showing a move to my location button
                mGoogleMap.setMyLocationEnabled(true);

                OpenEvent openEvent = mEvents.get(mEvents.size() - 1);
                Venue venue = openEvent.getVenue();
                if(venue != null && venue.isVisible()) {
//                    mGoogleMap.moveCamera(CameraUpdateFactory
//                            .newLatLngZoom(new LatLng(venue.getLat(), venue.getLon()), Util.DEFAULT_RADIUS));
                    LatLng markerLocation = new LatLng(venue.getLat(), venue.getLon());
                    Marker marker = mGoogleMap.addMarker(new MarkerOptions().position(markerLocation).title(openEvent.getName()).snippet(openEvent.getVenue().getFullAddress()));
                    marker.setTag(openEvent.getId());
                    marker.showInfoWindow();
                    CameraPosition cameraPosition = new CameraPosition.Builder()
                            .target(markerLocation)
                            .zoom(6)
                            .build();
                    mGoogleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
                    mGoogleMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                        @Override
                        public void onInfoWindowClick(Marker marker) {
                            String id = (String) marker.getTag();
                            Toast.makeText(getActivity(), id, Toast.LENGTH_SHORT).show();

                        }
                    });
                }

            }
        });

    }

    @Override
    public void onResume(){
        mNewBinding.newMap.onResume();
        mHandler.post(mLoadData);
        if(!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }
        super.onResume();
    }

    @Override
    public void onPause(){
        mHandler.removeCallbacks(mLoadData);
        mNewBinding.newMap.onPause();
        super.onPause();
    }
}
