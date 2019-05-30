package api.apps.nw.registration.pin;

import api.android.Android;
import api.interfaces.Activity;

public class Pin implements Activity {


    @Override
    public Pin waitToLoad() {
        try{
            uiObject.inputPhoneNumber().waitToAppear(30);
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Phone number activity failed to load/open");
        }
    }
}
