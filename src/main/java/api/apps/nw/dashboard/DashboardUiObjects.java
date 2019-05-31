package api.apps.nw.dashboard;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class DashboardUiObjects {

    private static UiObject
            imgFab;

    public UiObject imgFab(){
        if(imgFab == null)imgFab = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/addFab").makeUiObject();
        return imgFab;
    }
}
