package com.supermeetup.supermeetup.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 * Sample:
 * {
 *      "created": 1488936101000,
 *      "name": "Adventures in Common",
 *      "id": 22812516,
 *      "join_mode": "open",
 *      "lat": 37.779998779296875,
 *      "lon": -122.41999816894531,
 *      "urlname": "Adventures-in-Common",
 *      "who": "Adventurers",
 *      "localized_location": "San Francisco, CA",
 *      "region": "en_US",
 *      "category": {
 *          "id": 31,
 *          "name": "Socializing",
 *          "shortname": "socializing",
 *          "sort_name": "Socializing"
 *      },
 *      "photo": {
 *          "id": 461031337,
 *          "highres_link": "https://secure.meetupstatic.com/photos/event/c/8/8/9/highres_461031337.jpeg",
 *          "photo_link": "https://secure.meetupstatic.com/photos/event/c/8/8/9/600_461031337.jpeg",
 *          "thumb_link": "https://secure.meetupstatic.com/photos/event/c/8/8/9/thumb_461031337.jpeg",
 *          "type": "event",
 *          "base_url": "https://secure.meetupstatic.com"
 *      }
 *  }
 */

public class Group extends BaseData {
    public static final String JOINMODETYPE_OPEN = "open";
    public static final String JOINMODETYPE_APPROVAL = "approval";
    public static final String JOINMODETYPE_CLOSED = "closed";

    public long created = 0;
    public String name = "";
    public long id = 0;
    public String join_mode = "";
    public double lat = 0.0;
    public double lon = 0.0;
    public String urlname = "";
    public String who = "";
    public String localized_location = "";
    public String region = "";
    public Category category = new Category();
    public Photo photo = new Photo();

    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }
        created = json.optLong("created", created);
        name = json.optString("name", name);
        join_mode = json.optString("join_mode", join_mode);
        lat = json.optDouble("lat", lat);
        lon = json.optDouble("lon", lon);
        urlname = json.optString("urlname", urlname);
        who = json.optString("who", who);
        localized_location = json.optString("localized_location", localized_location);
        region = json.optString("region", region);
        category.fromJson(json.optJSONObject("category"));
        photo.fromJson(json.optJSONObject("photo"));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("created", created);
            json.put("name", name);
            json.put("id", id);
            json.put("join_mode", join_mode);
            json.put("lat", lat);
            json.put("lon", lon);
            json.put("urlname", urlname);
            json.put("who", who);
            json.put("localized_location", localized_location);
            json.put("region", region);
            json.put("category", category.toJson());
            json.put("photo", photo.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }
}
