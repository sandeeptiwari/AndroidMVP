package com.techiesandeep.mvp.view.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.techiesandeep.mvp.R;
import com.techiesandeep.mvp.models.GitRepository;
import com.techiesandeep.mvp.repos.IRepoListView;
import com.techiesandeep.mvp.repos.RepoAdapter;
import com.techiesandeep.mvp.repos.RepoListPresenter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Response;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class RepoListFragment extends Fragment implements IRepoListView {

    public RepoListFragment() {}

    @BindView(R.id.fragment_repo_list_view)
    ListView listView;

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
        presenter.loadCommits("sandeeptiwari");
    }

    @Override
    public void onReposLoadedSuccess(List<GitRepository> list, Response response) {
        listView.setAdapter(new RepoAdapter(getActivity(), list));
    }

    @Override
    public void onReposLoadedFailure(String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }
}
