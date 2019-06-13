package api.apps.nw.registration.userInformation;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class UserInformationUiObjects {

    private static UiObject
            inputUser,
            inputPassword,
            btnCirclenext,
            lblError;


    public UiObject inputUser(){
        if(inputUser == null)inputUser = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/userInput").makeUiObject();
        return inputUser;
    }

    public UiObject inputPassword(){
        if(inputPassword == null)inputPassword = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/passwordInput").makeUiObject();
        return inputPassword;
    }

    public UiObject btnCirclenext(){
        if(btnCirclenext == null)btnCirclenext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/circleButton").makeUiObject();
        return btnCirclenext;
    }

    public UiObject lblError(){
        if(lblError == null)lblError = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/textinput_error").makeUiObject();
        return lblError;
    }

}
