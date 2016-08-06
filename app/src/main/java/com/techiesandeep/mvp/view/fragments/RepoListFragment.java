package com.techiesandeep.mvp.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techiesandeep.mvp.R;
import com.techiesandeep.mvp.models.GitRepository;
import com.techiesandeep.mvp.repos.IRepoListView;
import com.techiesandeep.mvp.repos.RepoListPresenter;
import com.techiesandeep.mvp.repos.RepositoryAdapter;
import com.techiesandeep.mvp.utils.DividerItemDecoration;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class RepoListFragment extends Fragment implements IRepoListView {

    public RepoListFragment() {}

    @BindView(R.id.rvContacts)
    RecyclerView recyclerView;

    @BindView(R.id.progressBar_splash)
    ProgressBar progressBar;

    private RepoListPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new RepoListPresenter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_repo_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        progressBar.setVisibility(View.VISIBLE);
        presenter.loadCommits("sandeeptiwari");
    }

    @Override
    public void onReposLoadedSuccess(List<GitRepository> list, Response response) {
        RepositoryAdapter adapter = new RepositoryAdapter(getActivity(), list);
        RecyclerView.ItemDecoration itemDecoration = new
                DividerItemDecoration(getActivity(), R.drawable.divider);
        recyclerView.addItemDecoration(itemDecoration);
        // Set layout manager to position the items
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onReposLoadedFailure(String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
