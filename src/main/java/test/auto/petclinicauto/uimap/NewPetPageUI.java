package test.auto.petclinicauto.uimap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPetPageUI {

	@FindBy(id="name")
	protected WebElement petNameTextBox;
	
	@FindBy(id="birthDate")
	protected WebElement petBirthDateTextBox;
	
	@FindBy(id="type")
	protected WebElement typeDropDown;
	
	@FindBy(xpath="//button[@type='submit' and text()='Add Pet']")
	protected WebElement addPetButton;
	
}
