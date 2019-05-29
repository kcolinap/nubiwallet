package stepsDefinitions.regression.registro;

import core.screens.registro.RegistroActions;
import core.utils.Actions;
import core.utils.CommonUtils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import runner.regression.RegressionCore_Register;
import stepsDefinitions.CommonSteps;

import java.io.IOException;


public class NWReg001ValidateEmailTest extends RegressionCore_Register {

    public static RegistroActions registroActions;
    public static Actions actions;
    private String armedEmail;
    private CommonSteps commonSteps;
    private CommonUtils commonUtils;
    public String textOnElement ="";
    private boolean status = false;

    public NWReg001ValidateEmailTest(CommonSteps commonSteps) throws IOException {
        this.commonSteps = commonSteps;
        registroActions = new RegistroActions(driver);
        this.commonSteps.setRegistroActionsDriver(registroActions);
        actions = new Actions(driver);
    }

        @Given("That nubi wallet app is running")
        public void that_nubi_wallet_app_is_running() throws Exception{
           System.out.println("given");
           commonSteps.home_screen_showed(driver);
        }

        @When("User set an email as \"([^\"]*)\"")
        public void user_set_an_email_as(String email) {
           try{
                //registroActions.clearInputEmail();
                registroActions.setEmail(email);
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

                registroActions.setEmail(texto);

            }catch (Exception e){
                e.printStackTrace();
            }
        }


    @When("User set a valid email")
    public void user_set_a_valid_email_as() {
        try{
            boolean existEmail;
            armedEmail = commonSteps.generateArmedEmail();
            existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);

            while (existEmail){
                armedEmail = commonSteps.generateArmedEmail();
                existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);;
            }

           commonSteps.setEmail(armedEmail);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User set a new valid email")
    public void user_set_a_new_valid_email_as() {
        try{
            armedEmail = commonSteps.generateArmedEmail();
           commonSteps.setEmail(armedEmail);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Click on next button method
     */
    @When("Click on next button")
    public void click_on_next_button() {
        try {
            registroActions.implicitWaitByMSeconds(400);
            registroActions.clickBtnNext();
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
            registroActions.waitForBackButtonVisible();
            registroActions.implicitWaitByMSeconds(400);
            registroActions.clickBtnBack();
            Thread.sleep(500);
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
            registroActions.waitForBackButtonVisible();
            registroActions.implicitWaitByMSeconds(400);
            registroActions.clickBtnUpdate();
            registroActions.implicitWaitByMSeconds(400);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

        @Then("Validate condition on next button as \"([^\"]*)\"")
        public void validate_condition_on_next_button_as(String condition) {
            try{
                status = registroActions.btnNextEnabledStatus();

                registroActions.implicitWaitByMSeconds(300);
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
                status = registroActions.validateLblNotValidFormatIsPresent();
                registroActions.implicitWaitByMSeconds(400);
                Assert.assertEquals(status, true);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate that previous setted email is show")
    public void validate_that_previous_setted_email_is_show() {
       try {

           registroActions.waitForInputEmailVisible();
           registroActions.waitForInputEmailVisible();
           registroActions.implicitWaitByMSeconds(300);
           textOnElement = registroActions.getInputMailValue();
           Assert.assertEquals(textOnElement,armedEmail);

       }catch (Exception e){
           e.printStackTrace();
       }
    }

    @Then("Validate that newest setted email is show")
    public void validate_that_newest_setted_email_is_show() {
        try {

            registroActions.waitForBackButtonVisible();
            registroActions.implicitWaitByMSeconds(300);
            textOnElement = registroActions.getLblRegisteredEmailValue();
            registroActions.waitForBackButtonVisible();
            registroActions.implicitWaitByMSeconds(300);
            Assert.assertEquals(textOnElement,armedEmail);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Close app")
    public void close_app(){
        try {
            closeApp();

            setUp();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Open email from confirm mail button")
    public void open_email_from_confirm_mail_button(){
        try {
            registroActions.waitForBackButtonVisible();
            registroActions.implicitWaitByMSeconds(300);
            registroActions.clickBtnOpenMail();
            Thread.sleep(3000);
            registroActions.implicitWaitByMSeconds(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User confirm email")
    public void user_confirm_email(){
        try {

           // String emailToConfirm = commonSteps.getArmedEmail();
            String token = registroActions.devolverToken(armedEmail);
            registroActions.iConfirmEmailFromDB(token);
            registroActions.waitForInputLastNamesVisible();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("validate personal information screen was showed")
    public void validate_personal_information_screen_was_showed(){
        try{
            registroActions.implicitWaitByMSeconds(1500);
            registroActions.waitForInputNamesVisible();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate elements on next screen")
    public void validate_elements_on_next_screen(){
        try {
            registroActions.waitForBackButtonVisible();

            //Check for lblPrimarymessage present
            status = registroActions.isPresentLblPrimaryMsg();
            Assert.assertEquals(status, true);

            //Check for lblSecondaryMesg present
            status = registroActions.isPresentLblSecondaryMsg();
            Assert.assertEquals(status, true);

            //Check for btnOpenMail present
            status = registroActions.isPresentBtnOpenMail();
            Assert.assertEquals(status, true);

            //Check for btnOpenMail enabled
            status = registroActions.isEnabledBtnOpenMail();
            Assert.assertEquals(status, true);

            //Check for btnUpdateMail enabled
            status = registroActions.isEnabledBtnUpdateMail();
            Assert.assertEquals(status, true);

            //Check for email shown on screen
            textOnElement = registroActions.getLblRegisteredEmailValue();
            Assert.assertEquals(textOnElement, armedEmail);

            //
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    /*public void setEmail(String email){

            String suijoEmail = String.valueOf(commonUtils.generateRamdonNumber(4));
            armedEmail = email+suijoEmail+"@yopmail.com";
            registroActions.setEmail(armedEmail);

    }*/

}
