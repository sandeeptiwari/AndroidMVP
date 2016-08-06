package com.techiesandeep.mvp.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Sandeep Tiwari on 8/6/2016.
 */
public class AppUtil {

    public static void hideKeyboard(Context ctx, View view){
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)ctx.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
