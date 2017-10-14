package com.supermeetup.supermeetup.model;

import com.supermeetup.supermeetup.common.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yuxin on 10/13/17.
 * Sample: https://secure.meetup.com/meetup_api/console/?path=/find/topic_categories
 * "0": {
 *      "id": 242,
 *      "shortname": "outdoors-adventure",
 *      "name": "Outdoors & Adventure",
 *      "sort_name": "Outdoors & Adventure",
 *      "photo": {
 *          "id": 450131943,
 *          "highres_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/highres_450131943.jpeg",
 *          "photo_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/600_450131943.jpeg",
 *          "thumb_link": "https://secure.meetupstatic.com/photos/event/2/e/a/7/thumb_450131943.jpeg",
 *          "type": "event",
 *          "base_url": "https://secure.meetupstatic.com"
 *          },
 *      "category_ids": [
 *              3,
 *              23
 *          ]
 *  }
 */

public class Category extends BaseData{

    public long id = 0;
    public String shortname = "";
    public String name = "";
    public String sort_name = "";
    public Photo photo = new Photo();
    public ArrayList<Long> category_ids = new ArrayList<>();


    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }

        id = json.optLong("id", id);
        shortname = json.optString("shortname", shortname);
        name = json.optString("name", name);
        sort_name = json.optString("sort_name", sort_name);
        photo.fromJson(json.optJSONObject("photo"));
        category_ids = Util.putJsonArrayToLongList(json.optJSONArray("category_ids"));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("shortname", shortname);
            json.put("name", name);
            json.put("sort_name", sort_name);
            json.put("photo", photo.toJson());
            json.put("category_ids", Util.getJsonArrayFromLongArrayList(category_ids));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
