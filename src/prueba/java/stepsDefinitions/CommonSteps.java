package stepsDefinitions;

import api.android.Android;
import api.apps.nw.NubiWallet;
import com.github.javafaker.Faker;

import core.screens.registro.RegistroActions;
import core.utils.Actions;
import core.utils.CommonUtils;
import core.utils.PasswordGenerator;

import com.nw.screens.home.Home;
import cucumber.api.java.en.Given;
import cucumber.api.java.sl.In;
import io.appium.java_client.android.AndroidDriver;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommonSteps {

    private String armedEmail, query;
    private RegistroActions registroActionsF;
    private CommonUtils commonUtils = new CommonUtils();
    private static NubiWallet nubiWallet = Android.app.nubiWallet;
    //private static Home home;
    //private Actions actions;


    public void home_screen_showed(AndroidDriver driver) throws IOException{
        nubiWallet.home.waitToLoad();
    }

    public void setRegistroActionsDriver(RegistroActions regActions){
        this.registroActionsF = regActions;
    }

    public void clickOnCircleNextButton(){
        registroActionsF.clickOnBtnCircleNext();
    }

    public String generateArmedEmail(){
        try{
            armedEmail = "nwtest"+commonUtils.generateRamdonNumber(4)+"@yopmail.com";
            //return armedEmail;
        }catch (Exception e){
            e.printStackTrace();
        }

        return armedEmail;
    }
    public void setEmail(String email){

        registroActionsF.setEmail(email);

    }

    public boolean checkTextIsNumeric(String text) {
        try {
            if (text != null) {
                Integer.parseInt(text.trim());
            }
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public boolean checkTextSpecialChar(String text) {
        boolean aux = false;
        try {

            Pattern p = Pattern.compile("/^(%~`!@#%&)");
            Matcher m = p.matcher(text);
            if (m.find()){
                aux = true;
            }else{
                aux= false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return aux;
    }

    public boolean validateIfEmailExist(String email, Actions actions) throws SQLException, IOException {
        try {
            String table =
            query = "SELECT email FROM \"user\" where email ='"+email+"'";
            String aux = actions.ConsultaBDSimple(query, "email", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
           return false;
        }

       return true;
    }

    public boolean validateIfDniExist(String dni, Actions actions) throws SQLException, IOException {
        try {
            String table =
                    query = "SELECT dni FROM \"user\" where dni ='"+dni+"'";
            String aux = actions.ConsultaBDSimple(query, "dni", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public boolean validateIfUserExist(String user, Actions actions) throws SQLException, IOException {
        try {
            String table =
                    query = "SELECT * FROM \"user\" where user ='"+user+"'";
            String aux = actions.ConsultaBDSimple(query, "username", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public boolean validateIfPhoneExist(String phone, Actions actions) throws SQLException, IOException {
        try {
            String table =
                    query = "SELECT * FROM \"user\" where phone_number ='"+phone+"'";
            String aux = actions.ConsultaBDSimple(query, "phone_number", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    public String getSmsCode(String number, Actions actions) throws SQLException, IOException{
        query = "SELECT * FROM phone_data where phone_number ='"+number+"'";
        return actions.ConsultaBDSimple(query, "sms_confirmation_code", "registration");
    }

    public String generatePersonalInformation(String kindOfInformation){
        String data ="";
        try{
            Faker faker = new Faker();
            if(kindOfInformation.toUpperCase().contentEquals("NAMES")){
                data = faker.name().firstName();
            }else if(kindOfInformation.toUpperCase().contentEquals("LASTNAMES")){
                data = faker.name().lastName();
            }else if(kindOfInformation.toUpperCase().contentEquals("USERNAME")){
                data = faker.name().username();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return data;
    }

    public String passwordGenerator(){
        PasswordGenerator passwordGenerator = new PasswordGenerator.PasswordGeneratorBuilder()
                .useDigits(true)
                .useLower(true)
                .useUpper(true)
                .usePunctuation(true)
                .build();

        String password = passwordGenerator.generate(8);

        return password;

    }

}
