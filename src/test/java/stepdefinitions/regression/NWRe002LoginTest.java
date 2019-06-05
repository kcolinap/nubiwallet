package stepdefinitions.regression;

import api.android.Android;
import api.apps.nw.NubiWallet;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class NWRe002LoginTest {

    boolean status;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @Given("That nubi wallet app is running and user is on login screen")
    public void that_nubi_wallet_app_is_running() throws Exception{

        //Login screen
        nubiWallet.home.waitToLoad();
    }

    @When("User set his credentials as {string} and {string}")
    public void setCredentials(String user, String pass){
        try {
            nubiWallet.home.setUser(user);

            nubiWallet.home.setPassword(pass);

            Android.driver.hideKeyboard();
            Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate condition on init session button as {string}")
    public void validate_condition_on_next_button_as(String condition) {
        try{
            status = nubiWallet.home.uiObject.btnInitSession().isEnabled();
            Thread.sleep(300);

            if(condition.toUpperCase().contentEquals("TRUE")){
                Assert.assertEquals(true, status);
            }else{
                Assert.assertEquals(false, status);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("Validate if legend is present as {string}")
    public void validate_if_legend_is_present(String legend){
        try {
            if(legend.toUpperCase().contentEquals("T")){
                nubiWallet.home.tapInitSession();
                Thread.sleep(300);
                status = nubiWallet.home.uiObject.lblWrongData().exists();
                Thread.sleep(300);
                Assert.assertEquals(true, status);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
