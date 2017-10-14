package com.supermeetup.supermeetup.common;

import com.supermeetup.supermeetup.model.BaseData;
import com.supermeetup.supermeetup.model.EventHost;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yuxin on 10/13/17.
 */

public class Util {

    public static ArrayList<Long> putJsonArrayToLongList(JSONArray jsonArray){
        ArrayList<Long> res = new ArrayList<>();
        if(jsonArray != null && jsonArray.length() > 0){
            for(int i = 0; i < jsonArray.length(); i++) {
                res.add(jsonArray.optLong(i, -1));
            }
        }
        return res;
    }

    public static JSONArray getJsonArrayFromLongArrayList(ArrayList<Long> list){
        JSONArray jsonArray = new JSONArray();
        if(list != null || list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                jsonArray.put(list.get(i));
            }
        }
        return jsonArray;
    }

    public static ArrayList<EventHost> putJsonArrayToEventHostList(JSONArray jsonArray){
        ArrayList<EventHost> res = new ArrayList<>();
        if(jsonArray != null && jsonArray.length() > 0){
            for(int i = 0; i < jsonArray.length(); i++) {
                try {
                    JSONObject json = jsonArray.getJSONObject(i);
                    EventHost t = new EventHost();
                    t.fromJson(json);
                    res.add(t);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return res;
    }

    public static JSONArray getJsonArrayFromEventHostList(ArrayList<EventHost> eventHosts){
        JSONArray jsonArray = new JSONArray();
        if(eventHosts != null && eventHosts.size() > 0){
            for(EventHost eventHost : eventHosts){
                jsonArray.put(eventHost.toJson());
            }
        }
        return jsonArray;
    }
}
