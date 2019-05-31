package api.apps.nw.registration.pin;

import api.android.Android;
import api.apps.nw.registration.termsandconditions.TermsAndConditions;
import api.interfaces.Activity;

public class Pin implements Activity {

    public PinUiObjects uiObject = new PinUiObjects();

    @Override
    public Pin waitToLoad() {
        try{
            uiObject.textTitle().waitToAppear(30);
            return Android.app.nubiWallet.pin;
        }catch (AssertionError e){
            throw new AssertionError("Pin screen activity failed to load/open");
        }
    }

    public Pin setFirstDigitPin(String pin){
        try{
            uiObject.inputFirstDigitPin().typeText(pin);
            return Android.app.nubiWallet.pin;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set first pin code");
        }
    }

    public Pin setSecondDigitPin(String pin){
        try{
            uiObject.inputSecondDigitPin().typeText(pin);
            return Android.app.nubiWallet.pin;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set second pin code");
        }
    }

    public Pin setThirdDigitPin(String pin){
        try{
            uiObject.inputThirdDigitPin().typeText(pin);
            return Android.app.nubiWallet.pin;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set third pin code");
        }
    }

    public Pin setFourthDigitPin(String pin){
        try{
            uiObject.inputFourthDigitPin().typeText(pin);
            return Android.app.nubiWallet.pin;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set fourth pin code");
        }
    }

    public TermsAndConditions tapCircleButton(){
        try{
            uiObject.btnCirclenext().tap();
            return Android.app.nubiWallet.termConditions;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap circle button on pin screen");
        }
    }
}
