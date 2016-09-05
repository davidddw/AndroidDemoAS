package jbuilder.org.android_dagger2_demo;

import javax.inject.Singleton;

import dagger.Component;
import jbuilder.org.android_dagger2_demo.data.UserComponent;
import jbuilder.org.android_dagger2_demo.data.api.GithubApiModule;
import jbuilder.org.android_dagger2_demo.data.api.UserModule;
import jbuilder.org.android_dagger2_demo.ui.activity.component.SplashActivityComponent;
import jbuilder.org.android_dagger2_demo.ui.activity.module.SplashActivityModule;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Singleton
@Component(modules = {AppModule.class, GithubApiModule.class})
public interface AppComponent {
    SplashActivityComponent plus(SplashActivityModule module);
    UserComponent plus(UserModule userModule);
}
