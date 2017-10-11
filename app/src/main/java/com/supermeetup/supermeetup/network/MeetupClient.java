package com.supermeetup.supermeetup.network;

import android.content.Context;

import com.codepath.oauth.OAuthBaseClient;
import com.github.scribejava.core.builder.api.BaseApi;

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
}
