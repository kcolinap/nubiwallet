package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class RGSDashboard {

    boolean status;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @Given("That user is on dashboard screen")
    public void user_is_on_dashboard_screen(){
        try {
            nubiWallet.dashboard.waitToLoad();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate balance card element")
    public void validate_balance_card_element(){
        try {
            Assert.assertTrue(nubiWallet.dashboard.uiObject.balanceCard().exists());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate balance card title as {string}")
    public void validate_balance_card_title(String title){
        try {

            String auxTitle;
            Assert.assertTrue(nubiWallet.dashboard.uiObject.balanceCardTitle().exists());

            auxTitle = nubiWallet.dashboard.uiObject.balanceCardTitle().getText();

            Assert.assertEquals(title, auxTitle);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate frequent contacts container")
    public void validate_frequent_contacts_container(){
        try {

            Assert.assertTrue(nubiWallet.dashboard.uiObject.frequentContactContainer().exists());

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
