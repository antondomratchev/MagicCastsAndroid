package com.grokinteractive.magiccasts.model;

import java.util.ArrayList;

public class Video {
    private String title, thumbnailUrl;
    private String length;
    private String description;
    private ArrayList<String> collection;

    public Video() {
    }

    public Video(String name, String thumbnailUrl, String length, String description,
                 ArrayList<String> collection) {
        this.title = name;
        this.thumbnailUrl = thumbnailUrl;
        this.length = length;
        this.description = description;
        this.collection = collection;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String name) {
        this.title = name;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getCollection() {
        return collection;
    }

    public void setCollection(ArrayList<String> collection) {
        this.collection = collection;
    }

}