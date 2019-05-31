package stepdefinitions.endtoend;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import core.Util;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NWE2E002LoginTest {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();

    private static NubiWallet nubiWallet = Android.app.nubiWallet;

    @When("User set its credential to acces nubi wallet")
    public void setCredentials(){
        try{
            nubiWallet.home.waitToLoad();

            //Set user
            nubiWallet.home.setUser("userdt31");

            nubiWallet.home.setPassword("111Cc-11");

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
