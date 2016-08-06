package com.techiesandeep.mvp.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.techiesandeep.mvp.R;

public class RepoListFragmentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repo_list_fragment);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("AndroidMVP");
    }

}
