package com.supermeetup.supermeetup.model.requestparameters;

/**
 * Created by yuxin on 10/13/17.
 */

public class FindEventRequestParameters {
    public String fields = "event_hosts, group_category, group_photo, venue_visibility";
    public String lat = "";
    public String lon = "";
    public String radius = ""; //May be 0.0-100.0, 'global' or 'smart', Defaults to member's preferred radius
    public String text = "";
}
