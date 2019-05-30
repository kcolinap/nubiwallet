package api.apps.nw.registration.userInformation;

import api.android.Android;
import api.apps.nw.registration.phonenumber.PhoneNumber;
import api.interfaces.Activity;

public class UserInformation implements Activity {


    public UserInformationUiObjects uiObject = new UserInformationUiObjects();

    @Override
    public UserInformation waitToLoad() {
        try{
            uiObject.inputUser().waitToAppear(30);
            return Android.app.nubiWallet.userInformation;
        }catch (AssertionError e){
            throw new AssertionError("User Information activity failed to load/open");
        }
    }

    public UserInformation setUser(String user){
        try{
            uiObject.inputUser().typeText(user);
            return Android.app.nubiWallet.userInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set user:"+user);
        }
    }

    public UserInformation setPassword(String pass){
        try{
            uiObject.inputPassword().typeText(pass);
            return Android.app.nubiWallet.userInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set password");
        }
    }

    public PhoneNumber tapCircleButton(){
        try{
            uiObject.btnCirclenext().tap();
            return Android.app.nubiWallet.phoneNumber;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap circle button on user information screen");
        }
    }

}
