package api.apps.nw.registration.pin;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class PinUiObjects {

    private static UiObject
            textTitle,
            inputFirstDigitPin,
            inputSecondDigitPin,
            inputThirdDigitPin,
            inputFourthDigitPin,
            btnCirclenext;

    public UiObject textTitle(){
        if(textTitle == null)textTitle = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/pinCreationTitle").makeUiObject();
        return textTitle;
    }

    public UiObject btnCirclenext(){
        if(btnCirclenext == null)btnCirclenext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/circleButton").makeUiObject();
        return btnCirclenext;
    }

    public UiObject inputFirstDigitPin(){
        if(inputFirstDigitPin == null)inputFirstDigitPin = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/firstDigitInput").makeUiObject();
        return inputFirstDigitPin;
    }

    public UiObject inputSecondDigitPin(){
        if(inputSecondDigitPin == null)inputSecondDigitPin = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/secondDigitInput").makeUiObject();
        return inputSecondDigitPin;
    }

    public UiObject inputThirdDigitPin(){
        if(inputThirdDigitPin == null)inputThirdDigitPin = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/thirdDigitInput").makeUiObject();
        return inputThirdDigitPin;
    }

    public UiObject inputFourthDigitPin(){
        if(inputFourthDigitPin == null)inputFourthDigitPin = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/fourthDigitInput").makeUiObject();
        return inputFourthDigitPin;
    }

}
