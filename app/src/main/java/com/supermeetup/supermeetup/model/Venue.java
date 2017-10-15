package com.supermeetup.supermeetup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by yuxin on 10/13/17.
 * Sample: https://secure.meetup.com/meetup_api/console/?path=/find/venues
 * "venue": {
 * "id": 1869971,
 * "name": "Studio 302",
 * "lat": 37.748023986816406,
 * "lon": -122.41981506347656,
 * "repinned": false,
 * "address_1": "3435 Cesar Chavez ",
 * "city": "San Francisco",
 * "country": "us",
 * "localized_country_name": "USA",
 * "zip": "94110",
 * "state": "CA"
 * }
 */

public class Venue {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("lat")
    @Expose
    private double lat;
    @SerializedName("lon")
    @Expose
    private double lon;
    @SerializedName("repinned")
    @Expose
    private boolean repinned;
    @SerializedName("address_1")
    @Expose
    private String address1;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("localized_country_name")
    @Expose
    private String localizedCountryName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public boolean isRepinned() {
        return repinned;
    }

    public void setRepinned(boolean repinned) {
        this.repinned = repinned;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocalizedCountryName() {
        return localizedCountryName;
    }

    public void setLocalizedCountryName(String localizedCountryName) {
        this.localizedCountryName = localizedCountryName;
    }

}
