package test.auto.petclinicauto.pages;

import test.auto.petclinicauto.uimap.OwnerDetailPageUI;

public class OwnerDetailPage extends OwnerDetailPageUI {

	public void clickAddNewPet() {
		addNewPetButton.click();
	}
	
	public boolean isAddNetPetBtnExist() {
		return addNewPetButton.isDisplayed();
	}
}
