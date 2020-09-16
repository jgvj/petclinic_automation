package test.auto.petclinicauto.testcases;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class DEVTest {
	
	@Test(description="DEV: Go to Owner page and add new pets", alwaysRun=true)
	public static void testAddNewPets() throws Exception{
		Reporter.log("Login:");
		String env = System.getProperty("environment");
    	
    	System.out.println("Current environment: " + env);
    	String url = "https://jgvjpetclinicqa.azurewebsites.net/petclinic/";
    	if(env.equalsIgnoreCase("qa")) {
    		url = "https://jgvjpetclinicqa.azurewebsites.net/petclinic/";
    	}else if(env.equalsIgnoreCase("dev")) {
    		url = "https://jgvjpetclinicdev.azurewebsites.net/petclinic/";
    	}
    	
    	System.out.println("URL: " + url);
	}

}
