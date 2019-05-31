package api.apps.nw.registration.termsandconditions;

import api.android.Android;
import api.interfaces.Activity;

public class TermsAndConditions implements Activity {

    public TermsAndConditionsUiObjects uiObject = new TermsAndConditionsUiObjects();

    @Override
    public TermsAndConditions waitToLoad() {
        try{
            uiObject.buttonCreateAccount().waitToAppear(30);
            return Android.app.nubiWallet.termConditions;
        }catch (AssertionError e){
            throw new AssertionError("Terms and conditions screen activity failed to load/open");
        }
    }

    public TermsAndConditions tapCheckTermsAndConditions() {
        try{
            uiObject.checkBoxTerms().tap();
            return Android.app.nubiWallet.termConditions;
        }catch (AssertionError e){
            throw new AssertionError("Unable to check the element");
        }
    }

    public TermsAndConditions tapCreateAccountButton() {
        try{
            uiObject.buttonCreateAccount().tap();
            return Android.app.nubiWallet.termConditions;
        }catch (AssertionError e){
            throw new AssertionError("Unable to tap create account button");
        }
    }
}
