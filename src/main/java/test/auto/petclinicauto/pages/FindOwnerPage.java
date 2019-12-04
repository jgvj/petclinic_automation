package test.auto.petclinicauto.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.auto.petclinicauto.uimap.FindOwnerPageUI;

public class FindOwnerPage extends FindOwnerPageUI{

	
	public boolean isOwnerExist(String lastNameStr) {
		lastNameTextBox.sendKeys(lastNameStr);
		findOwnerButton.click();
		WebElement searchResult;
		try{
			searchResult = lastNameTextBox.findElement(By.xpath("./..//p"));
		}catch(Exception e) {
			return true;
		}
		return !searchResult.isDisplayed();
	}
	
	public void clickAddOwnerButton() {
		addOwnerButton.click();
	}
	
}
