package core;

import api.android.Android;
import api.apps.nw.registration.personalInformation.PersonalInformation;
import core.Util;

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
}
