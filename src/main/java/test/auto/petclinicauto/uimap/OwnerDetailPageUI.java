package test.auto.petclinicauto.uimap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OwnerDetailPageUI {
	
	@FindBy(xpath="//a[contains(text(),'New Pet')]")
	public WebElement addNewPetButton;
	
	@FindBy(xpath="//a[text()='Owner' and contains(@href,'edit')]")
	public WebElement editOwnerButton;
	
}
