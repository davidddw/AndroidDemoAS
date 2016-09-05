package jbuilder.org.android_dagger2_demo;

/**
 * Created by d05660ddw on 16/9/5.
 */
public class HeavyExternalLibrary {
    private boolean initialized = false;

    public HeavyExternalLibrary() {
    }

    public void init() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        initialized = true;
    }

    public void callMethod() {
        if (!initialized) throw new RuntimeException("Call init() before you use this library");
    }
}
