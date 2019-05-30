package api.apps.nw.registration.personalInformation;

import api.android.Android;
import api.interfaces.Activity;

public class PersonalInformation implements Activity {

    public PersonalInformationUiObjects uiObject = new PersonalInformationUiObjects();

    @Override
    public PersonalInformation waitToLoad() {
        try{
            uiObject.inputNames().waitToAppear(30);
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Personal Information activity failed to load/open");
        }
    }

    public PersonalInformation setNames(String names){
        try{
            uiObject.inputNames().typeText(names);
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set name:"+names);
        }
    }
}
