package jbuilder.org.android_dagger2_demo.util;

import android.text.TextUtils;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by d05660ddw on 16/9/4.
 */
@Singleton
public class Validator {
    @Inject
    public Validator() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username) && username.length()>0;
    }
}
