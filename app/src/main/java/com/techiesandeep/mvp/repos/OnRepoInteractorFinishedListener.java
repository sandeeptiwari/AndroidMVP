package com.techiesandeep.mvp.repos;

import com.techiesandeep.mvp.models.GitRepository;

import java.util.List;
import retrofit2.Response;

/**
 * Created by Sandeep Tiwari on 4/Aug/16.
 */
public interface OnRepoInteractorFinishedListener {
    void onNetworkSuccess(List<GitRepository> list, Response response);
    void onNetworkFailure(String errorResponse);
}
