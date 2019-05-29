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


public class NWReg002ValidatePersonalInformationScreenTest extends RegressionCore_Register {

    private CommonSteps commonSteps;
    private static RegistroActions registroActions;
    private static Actions actions;
    public String armedEmail;
    private String dniRandom = "95";
    private CommonUtils commonUtils = new CommonUtils();
    private boolean auxStatus = false;

    public NWReg002ValidatePersonalInformationScreenTest(CommonSteps commonSteps)throws IOException {
        this.commonSteps = commonSteps;
        registroActions = new RegistroActions(driver);
        actions = new Actions(driver);
    }

    @Given("Email screen is completed with a valid email and condition next button as {string}")
    public void complete_email_screen(String condition){
        try{
            boolean status, existEmail;
            armedEmail = commonSteps.generateArmedEmail();
            existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);

            while (existEmail){
                armedEmail = commonSteps.generateArmedEmail();
                existEmail = commonSteps.validateIfEmailExist(armedEmail, actions);;
            }

            commonSteps.setEmail(armedEmail);
            registroActions.implicitWaitByMSeconds(300);
            status = registroActions.btnNextEnabledStatus();
            if(condition.toUpperCase().contentEquals("TRUE")){
                Assert.assertEquals(status,true);
            }

            registroActions.implicitWaitByMSeconds(400);
            registroActions.clickBtnNext();
            registroActions.waitForBackButtonVisible();

            String token = registroActions.devolverToken(armedEmail);


            registroActions.implicitWaitByMSeconds(300);
            registroActions.clickBtnOpenMail();
            Thread.sleep(3000);

            registroActions.iConfirmEmailFromDB(token);

            registroActions.implicitWaitByMSeconds(3000);
            registroActions.waitForInputNamesVisible();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Given("User is on personal information screen")
    public void user_is_on_personal_information_screen() {
        try{
            //registroActions = commonSteps.getRegistroActionsDriver();
            registroActions.implicitWaitByMSeconds(1500);
            registroActions.waitForInputNamesVisible();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @When("User sets names as {string}, lastnames as {string}, dni as {string} and genre as {string}")
    public void set_user_personal_information(String names, String lastNames, String dni, String genre){
        try {

            if(!names.contentEquals("")){
                registroActions.setNames(names);
                if(commonSteps.checkTextIsNumeric(names) || commonSteps.checkTextSpecialChar(names)){
                    registroActions.waitForLblInputErrorVisible();
                    auxStatus = registroActions.isLblInputErrorPresent();
                    Assert.assertEquals(auxStatus, true);
                }
            }else{
                registroActions.setNames("");
            }

            if(!lastNames.contentEquals("")){
                registroActions.setLastNames(lastNames);
                if(commonSteps.checkTextIsNumeric(lastNames) || commonSteps.checkTextSpecialChar(lastNames)){
                    registroActions.waitForLblInputErrorVisible();
                    auxStatus = registroActions.isLblInputErrorPresent();
                    Assert.assertEquals(auxStatus, true);
                }
            }else{
                registroActions.setLastNames("");
            }

            if(!dni.contentEquals("")){
                if (dni.toUpperCase().contentEquals("P")) {
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
                    }
                    registroActions.setDni(dniRandom);
                }else if(dni.length()<7){
                    registroActions.setDni(dni);
                    registroActions.waitForLblInputErrorVisible();
                    auxStatus = registroActions.isLblInputErrorPresent();
                    Assert.assertEquals(auxStatus, true);
                }
            }else{
                registroActions.setDni("");
            }

            if(!genre.contentEquals("")){
                if(genre.toUpperCase().contentEquals("H")){
                    registroActions.clickOptMale();
                }else{
                    registroActions.clickOptFemale();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate circle next button codition as {string}")
    public void validate_circle_next_button_condition_as(String condition) {
        boolean status = false;
        try{
            status = registroActions.btnCircleNextStatus();

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

    @Then("Click on circle next button")
    public void user_click_on_circle_button(){
        try {
            commonSteps.clickOnCircleNextButton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @Then("validate cuil screen was showed")
    public void validate_user_is_on_cuil_screen(){
        try {
            registroActions.waitForInputCuilVisible();
            registroActions.implicitWaitByMSeconds(600);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Then("Validate that create user screen was showed")
    public void validate_create_user_screen(){
        try {
            registroActions.implicitWaitByMSeconds(600);
            registroActions.waitForInputUserVisible();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
