package com.techiesandeep.mvp.login.sync;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public class SynchronousLoginInteractor implements ISynchronousLoginInteractor {

    /******************************************************************************************
     * An Interactor helps models cross application boundaries such as networks or serialization
     * This LoginInteractor knows nothing about a UI or the LoginPresenter
     *******************************************************************************************
     */

    public SynchronousLoginInteractor() { }

    public boolean validatedCredentials(String username, String password) {
        return username.contains("gmail");
    }
}
