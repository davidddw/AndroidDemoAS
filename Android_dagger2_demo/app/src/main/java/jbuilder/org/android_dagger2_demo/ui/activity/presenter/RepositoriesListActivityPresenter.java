package jbuilder.org.android_dagger2_demo.ui.activity.presenter;

import com.google.common.collect.ImmutableList;

import jbuilder.org.android_dagger2_demo.data.api.RepositoriesManager;
import jbuilder.org.android_dagger2_demo.data.model.Repository;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoriesListActivity;
import jbuilder.org.android_dagger2_demo.util.SimpleObserver;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class RepositoriesListActivityPresenter {
    private RepositoriesListActivity repositoriesListActivity;
    private RepositoriesManager repositoriesManager;

    public RepositoriesListActivityPresenter(RepositoriesListActivity repositoriesListActivity,
                                             RepositoriesManager repositoriesManager) {
        this.repositoriesListActivity = repositoriesListActivity;
        this.repositoriesManager = repositoriesManager;
    }

    public void loadRepositories() {
        repositoriesListActivity.showLoading(true);
        repositoriesManager.getUsersRepositories().subscribe(new SimpleObserver<ImmutableList<Repository>>() {
            @Override
            public void onNext(ImmutableList<Repository> repositories) {
                repositoriesListActivity.showLoading(false);
                repositoriesListActivity.setRepositories(repositories);
            }

            @Override
            public void onError(Throwable e) {
                repositoriesListActivity.showLoading(false);
            }
        });
    }
}
