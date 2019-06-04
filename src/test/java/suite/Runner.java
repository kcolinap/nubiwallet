package suite;

import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.runner.JUnitCore;
import suite.e2e.*;
import suite.regression.RegistrationRegexTest;

import java.net.MalformedURLException;

public class Runner {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver = null;
        try {
            DriverManager.loadConfigProp("AndroidApp.properties");
            DriverManager.createDriver();

            String opt = "r";//param to filter suite

            switch (opt){
                case "r":
                    JUnitCore.runClasses(RegistrationRegexTest.class);
                    break;
                case "e":
                    JUnitCore.runClasses(Registration.class);
                    JUnitCore.runClasses(Login.class);
                    break;
                    default:
                        break;
            }


        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DriverManager.killDriver();
        }

    }
}
