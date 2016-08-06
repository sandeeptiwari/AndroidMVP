package com.techiesandeep.mvp.models;

import com.google.gson.annotations.SerializedName;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class GitRepository {
    public int id;
    public String name;
    public boolean fork;
    @SerializedName("stargazers_count")
    public int stars;

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

    public boolean isFork() {
        return fork;
    }

    public void setFork(boolean fork) {
        this.fork = fork;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }
}
