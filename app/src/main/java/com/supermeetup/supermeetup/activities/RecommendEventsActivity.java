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
import com.supermeetup.supermeetup.dialog.CategoryDialog;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Category;

import org.parceler.Parcels;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

/**
 * Created by Irene on 10/17/17.
 */

public class RecommendEventsActivity extends AppCompatActivity {

    private ActivityRecommendeventsBinding mBinding;
    private Category mCurrentCategory;
    private ArrayList<Category> mCategories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_recommendevents);
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
    }

    protected void onNewIntent(Intent intent){
        super.onNewIntent(intent);
        updateUI(intent);
    }

}
