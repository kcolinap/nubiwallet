package core.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



public class CommonUtils {

    private static AndroidDriver driver;

   // private static URL serverUrl;

    private static DateFormat date;



    public static void takeScreeShoot(String path, String fileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        date = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
        String destFolder = date.format(new Date());
        new File(path+"\\"+date.format(new Date())).mkdirs();

        try{
            FileUtils.copyFile(scrFile, new File(path+"/"+destFolder+"/"+fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void takeScreeShootIter(String path, String dt, String fileName){
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        new File(path+"/"+dt).mkdirs();

        try{
            FileUtils.copyFile(scrFile, new File(path+"/"+dt+"/"+fileName));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static FileInputStream loadPropertyFile(String propertyFile) throws IOException{

        String userDir = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\Resources\\properties\\"+propertyFile);
        return fis;
    }

    public int generateRamdonNumber(int lenght){
        int numberGenerated;
        switch (lenght){
            case 1:
                numberGenerated=  (int)(10 * Math.random());
                break;
            case 2:
                numberGenerated =  (int)(100 * Math.random());
                break;
            case 3:
                numberGenerated =  (int)(1000 * Math.random());
                break;
            case 4:
                numberGenerated = (int)(10000 * Math.random());
                break;
            case 5:
                numberGenerated = (int)(100000 * Math.random() + 1);
                break;
            case 6:
                numberGenerated = (int)(1000000 * Math.random());
                break;
            case 8:
                numberGenerated = (int)(100000000 * Math.random() +1);
                break;
            default:
                numberGenerated  = (int)(1 * Math.random());
                break;

        }

        return numberGenerated;
    }
}
