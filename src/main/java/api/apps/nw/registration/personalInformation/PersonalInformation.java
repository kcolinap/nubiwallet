package api.apps.nw.registration.personalInformation;

import api.android.Android;
import api.apps.nw.registration.cuil.Cuil;
import api.apps.nw.registration.userInformation.UserInformation;
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

    public PersonalInformation setlastnames(String lNames){
        try{
            uiObject.inputLastNames().typeText(lNames);
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set last name:"+lNames);
        }
    }

    public PersonalInformation setDni(String dni){
        try{
            uiObject.inputDni().typeText(dni);
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set dni: "+dni);
        }
    }

    public PersonalInformation tapMale(){
        try{
            uiObject.optMaleBtn().tap();
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap male gender");
        }
    }

    public PersonalInformation tapFemale(){
        try{
            uiObject.optFemaleBtn().tap();
            return Android.app.nubiWallet.personalInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap female gender");
        }
    }

    public Cuil tapCircleButton(){
        try{
            uiObject.btnCirclenext().tap();
            return Android.app.nubiWallet.cuil;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap circle button on personal information screen");
        }
    }
}
