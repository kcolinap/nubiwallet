package core.utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;


public class DataBaseConnection {

    Connection connection = null;
    Statement stmt = null;
    ResultSet rs = null;
    private Properties properties = new Properties();
    private static String baseUrl = "jdbc:postgresql://";

    //Constantes para la conexion a bd
    private static String dbServer;
    private static String port;
    private static String db;
    private static String user;
    private static String urlConexion="";

    public void iDataBaseConnection(String env, String table) throws IOException {

        try{
            properties.load(CommonUtils.loadPropertyFile("db.properties"));

            //System.out.println(env);

            if (env.toUpperCase().contentEquals("TEST")) {

                dbServer = properties.getProperty("testDBServer");
                port = properties.getProperty("port1");
                if(table.contentEquals("users")){
                    db = properties.getProperty("dbUsers");
                }else if(table.contentEquals("registration")){
                    db = properties.getProperty("dbRegistration");
                }

                user = properties.getProperty("user");
            }else{
                //"setear propertyes para otro ambiente
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
        while (rs.next()){
            return rs.getString(field);
        }

        return rs.getString(1);
    }


    public void closeConecction() throws SQLException{
        if(rs!=null){
            rs.close();
        }
        if(stmt!=null){
            stmt.close();
        }
        if(connection!=null){
            connection.close();
        }
    }

}
