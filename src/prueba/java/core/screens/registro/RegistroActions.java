package core.screens.registro;

import core.utils.Actions;
import core.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.sql.SQLException;

public class RegistroActions extends Actions {

    public RegistroActions(AndroidDriver driver) throws IOException {
        super(driver);
    }

    private Actions actions = new Actions(ScreenBase.driver);
    private RegistroObjects registroObjects = new RegistroObjects(ScreenBase.driver);
    private static String urlNubiToConfirm = "http://tunubi.app/registration/confirm/";
    private String query = "";

    /*****************************************************8
     *      DATABASE ACTIONS
     ****************************************************/

    public String devolverToken(String email) throws SQLException, IOException {
        query = "select * from email_registration WHERE EMAIL ='"+email+"'";
        return actions.ConsultaBDSimple(query, "email_confirmation_jwt", "registration");
    }

    /*****************************************************/

    /***********************
     *  Email screen actions
     **********************/
    //Set email
    public RegistroActions setEmail(String email){
        actions.setText(registroObjects.getInputEmail(), email);
        return this;
    }

    public RegistroActions clearInputEmail(){
        actions.clearInput(registroObjects.getInputEmail());
        return this;
    }

    //Validate is btn Next is enabled
    public boolean btnNextEnabledStatus(){
        return actions.elementIsEnabled(registroObjects.getBtnNext());
    }

    //Click button next
    public RegistroActions clickBtnNext(){
        actions.clickOnElement(registroObjects.getBtnNext());
        return this;
    }

    //validatre lbl no format valid is visible
    public boolean validateLblNotValidFormatIsPresent(){
        return actions.elementIsPresent(registroObjects.getLblNoValidFormat());
    }

    //Wait until input email is visible
    public void waitForInputEmailVisible(){
        actions.waitForElementPresent(registroObjects.getInputEmail());
    }

    //Get the value of input email
    public String getInputMailValue(){
        return actions.getTextFromElement(registroObjects.getInputEmail());
    }
    /*********************/


    /******************************
     *  Confirm mail screen actions
     ****************************/
    public void waitForBackButtonVisible(){
        actions.waitForElementPresent(registroObjects.getBtnBack());
    }

    public RegistroActions clickBtnBack(){
        actions.clickOnElement(registroObjects.getBtnBack());
        return this;
    }

    public RegistroActions clickBtnUpdate(){
        actions.clickOnElement(registroObjects.getBtnUpdateMail());
        return this;
    }

    public RegistroActions clickBtnOpenMail(){
        actions.clickOnElement(registroObjects.getBtnOpenMail());
        return this;
    }

    //Get the value text of registered email
    public String getLblRegisteredEmailValue(){
        return actions.getTextFromElement(registroObjects.getLblRegisteredEmail());
    }

    //Validate if element lblPrimaryMsg is present
    public boolean isPresentLblPrimaryMsg(){
        return actions.elementIsPresent(registroObjects.getLblPrimaryMsg());
    }

    //Validate if element lblSecondMsg is present
    public boolean isPresentLblSecondaryMsg(){
        return actions.elementIsPresent(registroObjects.getLblSecondaryMsg());
    }

    //Validate if element btn open mail is present
    public boolean isPresentBtnOpenMail(){
        return actions.elementIsPresent(registroObjects.getBtnOpenMail());
    }

    //Validate if element btn update mail is present
    public boolean isPresentBtnUpdateMail(){
        return actions.elementIsPresent(registroObjects.getBtnUpdateMail());
    }

    //Validate if element btn open mail is enabled
    public boolean isEnabledBtnOpenMail(){
        return actions.elementIsPresent(registroObjects.getBtnOpenMail());
    }

    //Validate if element btn update mail is enabled
    public boolean isEnabledBtnUpdateMail(){
        return actions.elementIsPresent(registroObjects.getBtnUpdateMail());
    }
    /****************************/


    /**************************************
     *      Personal information screen actions
     *******************************************/

    public RegistroActions waitForInputNamesVisible(){
        actions.waitForElementPresent(registroObjects.getInputNames());
        return this;
    }

    public RegistroActions waitForInputLastNamesVisible(){
        actions.waitForElementPresent(registroObjects.getInputLastNames());
        return this;
    }

    public RegistroActions waitForLblInputErrorVisible(){
        actions.waitForElementPresent(registroObjects.getLblInputError());
        return this;
    }

    public boolean isLblInputErrorPresent(){
        return actions.elementIsPresent(registroObjects.getLblInputError());
    }

    public RegistroActions setNames(String names){
        actions.setText(registroObjects.getInputNames(), names);
        return this;
    }

    public RegistroActions setLastNames(String lastNames){
        actions.setText(registroObjects.getInputLastNames(), lastNames);
        return this;
    }

    public RegistroActions setDni(String dni){
        actions.setText(registroObjects.getInputDni(), dni);
        return this;
    }

    public RegistroActions clickOptMale(){
        actions.clickOnElement(registroObjects.getOptMaleBtn());
        return this;
    }

    public RegistroActions clickOptFemale(){
        actions.clickOnElement(registroObjects.getOptFemaleBtn());
        return this;
    }

    public RegistroActions clickOnBtnCircleNext(){
        actions.clickOnElement(registroObjects.getBtnCirclenext());
        return this;
    }

    public boolean btnCircleNextStatus(){
        return actions.elementIsEnabled(registroObjects.getBtnCirclenext());
    }

    /*******************************************/


    /***************************************************
     *      CUIL SCREEN ACTIONS
     **************************************************/

    public RegistroActions waitForInputCuilVisible(){
        actions.waitForElementPresent(registroObjects.getInputCuil());
        return this;
    }

    /**************************************************
     *      CREATE USER SCREEN ACTIONS
     ************************************************/
     public RegistroActions waitForInputUserVisible(){
         actions.waitForElementPresent(registroObjects.getInputUser());
         return this;
     }

    public RegistroActions setUser(String user){
        actions.setText(registroObjects.getInputUser(), user);
        return this;
    }
    public RegistroActions setPass(String pass){
        actions.setText(registroObjects.getInputPassword(), pass);
        return this;
    }

    /***************************************************/


    /***************************************************
     *          PHONE VALIDATION SCREEN ACTIONS
     *************************************************/
    /*********************************
     *  Phone validation screen
     ********************************/

    public RegistroActions waitVisibilityOfCodePhone(){
        actions.waitForElementPresent(registroObjects.getInputCodePhone());
        return this;
    }

    public RegistroActions setCodePhone(String text){
        actions.setText(registroObjects.getInputCodePhone(), text);
        return this;
    }

    public RegistroActions setNumberPhone(String text){
        actions.setText(registroObjects.getInputPhoneNumber(), text);
        return this;
    }

    public RegistroActions waitVisibilityOfFirtsDigitCode(){
        actions.waitForElementPresent(registroObjects.getInputFirstDigitCode());
        return this;
    }

    public RegistroActions setFirstDigitCode(String text){
        actions.setText(registroObjects.getInputFirstDigitCode(), text);
        return this;
    }

    public RegistroActions setSecondtDigitCode(String text){
        actions.setText(registroObjects.getInputSecondDigitCode(), text);
        return this;
    }

    public RegistroActions setThirdDigitCode(String text){
        actions.setText(registroObjects.getInputThirdDigitCode(), text);
        return this;
    }
    public RegistroActions setFourthDigitCode(String text){
        actions.setText(registroObjects.getInputFourthDigitCode(), text);
        return this;
    }

    public RegistroActions clickOnFirstDigitCode(){
        actions.clickOnElement(registroObjects.getInputFirstDigitCode());
        return this;
    }

    public RegistroActions clickOnFirstDigitPin(){
        actions.clickOnElement(registroObjects.getInputFirstDigitPin());
        return this;
    }

    public RegistroActions waitVisibilityOfFirtsDigitPin(){
        actions.waitForElementPresent(registroObjects.getInputFirstDigitPin());
        return this;
    }

    public RegistroActions setFirtsDigitPin(String text){
        actions.setText(registroObjects.getInputFirstDigitPin(), text);
        return this;
    }

    public RegistroActions setSecondDigitPin(String text){
        actions.setText(registroObjects.getInputSecondDigitPin(), text);
        return this;
    }

    public RegistroActions setThirdDigitPin(String text){
        actions.setText(registroObjects.getInputThirdDigitPin(), text);
        return this;
    }

    public RegistroActions setFourthDigitPin(String text){
        actions.setText(registroObjects.getInputFourthDigitPin(), text);
        return this;
    }

    /*********************************/


    /************************************
     *      TERMS AND CONDITIONS SCREEN
     ***********************************/
    public RegistroActions waitVisibilityOfChkTerms(){
        actions.waitForElementPresent(registroObjects.getChkTerms());
        return this;
    }

    public boolean chkTermsIsSelected(){
        return actions.elementIsChecked(registroObjects.getChkTerms());
    }

    public boolean btnCreateAccountIsEnabled(){
        return actions.elementIsEnabled(registroObjects.getBtnCreateAccount());
    }

    public RegistroActions clickChkTerms(){
        actions.clickOnElement(registroObjects.getChkTerms());
        return this;
    }

    public RegistroActions clickBtnCreateAccount(){
        actions.clickOnElement(registroObjects.getBtnCreateAccount());
        return this;
    }
    /***********************************/

    /************************************
     *      WELCOME SCREEN
     **********************************/
    public RegistroActions waitVisibilityOfLblWelcome(){
        actions.waitForElementPresent(registroObjects.getLblWelcome());
        return this;
    }

    public RegistroActions clickBtnContinuar(){
        actions.clickOnElement(registroObjects.getBtnContinuar());
        return this;
    }

    /****************************************************/

    public RegistroActions iConfirmEmailFromDB(String token){
        ScreenBase.driver.get(urlNubiToConfirm+token);
        return this;
    }

}
