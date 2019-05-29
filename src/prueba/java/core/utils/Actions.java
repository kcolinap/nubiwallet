package core.utils;

import core.base.ScreenBase;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

public class Actions extends ScreenBase {

    public Actions(AndroidDriver driver) throws IOException{

        super(driver);

    }

    WebDriverWait wait = new WebDriverWait(driver,30);

    DataBaseConnection con = new DataBaseConnection();


    public void setText(WebElement element, String text){
        element.sendKeys(text);
    }

    public void clearInput(WebElement element){
        element.clear();
    }

    public void hideKeyword(){
        driver.hideKeyboard();

        System.out.println(driver.getContext());
    }

    public void showKeyword(){
        driver.getKeyboard();
    }

    public void clickOnElement(WebElement element){
        element.click();
    }

    public boolean elementIsEnabled(WebElement element){
        return element.isEnabled();
    }

    public boolean elementIsChecked(WebElement element){
        return element.isSelected();
    }

    public boolean elementIsPresent(WebElement element){
        return element.isDisplayed();
    }

    public void waitForElementPresent(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public String getTextFromElement(WebElement element){
        return element.getText();
    }

   public String ConsultaBDSimple(String query, String field, String bd) throws SQLException, IOException {
        con.iDataBaseConnection("test", bd);
        String resultQuery = con.execute(query, field);
        con.closeConecction();
        return resultQuery;
   }

   public void cerrarApp(){
        driver.closeApp();
   }

   //Waits methods
   public void implicitWaitByMSeconds(int miliSeconds){
       driver.manage().timeouts().implicitlyWait(miliSeconds, TimeUnit.MILLISECONDS);
   }

}