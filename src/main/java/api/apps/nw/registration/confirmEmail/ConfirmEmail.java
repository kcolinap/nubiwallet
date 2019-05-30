package api.apps.nw.registration.confirmEmail;

import api.android.Android;
import api.apps.nw.registration.personalInformation.PersonalInformation;
import api.interfaces.Activity;

public class ConfirmEmail implements Activity {

    public ConfirmEmailUiObjects uiObject = new ConfirmEmailUiObjects();

    @Override
    public ConfirmEmail waitToLoad() {
        try{
            uiObject.buttonOpenMail().waitToAppear(30);
            return Android.app.nubiWallet.confirmEmail;
        }catch (AssertionError e){
            throw new AssertionError("Confirm Email activity failed to load/open");
        }
    }

    public PersonalInformation tapButtonOpenMail(){
        try {
            uiObject.buttonOpenMail().tap();
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Unable to tab button Open mail");
        }
    }
}
