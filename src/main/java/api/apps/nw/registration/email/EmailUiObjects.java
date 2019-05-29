package api.apps.nw.registration.email;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class EmailUiObjects {

    private static UiObject
            inputEmail,
            buttonBack,
            buttonNext;

    public UiObject inputEmail(){
        if(inputEmail == null)inputEmail = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/emailInput").makeUiObject();
        return inputEmail;
    }

    public UiObject buttonBack(){
        if(buttonBack == null)buttonBack = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/backButton").makeUiObject();
        return buttonBack;
    }

    public UiObject buttonNext(){
        if(buttonNext == null)buttonNext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/nextButton").makeUiObject();
        return buttonNext;
    }
}
