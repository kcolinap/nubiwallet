package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class RGSLogin {

    boolean status;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
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
            Thread.sleep(500);


            boolean status = (condition.toUpperCase().contentEquals("TRUE")) ? nubiWallet.home.uiObject.btnInitSession().isEnabled() :
                    nubiWallet.home.uiObject.btnInitSession().isEnabled();
            if(status)
                Assert.assertTrue(status);
            else
                Assert.assertFalse(status);


        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Then("User tap init session button")
    public void user_tap_init_session_button(){
        try {
            nubiWallet.home.tapInitSession();
            Thread.sleep(150);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
