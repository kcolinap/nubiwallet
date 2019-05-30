package api.apps.nw.registration.personalInformation;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class PersonalInformationUiObjects {


    private static UiObject
            inputNames,
            lblSecondaryMsg,
            buttonOpenMail,
            buttonUpdateMail,
            buttonBack,
            lblRegisteredEmail;

    public UiObject inputNames(){
        if(inputNames == null)inputNames = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/nameInput").makeUiObject();
        return inputNames;
    }
}
