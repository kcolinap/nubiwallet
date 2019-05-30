package api.apps.nw.registration.cuil;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class CuilUiObjects {

    private static UiObject
            inputCuil,
            btnCirclenext;

    public UiObject inputCuil(){
        if(inputCuil == null)inputCuil = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/dniInput").makeUiObject();
        return inputCuil;
    }

    public UiObject btnCirclenext(){
        if(btnCirclenext == null)btnCirclenext = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/circleButton").makeUiObject();
        return btnCirclenext;
    }
}
