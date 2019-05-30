package api.apps.nw.registration.cuil;

import api.android.Android;
import api.apps.nw.registration.userInformation.UserInformation;
import api.interfaces.Activity;

public class Cuil implements Activity {

    public CuilUiObjects uiObject = new CuilUiObjects();

    @Override
    public Cuil waitToLoad() {
        try{
            uiObject.inputCuil().waitToAppear(30);
            return Android.app.nubiWallet.cuil;
        }catch (AssertionError e){
            throw new AssertionError("cuil activity failed to load/open");
        }
    }


    public UserInformation tapCircleButton(){
        try{
            uiObject.btnCirclenext().tap();
            return Android.app.nubiWallet.userInformation;
        }catch (AssertionError e){
            throw new AssertionError("Failed to tap circle button on cuil screen");
        }
    }
}
