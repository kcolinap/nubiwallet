package api.apps.nw.registration.email;

import api.android.Android;
import api.apps.nw.home.HomeUiObjects;
import api.apps.nw.registration.confirmEmail.ConfirmEmail;
import api.interfaces.Activity;

public class Email implements Activity {

    public EmailUiObjects uiObject = new EmailUiObjects();

    @Override
    public Email waitToLoad() {
        try{
            uiObject.inputEmail().waitToAppear(30);
            return Android.app.nubiWallet.email;
        }catch (AssertionError e){
            throw new AssertionError("Email activity failed to load/open");
        }
    }

    public Email setEmail(String email){
        try{
            uiObject.inputEmail().typeText(email);
            return Android.app.nubiWallet.email;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set user:"+email);
        }
    }

    public boolean isEnabledNextButton(){
        try{
            boolean status = false;
            status = uiObject.buttonNext().isEnabled();
            return status;
        }catch (AssertionError e){
            throw new AssertionError("Can not determine if element is enabled");
        }
    }

    public ConfirmEmail tapButtonNext(){
        try {
            uiObject.buttonNext().tap();
            return Android.app.nubiWallet.confirmEmail;
        }catch (AssertionError e){
            throw new AssertionError("Unable to tab button next");
        }
    }
}
