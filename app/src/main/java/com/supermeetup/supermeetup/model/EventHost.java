package com.supermeetup.supermeetup.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 * Sample:
 *  {
 *      "id": 182465237,
 *      "name": "Ranelle Reyes",
 *      "intro": "Hello! Don't watch too much anime nowadays since I slowly transition to watching a lot more jDramas, kDrama, and asian variety shows, but love a lot of the older anime out there! Come talk to me about TGS 2015, I was there! :P",
 *      "photo": {
 *          "id": 254979559,
 *          "highres_link": "https://secure.meetupstatic.com/photos/member/9/a/8/7/highres_254979559.jpeg",
 *          "photo_link": "https://secure.meetupstatic.com/photos/member/9/a/8/7/member_254979559.jpeg",
 *          "thumb_link": "https://secure.meetupstatic.com/photos/member/9/a/8/7/thumb_254979559.jpeg",
 *          "type": "member",
 *          "base_url": "https://secure.meetupstatic.com"
 *      }
 *  }
 */

public class EventHost extends BaseData {

    public long id = 0;
    public String name = "";
    public String intro = "";
    public Photo photo = new Photo();

    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }

        id = json.optLong("id", id);
        name = json.optString("name", name);
        intro = json.optString("intro", intro);
        photo.fromJson(json.optJSONObject("photo"));
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("name", name);
            json.put("intro", intro);
            json.put("photo", photo.toJson());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
