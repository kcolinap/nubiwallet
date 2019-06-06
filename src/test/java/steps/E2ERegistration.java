package steps;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.Util;
import core.managers.DriverManager;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import core.CommonActions;
import org.junit.Assert;
import org.junit.Test;

public class E2ERegistration {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();
    private DriverManager driverManager = new DriverManager();
    private static String email, user, pass;
    boolean aux = false;


    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Test
    @When("Email screen is completed")
    public void email_screen_is_completed() throws Exception{
        try{
            boolean status, existEmail;

            do{

                email = util.generateArmedEmail();
                existEmail = commonActions.existEmail(email);

            }while (existEmail);

            nubiWallet.email.setEmail(email);

            commonActions.hideKeyBoard();

            status = nubiWallet.email.isEnabledNextButton();
            Assert.assertEquals(true, status);

            boolean isButtonNextPresent;
            do{
                nubiWallet.email.tapButtonNext();
                Thread.sleep(600);
                isButtonNextPresent = nubiWallet.email.uiObject.buttonNext().exists();
            }while (isButtonNextPresent);


            Thread.sleep(300);
            //////////////////////////////////////////////////////////

            //Confirm email screen
            nubiWallet.confirmEmail.waitToLoad();
           //nubiWallet.confirmEmail.tapButtonOpenMail();

           //Get acces token
            String token = commonActions.getAccesToken(email);
            driverManager.iConfirmEmailFromDB(token);
            commonActions.waitForActivity("com.nubi.featuresplash.view.SplashActivity", 30);
            nubiWallet.open();
            //

            nubiWallet.personalInformation.waitToLoad();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Personal information screen is completed")
    public void personal_information_screen_is_completed(){

        String name, lName, dni;
        boolean existDni, statusEnabled;

        try {

            nubiWallet.personalInformation.waitToLoad();

            //Set names
            name = commonActions.generatePersonalInformation("names");
            nubiWallet.personalInformation.setNames(name);


            //Set last names
            lName = commonActions.generatePersonalInformation("lastnames");
            nubiWallet.personalInformation.setlastnames(lName);

            commonActions.hideKeyBoard();


            //Set Dni
            do{

                dni = "9" + String.valueOf(util.generateRamdonNumber(7));

                existDni = commonActions.existDni(dni);

            }while (existDni || dni.length()<8);

            nubiWallet.personalInformation.setDni(dni);

            commonActions.hideKeyBoard();

            //set gender
            switch (util.generateRamdonNumber(1)){
                case 1:
                    nubiWallet.personalInformation.tapMale();
                    break;
                case 2:
                    nubiWallet.personalInformation.tapMale();
                    break;
                case 3:
                    nubiWallet.personalInformation.tapMale();
                    break;
                default:
                    nubiWallet.personalInformation.tapFemale();
                    break;
            }

            Assert.assertEquals(true, nubiWallet.personalInformation.uiObject.btnCirclenext().isEnabled());

            nubiWallet.personalInformation.tapCircleButton();
            nubiWallet.cuil.waitToLoad();
            nubiWallet.cuil.tapCircleButton();

            //Wait for next screen
            nubiWallet.userInformation.waitToLoad();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Create user screen is completed")
    public void create_user_screen_complete(){
        try{

            boolean existUser;

            //Waitcreate user screen
            nubiWallet.userInformation.waitToLoad();

            //Validate if user exist on bd
            do{
                user = "user"+util.generateRamdonNumber(4);
                existUser = commonActions.existUser(user);
            }while (existUser || user.length()<4);

            nubiWallet.userInformation.setUser(user);

            //Set password

           do{
               do{
                   pass = commonActions.passwordGenerator();
               }while (pass.length()<7);

               nubiWallet.userInformation.setPassword(pass);
               commonActions.hideKeyBoard();
               Thread.sleep(300);
               aux = nubiWallet.userInformation.uiObject.btnCirclenext().isEnabled();
               Thread.sleep(300);

           }while (aux==false);

           Assert.assertEquals(true, nubiWallet.userInformation.uiObject.btnCirclenext().isEnabled());
           nubiWallet.userInformation.tapCircleButton();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Phone number screen is completed")
    public void phone_number_screen_complete(){
        try {

            String phoneNumber, digit, pin;
            boolean existPhone;

            nubiWallet.phoneNumber.waitToLoad();

            //Set code phone
            nubiWallet.phoneNumber.setCode("11");

            //Set number phone
            do{
                phoneNumber = "999"+String.valueOf(util.generateRamdonNumber(5));
                existPhone = commonActions.existPhoneNumber(phoneNumber);
            }while (existPhone || phoneNumber.length()<8);

            nubiWallet.phoneNumber.setNumber(phoneNumber);

            commonActions.hideKeyBoard();
            Thread.sleep(300);

            Assert.assertEquals(true, nubiWallet.phoneNumber.uiObject.btnCirclenext().isEnabled());

            nubiWallet.phoneNumber.tapCircleButton();


            //sms code screen
            String smsCode = commonActions.getSmsCode("+54911"+phoneNumber);
            nubiWallet.phoneNumber.waitToLoadSmsCodeScreen();

            char[] auxSmsCode = {smsCode.charAt(0), smsCode.charAt(1), smsCode.charAt(2), smsCode.charAt(3)};

            digit = Character.toString(auxSmsCode[0]);
            nubiWallet.phoneNumber.setFirstDigitCode(digit);

            digit = Character.toString(auxSmsCode[1]);
            nubiWallet.phoneNumber.setSecondDigitCode(digit);

            digit = Character.toString(auxSmsCode[2]);
            nubiWallet.phoneNumber.setThirdDigitCode(digit);

            digit = Character.toString(auxSmsCode[3]);
            nubiWallet.phoneNumber.setFourthDigitCode(digit);

            Thread.sleep(800);
            /*****************************************************
             * pin screen
             *******/

            //Wait for pin screen
            nubiWallet.pin.waitToLoad();

            //Set pin
            do{
                pin = String.valueOf(util.generateRamdonNumber(4));
            }while (pin.length()<4);

            char[] codePin = {pin.charAt(0), pin.charAt(1), pin.charAt(2), pin.charAt(3)};

            digit = Character.toString(codePin[0]);
            nubiWallet.pin.setFirstDigitPin(digit);

            digit = Character.toString(codePin[1]);
            nubiWallet.pin.setSecondDigitPin(digit);

            digit = Character.toString(codePin[2]);
            nubiWallet.pin.setThirdDigitPin(digit);

            digit = Character.toString(codePin[3]);
            nubiWallet.pin.setFourthDigitPin(digit);

            commonActions.hideKeyBoard();

            Assert.assertEquals(true, nubiWallet.pin.uiObject.btnCirclenext().isEnabled());
            nubiWallet.pin.tapCircleButton();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Terms and conditions screen is completed")
    public void terms_and_conditions_screen(){
        try {

            //Wait for terms and conditions screen
            nubiWallet.termConditions.waitToLoad();

            //Validate check button terms and conditios is unchecked
            Assert.assertEquals(false, nubiWallet.termConditions.uiObject.checkBoxTerms().isChecked());

            //tap on check button terms and conditions
            nubiWallet.termConditions.tapCheckTermsAndConditions();

            Thread.sleep(400);

            //Validate create accoun button is enabled
            Assert.assertEquals(true, nubiWallet.termConditions.uiObject.buttonCreateAccount().isEnabled());

            //tap create accoun button
            nubiWallet.termConditions.tapCreateAccountButton();

            Thread.sleep(500);


            //Write created user on a file
            //util.writeOnFile(email, user, pass);



        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
