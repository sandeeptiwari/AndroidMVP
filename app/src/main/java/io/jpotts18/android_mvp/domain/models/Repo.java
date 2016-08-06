package io.jpotts18.android_mvp.domain.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jpotts18 on 5/12/15.
 */
public class Repo {
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
