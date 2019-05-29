package stepsDefinitions.regression.registro;

import core.screens.registro.RegistroActions;
import cucumber.api.java.en.When;
import runner.regression.RegressionCore_Register;
import stepsDefinitions.CommonSteps;


public class NWReg003ValidateCreateUserScreenTest extends RegressionCore_Register {

    private CommonSteps commonSteps;
    private static RegistroActions registroActions;

    public NWReg003ValidateCreateUserScreenTest(CommonSteps commonSteps){

        this.commonSteps = commonSteps;
    }

    @When("User click on circle button on cuil screen")
    public void user_click_on_circle_button(){
        try{
            commonSteps.clickOnCircleNextButton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
