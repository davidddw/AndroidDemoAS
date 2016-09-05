package jbuilder.org.android_dagger2_demo.data;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

import dagger.Subcomponent;
import jbuilder.org.android_dagger2_demo.data.api.RepositoriesManager;
import jbuilder.org.android_dagger2_demo.data.api.UserModule;
import jbuilder.org.android_dagger2_demo.util.AnalyticsManager;
import jbuilder.org.android_dagger2_demo.util.Validator;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {

}
