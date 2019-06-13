package steps.def;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.ADB;
import core.CommonActions;
import core.Util;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.Test;

public class RGSRegistration {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();
    boolean status;
    private static String email, textOnElement, auxName, auxLname, auxDni, num, especial,
    userRegistered;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @When("User set an email as {string}")
    public void user_set_an_email_as(String email) {
        try{
            nubiWallet.email.setEmail(email);
            Android.driver.hideKeyboard();
            Thread.sleep(400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate condition on next button as {string}")
    public void validate_condition_on_next_button_as(String condition) {
        try{
            //status = nubiWallet.email.uiObject.buttonNext().isEnabled();
            Thread.sleep(300);

            if(condition.toUpperCase().contentEquals("TRUE")){
                Assert.assertTrue(nubiWallet.email.uiObject.buttonNext().isEnabled());
            }else{
                Assert.assertFalse(nubiWallet.email.uiObject.buttonNext().isEnabled());
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
            Android.driver.hideKeyboard();
            Thread.sleep(400);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set a valid email")
    public void user_set_a_valid_email() {
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

    @When("user set an already registered email as {string}")
    public void set_alredy_registered_email(String email){
        try {
            nubiWallet.email.setEmail(email);
            Thread.sleep(300);
            Android.driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate message already registered as {string}")
    public void validate_message_already_registered(String message){
        try {
            String auxMsg;
            nubiWallet.confirmEmail.waitToLoad();

            auxMsg = nubiWallet.confirmEmail.uiObject.lblPrimaryMsg().getText();
            auxMsg = auxMsg.substring(0,19);

            Assert.assertEquals(message, auxMsg);

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


    /*******************************************
     *   STEPS FOR PERSONAL INFORMATION SCREEN
     ******************************************/

    @Given("User is on personal information screen")
    public void user_is_on_personal_information_screen(){
        try {
            nubiWallet.personalInformation.waitToLoad();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user set his name as {string}")
    public void user_set_name(String name){
        try {

            auxName = nubiWallet.personalInformation.uiObject.inputNames().getText();

            if(name.contentEquals("") && !auxName.toLowerCase().contentEquals("nombres")){
                //nubiWallet.personalInformation.uiObject.inputNames().clearText();
                nubiWallet.personalInformation.setNames(name);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }else if(name.contentEquals("") && auxName.toLowerCase().contentEquals("nombres")){

            }else if(name.toLowerCase().contentEquals("especialchar")){
                especial = "Be\u00f1at";
                nubiWallet.personalInformation.setNames(especial);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }else{
                //nubiWallet.personalInformation.uiObject.inputNames().clearText();
                nubiWallet.personalInformation.setNames(name);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("set his last name as {string}")
    public void user_set_lname(String lname){
        try {
            auxLname = nubiWallet.personalInformation.uiObject.inputLastNames().getText();

            if (lname.contentEquals("") && !auxLname.toLowerCase().contentEquals("apellidos")) {
              //  nubiWallet.personalInformation.uiObject.inputLastNames().clearText();
                nubiWallet.personalInformation.setlastnames(lname);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            } else if (lname.contentEquals("") && auxLname.toLowerCase().contentEquals("apellidos")) {

            }else if(lname.toLowerCase().contentEquals("especialchar")){
                especial = "Oca\u00f1a";
                nubiWallet.personalInformation.setlastnames(especial);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }else{
               // nubiWallet.personalInformation.uiObject.inputLastNames().clearText();
                nubiWallet.personalInformation.setlastnames(lname);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("set his dni as {string}")
    public void user_set_dni(String dni){
        try {
            auxDni = nubiWallet.personalInformation.uiObject.inputDni().getText();

            num = "N\u00famero";

            if(dni.contentEquals("") && !auxDni.contentEquals(num)){
               // nubiWallet.personalInformation.uiObject.inputDni().clearText();
                nubiWallet.personalInformation.setDni(dni);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }else{
               // nubiWallet.personalInformation.uiObject.inputDni().clearText();
                nubiWallet.personalInformation.setDni(dni);
                Android.driver.hideKeyboard();
                nubiWallet.personalInformation.uiObject.btnCirclenext().waitToAppear(30);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("tap his gender as {string}")
    public void tap_gender(String gender){
        try {
            if(gender.toUpperCase().contentEquals("M")){
                nubiWallet.personalInformation.tapMale();
            }else if (gender.toUpperCase().contentEquals("F")){
                nubiWallet.personalInformation.tapFemale();
            }else{

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*******************************************
     *   STEPS FOR user INFORMATION SCREEN
     ******************************************/
    @Given("User is on user information screen")
    public void user_is_on_user_information_screen(){
        try {
            nubiWallet.userInformation.waitToLoad();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("user set his user as {string}")
    public void user_set_his_user_as(String user) {
        try {
            nubiWallet.userInformation.setUser(user);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @When("set his password as {string}")
    public void set_his_password_as(String pass) {
        try {
            nubiWallet.userInformation.setPassword(pass);
            Android.driver.hideKeyboard();
            Thread.sleep(300);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set an already registered user")
    public void set_registered_user() {
        try {
            userRegistered = commonActions.returnUser();
           Thread.sleep(200);

           nubiWallet.userInformation.setUser(userRegistered);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate input error message is already on bd as {string}")
    public void validate_user_registered(String msg){
        try {
            nubiWallet.userInformation.uiObject.lblError().waitToAppear(10);
            String errDescription = nubiWallet.userInformation.uiObject.lblError().getText();

            Assert.assertTrue(errDescription.contentEquals(msg));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
