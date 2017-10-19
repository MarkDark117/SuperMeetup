package com.supermeetup.supermeetup.activities;

import android.Manifest;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.supermeetup.supermeetup.fragment.NearbyFragment;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.common.LocationHelper;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityHomeBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;
    private int mCurrentTabId = R.id.navigation_nearby;
    private LocationHelper mLocationHelper;
    private Location mLocation;
    private LoadingDialog mLoadingDialog;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            mCurrentTabId = item.getItemId();
            selectTab();
            return true;
        }

    };

    private boolean selectTab(){
        boolean res = false;
        Fragment fragment = null;
        switch (mCurrentTabId){
            case R.id.navigation_nearby:
                fragment = NearbyFragment.getInstance(mLocation);
                res = true;
                break;
            case R.id.navigation_find:
                res = true;
                break;
            case R.id.navigation_new:
                res = true;
                break;
            case R.id.navigation_shake:
                res = true;
                break;
        }
        if(fragment != null){
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.container, fragment)
                    .commit();
        }
        return res;
    }

    private LocationHelper.LocationResult locationResult = new LocationHelper.LocationResult() {

        @Override
        public void gotLocation(final Location location) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mLoadingDialog.dismiss();
                    mLocation = location;
                    Util.writeLocation(HomeActivity.this, Util.KEY_LOCATION, mLocation);
                    Toast.makeText(HomeActivity.this, "Got Location",
                            Toast.LENGTH_LONG).show();
                    selectTab();
                }
            });

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        binding.homeNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Util.disableBottomNavigationViewShiftMode(binding.homeNavigation);

        mLocationHelper = new LocationHelper();
        mLoadingDialog = new LoadingDialog(this);

        checkPermission();

        Fabric.with(this, new Crashlytics());
    }

    private void getLocation(){
        mLoadingDialog.setMessage(Util.getString(this, R.string.load_location));
        mLoadingDialog.show();
        mLocationHelper.getLocation(this, locationResult);
    }

    private void checkPermission(){
        if ( Build.VERSION.SDK_INT >= 23 &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION ) != PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                    Util.PERMISSIONREQUEST_ACCESS_LOCATION);

        }else{
            getLocation();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case Util.PERMISSIONREQUEST_ACCESS_LOCATION:
                if (grantResults.length > 0) {
                    boolean coarseLocation = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    boolean fineLocation = grantResults[0] == PackageManager.PERMISSION_GRANTED;

                    if(coarseLocation && fineLocation)
                    {
                        getLocation();
                    } else {
                        //TODO
                    }
                }
                break;
        }
    }

/*
    private void loadEvents(){
        meetupClient.findEvent(new Callback<ArrayList<Event>>() {
            @Override
            public void onResponse(Call<ArrayList<Event>> call, Response<ArrayList<Event>> response) {
                int statusCode = response.code();
                ArrayList<Event> events = response.body();
                if(events != null){
                    setCategoryList(null);
                    setEventList(events);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Event>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find event request error: " + t.toString());
            }
        }, Util.FIELDS_DEFAULT, null, null, null, mQuery);
    }
*/
}
