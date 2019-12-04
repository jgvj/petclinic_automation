package test.auto.petclinicauto.uimap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddOwnerPageUI {

	@FindBy(id="firstName")
	protected WebElement firstNameTextBox;
	
	@FindBy(id="lastName")
	protected WebElement lastNameTextBox;
	
	@FindBy(id="address")
	protected WebElement addressTextBox;
	
	@FindBy(id="city")
	protected WebElement cityTextBox;
	
	@FindBy(id="telephone")
	protected WebElement telephoneTextBox;
	
	@FindBy(xpath="//button[text()='Add Owner']")
	protected WebElement addOwnerButton;
	
}
