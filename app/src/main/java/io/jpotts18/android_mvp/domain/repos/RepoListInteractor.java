package io.jpotts18.android_mvp.domain.repos;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import io.jpotts18.android_mvp.domain.GithubService;
import io.jpotts18.android_mvp.domain.models.Repo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Sandeep Tiwari on 4/8/16.
 */
public class RepoListInteractor implements Callback<List<Repo>> {
    private static final String TAG = RepoListInteractor.class.getSimpleName();

    private static final String ENDPOINT = "http://api.github.com/";
    private OnRepoInteractorFinishedListener listener;

    public RepoListInteractor(OnRepoInteractorFinishedListener listener) {
        this.listener = listener;
    }

    private GithubService initRestAdapter(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GithubService service = retrofit.create(GithubService.class);

        return service;
    }

    public void loadRecentCommits(String username) {
        GithubService service = initRestAdapter();
        Call<List<Repo>> call = service.getRepos(username);
        //asynchronous call
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
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
    public void onFailure(Call<List<Repo>> call, Throwable t) {
        Log.i(TAG, "Error : "+t.getMessage());
        listener.onNetworkFailure(t.getMessage());
    }
}
