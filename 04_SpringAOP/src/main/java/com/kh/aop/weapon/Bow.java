package com.kh.aop.weapon;

public class Bow extends Weapon {

	public Bow(String name) {
		super(name);
	}
	
	@Override
	public String attack() {
		return "활을 쏜다.";
	}

	@Override
	public String toString() {
		return "Bow [name=" + name + "]";
	}

}
