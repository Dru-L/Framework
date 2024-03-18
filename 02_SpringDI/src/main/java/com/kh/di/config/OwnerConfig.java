package com.kh.di.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kh.di.owner.Owner;
import com.kh.di.pet.Dog;
import com.kh.di.pet.Pet;

@Configuration
public class OwnerConfig {
	
	@Bean(name = "lim")
	public Owner owner(@Autowired Dog dog) {
//		return new Owner("임꺽정", 30, cat());
		return new Owner("임꺽정", 30, dog);
	}
	
	@Bean
//	public Owner kim(@Autowired @Qualifier("dog") Pet pet) {
//	public Owner kim(@Autowired Pet pet) {
	public Owner kim(Pet pet) { //무조건 실행시켜야하기때문에 autowired를 안써도 실행된다.
		Owner owner = new Owner();
		
		owner.setName("김철수");
		owner.setAge(27);
//		owner.setPet(dog());
		owner.setPet(pet);
		
		return owner;
	}
}
