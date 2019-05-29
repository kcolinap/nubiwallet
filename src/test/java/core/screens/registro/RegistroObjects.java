package core.screens.registro;

import core.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class RegistroObjects extends ScreenBase {


    public RegistroObjects(AndroidDriver driver) throws IOException {
        super(driver);
    }


    /****************************
     * SCREEN PANTALLA EMAIL
     ****************************
     */
    @AndroidFindBy(id = "com.tunubi.wallet:id/emailInput")
    WebElement inputEmail;

    @AndroidFindBy(id = "com.tunubi.wallet:id/nextButton")
    WebElement btnNext;

    @AndroidFindBy(id = "com.tunubi.wallet:id/textinput_error")
    WebElement lblNoValidFormat;

    public  WebElement getInputEmail(){
        return inputEmail;
    }
    public  WebElement getBtnNext(){
        return btnNext;
    }
    public  WebElement getLblNoValidFormat(){
        return lblNoValidFormat;
    }

    /***************************/


    /*******************************8
     *  CONFIRM MAIL SCREEN OBJECTS
     *******************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/message")
    WebElement lblPrimaryMsg;

    @AndroidFindBy(id = "com.tunubi.wallet:id/secondaryMessage")
    WebElement lblSecondaryMsg;

    @AndroidFindBy(id = "com.tunubi.wallet:id/actionButtonPrimary")
    WebElement btnOpenMail;

    @AndroidFindBy(id = "com.tunubi.wallet:id/actionButtonLink")
    WebElement btnUpdateMail;

    @AndroidFindBy(id = "com.tunubi.wallet:id/backButton")
    WebElement btnBack;

    @AndroidFindBy(id = "com.tunubi.wallet:id/email")
    WebElement lblRegisteredEmail;

    public  WebElement getLblPrimaryMsg(){
        return lblPrimaryMsg;
    }

    public  WebElement getLblSecondaryMsg(){
        return lblSecondaryMsg;
    }

    public  WebElement getBtnOpenMail(){
        return btnOpenMail;
    }

    public  WebElement getBtnUpdateMail(){
        return btnUpdateMail;
    }

    public  WebElement getBtnBack(){
        return btnBack;
    }

    public WebElement getLblRegisteredEmail(){
        return lblRegisteredEmail;
    }
    /*******************************/


    /**************************************
     *      Personal information screen objects
     *******************************************/

    @AndroidFindBy(id = "com.tunubi.wallet:id/nameInput")
    public WebElement inputNames;

    @AndroidFindBy(id = "com.tunubi.wallet:id/lastNameInput")
    public WebElement inputLastNames;

    @AndroidFindBy(id = "com.tunubi.wallet:id/textinput_error")
    public WebElement lblInputError;

    @AndroidFindBy(id = "com.tunubi.wallet:id/dniInput")
    public WebElement inputDni;

    @AndroidFindBy(id = "com.tunubi.wallet:id/maleGenderOption")
    public WebElement optMaleBtn;

    @AndroidFindBy(id = "com.tunubi.wallet:id/femaleGenderOption")
    public WebElement optFemaleBtn;

    @AndroidFindBy(id = "com.tunubi.wallet:id/circleButton")
    public WebElement btnCirclenext;


    public WebElement getInputNames(){
        return inputNames;
    }

    public WebElement getInputLastNames(){
        return inputLastNames;
    }

    public WebElement getLblInputError(){
        return lblInputError;
    }

    public WebElement getInputDni(){
        return inputDni;
    }

    public WebElement getOptMaleBtn(){
        return optMaleBtn;
    }

    public WebElement getOptFemaleBtn(){
        return optFemaleBtn;
    }

    public WebElement getBtnCirclenext(){
        return btnCirclenext;
    }

    /**************************************************************/


    /**************************************************************
     *          CUIL SCREEN
     ************************************************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/dniInput")
    public WebElement inputCuil;

    public WebElement getInputCuil(){
        return inputCuil;
    }
    /************************************************************/


    /**************************************************************
     *      CREATE USER SCREEN OBJECTS
     *************************************************************/

    @AndroidFindBy(id = "com.tunubi.wallet:id/userInput")
    public WebElement inputUser;

    @AndroidFindBy(id = "com.tunubi.wallet:id/passwordInput")
    public WebElement inputPassword;

    public WebElement getInputUser(){
        return inputUser;
    }

    public WebElement getInputPassword(){
        return inputPassword;
    }

    /****************************************************************/


    /**********************************************************
     *          SCREEN PHONE NUMBER
     *********************************************************/

    @AndroidFindBy(id = "com.tunubi.wallet:id/areaCodeInput")
    public WebElement inputCodePhone;

    @AndroidFindBy(id = "com.tunubi.wallet:id/phoneInput")
    public WebElement inputPhoneNumber;

    @AndroidFindBy(id = "com.tunubi.wallet:id/firstDigitInput")
    public WebElement inputFirstDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/secondDigitInput")
    public WebElement inputSecondDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/thirdDigitInput")
    public WebElement inputThirdDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/fourthDigitInput")
    public WebElement inputFourthDigitCode;

    @AndroidFindBy(id = "com.tunubi.wallet:id/firstDigitInput")
    public WebElement inputFirstDigitPin;

    @AndroidFindBy(id = "com.tunubi.wallet:id/secondDigitInput")
    public WebElement inputSecondDigitPin;

    @AndroidFindBy(id = "com.tunubi.wallet:id/thirdDigitInput")
    public WebElement inputThirdDigitPin;

    @AndroidFindBy(id = "com.tunubi.wallet:id/fourthDigitInput")
    public WebElement inputFourthDigitPin;

    public WebElement getInputCodePhone(){
        return inputCodePhone;
    }

    public WebElement getInputPhoneNumber(){
        return inputPhoneNumber;
    }

    public WebElement getInputFirstDigitCode(){
        return inputFirstDigitPin;
    }

    public WebElement getInputSecondDigitCode(){
        return inputSecondDigitCode;
    }

    public WebElement getInputThirdDigitCode(){
        return inputThirdDigitCode;
    }

    public WebElement getInputFourthDigitCode(){
        return inputFourthDigitCode;
    }


    public WebElement getInputFirstDigitPin(){
        return inputFirstDigitPin;
    }

    public WebElement getInputSecondDigitPin(){
        return inputSecondDigitPin;
    }

    public WebElement getInputThirdDigitPin(){
        return inputThirdDigitPin;
    }

    public WebElement getInputFourthDigitPin(){
        return inputFourthDigitPin;
    }




    /*********************************************************/


    /**********************************************************
     *      TERMS AND CONDITIONS SCREEN
     *******************************************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/checkboxTerms")
    public WebElement chkTerms;

    @AndroidFindBy(id = "com.tunubi.wallet:id/createAccountButton")
    public WebElement btnCreateAccount;

    public WebElement getChkTerms(){
        return chkTerms;
    }

    public WebElement getBtnCreateAccount(){
        return btnCreateAccount;
    }

    /**********************************************************/

    /******************************************
     *  Welcome screen
     *****************************************/
    @AndroidFindBy(id = "com.tunubi.wallet:id/welcome_message")
    public WebElement lblWelcome;

    @AndroidFindBy(id = "com.tunubi.wallet:id/actionButtonPrimary")
    public WebElement btnContinuar;

    public WebElement getLblWelcome(){
        return lblWelcome;
    }

    public WebElement getBtnContinuar(){
        return btnContinuar;
    }
    /*****************************************/
}
