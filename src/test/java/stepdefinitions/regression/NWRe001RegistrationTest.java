package stepdefinitions.regression;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.CommonActions;
import core.Util;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class NWRe001RegistrationTest {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();
    boolean status;
    private static String email, textOnElement;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;



    @Before
    public void beforeMethod() throws Exception{
        System.out.println("opening nubi wallet app");
        nubiWallet.home.waitToLoad();
        nubiWallet.home.tapLinkRegister();

        //Email screen
        nubiWallet.email.waitToLoad();

    }

    @Test
    @Given("That nubi wallet app is running and user is on email screen")
    public void that_nubi_wallet_app_is_running() throws Exception{
        //Email screen
        nubiWallet.email.waitToLoad();
    }

    @When("User set an email as \"([^\"]*)\"")
    public void user_set_an_email_as(String email) {
        try{

            Thread.sleep(300);
            nubiWallet.email.setEmail(email);
            Thread.sleep(300);
            Android.driver.hideKeyboard();

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Then("Validate condition on next button as \"([^\"]*)\"")
    public void validate_condition_on_next_button_as(String condition) {
        try{
            status = nubiWallet.email.uiObject.buttonNext().isEnabled();
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
                status = nubiWallet.email.uiObject.labelNoValidFormat().exists();
                Thread.sleep(300);
                Assert.assertEquals(true, status);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set an email with more than permit characteres")
    public void user_set_an_email_with_more_than_permit_characteres() {
        try{
            int resultado;
            char letra;
            String texto ="";

            for (int i=0; i<257; i++){
                resultado=(int)(Math.random()*26+65);//Sumamos al numero de letras (sin ñ) el valor en ASCII
                letra = (char)resultado;
                texto+=letra;
            }

            nubiWallet.email.setEmail(texto);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set a valid email")
    public void user_set_a_valid_email_as() {
        try{
            boolean existEmail;

            do{

                email = util.generateArmedEmail();
                existEmail = commonActions.existEmail(email);

            }while (existEmail);

            nubiWallet.email.setEmail(email);

            Thread.sleep(300);

            Android.driver.hideKeyboard();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set a new valid email")
    public void user_set_a_new_valid_email_as() {
        try{
            boolean existEmail;

            do{

                email = util.generateArmedEmail();
                existEmail = commonActions.existEmail(email);

            }while (existEmail);

            nubiWallet.email.setEmail(email);

            Thread.sleep(300);

            Android.driver.hideKeyboard();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("Click on next button")
    public void click_on_next_button() {
        try {
            Thread.sleep(300);
            nubiWallet.email.tapButtonNext();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate elements on next screen")
    public void validate_elements_on_next_screen(){
        try {
            nubiWallet.confirmEmail.waitToLoad();

            //Check for lblPrimarymessage present
            status = nubiWallet.confirmEmail.uiObject.lblPrimaryMsg().exists();
            Assert.assertEquals(true, status);

            //Check for lblSecondaryMesg present
            status = nubiWallet.confirmEmail.uiObject.lblSecondaryMsg().exists();
            Assert.assertEquals(true, status);

            //Check for btnOpenMail present
            status = nubiWallet.confirmEmail.uiObject.buttonOpenMail().exists();
            Assert.assertEquals(true, status);

            //Check for btnOpenMail enabled
            status = nubiWallet.confirmEmail.uiObject.buttonOpenMail().isEnabled();
            Assert.assertEquals(true, status);

            //Check for btnUpdateMail enabled
            status = nubiWallet.confirmEmail.uiObject.buttonUpdateMail().isEnabled();
            Assert.assertEquals(true, status);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Click on back button method
     */
    @When("Click on back button")
    public void click_on_back_button() {
        try {
            nubiWallet.confirmEmail.waitToLoad();
            Thread.sleep(300);
            nubiWallet.confirmEmail.tapButtonBack();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Click on update button method
     */
    @When("Click on update button")
    public void click_on_update_button() {
        try {
            nubiWallet.confirmEmail.waitToLoad();
            Thread.sleep(300);
            nubiWallet.confirmEmail.tapButtonUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate that previous setted email is show")
    public void validate_that_previous_setted_email_is_show() {
        try {

            nubiWallet.email.waitToLoad();

            textOnElement = nubiWallet.email.uiObject.inputEmail().getText();
            Assert.assertEquals(email, textOnElement);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate that newest setted email is show")
    public void validate_that_newest_setted_email_is_show() {
        try {

            nubiWallet.confirmEmail.waitToLoad();
            textOnElement = nubiWallet.confirmEmail.uiObject.lblRegisteredEmail().getText();
            Assert.assertEquals(textOnElement,email);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @After
    public void afterMethod(){
        Android.driver.resetApp();
    }

}
