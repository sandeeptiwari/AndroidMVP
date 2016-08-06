package com.techiesandeep.mvp.login.sync;

/**
 *  Created by Sandeep Tiwari on 8/6/16.
 */
public interface ISynchronousLoginInteractor {
    boolean validatedCredentials(String username, String password);
}
