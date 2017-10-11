package com.supermeetup.supermeetup.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.crashlytics.android.Crashlytics;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.databinding.ActivityHomeBinding;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home);
        Fabric.with(this, new Crashlytics());
    }
}
