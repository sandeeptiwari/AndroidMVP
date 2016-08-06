package com.techiesandeep.mvp.view.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.appcompat.BuildConfig;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.techiesandeep.mvp.R;
import com.techiesandeep.mvp.login.ILoginView;
import com.techiesandeep.mvp.login.LoginPresenter;
import com.techiesandeep.mvp.utils.AppUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class LoginActivity extends AppCompatActivity implements ILoginView {

    /******************************************************************************************
     - LoginActivity ONLY knows how to display views and sending events and data to the presenter
     - LoginActivity doesn't know anything about the model (SynchronousLoginInteractor)
     - The only changes to the LoginActivity to allow for asynchronous behavior was to add a ProgressDialog
    ********************************************************************************************
    */

    @BindView(R.id.login_github_username)
    EditText githubUsernameEditText;

    @BindView(R.id.login_fake_password)
    EditText fakePasswordEditText;

    @BindView(R.id.progressBar_splash)
    ProgressBar progressBar;

    LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.login_submit_button)
    public void loginTapped(View view){
        progressBar.setVisibility(View.VISIBLE);
        String email =  githubUsernameEditText.getText().toString();
        String password = fakePasswordEditText.getText().toString();
        // Pass user event straight to presenter
        presenter.attemptLogin(email, password);
        AppUtil.hideKeyboard(this, view);
    }

    @Override
    public void navigateToListActivity() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Login Success!",Toast.LENGTH_SHORT).show();
        // TODO: This seems to have to do with persisting data. Where should we move this?
        Intent i = new Intent(this, RepoListFragmentActivity.class);
        i.putExtra("username", githubUsernameEditText.getText().toString());
        startActivity(i);
    }

    @Override
    public void loginFailed() {
        progressBar.setVisibility(View.GONE);
        Toast.makeText(this, "Login Invalid: Must be 3 letters or longer", Toast.LENGTH_SHORT).show();
    }
}



