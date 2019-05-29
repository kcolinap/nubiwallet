package api.apps.nw;

import api.android.Android;
import api.apps.nw.home.Home;
import api.apps.nw.registration.email.Email;
import api.interfaces.Application;

public class NubiWallet implements Application {

    public Home home = new Home();
    public Email email = new Email();

    @Override
    public void forceStop() {
        Android.adb.forceStopApp(packageID());
    }

    @Override
    public void clearData() {
        Android.adb.clearAppsData(packageID());
    }

    @Override
    public Object open() {
        Android.adb.openAppsActivity(packageID(), activityID());
        return null;
    }

    @Override
    public String packageID() {

        return "com.tunubi.wallet";
    }

    @Override
    public String activityID() {

        return "com.nubi.splashFeature.view.SplashActivity";
    }
}
