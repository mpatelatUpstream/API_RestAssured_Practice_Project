package nishant_Utils;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class FileAndEnv {

	public static Map<String,String> fileandenv = new HashMap<String,String>();
	public static Properties propMain = new Properties();
	public static Properties propPreSet = new Properties();
	
	
	public static Map<String, String> envAndFile(){
		 String enviornment = System.getProperty("env");
		 
		 try {
			 if(enviornment.equalsIgnoreCase("dev")) {
				 FileInputStream flsDev = new FileInputStream(System.getProperty("user.dir")+"/inputs/dev.properties");
				 propMain.load(flsDev);
				 fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
				 fileandenv.put("portNo", propMain.getProperty("portNo"));
				 fileandenv.put("username", propMain.getProperty("username"));
				 fileandenv.put("password", propMain.getProperty("password"));
			 } else if(enviornment.equalsIgnoreCase("qa")) {
				 FileInputStream flsQA = new FileInputStream(System.getProperty("user.dir")+"/inputs/qa.properties");
				 propMain.load(flsQA);
				 fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
				 fileandenv.put("portNo", propMain.getProperty("portNo"));
				 fileandenv.put("username", propMain.getProperty("username"));
				 fileandenv.put("password", propMain.getProperty("password"));
			 } else if(enviornment.equalsIgnoreCase("staging")) {
				 FileInputStream flsStaging = new FileInputStream(System.getProperty("user.dir")+"/inputs/staging.properties");
				 propMain.load(flsStaging);
				 fileandenv.put("ServerUrl", propMain.getProperty("ServerUrl"));
				 fileandenv.put("portNo", propMain.getProperty("portNo"));
				 fileandenv.put("username", propMain.getProperty("username"));
				 fileandenv.put("password", propMain.getProperty("password"));
			 } 
		 }catch (Exception e){
		 }
		
		return fileandenv;
	}
	
	public static Map<String, String> getConfigReader(){
if(fileandenv == null) {
	fileandenv = envAndFile();
}
		return fileandenv;
	}
}
