package com.kh.aop.pet;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog extends Pet {
//	public Dog() {
//	}

	public Dog(@Value("댕댕이") String name) {
		this.name = name;
	}

	@Override
	public String bark() {
		return "월월으르르를르ㅡㄹ월!!!!!";
	}
	
	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}

}
