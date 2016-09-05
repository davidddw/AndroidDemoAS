package jbuilder.org.android_dagger2_demo.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import jbuilder.org.android_dagger2_demo.HeavyLibraryWrapper;
import jbuilder.org.android_dagger2_demo.data.api.UserManager;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.SplashActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.presenter.SplashActivityPresenter;
import jbuilder.org.android_dagger2_demo.util.Validator;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Module
public class SplashActivityModule {
    public SplashActivityModule(SplashActivity splashActivity) {
        this.splashActivity = splashActivity;
    }

    private SplashActivity splashActivity;

    @Provides
    @ActivityScope
    SplashActivity provideSplashActivity() {
        return splashActivity;
    }

    @Provides
    @ActivityScope
    SplashActivityPresenter provideSplashActivityPresenter(Validator validator, UserManager userManager,
                                                           HeavyLibraryWrapper heavyLibraryWrapper) {
        return new SplashActivityPresenter(splashActivity, validator, userManager, heavyLibraryWrapper);
    }
}
