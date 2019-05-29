package test.stepDefinitions.e2e;

import api.android.Android;
import api.apps.nw.NubiWallet;
import core.Util;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import core.CommonActions;

public class NWE2E001RegistrationTest {

    private Util util = new Util();
    private CommonActions commonActions = new CommonActions();
    private static String email;

    private static NubiWallet nubiWallet = Android.app.nubiWallet;

    @Given("That nubi wallet app is running for E2E proccess")
    public void a1_that_nubi_wallet_app_is_running_for_e2e() throws Exception{
        nubiWallet.open();
        System.out.println("given");
        nubiWallet.home.waitToLoad();
    }

    @When("Email screen is completed e2e")
    public void a2_email_screen_is_completed() throws Exception{
        try{
            boolean status, existEmail;
            nubiWallet.home.tapLinkRegister();

            nubiWallet.email.waitToLoad();

            do{

                email = util.generateArmedEmail();
                existEmail = commonActions.existEmail(email);

            }while (existEmail);

            nubiWallet.email.setEmail(email);

//            existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);
//
//            while (existEmail){
//                armedEmail = commonSteps.generateArmedEmail();
//                existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);;
//            }
//
//            System.out.println(driver.currentActivity());
//            System.out.println(driver.getCurrentPackage());
//
//            nubiWallet.home.waitToLoad();
//
//            registroActions.waitForInputEmailVisible();
//
//            System.out.println(driver.currentActivity());
//            System.out.println(driver.getCurrentPackage());
//
//            commonSteps.setEmail(armedEmail);
//            registroActions.hideKeyword();
//            registroActions.implicitWaitByMSeconds(300);
//            status = registroActions.btnNextEnabledStatus();
//
//            Assert.assertEquals(status,true);
//
//
//            registroActions.implicitWaitByMSeconds(400);
//            registroActions.clickBtnNext();
//            registroActions.waitForBackButtonVisible();
//
//            System.out.println(driver.currentActivity());
//            System.out.println(driver.getCurrentPackage());
//
//
//            String token = registroActions.devolverToken(armedEmail);
//
//            String currentActivity=(driver.currentActivity());
//            String currentPackage = driver.getCurrentPackage();
//            registroActions.implicitWaitByMSeconds(300);
//            registroActions.clickBtnOpenMail();
//
//
//
//
//            //registroActions.iConfirmEmailFromDB(token);
//
//
//            registroActions.iConfirmEmailFromDB(token);
//            Thread.sleep(3000);
//
//            registroActions.implicitWaitByMSeconds(3000);
//
//
//            driver.startActivity(new Activity(currentPackage,"com.nubi.splashFeature.view.SplashActivity"));
//            //registroActions.waitForBackButtonVisible();
//
//            //registroActions.cerrarApp();
//            //
//
//            //registroActions.waitForInputNamesVisible();
//
//
//            //driver.startActivity(new Activity(currentPackage,"com.nubi.registerFeature.view.RegistrationActivity"));
//            //registroActions.waitForBackButtonVisible();
//
//            registroActions.waitForInputNamesVisible();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
