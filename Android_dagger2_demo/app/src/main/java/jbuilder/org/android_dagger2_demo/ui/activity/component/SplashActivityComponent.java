package jbuilder.org.android_dagger2_demo.ui.activity.component;

import dagger.Subcomponent;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.SplashActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.module.SplashActivityModule;

/**
 * Created by d05660ddw on 16/9/4.
 */
@ActivityScope
@Subcomponent(modules = SplashActivityModule.class)
public interface SplashActivityComponent {
    SplashActivity inject(SplashActivity splashActivity);
}
