package com.supermeetup.supermeetup.model;

import android.text.TextUtils;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 */

public abstract class BaseData {

    public abstract void fromJson(JSONObject json);
    public abstract JSONObject toJson();

    public BaseData(){

    }

    public void fromString(String jsonString) {
        if(TextUtils.isEmpty(jsonString)){
            return;
        }
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            fromJson(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString(){
        JSONObject json = toJson();
        if(json != null){
            return json.toString();
        }else{
            return null;
        }
    }
}
