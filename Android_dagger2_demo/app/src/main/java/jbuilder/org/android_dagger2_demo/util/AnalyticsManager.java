package jbuilder.org.android_dagger2_demo.util;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;

import timber.log.Timber;

/**
 * Created by d05660ddw on 16/9/4.
 */
//@Singleton
public class AnalyticsManager {
    private Application app;

    @Inject
    public AnalyticsManager(Application app) {
        this.app = app;
    }

    public void logScreenView(String screenName) {
        Timber.d("Logged screen name: " + screenName);
    }
}
