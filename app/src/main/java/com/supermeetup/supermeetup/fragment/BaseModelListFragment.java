package com.supermeetup.supermeetup.fragment;


import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.supermeetup.supermeetup.MeetupApp;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.databinding.FragmentEventListBinding;
import com.supermeetup.supermeetup.listeners.EndlessRecyclerViewScrollListener;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.network.MeetupClient;

import java.util.List;

public class EventListFragment extends Fragment {

    public static final String TAG = "EventListFragment";
    protected MeetupClient mClient;
    protected FragmentEventListBinding mEventListBinding;
    protected RecyclerView.Adapter mEventAdapter;
    protected EndlessRecyclerViewScrollListener mScrollListener;

    public EventListFragment() {
        // Required empty public constructor
    }

    public static EventListFragment getInstance(){
        return new EventListFragment();
    }

    public interface EventSelectedListener {
        // handle event selection
        void onEventSelected(@NonNull Event event);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        if (mEventListBinding != null) return mEventListBinding.getRoot();
        mClient = MeetupApp.getRestClient(getContext());
        // Inflate the layout for this fragment
        mEventListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_event_list, container, false);

        // Setup refresh listener which triggers new data loading
        mEventListBinding.swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Your code to refresh the list here.
                // Make sure you call swipeContainer.setRefreshing(false)
                // once the network request has completed successfully.
                fetchTimelineAsync(0);
            }
        });
        // Configure the refreshing colors
        mEventListBinding.swipeContainer.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.scrollToPosition(0);
        mEventListBinding.rvEvents.setLayoutManager(layoutManager);
        mScrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                // Triggered only when new data needs to be appended to the list
                // Add whatever code is needed to append new items to the bottom of the list
                loadNextDataFromApi(mEventAdapter.getItemCount());
            }
        };

        // Adds the scroll listener to RecyclerView
        mEventListBinding.rvEvents.addOnScrollListener(mScrollListener);

        return mEventListBinding.getRoot();
    }

    // Required to be implemented by derived class
    protected RecyclerView.Adapter createAdapter() {
        throw new UnsupportedOperationException();
    };

    public void setAdapter(@Nullable RecyclerView.Adapter adapter) {
        mEventAdapter = adapter;
        mEventListBinding.rvEvents.setAdapter(adapter);
    }

    public RecyclerView.Adapter getAdapter() {
        return mEventListBinding.rvEvents.getAdapter();
    }

    /**
     * Put this fragment into an fragment slot in derived fragment
     * @param fragmentId
     */
    protected void placeEventListFragment(@NonNull FragmentManager fragmentManager, @IdRes int fragmentId) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(fragmentId, this, TAG);
        ft.commit();
    }

    // Offline mode
    protected void populateEvents(@NonNull List<Event> events) {
        //this.mEvents.addAll(tweets);
        mEventAdapter.notifyDataSetChanged();
    }

    // Reset all views and clear items
    protected void reset() {
        mScrollListener.resetState();
        //mEventAdapter.clear();
        mEventAdapter.notifyDataSetChanged();
    }

    public void fetchTimelineAsync(int page) {
        // Send the network request to fetch the updated data
        // `client` here is an instance of Android Async HTTP
        // getHomeTimeline is an example endpoint.
    }

    // Append the next page of data into the adapter
    public void loadNextDataFromApi(int offset) {
        // Send an API request to retrieve appropriate paginated data
        //  --> Send the request including an offset value (i.e `page`) as a query parameter.
        //  --> Deserialize and construct new model objects from the API response
        //  --> Append the new data objects to the existing set of items inside the array of items
        //  --> Notify the adapter of the new items made with `notifyItemRangeInserted()`
        /*
        if (Config.isOnline()) {
            if (tweets.isEmpty()) return;
            long maxId = tweets.get(tweets.size() - 1).uid - 1;
            getMoreEvents(maxId);
        } else {
            populateEvents(Tweet.getTopOfflineTweets(offset, Constants.TWEETS_COUNT_PER_PAGE));
        }*/
    }

}
