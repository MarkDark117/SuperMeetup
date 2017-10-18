package com.supermeetup.supermeetup.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.CategoryAdapter;
import com.supermeetup.supermeetup.callback.CloseActivityCallback;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityCategoryBinding;
import com.supermeetup.supermeetup.dialog.LoadingDialog;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.network.MeetupClient;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Irene on 10/17/17.
 */

public class CategoryActivity extends AppCompatActivity implements CloseActivityCallback {

    private ActivityCategoryBinding mBinding;
    private LoadingDialog mLoadingDialog;
    private MeetupClient meetupClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_category);
        mBinding.getRoot().setBackgroundColor(Util.getColor(this, R.color.white_trans));
        mBinding.categoryList.setLayoutManager(new GridLayoutManager(this, 4));
        meetupClient = MeetupApp.getRestClient(this);
        mLoadingDialog = new LoadingDialog(this);
        loadCategories();
    }

    private void loadCategories(){
        mLoadingDialog.setMessage(Util.getString(this, R.string.load_category));
        mLoadingDialog.show();

        meetupClient.findTopicCategories(new Callback<ArrayList<Category>>() {
            @Override
            public void onResponse(Call<ArrayList<Category>> call, Response<ArrayList<Category>> response) {
                int statusCode = response.code();
                ArrayList<Category> categories = response.body();
                if(categories != null){
                    setCategoryList(categories);
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Category>> call, Throwable t) {
                // Log error here since request failed
                Log.e("finderror", "Find topic categories request error: " + t.toString());
            }
        }, null, null, null, null);

    }

    private void setCategoryList(ArrayList<Category> categories){
        mBinding.categoryList.setAdapter(new CategoryAdapter(this, categories, this));
        mLoadingDialog.dismiss();
    }

    public void close(){
        finish();
    }

}
