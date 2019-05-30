package api.apps.nw;

import api.android.Android;
import api.apps.nw.home.Home;
import api.apps.nw.registration.confirmEmail.ConfirmEmail;
import api.apps.nw.registration.cuil.Cuil;
import api.apps.nw.registration.email.Email;
import api.apps.nw.registration.personalInformation.PersonalInformation;
import api.apps.nw.registration.phonenumber.PhoneNumber;
import api.apps.nw.registration.userInformation.UserInformation;
import api.interfaces.Application;

public class NubiWallet implements Application {

    public Home home = new Home();
    public Email email = new Email();
    public ConfirmEmail confirmEmail = new ConfirmEmail();
    public PersonalInformation personalInformation = new PersonalInformation();
    public UserInformation userInformation = new UserInformation();
    public Cuil cuil = new Cuil();
    public PhoneNumber phoneNumber = new PhoneNumber();


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

        return "com.nubi.featuresplash.view.SplashActivity";
    }
}
