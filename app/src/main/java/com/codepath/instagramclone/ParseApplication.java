package com.codepath.instagramclone;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();


        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("uK9qhMtIDOLIQmDh420kijq3UXpLLwFDKHqxW5mp")
                .clientKey("mFPrlFNAPPGktNRRFZ3sly88aAJMwWFrbNpa0u6k")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
