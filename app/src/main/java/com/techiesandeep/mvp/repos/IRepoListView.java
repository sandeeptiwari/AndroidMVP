package com.techiesandeep.mvp.repos;

import com.techiesandeep.mvp.models.GitRepository;

import java.util.List;
import retrofit2.Response;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public interface IRepoListView {
    void onReposLoadedSuccess(List<GitRepository> list, Response response);
    void onReposLoadedFailure(String error);
}
