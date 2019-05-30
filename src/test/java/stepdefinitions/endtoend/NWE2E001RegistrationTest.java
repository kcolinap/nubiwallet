package stepdefinitions.endtoend;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.Util;
import core.managers.DriverManager;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import core.CommonActions;
import org.junit.Assert;

public class NWE2E001RegistrationTest {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();
    private DriverManager driverManager = new DriverManager();
    private static String email;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;


    @Given("That nubi wallet app is running for endToend process")
    public void that_nubi_wallet_app_is_running_for_e2e() throws Exception{
        System.out.println("opening nubi wallet app");
        nubiWallet.home.waitToLoad();
    }

    @When("Email screen is completed")
    public void email_screen_is_completed() throws Exception{
        try{
            boolean status, existEmail;
            nubiWallet.home.tapLinkRegister();


            //Email screen
            nubiWallet.email.waitToLoad();

            do{

                email = util.generateArmedEmail();
                existEmail = commonActions.existEmail(email);

            }while (existEmail);

            nubiWallet.email.setEmail(email);

            commonActions.hideKeyBoard();

            status = nubiWallet.email.isEnabledNextButton();
            Assert.assertEquals(true, status);
            nubiWallet.email.tapButtonNext();


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

            String user, pass;
            boolean existUser, aux;

            //Waitcreate user screen
            nubiWallet.userInformation.waitToLoad();

            //Validate if user exist on bd
            do{
                user = "user"+util.generateRamdonNumber(4);
                existUser = commonActions.existUser(user);
            }while (existUser && user.length()<4);

            nubiWallet.userInformation.setUser(user);

            //Set password
           do{
               do{
                   pass = commonActions.passwordGenerator();
               }while (pass.length()<7);

               nubiWallet.userInformation.setPassword(pass);
               commonActions.hideKeyBoard();
               aux = nubiWallet.userInformation.uiObject.btnCirclenext().isEnabled();

           }while (!aux);

           Assert.assertEquals(true, nubiWallet.userInformation.uiObject.btnCirclenext().isEnabled());
           nubiWallet.userInformation.tapCircleButton();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @And("Phone number screen is completed")
    public void phone_number_screen_complete(){
        try {

            String phoneNumber, digit;
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

            /*****************************************************
             * pin screen
             */




        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
