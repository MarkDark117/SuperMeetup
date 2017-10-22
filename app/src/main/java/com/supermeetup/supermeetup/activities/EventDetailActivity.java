package com.supermeetup.supermeetup.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.text.TextUtilsCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.supermeetup.supermeetup.BR;
import com.supermeetup.supermeetup.R;
import com.supermeetup.supermeetup.adapter.viewholder.GroupViewHolder;
import com.supermeetup.supermeetup.common.ImageRoundCorners;
import com.supermeetup.supermeetup.common.Util;
import com.supermeetup.supermeetup.databinding.ActivityEventBinding;
import com.supermeetup.supermeetup.databinding.ItemGroupBinding;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.model.EventHost;
import com.supermeetup.supermeetup.model.Venue;

import org.parceler.Parcels;

import java.util.ArrayList;

/**
 * Created by Irene on 10/21/17.
 */

public class EventDetailActivity extends AppCompatActivity {
    private ActivityEventBinding mBinding;
    private Event mEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mEvent = Parcels.unwrap(getIntent().getParcelableExtra(Util.EXTRA_EVENT));
        if(mEvent == null){
            finish();
        }
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_event);

        String groupImageUrl = Util.getGroupPhotoUrl(mEvent.getGroup());
        if(!TextUtils.isEmpty(groupImageUrl)){
            mBinding.eventdetailGrouplayout.setVisibility(View.VISIBLE);
            Picasso.with(this)
                    .load(groupImageUrl)
                    .transform(new ImageRoundCorners())
                    .into(mBinding.eventdetailGroupImage);
        }else{
            mBinding.eventdetailGrouplayout.setVisibility(View.GONE);
        }

        mBinding.eventdetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Venue venue = mEvent.getVenue();
        if(venue == null){
            mBinding.eventdetailAddressName.setText(Util.getString(this, R.string.no_location));
            mBinding.eventdetailAddressLocation.setVisibility(View.GONE);
        }else{
            if(venue.isVisible()){
                mBinding.eventdetailAddressName.setText(venue.getName());
                mBinding.eventdetailAddressLocation.setVisibility(View.VISIBLE);
                mBinding.eventdetailAddressLocation.setText(venue.getFullAddress());
            }else{
                mBinding.eventdetailAddressName.setText(Util.getString(this, R.string.private_location));
                mBinding.eventdetailAddressLocation.setVisibility(View.GONE);
            }
        }

        ArrayList<EventHost> hosts = mEvent.getEventHosts();
        if(hosts == null || hosts.size() == 0){
            mBinding.eventdetailHostName.setText(Util.getString(this, R.string.no_host));
            mBinding.eventdetailHostIntro.setVisibility(View.GONE);
        }else{
            EventHost host = hosts.get(0);
            mBinding.eventdetailHostName.setText(host.getName());
            if(TextUtils.isEmpty(host.getIntro())){
                mBinding.eventdetailHostIntro.setVisibility(View.GONE);
            }else {
                mBinding.eventdetailHostIntro.setVisibility(View.VISIBLE);
                mBinding.eventdetailHostIntro.setText(host.getIntro());
            }
        }

        mBinding.setVariable(BR.event, mEvent);
    }
}
