package com.supermeetup.supermeetup.model;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 * Sample: https://secure.meetup.com/meetup_api/console/?path=/find/venues
 * "venue": {
 *      "id": 1869971,
 *      "name": "Studio 302",
 *      "lat": 37.748023986816406,
 *      "lon": -122.41981506347656,
 *      "repinned": false,
 *      "address_1": "3435 Cesar Chavez ",
 *      "city": "San Francisco",
 *      "country": "us",
 *      "localized_country_name": "USA",
 *      "zip": "94110",
 *      "state": "CA"
 *  }
 */

public class Venue extends BaseData {

    public static final String VISIBILITYTYPE_PUBLIC = "public";
    public static final String VISIBILITYTYPE_PRIVATE = "private";

    public long id = 0;
    public double lat = 0.0;
    public double lon = 0.0;
    public String name = "";
    public String address_1 = "";
    public String address_2 = "";
    public String address_3 = "";
    public String city = "";
    public String country = "";
    public String localized_country_name = "";
    public String zip = "";
    public String state = "";
    public boolean repinned = false;
    public String visibility = "";
    public String phone = "";
    public long rating_count = 0;
    public double rating = 0.0;

    @Override
    public void fromJson(JSONObject json) {
        if(json == null && json.length() == 0){
            return;
        }
        id = json.optLong("id", id);
        lat = json.optDouble("lat", lat);
        lon = json.optDouble("lat", lon);
        name = json.optString("name", name);
        address_1 = json.optString("name", address_1);
        address_2 = json.optString("name", address_2);
        address_3 = json.optString("name", address_3);
        city = json.optString("name", city);
        country = json.optString("name", country);
        localized_country_name = json.optString("name", localized_country_name);
        zip = json.optString("name", zip);
        state = json.optString("name", state);
        repinned = json.optBoolean("repinned", false);
        visibility = json.optString("name", visibility);
        phone = json.optString("name", phone);
        rating_count = json.optLong("rating_count", 0);
        rating = json.optDouble("rating", 0.0);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("lat", lat);
            json.put("lon", lon);
            json.put("name", name);
            json.put("address_1", address_1);
            json.put("address_2", address_2);
            json.put("address_3", address_3);
            json.put("city", city);
            json.put("country", country);
            json.put("localized_country_name", localized_country_name);
            json.put("zip", zip);
            json.put("state", state);
            json.put("repinned", repinned);
            json.put("visibility", visibility);
            json.put("phone", phone);
            json.put("rating_count", rating_count);
            json.put("rating", rating);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public boolean isVisible(){
        return VISIBILITYTYPE_PUBLIC.equals(visibility);
    }

    public String getFullAddress(){
        StringBuilder sb = new StringBuilder(address_1);
        if(!TextUtils.isEmpty(address_2)){
            sb.append(" ");
            sb.append(address_2);
        }
        if(!TextUtils.isEmpty(address_3)){
            sb.append(" ");
            sb.append(address_3);
        }
        if(!TextUtils.isEmpty(city)){
            sb.append(", ");
            sb.append(city);
        }
        if(!TextUtils.isEmpty(city)){
            sb.append(", ");
            sb.append(city);
        }
        if(!TextUtils.isEmpty(state)){
            sb.append(", ");
            sb.append(state);
        }
        if(!TextUtils.isEmpty(zip)){
            sb.append(" ");
            sb.append(zip);
        }
        if(!TextUtils.isEmpty(localized_country_name)){
            sb.append(", ");
            sb.append(localized_country_name);
        }

        return sb.toString();
    }
}
