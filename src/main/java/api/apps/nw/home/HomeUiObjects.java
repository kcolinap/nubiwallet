package api.apps.nw.home;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class HomeUiObjects {

    private static UiObject
            txtUser,
            txtPass,
            btnInitSession,
            lnkRegister,
            lnkForgotPass,
            lblWrongData;

    public UiObject txtUser(){
        if(txtUser == null)txtUser = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/userInput").makeUiObject();
        return txtUser;
    }

    public UiObject lblWrongData(){
        if(lblWrongData == null)lblWrongData = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/textinput_error").makeUiObject();
        return lblWrongData;
    }

    public UiObject txtPassword(){
        if(txtPass == null)txtPass = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/passwordInput").makeUiObject();
        return txtPass;
    }

    public UiObject btnInitSession(){
        if(btnInitSession == null) btnInitSession = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/loginButton").makeUiObject();
        return btnInitSession;
    }

    public UiObject lnkRegister(){
        if(lnkRegister == null) lnkRegister = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/linkRegister").makeUiObject();
        return lnkRegister;
    }

    public UiObject lnkForgotPassword(){
        if(lnkForgotPass == null) lnkForgotPass = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/link_remember_password").makeUiObject();
        return lnkForgotPass;
    }
}
