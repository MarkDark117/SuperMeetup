package com.supermeetup.supermeetup.model;

import com.supermeetup.supermeetup.common.Util;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by yuxin on 10/13/17.
 * Definition: https://www.meetup.com/meetup_api/docs/find/events/
 */

public class Event extends BaseData {
    public static final String STATUS_CANCELLED = "cancelled";
    public static final String STATUS_UPCOMING = "upcoming";
    public static final String STATUS_PAST = "past";
    public static final String STATUS_PROPOSED = "proposed";
    public static final String STATUS_SUGGESTED = "suggested";
    public static final String STATUS_DRAFT = "draft";
    public static final String VENUEVISIBILITYTYPE_MEMBERS = "members";
    public static final String VENUEVISIBILITYTYPE_PUBLIC = "public";
    public static final String EVENTVISIBILITYTYPE_PUBLIC = "public";
    public static final String EVENTVISIBILITYTYPE_PUBLICLIMITED = "public_limited";
    public static final String EVENTVISIBILITYTYPE_MEMBERS = "members";

    public long id = 0;
    public long created = 0;
    public String description = "";
    public long duration = 3*60*1000;
    public ArrayList<EventHost> event_hosts = new ArrayList<>();
    public Fee fee = new Fee();
    public Group group = new Group();
    public String link = "";
    public long manual_attendance_count = 0;
    public String name = "";
    public String rsvp_close_offset = "";
    public long rsvp_limit = 0;
    public String rsvp_open_offset = "";
    public String status = "";
    public long time = 0;
    public long updated = 0;
    public long utc_offset = 0;
    public Venue venue = new Venue();
    public String venue_visibility = "";
    public String visibility = "";
    public long waitlist_count = 0;
    public String why = "";
    public long yes_rsvp_count = 0;

    @Override
    public void fromJson(JSONObject json) {
        if(json == null || json.length() == 0){
            return;
        }
        id = json.optLong("id", id);
        created = json.optLong("created", created);
        description = json.optString("description", description);
        duration = json.optLong("duration", duration);
        event_hosts = Util.putJsonArrayToEventHostList(json.optJSONArray("event_hosts"));
        fee.fromJson(json.optJSONObject("fee"));
        group.fromJson(json.optJSONObject("group"));
        link = json.optString("link", link);
        manual_attendance_count = json.optLong("manual_attendance_count", manual_attendance_count);
        name = json.optString("name", name);
        rsvp_close_offset = json.optString("rsvp_close_offset", rsvp_close_offset);
        rsvp_limit = json.optLong("rsvp_limit", rsvp_limit);
        rsvp_open_offset = json.optString("rsvp_open_offset", rsvp_open_offset);
        status = json.optString("status", status);
        time = json.optLong("time", time);
        updated = json.optLong("updated", updated);
        utc_offset = json.optLong("utc_offset", utc_offset);
        venue_visibility = json.optString("venue_visibility", venue_visibility);
        venue.fromJson(json.optJSONObject("venue"));
        waitlist_count = json.optLong("waitlist_count", waitlist_count);
        why = json.optString("why", why);
        yes_rsvp_count = json.optLong("yes_rsvp_count", yes_rsvp_count);
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        try {
            json.put("id", id);
            json.put("created", created);
            json.put("description", description);
            json.put("duration", duration);
            json.put("event_hosts", Util.getJsonArrayFromEventHostList(event_hosts));
            json.put("fee", fee.toJson());
            json.put("group", group.toJson());
            json.put("link", link);
            json.put("manual_attendance_count", manual_attendance_count);
            json.put("name", name);
            json.put("rsvp_close_offset", rsvp_close_offset);
            json.put("rsvp_limit", rsvp_limit);
            json.put("rsvp_open_offset", rsvp_open_offset);
            json.put("status", status);
            json.put("time", time);
            json.put("updated", updated);
            json.put("utc_offset", utc_offset);
            json.put("venue", venue.toJson());
            json.put("venue_visibility", venue_visibility);
            json.put("waitlist_count", waitlist_count);
            json.put("why", why);
            json.put("yes_rsvp_count", yes_rsvp_count);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return json;
    }

    public boolean isVenueVisible(){
        return VENUEVISIBILITYTYPE_PUBLIC.equals(venue_visibility);
    }

}
