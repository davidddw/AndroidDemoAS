package jbuilder.org.android_dagger2_demo.ui.activity.module;

import android.support.v7.widget.LinearLayoutManager;

import java.util.Map;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntKey;
import dagger.multibindings.IntoMap;
import jbuilder.org.android_dagger2_demo.data.api.RepositoriesManager;
import jbuilder.org.android_dagger2_demo.data.model.Repository;
import jbuilder.org.android_dagger2_demo.ui.activity.ActivityScope;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoriesListActivity;
import jbuilder.org.android_dagger2_demo.ui.activity.presenter.RepositoriesListActivityPresenter;
import jbuilder.org.android_dagger2_demo.ui.adapter.RepositoriesListAdapter;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoriesListViewHolderFactory;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoryViewHolderBigFactory;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoryViewHolderFeaturedFactory;
import jbuilder.org.android_dagger2_demo.ui.adapter.viewholder.RepositoryViewHolderNormalFactory;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Module
public class RepositoriesListActivityModule {
    private RepositoriesListActivity repositoriesListActivity;

    public RepositoriesListActivityModule(RepositoriesListActivity repositoriesListActivity) {
        this.repositoriesListActivity = repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivity provideRepositoriesListActivity() {
        return repositoriesListActivity;
    }

    @Provides
    @ActivityScope
    RepositoriesListActivityPresenter provideRepositoriesListActivityPresenter(RepositoriesManager repositoriesManager) {
        return new RepositoriesListActivityPresenter(repositoriesListActivity, repositoriesManager);
    }

    @Provides
    @ActivityScope
    RepositoriesListAdapter provideRepositoriesListAdapter(RepositoriesListActivity repositoriesListActivity,
                                                           Map<Integer, RepositoriesListViewHolderFactory> viewHolderFactories) {
        return new RepositoriesListAdapter(repositoriesListActivity, viewHolderFactories);
    }

    @Provides
    @ActivityScope
    LinearLayoutManager provideLinearLayoutManager(RepositoriesListActivity repositoriesListActivity) {
        return new LinearLayoutManager(repositoriesListActivity);
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_NORMAL)
    RepositoriesListViewHolderFactory provideViewHolderNormal() {
        return new RepositoryViewHolderNormalFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_BIG)
    RepositoriesListViewHolderFactory provideViewHolderBig() {
        return new RepositoryViewHolderBigFactory();
    }

    @Provides
    @IntoMap
    @IntKey(Repository.TYPE_FEATURED)
    RepositoriesListViewHolderFactory provideViewHolderFeatured() {
        return new RepositoryViewHolderFeaturedFactory();
    }
}
