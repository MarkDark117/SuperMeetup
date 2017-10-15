package com.supermeetup.supermeetup.network;

import android.support.annotation.Nullable;

import com.supermeetup.supermeetup.model.Event;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MeetupEndpointInterface {
    @GET("find/events")
    Call<ArrayList<Event>> findEvent(@Nullable @Query("text") String text,
                                     @Nullable @Query("radius") Float radius,
                                     @Nullable @Query("lat") Double lat,
                                     @Nullable @Query("lon") Double lon,
                                     @Nullable @Query("fields") String fields);
}
