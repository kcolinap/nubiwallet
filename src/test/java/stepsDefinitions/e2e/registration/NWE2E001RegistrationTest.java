package stepsDefinitions.e2e.registration;


import api.android.Android;
import api.apps.nw.NubiWallet;
import core.screens.registro.RegistroActions;
import core.utils.Actions;
import core.utils.CommonUtils;
//import com.nw.screens.home.Home;
import api.apps.nw.home.Home;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.android.Activity;
//import org.testng.Assert;
//import runner.e2e.E2ECore_Register;
import stepsDefinitions.CommonSteps;

import java.io.IOException;


public class NWE2E001RegistrationTest{// extends E2ECore_Register {

    public static RegistroActions registroActions;
    public static Actions actions;
    private String armedEmail;
    private CommonSteps commonSteps;
    private CommonUtils commonUtils = new CommonUtils();
    private boolean status = false;
    private String dniRandom = "95";
    private String user = "", pass = "";
    private String phoneNumber = "", codePhone="11", prefixPhone = "+549", digit="";
    private static NubiWallet nubiWallet = Android.app.nubiWallet;

    public NWE2E001RegistrationTest(CommonSteps commonSteps) throws IOException {
        this.commonSteps = commonSteps;
        registroActions = new RegistroActions(driver);
        this.commonSteps.setRegistroActionsDriver(registroActions);
        actions = new Actions(driver);
        //home = new Home(driver);
    }

    @Given("That nubi wallet app is running for E2E proccess")
    public void that_nubi_wallet_app_is_running_for_e2e() throws Exception{
        System.out.println("given");
       commonSteps.home_screen_showed(driver);
    }

        @When("Email screen is completed e2e")
        public void email_screen_is_completed() throws Exception{
            try{
                boolean status, existEmail;
                armedEmail = commonSteps.generateArmedEmail();
                existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);

                while (existEmail){
                    armedEmail = commonSteps.generateArmedEmail();
                    existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);;
                }

               System.out.println(driver.currentActivity());
                System.out.println(driver.getCurrentPackage());

                nubiWallet.home.waitToLoad();

                registroActions.waitForInputEmailVisible();

                System.out.println(driver.currentActivity());
                System.out.println(driver.getCurrentPackage());

                commonSteps.setEmail(armedEmail);
                registroActions.hideKeyword();
                registroActions.implicitWaitByMSeconds(300);
                status = registroActions.btnNextEnabledStatus();

                Assert.assertEquals(status,true);


                registroActions.implicitWaitByMSeconds(400);
                registroActions.clickBtnNext();
                registroActions.waitForBackButtonVisible();

                System.out.println(driver.currentActivity());
                System.out.println(driver.getCurrentPackage());


                String token = registroActions.devolverToken(armedEmail);

                String currentActivity=(driver.currentActivity());
                String currentPackage = driver.getCurrentPackage();
                registroActions.implicitWaitByMSeconds(300);
                registroActions.clickBtnOpenMail();




                //registroActions.iConfirmEmailFromDB(token);


                registroActions.iConfirmEmailFromDB(token);
                Thread.sleep(3000);

                registroActions.implicitWaitByMSeconds(3000);


                driver.startActivity(new Activity(currentPackage,"com.nubi.splashFeature.view.SplashActivity"));
                //registroActions.waitForBackButtonVisible();

                //registroActions.cerrarApp();
                //

                //registroActions.waitForInputNamesVisible();


                //driver.startActivity(new Activity(currentPackage,"com.nubi.registerFeature.view.RegistrationActivity"));
                //registroActions.waitForBackButtonVisible();

                registroActions.waitForInputNamesVisible();

            }catch (Exception e){
                e.printStackTrace();
            }
        }

    @And("Personal information screen is completed e2e")
    public void personal_information_screen_is_completed_e2e(){

        try {
            String name, lName;
            registroActions.waitForInputNamesVisible();

            name = commonSteps.generatePersonalInformation("names");
            registroActions.setNames(name);

            lName = commonSteps.generatePersonalInformation("lastnames");
            registroActions.setLastNames(lName);

            registroActions.hideKeyword();

            dniRandom = dniRandom + String.valueOf(commonUtils.generateRamdonNumber(6));
            while(dniRandom.length()<7){
                dniRandom = "95"+String.valueOf(commonUtils.generateRamdonNumber(6));
            }

            boolean existDni = commonSteps.validateIfDniExist(dniRandom, actions);
            while (existDni){
                dniRandom = dniRandom + String.valueOf(commonUtils.generateRamdonNumber(6));
                while(dniRandom.length()<7){
                    dniRandom = "95"+String.valueOf(commonUtils.generateRamdonNumber(6));
                }
                existDni = commonSteps.validateIfDniExist(dniRandom, actions);
            }
            registroActions.setDni(dniRandom);
            registroActions.hideKeyword();

            switch (commonUtils.generateRamdonNumber(1)){
                case 1:
                    registroActions.clickOptMale();
                    break;
                case 2:
                    registroActions.clickOptMale();
                    break;
                case 3:
                    registroActions.clickOptMale();
                    break;
                    default:
                        registroActions.clickOptFemale();
                        break;
            }

            registroActions.hideKeyword();
            status = registroActions.btnCircleNextStatus();
            registroActions.implicitWaitByMSeconds(300);
            Assert.assertEquals(status, true);
            commonSteps.clickOnCircleNextButton();

            //Validate user is on cuil screen
            registroActions.waitForInputCuilVisible();
            registroActions.implicitWaitByMSeconds(600);

            //click on cuil screen
            commonSteps.clickOnCircleNextButton();

            //Validate user is on create user screen
            registroActions.implicitWaitByMSeconds(600);
            registroActions.waitForInputUserVisible();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @And("Create user screen is completed e2e")
    public void create_user_screen_complete(){
        try{

            //Validate user is on create user screen
            registroActions.implicitWaitByMSeconds(600);
            registroActions.waitForInputUserVisible();

            //Set user
            boolean existUser;
            do{
               user = "user"+commonUtils.generateRamdonNumber(4);
               existUser = commonSteps.validateIfUserExist(user, actions);
           }while (existUser && user.length()<4);

            registroActions.setUser(user);


            //Set pass
            do{
                do{
                    pass = commonSteps.passwordGenerator();
                }while (pass.length()<7);
                registroActions.setPass(pass);
                registroActions.hideKeyword();
                registroActions.implicitWaitByMSeconds(400);
                status = registroActions.btnCircleNextStatus();
            }while (!status);

            registroActions.implicitWaitByMSeconds(300);
            Assert.assertEquals(status, true);
            commonSteps.clickOnCircleNextButton();

            //Validate user is on phone number screen
            registroActions.implicitWaitByMSeconds(600);
            registroActions.waitVisibilityOfCodePhone();


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Phone number screen is completed e2e")
    public void phone_number_screen_complete_e2e(){
        try {
            //Validate user is on phone number screen
            registroActions.implicitWaitByMSeconds(600);
            registroActions.waitVisibilityOfCodePhone();

            //Set phone number
            registroActions.setCodePhone(codePhone);

            boolean existPhone;
            do{
                do{
                    phoneNumber = "999" + String.valueOf(commonUtils.generateRamdonNumber(5));
                }while (phoneNumber.length()<8);
                existPhone = commonSteps.validateIfPhoneExist(prefixPhone+phoneNumber, actions);
            }while (existPhone);

            registroActions.setNumberPhone(phoneNumber);
            registroActions.hideKeyword();
            status = registroActions.btnCircleNextStatus();
            registroActions.implicitWaitByMSeconds(300);
            Assert.assertEquals(status, true);
            commonSteps.clickOnCircleNextButton();

            //Get and set sms code
            String smsCode = commonSteps.getSmsCode(prefixPhone+codePhone+phoneNumber, actions);

            registroActions.waitVisibilityOfFirtsDigitCode();

            char[] codeSms = {smsCode.charAt(0), smsCode.charAt(1), smsCode.charAt(2), smsCode.charAt(3)};
            registroActions.showKeyword();
            registroActions.clickOnFirstDigitCode();

            //digit 1
            digit = Character.toString(codeSms[0]);
            registroActions.setFirstDigitCode(digit);

            //digit 2
            digit = Character.toString(codeSms[1]);
            registroActions.setSecondtDigitCode(digit);

            //digit 3
            digit = Character.toString(codeSms[2]);
            registroActions.setThirdDigitCode(digit);

            //digit 4
            digit = Character.toString(codeSms[3]);
            registroActions.setFourthDigitCode(digit);


            registroActions.hideKeyword();


            registroActions.waitVisibilityOfFirtsDigitPin();


            //Set pin
            String pin = String.valueOf(commonUtils.generateRamdonNumber(4));
            do{
                pin = String.valueOf(commonUtils.generateRamdonNumber(4));
            }while (pin.length()<4);

            char[] codePin = {pin.charAt(0), pin.charAt(1), pin.charAt(2), pin.charAt(3)};
            registroActions.showKeyword();
            registroActions.clickOnFirstDigitPin();

            //pin 1
            digit = Character.toString(codePin[0]);
            registroActions.setFirtsDigitPin(digit);

            //pin 2
            digit = Character.toString(codePin[1]);
            registroActions.setSecondDigitPin(digit);

            //pin 3
            digit = Character.toString(codeSms[2]);
            registroActions.setThirdDigitPin(digit);

            //digit 4
            digit = Character.toString(codeSms[3]);
            registroActions.setFourthDigitPin(digit);


            registroActions.hideKeyword();

            status = registroActions.btnCircleNextStatus();
            registroActions.implicitWaitByMSeconds(300);
            Assert.assertEquals(status, true);
            commonSteps.clickOnCircleNextButton();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Terms and conditions screen is completed e2e")
    public void terms_and_conditions_screen_e2e(){
        try {
            registroActions.waitVisibilityOfChkTerms();
            registroActions.implicitWaitByMSeconds(600);


            status = registroActions.chkTermsIsSelected();
            Assert.assertEquals(false,status);

            status = registroActions.btnCreateAccountIsEnabled();
            Assert.assertEquals(false, status);

            registroActions.clickChkTerms();
            registroActions.implicitWaitByMSeconds(300);

            status = registroActions.btnCreateAccountIsEnabled();
            Assert.assertEquals(true, status);

            //ComUtils.takeScreeShoot(testPath, "ValidacionTerms.png");

            registroActions.clickBtnCreateAccount();

            registroActions.waitVisibilityOfLblWelcome();
            registroActions.implicitWaitByMSeconds(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("User sees the welcome screen with its name e2e")
    public void user_sees_welcome_screen_e2e(){
        try {
            registroActions.waitVisibilityOfLblWelcome();
            registroActions.implicitWaitByMSeconds(500);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
