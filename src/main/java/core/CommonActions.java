package core;

import api.android.Android;
import api.apps.nw.registration.personalInformation.PersonalInformation;
import com.github.javafaker.Faker;
import core.Util;
//import org.omg.CORBA.PUBLIC_MEMBER;

import java.io.IOException;
import java.sql.SQLException;

public class CommonActions {

    private Util util = new Util();

    private static String urlNubiToConfirm = "http://tunubi.app/registration/confirm/";

    private static String query;


    /****
     *
     * VALIDATE IF EMAIL EXIST ON BD
     *
     *************/
    public boolean existEmail(String email){

        String aux = "";
        try {

            query = "SELECT email FROM \"user\" where email ='"+email+"'";
            aux = util.simpleQuery(query, "email", "users");

        }catch (Exception e){
            return false;
        }

        return true;
    }

    /****
     *
     * VALIDATE IF dni EXIST ON BD
     *
     *************/
    public boolean existDni(String dni){

        String aux = "";
        try {

            query = "SELECT dni FROM \"user\" where dni ='"+dni+"'";
            aux = util.simpleQuery(query, "dni", "users");

        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*******
     *  VALIDATE IF USER EXIST ON BD
     ******/
    public boolean existUser(String user){

        String aux = "";
        try {

            query = "SELECT * FROM \"user\" where user ='"+user+"'";
            aux = util.simpleQuery(query, "username", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*****
     *   VALIDATE IF PHONE NUMBER EXIST ON BD
     *****/
    public boolean existPhoneNumber(String phone){

        String aux;

        try {
            query = "SELECT * FROM \"user\" where phone_number ='"+phone+"'";
            aux = util.simpleQuery(query, "phone_number", "users");

            if(aux.contentEquals("")){
                return false;
            }
        }catch (Exception e){
            return false;
        }

        return true;
    }

    /*******
     *  GET SMS CODE PHONE
     ******/
    public String getSmsCode(String number) throws SQLException, IOException{
        query = "SELECT * FROM phone_data where phone_number ='"+number+"'";
        return util.simpleQuery(query, "sms_confirmation_code", "registration");
    }

    /**************
     *  GET ACCES TOKEN
     ***********/
    public String getAccesToken(String email){
        String token = "";
        try{
            query = "SELECT * FROM email_registration WHERE email ='"+email+"'";
            token = util.simpleQuery(query, "email_confirmation_jwt", "registration");
        }catch (Exception e){
            System.out.println("Unable to execute query to get acces token");
            e.printStackTrace();
        }
        return token;
    }

    public PersonalInformation iConfirmEmailFromDB(String token) {

        Android.driver.get(urlNubiToConfirm + token);
        return Android.app.nubiWallet.personalInformation;
    }

    public void waitForActivity(String desiredActivity, int wait) throws InterruptedException {
        int counter=0;
        do{
            Thread.sleep(1000);
            counter++;
        }while(Android.driver.currentActivity().toString().contains(desiredActivity) && (counter<=wait));

        System.out.println("Activity appeared :"+Android.driver.currentActivity());
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

    /***********
     * HIDE KEYWORD
     */
    public void hideKeyBoard(){
        try {
            Android.driver.hideKeyboard();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*****
     * RESET APP
     */
    public void resetApp(){
        try {
            Android.driver.resetApp();
        }catch (Exception e){
            System.out.println("Unable to reset the app");
        }
    }
}
