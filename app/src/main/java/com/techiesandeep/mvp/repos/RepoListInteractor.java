package com.techiesandeep.mvp.repos;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.techiesandeep.mvp.GithubService;
import com.techiesandeep.mvp.models.GitRepository;
import com.techiesandeep.mvp.utils.StringConstants;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sandeep Tiwari on 4/8/16.
 */
public class RepoListInteractor implements Callback<List<GitRepository>> {
    private static final String TAG = RepoListInteractor.class.getSimpleName();

    private OnRepoInteractorFinishedListener listener;

    public RepoListInteractor(OnRepoInteractorFinishedListener listener) {
        this.listener = listener;
    }

    private GithubService initRestAdapter(){
        Gson gson = new GsonBuilder()
                .setDateFormat(StringConstants.TIMEFORMAT)
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(StringConstants.ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GithubService service = retrofit.create(GithubService.class);

        return service;
    }

    public void loadRecentCommits(String username) {
        GithubService service = initRestAdapter();
        Call<List<GitRepository>> call = service.getRepos(username);
        //asynchronous call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<GitRepository>> call, Response<List<GitRepository>> response) {
        int code = response.code();
        Log.i(TAG, "Response : "+code);
        if (code == 200) {
            for(int i=0;i< response.body().size();i++){
                Log.d(TAG, (response.body().get(i)).getName());
            }
            listener.onNetworkSuccess(response.body(), response);
        } else {
        }
    }

    @Override
    public void onFailure(Call<List<GitRepository>> call, Throwable t) {
        Log.i(TAG, "Error : "+t.getMessage());
        listener.onNetworkFailure(t.getMessage());
    }
}
