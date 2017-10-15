package com.supermeetup.supermeetup.model.responses;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.supermeetup.supermeetup.model.Event;

import java.util.ArrayList;
import java.util.List;

public class FindEventResponse {

    List<Event> events;

    public FindEventResponse() {
        events = new ArrayList<>();
    }

    public static FindEventResponse parseJSON(String response) {
        Gson gson = new GsonBuilder().create();

        FindEventResponse findEventResponse = (gson.fromJson(response, FindEventResponse.class));
        return findEventResponse;
    }
}
