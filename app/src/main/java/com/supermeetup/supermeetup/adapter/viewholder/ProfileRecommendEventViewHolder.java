package com.supermeetup.supermeetup.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.supermeetup.supermeetup.BR;
import com.supermeetup.supermeetup.databinding.ItemProfilerecommendeventBinding;
import com.supermeetup.supermeetup.model.Event;

/**
 * Created by Irene on 10/21/17.
 */

public class ProfileRecommendEventViewHolder extends RecyclerView.ViewHolder {

    private ItemProfilerecommendeventBinding mBinding;

    public ProfileRecommendEventViewHolder(ItemProfilerecommendeventBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }
    public void bind(Event event){
        mBinding.setVariable(BR.event, event);
        mBinding.executePendingBindings();
    }
}
