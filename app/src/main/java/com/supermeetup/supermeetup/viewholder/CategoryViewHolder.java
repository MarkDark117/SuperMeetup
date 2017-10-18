package com.supermeetup.supermeetup.viewholder;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;

import com.supermeetup.supermeetup.BR;
import com.supermeetup.supermeetup.activities.RecommendEventsActivity;
import com.supermeetup.supermeetup.callback.CloseActivityCallback;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ItemCategoryBinding;
import com.supermeetup.supermeetup.model.Category;

import org.parceler.Parcels;


/**
 * Created by yuxin on 10/14/17.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private ItemCategoryBinding mBinding;
    private CloseActivityCallback mCallback;

    public CategoryViewHolder(ItemCategoryBinding binding, CloseActivityCallback callback) {
        super(binding.getRoot());
        mCallback = callback;
        mBinding = binding;
    }

    public void bind(final Category category){
        mBinding.setVariable(BR.category, category);
        mBinding.getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), RecommendEventsActivity.class);
                i.putExtra(Util.EXTRA_CATEGORY, Parcels.wrap(category));
                v.getContext().startActivity(i);
                if(mCallback != null){
                    mCallback.close();
                }
            }
        });
        mBinding.executePendingBindings();
    }
}
