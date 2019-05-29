package core;

import core.Util;

import java.io.IOException;
import java.sql.SQLException;

public class CommonActions {

    private Util util = new Util();

    private static String query;

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
}
