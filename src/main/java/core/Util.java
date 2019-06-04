package core;

import core.database.ConnectionDB;

import java.io.*;
import java.sql.SQLException;

public class Util {

    private ConnectionDB connectionDB = new ConnectionDB();
    private String email;


    /************
     *  GENERATE RANDOM NUMBER
     ***********/
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
            case 7:
                numberGenerated = (int)(10000000 * Math.random());
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


    public String generateArmedEmail(){
        try{
            email = "nwtest"+generateRamdonNumber(4)+"@yopmail.com";
            //return armedEmail;
        }catch (Exception e){
            throw new RuntimeException("Cannot generate email");
        }
        return email;
    }

    /***
     * Load property file method
     ***/
    public static FileInputStream loadPropertyFile(String propertyFile) throws IOException {

        String userDir = System.getProperty("user.dir");
        FileInputStream fis = new FileInputStream(userDir + "\\src\\main\\Resources\\properties\\"+propertyFile);
        return fis;
    }

    /*******
     *  DB query simple method
     *****/
    public String simpleQuery(String query, String field, String bd) throws SQLException, IOException {
        connectionDB.iDataBaseConnection("test", bd);
        String resultQuery = connectionDB.execute(query, field);
        connectionDB.closeConecction();
        return resultQuery;
    }


    /****
     * Write on file
     */
    public void writeOnFile(String email, String user, String pass){
        try{
/*
            String useDir = System.getProperty("user.dir");
            File file = new File(useDir+"\\src\\main\\resources\\user.txt");
            BufferedWriter bufferedWriter;
            if(file.exists()){
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("Email: "+email);
                bufferedWriter.write("User: "+user);
                bufferedWriter.write("Password: "+pass);
            }else{
                bufferedWriter = new BufferedWriter(new FileWriter(file));
                bufferedWriter.write("Email: "+email);
                bufferedWriter.write("User: "+user);
                bufferedWriter.write("Password: "+pass);
            }

            bufferedWriter.close();*/

            String useDir = System.getProperty("user.dir");
            FileWriter file = null;
            PrintWriter pw = null;

            try{
                file = new FileWriter(useDir+"\\src\\main\\resources\\user.txt");
                pw = new PrintWriter(file);

                pw.println(user);
                pw.println(email);
                pw.print(pass);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if(file!=null){
                        file.close();
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
