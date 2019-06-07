package api.apps.nw.dashboard;

import api.android.Android;
import core.UiObject;
import core.UiSelector;

public class DashboardUiObjects {

    private static UiObject
            balanceCard,
            balanceCardTitle,
            frequentContactContainer;

    public UiObject balanceCard(){
        if(balanceCard == null)balanceCard = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/balanceCard").makeUiObject();
        return balanceCard;
    }

    public UiObject balanceCardTitle(){
        if(balanceCardTitle == null)balanceCardTitle = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/balanceTitle").makeUiObject();
        return balanceCardTitle;
    }

    public UiObject frequentContactContainer(){
        if(frequentContactContainer == null)frequentContactContainer = new UiSelector().resourceId(Android.app.nubiWallet.packageID()+":id/frequentContactsContent").makeUiObject();
        return frequentContactContainer;
    }
}
