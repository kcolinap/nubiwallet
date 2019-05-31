package api.apps.nw.registration.termsandconditions;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class TermsAndConditionsUiObjects {

    private static UiObject
            checkBoxTerms,
            buttonCreateAccount;

    public UiObject checkBoxTerms(){
        if(checkBoxTerms == null)checkBoxTerms = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/checkboxTerms").makeUiObject();
        return checkBoxTerms;
    }

    public UiObject buttonCreateAccount(){
        if(buttonCreateAccount == null)buttonCreateAccount = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/createAccountButton").makeUiObject();
        return buttonCreateAccount;
    }

}
