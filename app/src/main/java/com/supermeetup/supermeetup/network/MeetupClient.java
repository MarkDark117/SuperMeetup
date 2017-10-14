package com.supermeetup.supermeetup.network;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.core.builder.api.BaseApi;
import com.supermeetup.supermeetup.model.Category;
import com.supermeetup.supermeetup.model.Event;
import com.supermeetup.supermeetup.model.requestparameters.FindEventRequestParameters;
import com.supermeetup.supermeetup.model.requestparameters.RecommendCategoriesRequestParameters;
import com.supermeetup.supermeetup.model.requestparameters.TopicCategoriesRequestParameters;

import java.util.ArrayList;

public class MeetupClient extends OAuthBaseClient {

    private static final BaseApi REST_API_INSTANCE = MeetupApi20.instance();
    private static final String REST_URL = "https://api.meetup.com/2";
    private static final String REST_CONSUMER_KEY = "tsnbip354bn734c40plu1nnif3";
    private static final String REST_CONSUMER_SECRET = "573r6lbbiq32q8619f0o2o7tkv";
    private static final String FALLBACK_URL = "meetupoauth://supermeetup.com";

    public MeetupClient(Context context) {
        super(context,
              REST_API_INSTANCE,
              REST_URL,
              REST_CONSUMER_KEY,
              REST_CONSUMER_SECRET,
              FALLBACK_URL);
    }

    public ArrayList<Category> getCategories(TopicCategoriesRequestParameters requestParameters){
        /**
         * TODO
         * url: https://secure.meetup.com/meetup_api/console/?path=%2Ffind%2Ftopic_categories
         * requestParameters can be null
         */
        return null;
    }

    public ArrayList<Event> findEvents(FindEventRequestParameters requestParameters){
        /**
         * TODO
         * url: https://secure.meetup.com/meetup_api/console/?path=/find/events
         */
        return null;
    }

    public ArrayList<Event> getRecommendEvents(RecommendCategoriesRequestParameters requestParameters){
        /**
         * TODO
         * url: https://secure.meetup.com/meetup_api/console/?path=/recommended/events
         */
        return null;
    }

}
