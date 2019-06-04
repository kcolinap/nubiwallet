package core.database;

import core.Util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ConnectionDB {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;

    private static Util util = new Util();
    private Properties properties = new Properties();
    private static String baseUrl = "jdbc:postgresql://";

    //Constants for BD connection
    private static String dbServer;
    private static String port;
    private static String db;
    private static String user;
    private static String urlConexion="";

    public void iDataBaseConnection(String environment, String db) throws IOException {
        try{
            properties.load(util.loadPropertyFile("db.properties"));

            if (environment.toLowerCase().contentEquals("test")) {
                dbServer = properties.getProperty("testDBServer");
                port = properties.getProperty("port1");
                if(db.contentEquals("users")){
                    db = properties.getProperty("dbUsers");
                }else if(db.contentEquals("registration")){
                    db = properties.getProperty("dbRegistration");
                }

                user = properties.getProperty("user");

            }else{
                //"set properties for other environments
            }

            urlConexion = baseUrl+dbServer+":"+port+"/"+db;
            connection = DriverManager.getConnection(urlConexion, user, null);

        }catch (SQLException e){
            e.getMessage();
        }
    }

    public String execute(String query, String field) throws SQLException{

        stmt = connection.createStatement();
        rs = stmt.executeQuery(query);

        while (rs.next())
            return rs.getString(field);

        return rs.getString(1);
    }


    public void closeConecction() throws SQLException{

        if(rs!=null) rs.close();

        if(stmt!=null) stmt.close();

        if(connection!=null) connection.close();

    }


}
