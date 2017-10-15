package com.supermeetup.supermeetup.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.viewholder.CategoryViewHolder;

import java.util.ArrayList;

/**
 * Created by yuxin on 10/14/17.
 */

public class CategoryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<Category> mCategories;

    public CategoryAdapter(Context context, ArrayList<Category> categories){
        mContext = context;
        mCategories = categories;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CategoryViewHolder((LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false)));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CategoryViewHolder) holder).bind(mCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return mCategories.size();
    }
}
