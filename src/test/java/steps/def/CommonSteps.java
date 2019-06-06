package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;

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

    @Then("Validate if legend is present as {string} on screen {string}")
    public void validate_if_legend_is_present_on_screen(String legend, String screen){
        try {
            boolean status = false;
            if(legend.toUpperCase().contentEquals("T")){
                if (screen.toUpperCase().contentEquals("HOME")){
                    nubiWallet.home.tapInitSession();
                    Thread.sleep(300);
                    status = nubiWallet.home.uiObject.lblWrongData().exists();
                }else if (screen.toUpperCase().contentEquals("EMAIL")){
                    status = nubiWallet.email.uiObject.labelNoValidFormat().exists();
                }
                Thread.sleep(300);
                Assert.assertEquals(true, status);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Reset app")
    public void reset_app() {
        commonActions.resetApp();
    }
}
