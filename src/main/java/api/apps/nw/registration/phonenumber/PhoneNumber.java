package api.apps.nw.registration.phonenumber;

import api.android.Android;
import api.interfaces.Activity;

public class PhoneNumber implements Activity {

    public PhoneNumberUiObjects uiObject = new PhoneNumberUiObjects();

    @Override
    public PhoneNumber waitToLoad() {
        try{
            uiObject.inputPhoneNumber().waitToAppear(30);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Phone number activity failed to load/open");
        }
    }

    public PhoneNumber setCode(String code){
        try{
            uiObject.inputCodePhone().typeText(code);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set phone code: "+code);
        }
    }

    public PhoneNumber setNumber(String number){
        try{
            uiObject.inputPhoneNumber().typeText(number);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set phone number: "+number);
        }
    }

    public PhoneNumber tapCircleButton(){
        try{
            uiObject.btnCirclenext().tap();
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap circle button on phone number screen");
        }
    }

    public PhoneNumber waitToLoadSmsCodeScreen() {
        try{
            uiObject.inputFirstDigitCode().waitToAppear(30);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Phone number activity failed to load/open");
        }
    }

    public PhoneNumber setFirstDigitCode(String code){
        try{
            uiObject.inputFirstDigitCode().typeText(code);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set first sms digit code: ");
        }
    }

    public PhoneNumber setSecondDigitCode(String code){
        try{
            uiObject.inputSecondDigitCode().typeText(code);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set second sms digit code: ");
        }
    }

    public PhoneNumber setThirdDigitCode(String code){
        try{
            uiObject.inputThirdDigitCode().typeText(code);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set third sms digit code: ");
        }
    }

    public PhoneNumber setFourthDigitCode(String code){
        try{
            uiObject.inputFourthDigitCode().typeText(code);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set fourth sms digit code: ");
        }
    }

}
