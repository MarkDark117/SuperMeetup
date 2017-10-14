package com.supermeetup.supermeetup.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 * Sample: https://secure.meetup.com/meetup_api/console/?path=/find/topic_categories
 * "photo": {
 *      "id": 450131943,
 *      "highres_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/highres_450131943.jpeg",
 *      "photo_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/600_450131943.jpeg",
 *      "thumb_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/thumb_450131943.jpeg",
 *      "type": "event",
 *      "base_url": "https://secure.meetupstatic.com"
 *  }
 */

public class Photo extends BaseData {
    public static final String PHOTOTYPE_EVENT = "event";
    public static final String PHOTOTYPE_MEMBER = "member";

    public long id = 0;
    public String highres_link = "";
    public String photo_link = "";
    public String thumb_link = "";
    public String type = "";
    public String base_url = "";
    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }

        id = json.optLong("id", id);
        highres_link = json.optString("highres_link", highres_link);
        photo_link = json.optString("photo_link", photo_link);
        thumb_link = json.optString("thumb_link", thumb_link);
        type = json.optString("type", type);
        base_url = json.optString("base_url", base_url);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("highres_link", highres_link);
            json.put("photo_link", photo_link);
            json.put("thumb_link", thumb_link);
            json.put("type", type);
            json.put("base_url", base_url);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public boolean isEventPhoto(){
        return PHOTOTYPE_EVENT.equals(type);
    }
}
