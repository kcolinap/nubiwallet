import core.managers.DriverManager;
import io.appium.java_client.android.AndroidDriver;
import org.junit.runner.JUnitCore;
import test.suites.E2ESuite;


import java.net.MalformedURLException;

public class Runner {

    public static void main(String[] args) throws MalformedURLException {
        AndroidDriver driver = null;
        try {
            DriverManager.loadConfigProp("AndroidApp.properties");
            DriverManager.createDriver();

            JUnitCore.runClasses(E2ESuite.class);

        }catch (Exception e){
            e.printStackTrace();
        }finally {
             DriverManager.killDriver();
        }

    }
}