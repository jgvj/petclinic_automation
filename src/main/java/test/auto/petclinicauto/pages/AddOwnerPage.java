package test.auto.petclinicauto.pages;

import test.auto.petclinicauto.entity.Owner;
import test.auto.petclinicauto.uimap.AddOwnerPageUI;

public class AddOwnerPage extends AddOwnerPageUI{

	public void fillForm(Owner owner) {
		firstNameTextBox.sendKeys(owner.getFirstName());
		lastNameTextBox.sendKeys(owner.getLastName());
		addressTextBox.sendKeys(owner.getAddress());
		cityTextBox.sendKeys(owner.getCity());
		telephoneTextBox.sendKeys(owner.getTelephone());
	}
	
	public void submitForm() {
		addOwnerButton.click();
	}
}
