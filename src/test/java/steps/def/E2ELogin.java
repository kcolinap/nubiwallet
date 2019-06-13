package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import core.Util;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class E2ELogin {

    private CommonActions commonActions = new CommonActions();

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @When("User set its credential to acces nubi wallet")
    public void setCredentials(){
        try{
            nubiWallet.home.waitToLoad();

            //Set user
            nubiWallet.home.setUser("user2605");

            nubiWallet.home.setPassword("n$65d1kU");

            commonActions.hideKeyBoard();

            Assert.assertEquals(true, nubiWallet.home.uiObject.btnInitSession().isEnabled());

            nubiWallet.home.tapInitSession();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("User sees dashboard screen")
    public void showDashboardScreen(){
        try {
            nubiWallet.dashboard.waitToLoad();
            Thread.sleep(400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
