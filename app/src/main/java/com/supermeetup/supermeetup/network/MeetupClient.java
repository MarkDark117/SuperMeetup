package com.supermeetup.supermeetup.network;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.core.builder.api.BaseApi;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.Event;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MeetupClient extends OAuthBaseClient {

    private static final BaseApi REST_API_INSTANCE = MeetupApi20.instance();
    private static final String REST_URL = "https://api.meetup.com";
    private static final String REST_CONSUMER_KEY = "tsnbip354bn734c40plu1nnif3";
    private static final String REST_CONSUMER_SECRET = "573r6lbbiq32q8619f0o2o7tkv";
    private static final String CALLBACK_URL = "meetupoauth://supermeetup.com";

    private Retrofit retrofit;

    private MeetupEndpointInterface apiService;

    public MeetupClient(Context context) {
        super(context,
              REST_API_INSTANCE,
              REST_URL,
              REST_CONSUMER_KEY,
              REST_CONSUMER_SECRET,
              CALLBACK_URL);

        // Define the interceptor, add authentication headers
        Interceptor interceptor = new Interceptor() {
            @Override
            public okhttp3.Response intercept(Chain chain) throws IOException {
                String accessToken = ((OAuth2AccessToken) client.getAccessToken()).getAccessToken().toString();
                Request newRequest = chain.request().newBuilder()
                        .addHeader("Authorization", "Bearer " + accessToken).build();
                return chain.proceed(newRequest);
            }
        };

        // Add the interceptor to OkHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.interceptors().add(interceptor);
        OkHttpClient client = builder.build();

        retrofit = new Retrofit.Builder()
                .baseUrl(REST_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(MeetupEndpointInterface.class);
    }

    public void findEvent(@NonNull Callback<ArrayList<Event>> callback,
                          @Nullable String fields,
                          @Nullable Double lat,
                          @Nullable Double lon,
                          @Nullable Float radius,
                          @Nullable String text) {

        Call<ArrayList<Event>> call = apiService.findEvent(fields, lat, lon, radius, text);
        call.enqueue(callback);
    }

    public void findTopicCategories(@NonNull Callback<ArrayList<Category>> callback,
                                    @Nullable String fields,
                                    @Nullable Double lat,
                                    @Nullable Double lon,
                                    @Nullable Float radius) {

        Call<ArrayList<Category>> call = apiService.findTopicCategories(fields, lat, lon, radius);
        call.enqueue(callback);
    }

    public void recommendedEvents(@NonNull Callback<ArrayList<Event>> callback,
                                  @Nullable String fields,
                                  @Nullable Double lat,
                                  @Nullable Double lon,
                                  @Nullable Integer page,
                                  @Nullable Boolean self_groups,
                                  @Nullable Integer topic_category) {
        Call<ArrayList<Event>> call = apiService.recommendedEvents(fields, lat, lon, page, self_groups, topic_category);
        call.enqueue(callback);
    }
}
