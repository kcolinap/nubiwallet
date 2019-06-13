package api.apps.nw.dashboard;

import api.android.Android;
import api.interfaces.Activity;

public class Dashboard implements Activity {

    public DashboardUiObjects uiObject = new DashboardUiObjects();

    @Override
    public Dashboard waitToLoad() {
        try{
            uiObject.balance().waitToAppear(10);
            return Android.app.nubiWallet.dashboard;
        }catch (AssertionError e){
            throw new AssertionError("Dashboard activity failed to load/open");
        }
    }
}
