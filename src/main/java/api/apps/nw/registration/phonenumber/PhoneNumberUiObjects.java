package api.apps.nw.registration.phonenumber;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class PhoneNumberUiObjects {

    private static UiObject
            inputCodePhone,
            inputPhoneNumber,
            inputFirstDigitCode,
            inputSecondDigitCode,
            inputThirdDigitCode,
            inputFourthDigitCode,
            inputFirstDigitPin,
            inputSecondDigitPin,
            inputThirdDigitPin,
            inputFourthDigitPin,
            btnCirclenext;

    public UiObject btnCirclenext(){
        if(btnCirclenext == null)btnCirclenext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/circleButton").makeUiObject();
        return btnCirclenext;
    }

    public UiObject inputCodePhone(){
        if(inputCodePhone == null)inputCodePhone = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/areaCodeInput").makeUiObject();
        return inputCodePhone;
    }

    public UiObject inputPhoneNumber(){
        if(inputPhoneNumber == null)inputPhoneNumber = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/phoneInput").makeUiObject();
        return inputPhoneNumber;
    }

    public UiObject inputFirstDigitCode(){
        if(inputFirstDigitCode == null)inputFirstDigitCode = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/firstDigitInput").makeUiObject();
        return inputFirstDigitCode;
    }

    public UiObject inputSecondDigitCode(){
        if(inputSecondDigitCode == null)inputSecondDigitCode = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/secondDigitInput").makeUiObject();
        return inputSecondDigitCode;
    }

    public UiObject inputThirdDigitCode(){
        if(inputThirdDigitCode == null)inputThirdDigitCode = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/thirdDigitInput").makeUiObject();
        return inputThirdDigitCode;
    }

    public UiObject inputFourthDigitCode(){
        if(inputFourthDigitCode == null)inputFourthDigitCode = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/fourthDigitInput").makeUiObject();
        return inputFourthDigitCode;
    }
}
