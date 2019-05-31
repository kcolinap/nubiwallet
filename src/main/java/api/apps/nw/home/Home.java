package api.apps.nw.home;

import api.android.Android;
import api.apps.nw.dashboard.Dashboard;
import api.apps.nw.registration.email.Email;
import api.interfaces.Activity;
import core.MyLogger;

public class Home implements Activity {

    public HomeUiObjects uiObject = new HomeUiObjects();

    @Override
    public Home waitToLoad() {
        try{
            uiObject.txtUser().waitToAppear(20);
            return Android.app.nubiWallet.home;
        }catch (AssertionError e){
            throw new AssertionError("Home activity failed to load/open");
        }
    }

    public Home setUser(String user){
        try{
            uiObject.txtUser().typeText(user);
            return Android.app.nubiWallet.home;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set user:"+user);
        }
    }

    public Home setPassword(String password){
        try{
            uiObject.txtPassword().typeText(password);
            return Android.app.nubiWallet.home;
        }catch (AssertionError e){
            throw new AssertionError("Failed to set password");
        }
    }

    public Email tapLinkRegister(){
        try {
            uiObject.lnkRegister().tap();
            return Android.app.nubiWallet.email;
        }catch (AssertionError e){
            throw new AssertionError("Unable to tab link register");
        }
    }

    public Dashboard tapInitSession(){
        try {
            uiObject.btnInitSession().tap();
            return Android.app.nubiWallet.dashboard;
        }catch (AssertionError e){
            throw new AssertionError("Unable to tab init session button");
        }
    }

}
