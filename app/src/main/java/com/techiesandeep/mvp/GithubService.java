package com.techiesandeep.mvp;
import com.techiesandeep.mvp.models.GitRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by Sandeep Tiwari on 8/6/16.
 */

public interface GithubService {
    @GET("users/{user}/repos")
    Call<List<GitRepository>> getRepos(@Path("user") String user);
}