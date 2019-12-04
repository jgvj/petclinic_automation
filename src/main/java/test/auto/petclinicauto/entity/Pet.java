package test.auto.petclinicauto.entity;

public class Pet {

	private String name;
	private String birthDate;
	private String type;
	
	public Pet(String name,String birthDate, String type) {
		this.name = name;
		this.birthDate = birthDate;
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
