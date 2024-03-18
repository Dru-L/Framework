package com.kh.di.pet;

public abstract class Pet {

	protected String name;

	public Pet() {
	}

	public Pet(String name) {
		this.name = name;
	}
	
	public abstract String bark(); //각 펫 종류마다 달라야하므로 추상 메소드

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
