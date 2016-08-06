package com.techiesandeep.mvp.login;


import com.techiesandeep.mvp.login.async.AsyncLoginInteractor;
import com.techiesandeep.mvp.login.async.OnLoginFinishedListener;

/**
 * Created by Sandeep Tiwari on 8/6/16.
 */
public class LoginPresenter implements ILoginPresenter, OnLoginFinishedListener {

    /******************************************************************************************
     - LoginPresenter has a reference to both the View and the Interactor
     - LoginPresenter retrieves data from the model, and notifies the view to display it.
     - OnLoginFinishedListener adds the methods that are necessary for asynchronous callbacks which leaves the rest of the interface intact
    *******************************************************************************************
    */

    // Referencing any class that implements the ILoginView interface provides greater flexibility
    private ILoginView view;
    private AsyncLoginInteractor interactor;

    public LoginPresenter(ILoginView loginView) {
        this.view = loginView;
        this.interactor = new AsyncLoginInteractor();
    }

    public void attemptLogin(String username, String password){
        interactor.validateCredentialsAsync(this, username, password);
    }

    @Override
    public void onError() {
        view.loginFailed();
    }

    @Override
    public void onSuccess() {
        view.navigateToListActivity();
    }
}
