package jbuilder.org.android_dagger2_demo;

import android.app.Application;
import android.content.Context;

import jbuilder.org.android_dagger2_demo.data.UserComponent;
import jbuilder.org.android_dagger2_demo.data.api.UserModule;
import jbuilder.org.android_dagger2_demo.data.model.User;
import timber.log.Timber;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class AppApplication extends Application {

    private AppComponent appComponent;
    private UserComponent userComponent;

    public static AppApplication get(Context context) {
        return (AppApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }

        initAppComponent();

    }

    private void initAppComponent() {
        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public void releaseUserComponent() {
        userComponent = null;
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
