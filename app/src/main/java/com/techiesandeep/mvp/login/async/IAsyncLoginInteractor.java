package com.techiesandeep.mvp.login.async;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public interface IAsyncLoginInteractor {
    void validateCredentialsAsync(OnLoginFinishedListener listener, String username, String password);
}
