package jbuilder.org.android_dagger2_demo.ui.activity.component;

import dagger.Subcomponent;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoriesListActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.module.RepositoriesListActivityModule;

/**
 * Created by d05660ddw on 16/9/4.
 */
@ActivityScope
@Subcomponent(modules = RepositoriesListActivityModule.class)
public interface RepositoriesListActivityComponent {
    RepositoriesListActivity inject(RepositoriesListActivity repositoriesListActivity);
}
