package jbuilder.org.android_dagger2_demo.ui.activity.component;

import dagger.Subcomponent;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoryDetailsActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.module.RepositoryDetailsActivityModule;

/**
 * Created by d05660ddw on 16/9/4.
 */
@ActivityScope
@Subcomponent(modules = RepositoryDetailsActivityModule.class)
public interface RepositoryDetailsActivityComponent {
    RepositoryDetailsActivity inject(RepositoryDetailsActivity repositoryDetailsActivity);
}
