package jbuilder.org.android_dagger2_demo.data.api;

import dagger.Module;
import dagger.Provides;
import jbuilder.org.android_dagger2_demo.data.UserScope;
import jbuilder.org.android_dagger2_demo.data.model.User;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Module
public class UserModule {
    private User user;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    RepositoriesManager provideRepositoriesManager(User user, GithubApiService githubApiService) {
        return new RepositoriesManager(user, githubApiService);
    }
}
