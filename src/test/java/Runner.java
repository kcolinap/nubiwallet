import core.CommonActions;
import core.managers.DriverManager;
import org.junit.runner.JUnitCore;
import suite.e2e.Registration;
import suite.e2e.Login;
import suite.regression.DashboardR;
import suite.regression.LoginR;
import suite.regression.RegistrationR;

import java.net.MalformedURLException;

public class Runner {

    public static void main(String[] args) throws MalformedURLException {

        try {
            DriverManager.loadConfigProp("AndroidApp.properties");
            DriverManager.createDriver();

            String opt = "r";//param to filter suite

            switch (opt){
                case "r":
                    JUnitCore.runClasses(RegistrationR.class);
                    JUnitCore.runClasses(LoginR.class);
                    JUnitCore.runClasses(DashboardR.class);
                    break;
                case "e":
                    JUnitCore.runClasses(Registration.class);
                    JUnitCore.runClasses(Login.class);
                    break;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DriverManager.killDriver();
        }

    }
}
