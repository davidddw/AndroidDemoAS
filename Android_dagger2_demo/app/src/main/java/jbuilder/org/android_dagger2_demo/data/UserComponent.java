package jbuilder.org.android_dagger2_demo.data;

import dagger.Subcomponent;
import jbuilder.org.android_dagger2_demo.data.api.UserModule;
import jbuilder.org.android_dagger2_demo.ui.activity.component.RepositoriesListActivityComponent;
import jbuilder.org.android_dagger2_demo.ui.activity.component.RepositoryDetailsActivityComponent;
import jbuilder.org.android_dagger2_demo.ui.activity.module.RepositoriesListActivityModule;
import jbuilder.org.android_dagger2_demo.ui.activity.module.RepositoryDetailsActivityModule;

/**
 * Created by d05660ddw on 16/9/5.
 */
@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {
    RepositoriesListActivityComponent plus(RepositoriesListActivityModule module);
    RepositoryDetailsActivityComponent plus(RepositoryDetailsActivityModule module);
}
