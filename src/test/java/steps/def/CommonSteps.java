package steps;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CommonSteps {

    private CommonActions commonActions = new CommonActions();
    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Given("That nubi wallet app is running and user is on home screen")
    public void that_nubi_wallet_app_is_running() throws Exception{
        nubiWallet.home.waitToLoad();
    }

    @And("User is on email screen")
    public void user_is_on_email_screen(){
        try{
            nubiWallet.home.tapLinkRegister();

            //Email screen
            nubiWallet.email.waitToLoad();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Reset app")
    public void reset_app() {
        commonActions.resetApp();
    }
}
