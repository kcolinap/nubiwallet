package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class CommonSteps {

    private CommonActions commonActions = new CommonActions();
    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Then("validate user is on login screen")
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
                    Thread.sleep(150);
                    nubiWallet.home.uiObject.lblWrongData().waitToAppear(10);
                    Assert.assertTrue(nubiWallet.home.uiObject.lblWrongData().exists());
                }else if (screen.toUpperCase().contentEquals("EMAIL")){
                    nubiWallet.email.uiObject.labelNoValidFormat().waitToAppear(10);
                    Assert.assertTrue(nubiWallet.email.uiObject.labelNoValidFormat().exists());
                }else if(screen.toUpperCase().contentEquals("PERSONALINF")){
                    nubiWallet.personalInformation.uiObject.lblInputError().waitToAppear(10);
                    Assert.assertTrue(nubiWallet.personalInformation.uiObject.lblInputError().exists());
                }else if(screen.toUpperCase().contentEquals("USERINF")){
                    nubiWallet.userInformation.uiObject.lblError().waitToAppear(10);
                    Assert.assertTrue(nubiWallet.userInformation.uiObject.lblError().exists());
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("user close the app")
    @When("user kill-close the app")
    public void user_kill_close_the_app() {
        commonActions.closeApp();
        nubiWallet.clearData();
    }

    @Then("Reset app")
    public void reset_app() {
        commonActions.resetApp();
    }

    @Then("open the app")
    public void open_the_app() {
        nubiWallet.open();
    }

    @Then("Validate status circle button as {string}")
    public void validate_status_circle_button(String condition){
        try {

            Thread.sleep(400);
            if(condition.toUpperCase().contentEquals("F")){
                Assert.assertFalse(nubiWallet.personalInformation.uiObject.btnCirclenext().isEnabled());
            }else if(condition.toUpperCase().contentEquals("T")){
                Assert.assertTrue(nubiWallet.personalInformation.uiObject.btnCirclenext().isEnabled());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("tap button circle on screen {string}")
    public void tap_circle_button(String screen){
        try {
            if(screen.toLowerCase().contentEquals("user")){
                nubiWallet.userInformation.tapCircleButton();
            }

            Thread.sleep(200);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
