package test.auto.petclinicauto.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import test.auto.petclinicauto.entity.Pet;
import test.auto.petclinicauto.uimap.NewPetPageUI;

public class NewPetPage extends NewPetPageUI {

	public void fillForm(Pet pet) {
		petNameTextBox.sendKeys(pet.getName());
		petBirthDateTextBox.sendKeys(pet.getBirthDate());
		List<WebElement> optionList = typeDropDown.findElements(By.tagName("option"));
		for(WebElement option:optionList) {
			if(option.getText().equalsIgnoreCase(pet.getType())) {
				option.click();
			}
		}
	}
	
	public void clickAddPet() {
		addPetButton.click();
	}
}
