package com.techiesandeep.mvp.repos;

import com.techiesandeep.mvp.models.GitRepository;

import java.util.List;
import retrofit2.Response;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class RepoListPresenter implements IRepoListPresenter, OnRepoInteractorFinishedListener {

    private IRepoListView view;
    private RepoListInteractor interactor;

    public RepoListPresenter(IRepoListView view) {
        this.view = view;
        this.interactor = new RepoListInteractor(this); // pass in the InteractorListener
    }

    @Override
    public void loadCommits(String username) {
        interactor.loadRecentCommits(username);
    }

    @Override
    public void onNetworkSuccess(List<GitRepository> list, Response response) {
        view.onReposLoadedSuccess(list, response);
    }

    @Override
    public void onNetworkFailure(String error) {

        view.onReposLoadedFailure(error);
    }
}
