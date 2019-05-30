package api.apps.nw.dashboard;

import api.interfaces.Activity;

public class Dashboard implements Activity {

    public DashboardUiObjects uiObject = new DashboardUiObjects();

    @Override
    public Object waitToLoad() {
        return null;
    }
}
