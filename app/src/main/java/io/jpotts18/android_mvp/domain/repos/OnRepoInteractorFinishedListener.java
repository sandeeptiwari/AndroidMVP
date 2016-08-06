package io.jpotts18.android_mvp.domain.repos;

import java.util.List;

import io.jpotts18.android_mvp.domain.models.Repo;
import retrofit2.Response;

/**
 * Created by Sandeep Tiwari on 4/Aug/16.
 */
public interface OnRepoInteractorFinishedListener {
    void onNetworkSuccess(List<Repo> list, Response response);
    void onNetworkFailure(String errorResponse);
}
