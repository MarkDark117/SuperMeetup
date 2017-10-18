package com.supermeetup.supermeetup.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.crashlytics.android.Crashlytics;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.common.LocationHelper;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityRecommendeventsBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Category;

import org.parceler.Parcels;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Irene on 10/17/17.
 */

public class RecommendEventsActivity extends AppCompatActivity {

    private ActivityRecommendeventsBinding mBinding;
    private Category mCurrentCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mCurrentCategory = Parcels.unwrap(getIntent().getParcelableExtra(Util.EXTRA_CATEGORY));
        if(mCurrentCategory == null){
            finish();
        }

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recommendevents);
        mBinding.recommendeventsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mBinding.recommendeventsCategoryIcon.setImageResource(Util.getCategoryIcon(this, mCurrentCategory.getId()));
        mBinding.recommendeventsCategoryName.setText(mCurrentCategory.getName());
        mBinding.recommendeventsCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), CategoryActivity.class);
                v.getContext().startActivity(i);
            }
        });
    }

}
