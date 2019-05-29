package core.base;

import core.utils.CommonUtils;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.Properties;

public class  ScreenBase {

    public static AndroidDriver driver;
    public  static Properties properties = new Properties();

    public ScreenBase(AndroidDriver driver) throws IOException {

        this.driver = driver;
        properties.load(CommonUtils.loadPropertyFile("UIElements.properties"));
        loadElements();
    }

    public void loadElements(){

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
}
