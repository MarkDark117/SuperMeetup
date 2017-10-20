package com.supermeetup.supermeetup.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GroupPhoto {

    @SerializedName("highres_link")
    @Expose
    private String highresLink;
    @SerializedName("photo_link")
    @Expose
    private String photoLink;
    @SerializedName("photo_id")
    @Expose
    private long photoId;
    @SerializedName("thumb_link")
    @Expose
    private String thumbLink;

    public String getHighresLink() {
        return highresLink;
    }

    public void setHighresLink(String highresLink) {
        this.highresLink = highresLink;
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long photoId) {
        this.photoId = photoId;
    }

    public String getThumbLink() {
        return thumbLink;
    }

    public void setThumbLink(String thumbLink) {
        this.thumbLink = thumbLink;
    }

}
