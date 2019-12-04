package test.auto.petclinicauto.uimap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPageUI {

	@FindBy(xpath="//a[@title='find owners']")
	protected WebElement findOwnersLink;
}
