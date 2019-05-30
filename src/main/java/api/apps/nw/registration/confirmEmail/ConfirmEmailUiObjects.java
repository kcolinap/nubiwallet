package api.apps.nw.registration.confirmEmail;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class ConfirmEmailUiObjects {

    private static UiObject
            lblPrimaryMsg,
            lblSecondaryMsg,
            buttonOpenMail,
            buttonUpdateMail,
            buttonBack,
            lblRegisteredEmail;

    public UiObject lblPrimaryMsg(){
        if(lblPrimaryMsg == null)lblPrimaryMsg = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/message").makeUiObject();
        return lblPrimaryMsg;
    }

    public UiObject lblSecondaryMsg(){
        if(lblSecondaryMsg == null)lblSecondaryMsg = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/secondaryMessage").makeUiObject();
        return lblSecondaryMsg;
    }

    public UiObject buttonOpenMail(){
        if(buttonOpenMail == null)buttonOpenMail = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/actionButtonPrimary").makeUiObject();
        return buttonOpenMail;
    }

    public UiObject buttonUpdateMail(){
        if(buttonUpdateMail == null)buttonUpdateMail = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/actionButtonLink").makeUiObject();
        return buttonUpdateMail;
    }

    public UiObject buttonBack(){
        if(buttonBack == null)buttonBack = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/backButton").makeUiObject();
        return buttonBack;
    }

    public UiObject lblRegisteredEmail(){
        if(lblRegisteredEmail == null)lblRegisteredEmail = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/email").makeUiObject();
        return lblRegisteredEmail;
    }


}
