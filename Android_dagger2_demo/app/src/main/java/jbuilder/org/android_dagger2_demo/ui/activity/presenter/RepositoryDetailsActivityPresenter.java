package jbuilder.org.android_dagger2_demo.ui.activity.presenter;

import jbuilder.org.android_dagger2_demo.data.model.User;
import jbuilder.org.android_dagger2_demo.ui.activity.RepositoryDetailsActivity;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class RepositoryDetailsActivityPresenter {
    private RepositoryDetailsActivity repositoryDetailsActivity;
    private User user;

    public RepositoryDetailsActivityPresenter(RepositoryDetailsActivity repositoryDetailsActivity, User user) {
        this.repositoryDetailsActivity = repositoryDetailsActivity;
        this.user = user;
    }

    public void init() {
        repositoryDetailsActivity.setupUserName(user.login);
    }


}
