package api.apps.nw.dashboard;

import api.android.Android;
import api.interfaces.Activity;

public class Dashboard implements Activity {

    public DashboardUiObjects uiObject = new DashboardUiObjects();

    //at this moment, misaldo container has not id, so, for now , we waito for another element on dashboard screen
    @Override
    public Dashboard waitToLoad() {
        try{
            uiObject.imgFab().waitToAppear(20);
            return Android.app.nubiWallet.dashboard;
        }catch (AssertionError e){
            throw new AssertionError("Dashboard activity failed to load/open");
        }
    }
}
