package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class RGSDashboard {

    boolean status;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @Then("User is on dashboard screen")
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
            boolean ass;
            ass = nubiWallet.dashboard.uiObject.balanceCard().exists();
            System.out.println("djjd");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate balance card title")
    public void validate_balance_card_title(){
        try {

            String auxTitle;
            Assert.assertTrue(nubiWallet.dashboard.uiObject.balanceCardTitle().exists());

            auxTitle = nubiWallet.dashboard.uiObject.balanceCardTitle().getText();

            Assert.assertEquals("Mi Saldo", auxTitle);

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
