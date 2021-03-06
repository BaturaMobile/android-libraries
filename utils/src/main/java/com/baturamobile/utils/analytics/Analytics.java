package com.baturamobile.utils.analytics;

import android.content.Context;
import android.os.Bundle;

import com.baturamobile.utils.log.LogStatic;
import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by vssnake on 19/07/2017.
 */

public class Analytics {

    private static final String TAG ="Analytics";

    static Analytics analytics;

    private FirebaseAnalytics firebaseAnalytics;

    private Analytics(Context context){
        firebaseAnalytics = FirebaseAnalytics.getInstance(context);
    }

    public static Analytics getInstance(){
        return analytics;
    }


    public void registerEnter(){
        LogStatic.logInterface.d(TAG,"register_init");
        firebaseAnalytics.logEvent("register_init",null);
    }

    public void registerPartial(){
        LogStatic.logInterface.d(TAG,"register_partial");
        firebaseAnalytics.logEvent("register_partial",null);
    }

    public void registerComplete(){
        LogStatic.logInterface.d(TAG,"register_complete");
        firebaseAnalytics.logEvent("register_complete",null);
    }

    public void registerInServer(){
        LogStatic.logInterface.d(TAG,"FirebaseAnalytics.Event.SIGN_UP");
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SIGN_UP,null);
    }

    public void registerError(String param1){
        LogStatic.logInterface.d(TAG,"register_error " + param1);
        Bundle bundle = new Bundle();
        bundle.putString("error",param1);
        firebaseAnalytics.logEvent("register_error",bundle);
    }

    public void logged(){
        LogStatic.logInterface.d(TAG,FirebaseAnalytics.Event.LOGIN);
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN,null);
    }

    public static void init(Context applicationContext) {
        if (analytics == null){
            analytics = new Analytics(applicationContext);
        }
    }
}
