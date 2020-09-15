package test.auto.petclinicauto.testcases;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import test.auto.petclinicauto.entity.Owner;
import test.auto.petclinicauto.entity.Pet;
import test.auto.petclinicauto.pages.AddOwnerPage;
import test.auto.petclinicauto.pages.FindOwnerPage;
import test.auto.petclinicauto.pages.MainPage;
import test.auto.petclinicauto.pages.NewPetPage;
import test.auto.petclinicauto.pages.OwnerDetailPage;
import test.auto.petclinicauto.util.WebDriverUtil;

public class AddNewPets {
	private static WebDriver driver = null;
	private static int randomNum = 0;
	
	@BeforeTest
	  public void openBrowser() {
		Reporter.log("Login:");
		String env = "qa";
    	
    	System.out.println("Current environment: " + env);
    	String url = "https://jgvjpetclinicqa.azurewebsites.net/petclinic/";
    	if(env.equalsIgnoreCase("qa")) {
    		url = "https://jgvjpetclinicqa.azurewebsites.net/petclinic/";
    	}else if(env.equalsIgnoreCase("dev")) {
    		url = "https://jgvjpetclinicdev.azurewebsites.net/petclinic/";
    	}else if(env.equalsIgnoreCase("prod")) {
    		url = "https://jgvjpetclinic.azurewebsites.net/petclinic/";
    	}
    	
    	System.out.println("URL: " + url);
    	try {
    	       driver = WebDriverUtil.getDriver("chrome");
    	       driver.get(url);
    	}catch(Exception e) {
    		e.printStackTrace();
    		Reporter.log(e.getMessage());
    	       driver.close();
    	       driver.quit();
    	}
	  }

	  @AfterTest
	  public void closeBrowser() {
		  Reporter.log("Close PetClinic");

	    	try {
	    		if(driver != null) {
		    		driver.close();
		 	       	driver.quit();
	    		}

	    	}catch(Exception e) {
	    		e.printStackTrace();
	    		Reporter.log(e.getMessage());
	    	}
	  }
	
	@Test(description="Go to Owner page and add new pets", alwaysRun=true)
	public static void testAddNewPets() throws Exception{
		try {
			Reporter.log("Find owner and verify if owner exists.");
		       MainPage mainPage = new MainPage();
		       PageFactory.initElements(driver, mainPage);
		       mainPage.clickFindOwnerLink();
		       
		       FindOwnerPage findOwnerPage = new FindOwnerPage();
		       PageFactory.initElements(driver, findOwnerPage);
		       
		       randomNum = getRandomInt(1,10000);
		       System.out.println(randomNum);
		       boolean isExist = findOwnerPage.isOwnerExist("LTester"+randomNum);
		       if(!isExist) {
		    	   Reporter.log("Owner not find, create a new owner.");
		    	   findOwnerPage.clickAddOwnerButton();
		    	   AddOwnerPage addOwnerPage = new AddOwnerPage();
		    	   PageFactory.initElements(driver,addOwnerPage);
		    	   
		    	   Owner owner = new Owner("FTester"+randomNum, "LTester"+randomNum,"Tester1 Street","Tester1 City", "1234567");
		    	   addOwnerPage.fillForm(owner);
		    	   addOwnerPage.submitForm();
		    	   Reporter.log("Owner created.");
		       }
		       
				Reporter.log("Add new pets");
				OwnerDetailPage ownerDetailPage = new OwnerDetailPage();
			    PageFactory.initElements(driver, ownerDetailPage);
			    ownerDetailPage.clickAddNewPet();
			    List<String> typeList = new ArrayList<>();
				       typeList.add("bird");
				       typeList.add("dog");
				       typeList.add("cat");
				       typeList.add("lizard");
				       typeList.add("hamster");
				       typeList.add("snake");
				       NewPetPage newPetPage = new NewPetPage();
				       PageFactory.initElements(driver, newPetPage);
				       
				       String birthDate = "";
				       String year = String.valueOf(getRandomInt(2000,2019));
				      
				       int month = getRandomInt(1,12);
				       int day = getRandomInt(1,30);
				       birthDate = year+"-"+ format(month)+"-"+format(day);
				      
				       Pet pet = new Pet("pet"+randomNum, birthDate,getRandomElement(typeList));
				       newPetPage.fillForm(pet);
				       newPetPage.clickAddPet();
				       
				       ownerDetailPage.isAddNetPetBtnExist();
		}catch(Exception e) {
    		e.printStackTrace();
    		Reporter.log(e.getMessage());
    	       driver.close();
    	       driver.quit();
    	}

	}
	
	@Test(description="Hello world test.", alwaysRun=true)
	public static void testHello() throws Exception{
		Reporter.log("Hello world. pass");

	}

	private static String format(int month) {
		String monthStr=String.valueOf(month);
		   if(month<10) {
			   monthStr="0"+month;
		   }
		   return monthStr;
	}
    
	private static String getRandomElement(List<String> list) {
    	Random rand = new Random();
    	int index = rand.nextInt(list.size());
    	return list.get(index);
    }
    
	private static int getRandomInt(int min, int max) {
    	Random rand = new Random();
    	return rand.nextInt(max-min+1)+min;
    	
    }
}
