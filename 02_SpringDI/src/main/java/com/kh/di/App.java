package com.kh.di;

import com.kh.di.owner.Owner;
import com.kh.di.pet.Cat;

public class App {
    public static void main( String[] args ){
    	// 생성자를 통한 의존성 주입
    	Owner owner = new Owner("홍길동", 25, new Cat("댕댕이"));
    	
    	System.out.println(owner);
    }
}
