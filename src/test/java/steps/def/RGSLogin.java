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
}
