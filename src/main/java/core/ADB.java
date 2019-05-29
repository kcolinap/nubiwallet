package core;

import core.managers.ServerManager;

import java.util.ArrayList;

public class ADB {

    private String ID;

    public ADB(String deviceID){ID = deviceID;}

    public static String command(String command){
        //MyLogger.log.debug("Formatting ADB Command: "+command);
        if(command.startsWith("adb")) command = command.replace("adb ", ServerManager.getAndroidHome()+"/platform-tools/adb ");
        else throw new RuntimeException("This method is designed to run ADB commands only!");
        //MyLogger.log.debug("Formatted ADB Command: "+command);
        String output = ServerManager.runCommand(command);
        //MyLogger.log.debug("Output of the ADB Command: "+output);
        if(output == null) return "";
        else return output.trim();
    }

    public void openAppsActivity(String packageID, String activityID){
        command("adb -s "+ID+" shell am start -c api.android.intent.category.LAUNCHER -a api.android.intent.action.MAIN -n "+packageID+"/"+activityID);
    }

    public static ArrayList getConnectedDevices(){
        ArrayList devices = new ArrayList();
        String output = command("adb devices");
        for(String line : output.split("\n")){
            line = line.trim();
            if(line.endsWith("device")) devices.add(line.replace("device", "").trim());
        }
        return devices;
    }

    public ArrayList getInstalledPackages(){
        ArrayList packages = new ArrayList();
        String[] output = command("adb -s "+ID+" shell pm list packages").split("\n");
        for(String packageID : output)
            packages.add(packageID.replace("package:","").trim());
        return packages;
    }

    public void uninstallApp(String packageID){
        command("adb -s "+ID+" uninstall "+packageID);
    }

    public void forceStopApp(String packageID){

        command("adb -s "+ID+" shell am force-stop "+packageID);
    }

    public void clearAppsData(String packageID){

        command("adb -s "+ID+" shell pm clear "+packageID);
    }
}
