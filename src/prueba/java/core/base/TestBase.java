package core.base;

import io.appium.java_client.android.AndroidDriver;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestBase {

    public static AndroidDriver driver;

    //public static EmailScreen emailScreen;

    public static String path = System.getProperty("user.dir")+"\\screenshots";
    public static DateFormat dateTest = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
    public static String dateFolder = dateTest.format(new Date());


}
