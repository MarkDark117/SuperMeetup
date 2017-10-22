package com.supermeetup.supermeetup.activities;

import android.Manifest;
import android.content.Intent;
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
import android.text.TextUtils;
import android.view.MenuItem;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.supermeetup.supermeetup.fragment.FindFragment;
import com.supermeetup.supermeetup.fragment.NearbyFragment;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.common.LocationHelper;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityHomeBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.fragment.ShakeFragment;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding mHomeActivityBinding;
    private int mCurrentTabId = R.id.navigation_nearby;
    private LocationHelper mLocationHelper;
    private Location mLocation;
    private LoadingDialog mLoadingDialog;
    private String mQuery;

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
                ((NearbyFragment) fragment).setQuery(mQuery);
                res = true;
                break;
            case R.id.navigation_find:
                fragment = FindFragment.getInstance(mLocation, mQuery);
                res = true;
                break;
            case R.id.navigation_new:
                res = true;
                break;
            case R.id.navigation_shake:
                fragment = ShakeFragment.getInstance(mLocation);
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
        mHomeActivityBinding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        mHomeActivityBinding.homeNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        Util.disableBottomNavigationViewShiftMode(mHomeActivityBinding.homeNavigation);

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

    public String getQuery(){
        return mQuery;
    }

    public void setQuery(String query){
        mQuery = query;
    }

    @Override
    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        if(intent.hasExtra(Util.EXTRA_QUERY)){
            mQuery = intent.getStringExtra(Util.EXTRA_QUERY);
            mHomeActivityBinding.homeNavigation.setSelectedItemId(R.id.navigation_find);
        }
    }
}
