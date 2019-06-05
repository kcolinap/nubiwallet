package core.managers;

import api.android.Android;
import api.apps.nw.registration.confirmEmail.ConfirmEmail;
import api.apps.nw.registration.personalInformation.PersonalInformation;
import core.ADB;
import core.MyLogger;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

public class DriverManager {

    private static HashMap<String, URL> hosts;
    private static String unlockPackage = "io.appium.unlock";
    private static Properties prop = new Properties();
    private static String urlNubiToConfirm = "http://tunubi.app/registration/confirm/";
    private  static ADB adb;


    public static int EXPLICIT_WAIT_TIME;
    public static int IMPLICIT_WAIT_TIME;
    public static int DEFAULT_WAIT_TIME;
    public static String APP_NAME;
    public static String BASE_PKG;
    private static String APPIUM_PORT;
    public static String PLATFORM_NAME;
    public static String PLATFORM_VERSION;
    public static String DEVICE_NAME;


    public static void loadConfigProp(String propertyFileName) throws IOException {

        String userDir = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\resources\\properties\\"+propertyFileName);
        prop.load(fis);

        EXPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("explicit.wait"));
        DEFAULT_WAIT_TIME = Integer.parseInt(prop.getProperty("default.wait"));
        IMPLICIT_WAIT_TIME = Integer.parseInt(prop.getProperty("implicit.wait"));
        APP_NAME = prop.getProperty("app.path");
        APPIUM_PORT  = prop.getProperty("appiumserver.port");
        PLATFORM_NAME = prop.getProperty("platform.name");
        //DEVICE_NAME = prop.getProperty("device.name");
        PLATFORM_VERSION = prop.getProperty("platform.version");


    }

    private static DesiredCapabilities getCaps(String deviceID){
        DesiredCapabilities caps = new DesiredCapabilities();
            adb = new ADB(deviceID);
            caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, adb.getAndroidVersionAsString());
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, DriverManager.PLATFORM_NAME);
            caps.setCapability(MobileCapabilityType.APP, DriverManager.APP_NAME);
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, deviceID);
        return caps;
    }

    private static URL host(String deviceID) throws MalformedURLException {
        if(hosts == null){
            hosts = new HashMap<>();
            hosts.put(deviceID, new URL("http://127.0.0.1:4723/wd/hub"));
        }return hosts.get(deviceID);
    }

    private static ArrayList<String> getDevices(){
        ArrayList<String> availableDevices = new ArrayList<>();
        ArrayList connectedDevices = ADB.getConnectedDevices();
        for(Object connectedDevice: connectedDevices){
            String device = connectedDevice.toString();
            ArrayList apps = new ADB(device).getInstalledPackages();
            if(!apps.contains(unlockPackage)){
                availableDevices.add(device);
            }else{
                //System.out.println("Device: " + device + " has "+unlockPackage+" already installed");

                availableDevices.add(device);
            }
        }
        if(availableDevices.size() == 0) throw new RuntimeException("Not a device available for test");
        return availableDevices;
    }

    public static void createDriver() throws MalformedURLException{
        ArrayList<String> devices = getDevices();
        for (String device: devices){
            try{
                Android.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), getCaps(device));
               // Android.driver.closeApp();
                Android.adb = new ADB(device);
                break;
            }catch (Exception e){
                e.printStackTrace();
            }

        }


    }

    public ConfirmEmail iConfirmEmailFromDB(String token){

            //Thread.sleep(300);
            Android.driver.get(urlNubiToConfirm+token);


        return Android.app.nubiWallet.confirmEmail;
    }

    public static void killDriver(){
        if(Android.driver != null){
            Android.driver.quit();
            Android.adb.uninstallApp("com.tunubi.wallet");
        }else{
            System.out.println("Driver was not initialized");
        }
    }
}
