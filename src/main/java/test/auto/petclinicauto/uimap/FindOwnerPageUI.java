package test.auto.petclinicauto.uimap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindOwnerPageUI {

	@FindBy( xpath="//a[text()='Add Owner']")
	protected WebElement addOwnerButton;
	
	@FindBy( id="lastName")
	protected WebElement lastNameTextBox;
	
	@FindBy( xpath="//div[@class='form-group']//button[@type='submit']")
	protected WebElement findOwnerButton;
	
	@FindBy(xpath="//input[@id=lastName]/p")
	protected WebElement searchResultText;
	
}
