package com.supermeetup.supermeetup.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.viewholder.EventViewHolder;
import com.supermeetup.supermeetup.databinding.ItemEventBinding;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.Event;

import java.util.ArrayList;

/**
 * Created by Irene on 10/19/17.
 */

public class EventAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Event> mEvents = new ArrayList<>();
    private boolean mShowFirstEventDivider;

    public EventAdapter(){

    }

    public void setEvents(ArrayList<Event> events, boolean showFirstDivider){
        mEvents = events;
        mShowFirstEventDivider = showFirstDivider;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        return new EventViewHolder((ItemEventBinding) DataBindingUtil.inflate(layoutInflater, R.layout.item_event, parent, false), mShowFirstEventDivider);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((EventViewHolder) holder).bind(mEvents.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mEvents.size();
    }
}
