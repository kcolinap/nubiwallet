package api.apps.nw.dashboard;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class DashboardUiObjects {

    private static UiObject
            balanceCard;

    public UiObject balanceCard(){
        if(balanceCard == null)balanceCard = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/balanceCard").makeUiObject();
        return balanceCard;
    }
}
