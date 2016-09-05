package jbuilder.org.android_dagger2_demo.ui.activity.module;

import dagger.Module;
import dagger.Provides;
import jbuilder.org.android_dagger2_demo.data.model.User;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoryDetailsActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.presenter.RepositoryDetailsActivityPresenter;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Module
public class RepositoryDetailsActivityModule {
    private RepositoryDetailsActivity repositoryDetailsActivity;

    public RepositoryDetailsActivityModule(RepositoryDetailsActivity repositoryDetailsActivity) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivity provideRepositoryDetailsActivity() {
        return repositoryDetailsActivity;
    }

    @Provides
    @ActivityScope
    RepositoryDetailsActivityPresenter provideRepositoryDetailsActivityPresenter(User user) {
        return new RepositoryDetailsActivityPresenter(repositoryDetailsActivity, user);
    }
}
