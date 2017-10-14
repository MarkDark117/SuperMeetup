package com.supermeetup.supermeetup.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by yuxin on 10/13/17.
 *  {
 *      "accepts": "cash",
 *      "amount": 15,
 *      "currency": "USD",
 *      "description": "per person",
 *      "label": "Price",
 *      "required": false
 *  }
 */

public class Fee extends BaseData {

    public static final String ACCEPTTYPE_PAYPAL = "paypal";
    public static final String ACCEPTTYPE_AMAZON = "amazon";
    public static final String ACCEPTTYPE_WEPAY = "wepay";
    public static final String ACCEPTTYPE_CASH = "cash";

    public String accepts = "";
    public long amount = 0;
    public String currency = "";
    public String description = "";
    public String label = "";
    public boolean required = false;

    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }
        accepts = json.optString("accepts", accepts);
        amount = json.optLong("amount", amount);
        currency = json.optString("currency", currency);
        description = json.optString("description", description);
        label = json.optString("label", label);
        required = json.optBoolean("required", required);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("accepts", accepts);
            json.put("amount", amount);
            json.put("currency", currency);
            json.put("description", description);
            json.put("label", label);
            json.put("required", required);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }
}
