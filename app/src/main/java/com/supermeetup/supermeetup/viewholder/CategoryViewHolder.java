package com.supermeetup.supermeetup.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.databinding.DataBindingUtil;

import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.model.Category;


/**
 * Created by yuxin on 10/14/17.
 */

public class CategoryViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImage;
    private TextView mTitle;

    public CategoryViewHolder(View itemView) {
        super(itemView);
        mImage = itemView.findViewById(R.id.category_image);
        mTitle = itemView.findViewById(R.id.category_title);
    }

    public void bind(Category category){
        mTitle.setText(category.shortname);
    }
}
