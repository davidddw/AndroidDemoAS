package jbuilder.org.android_dagger2_demo.ui.activity.presenter;

import jbuilder.org.android_dagger2_demo.HeavyLibraryWrapper;
import jbuilder.org.android_dagger2_demo.data.api.UserManager;
import jbuilder.org.android_dagger2_demo.data.model.User;
import jbuilder.org.android_dagger2_demo.ui.activity.SplashActivity;
import jbuilder.org.android_dagger2_demo.util.SimpleObserver;
import jbuilder.org.android_dagger2_demo.util.Validator;

/**
 * Created by d05660ddw on 16/9/4.
 */
public class SplashActivityPresenter {
    public String username;

    private SplashActivity splashActivity;
    private Validator validator;
    private UserManager userManager;
    private HeavyLibraryWrapper heavyLibraryWrapper;

    public SplashActivityPresenter(SplashActivity splashActivity, Validator validator,
                                   UserManager userManager, HeavyLibraryWrapper heavyLibraryWrapper) {
        this.splashActivity = splashActivity;
        this.validator = validator;
        this.userManager = userManager;
        this.heavyLibraryWrapper = heavyLibraryWrapper;

        //This calls should be delivered to ExternalLibrary right after it will be initialized
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
        this.heavyLibraryWrapper.callMethod();
    }

    public void onShowRepositoriesClick() {
        if (validator.validUsername(username)) {
            splashActivity.showLoading(true);
            userManager.getUser(username).subscribe(new SimpleObserver<User>() {
                @Override
                public void onNext(User user) {
                    splashActivity.showLoading(false);
                    splashActivity.showRepositoriesListForUser(user);
                }

                @Override
                public void onError(Throwable e) {
                    splashActivity.showLoading(false);
                    splashActivity.showValidationError();
                }
            });
        } else {
            splashActivity.showValidationError();
        }
    }
}
