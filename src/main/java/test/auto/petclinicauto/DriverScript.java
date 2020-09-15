package test.auto.petclinicauto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import test.auto.petclinicauto.entity.Owner;
import test.auto.petclinicauto.entity.Pet;
import test.auto.petclinicauto.pages.AddOwnerPage;
import test.auto.petclinicauto.pages.FindOwnerPage;
import test.auto.petclinicauto.pages.MainPage;
import test.auto.petclinicauto.pages.NewPetPage;
import test.auto.petclinicauto.pages.OwnerDetailPage;
import test.auto.petclinicauto.util.WebDriverUtil;

/**
 * Hello world!
 *
 */
public class DriverScript
{
    public static void main( String[] args )
    {
    	String env = "qa";
    	if(args.length > 0 && !args[0].isEmpty()) {
    		env = args[0];
    	}
    	
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
       WebDriver driver = WebDriverUtil.getDriver("chrome");
//       WebDriver driver = WebDriverUtil.getDriver("ie");
//       driver.get("http://52.146.56.80:32111/petclinic/");
       driver.get(url);
       
       MainPage mainPage = new MainPage();
       PageFactory.initElements(driver, mainPage);
       mainPage.clickFindOwnerLink();
       
       FindOwnerPage findOwnerPage = new FindOwnerPage();
       PageFactory.initElements(driver, findOwnerPage);

       //double randomNum = Math.random();
       
       int randomNum = getRandomInt(1,10000);
       System.out.println(randomNum);
       boolean isExist = findOwnerPage.isOwnerExist("LTester"+randomNum);
       //System.out.println(isExist);
       if(!isExist) {
    	   findOwnerPage.clickAddOwnerButton();
    	   AddOwnerPage addOwnerPage = new AddOwnerPage();
    	   PageFactory.initElements(driver,addOwnerPage);
    	   
    	   Owner owner = new Owner("FTester"+randomNum, "LTester"+randomNum,"Tester1 Street","Tester1 City", "1234567");
    	   addOwnerPage.fillForm(owner);
    	   addOwnerPage.submitForm();
       }
       OwnerDetailPage ownerDetailPage = new OwnerDetailPage();
       PageFactory.initElements(driver, ownerDetailPage);
       ownerDetailPage.clickAddNewPet();
       try{
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
    	   System.out.println("Add Pet is stopped");
       }
       driver.close();
       driver.quit();
    }

	private static String format(int month) {
		String monthStr=String.valueOf(month);
		   if(month<10) {
			   monthStr="0"+month;
		   }
		   return monthStr;
	}
    
    public static String getRandomElement(List<String> list) {
    	Random rand = new Random();
    	int index = rand.nextInt(list.size());
    	return list.get(index);
    }
    
    public static int getRandomInt(int min, int max) {
    	Random rand = new Random();
    	return rand.nextInt(max-min+1)+min;
    	
    }
}
