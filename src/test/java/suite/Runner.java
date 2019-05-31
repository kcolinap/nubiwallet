package suite;

import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.runner.JUnitCore;
import suite.e2e.*;

import java.net.MalformedURLException;

public class Runner {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver = null;
        try {
            DriverManager.loadConfigProp("AndroidApp.properties");
            DriverManager.createDriver();

            JUnitCore.runClasses(Registration.class);
            JUnitCore.runClasses(Login.class);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DriverManager.killDriver();
        }

    }
}
