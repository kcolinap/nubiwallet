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
        nubiWallet.open();
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

        try {

            nubiWallet.personalInformation.waitToLoad();

            //Set names
            nubiWallet.personalInformation.setNames("names");

            /*
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
            registroActions.waitForInputUserVisible();*/

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
