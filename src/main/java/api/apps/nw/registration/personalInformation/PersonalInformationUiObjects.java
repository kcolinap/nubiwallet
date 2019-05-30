package api.apps.nw.registration.personalInformation;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class PersonalInformationUiObjects {


    private static UiObject
            inputNames,
            inputLastnames,
            lblInputError,
            inputDni,
            optMaleBtn,
            optFemaleBtn,
            btnCirclenext;


    public UiObject inputNames(){
        if(inputNames == null)inputNames = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/nameInput").makeUiObject();
        return inputNames;
    }

    public UiObject inputLastNames(){
        if(inputLastnames == null)inputLastnames = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/lastNameInput").makeUiObject();
        return inputLastnames;
    }

    public UiObject lblInputError(){
        if(lblInputError == null)lblInputError = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/textinput_error").makeUiObject();
        return lblInputError;
    }

    public UiObject inputDni(){
        if(inputDni == null)inputDni = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/dniInput").makeUiObject();
        return inputDni;
    }

    public UiObject optMaleBtn(){
        if(optMaleBtn == null)optMaleBtn = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/maleGenderOption").makeUiObject();
        return optMaleBtn;
    }

    public UiObject optFemaleBtn(){
        if(optFemaleBtn == null)optFemaleBtn = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/femaleGenderOption").makeUiObject();
        return optFemaleBtn;
    }

    public UiObject btnCirclenext(){
        if(btnCirclenext == null)btnCirclenext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/circleButton").makeUiObject();
        return btnCirclenext;
    }
}
