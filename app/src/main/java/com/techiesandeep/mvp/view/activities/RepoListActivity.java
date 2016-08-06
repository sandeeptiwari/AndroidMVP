package com.techiesandeep.mvp.view.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
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
public class RepoListActivity extends ActionBarActivity implements IRepoListView, AdapterView.OnItemClickListener {

    /**
     * Questions:
     *
     * TODO: What should we do with Adapters? They are a structural pattern to present our views but they combine Views and Data
     * TODO: What about Input Validations? Should the Views or the Models know how to validate themselves?
     */

    @BindView(R.id.repo_list_view)
    ListView listView;

    private RepoListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list);
        ButterKnife.bind(this);
        presenter = new RepoListPresenter(this);
        listView.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        // TODO: Should the view get this data?
        Intent intent = getIntent();
        String username = intent.getExtras().getString("username");
        presenter.loadCommits(username);
    }

    @Override
    public void onReposLoadedSuccess(List<GitRepository> list, Response response) {
        listView.setAdapter(new RepoAdapter(this, list));
    }

    @Override
    public void onReposLoadedFailure(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        // TODO: Is there a better way to do this?
        GitRepository gitRepository = (GitRepository) adapterView.getAdapter().getItem(i);
        Toast.makeText(this, String.format("Forked = %b", gitRepository.fork), Toast.LENGTH_SHORT).show();
    }
}
