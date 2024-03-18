package com.kh.di.character;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.kh.di.weapon.Weapon;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*
 * properties 파일의 값을 읽어오는 방법
 * 1.@PropertySource 를 사용하는 방법
 * 	- Environment 객체를 통해서 character.properties에 설정된 값을 읽어온다.
 * 	- 스프링 프로퍼티 플레이스 홀더를 통해서 character.propertires에 설정된 값을 읽어온다.
 * 
 * 2.@PropertySource 를 생략하는 방법
 * 	- xml 설정 파일을 사용하는 경우
 * 		<context:property-placeholder/> 요소를 설정파일(root-context.xml)에 추가해준다.
 * 	- 자바 설정 파일을 사용하는 경우
 * 		PropertySourcesPlaceholderConfigurer 빈을 생성한다.
 */

@Component
@ToString
@Getter
//@RequiredArgsConstructor //final을 만들때 필수
//필드중에 No Null 이 있거나 final이 있는 필드를 초기화를 할 수 있는 생성자
//@PropertySource("classpath:character.properties")
public class Character {
//	@Value("이몽룡")  //필드에 값을 직접 주입하는 방법
	@Value("${character.name:이몽룡}") //${프로퍼티이름:기본값}
	//스프링 프로퍼티 플레이스 홀더를 사용해서 character.properties에 설정된 값을 읽어올 수 있다.
	private String name;
	
//	@Value("15")
	@Value("${character.level:15}")
	private int level;
	
//	1.필드를 통해서 빈을 주입받는 방법
	@Autowired(required = false)
	@Qualifier("sword") //기본값이 아닌 다른 빈을 넣고싶을때 직접 지정
	private Weapon weapon;
	
	
//	2. Setter 메소드를 통해서 빈을 주입받는 방법
//	@Setter(onMethod_ = @Autowired)
//	private Weapon weapon;
	
	//setter
//	@Autowired // 생략 불가능 (메소드 위에만 지정 가능)
////	@Qualifier("sword")
//	public void setWeapon(Weapon weapon) {
//		this.weapon = weapon;
//	}
	
//	3. 생성자를 통해서 빈을 주입받는 방법
//	private final Weapon weapon;
	
//	public Character(@Autowired Weapon weapon) { 
//	public Character(Weapon weapon) { //@Autowired 생략 가능
//		this.weapon = weapon;
//	}
	
	// Environment 객체를 통해서 character.properties에 설정된 값을 읽어올 수 있다.
//	public Character(/* @Autowired */ Environment env) {
//		this.name = env.getProperty("character.name");
//		this.level = Integer.parseInt(env.getProperty("character.level"));
//	}
	

	
}
