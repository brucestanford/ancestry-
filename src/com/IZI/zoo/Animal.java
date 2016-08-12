package com.IZI.zoo;





public class Animal {

	int Animal_ID;
	int Zoo_ID;
	int Species_ID;
	String Animal_Name;
	String Description;
	String Health;
	int TimesToFeedADay;
	int AmountToFeedEachTime;
	String note;


	public int getAnimal_ID() {
		return Animal_ID;
	}


	public void setAnimal_ID(int animal_ID) {
		Animal_ID = animal_ID;
	}


	public int getZoo_ID() {
		return Zoo_ID;
	}


	public void setZoo_ID(int zoo_ID) {
		Zoo_ID = zoo_ID;
	}


	public int getSpecies_ID() {
		return Species_ID;
	}


	public void setSpecies_ID(int species_ID) {
		Species_ID = species_ID;
	}


	public String getAnimal_Name() {
		return Animal_Name;
	}


	public void setAnimal_Name(String animal_Name) {
		Animal_Name = animal_Name;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public String getHealth() {
		return Health;
	}


	public void setHealth(String health) {
		Health = health;
	}


	public int getTimesToFeedADay() {
		return TimesToFeedADay;
	}


	public void setTimesToFeedADay(int timesToFeedADay) {
		TimesToFeedADay = timesToFeedADay;
	}


	public int getAmountToFeedEachTime() {
		return AmountToFeedEachTime;
	}


	public void setAmountToFeedEachTime(int amountToFeedEachTime) {
		AmountToFeedEachTime = amountToFeedEachTime;
	}


	public String getNote() {
		return note;
	}


	public void setNote(String note) {
		this.note = note;
	}


	public void sleep() {
		
	}

	
	public void eat() {
		
	}

}
