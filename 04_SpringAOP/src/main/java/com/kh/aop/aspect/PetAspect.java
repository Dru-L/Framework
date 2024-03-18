package com.kh.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PetAspect {
//	@Around("execution(* com.kh.aop.pet.Dog.bark())")
//	@Around("execution(* com.kh.aop.pet.Pet.bark())")
//	@Around("execution(* com.kh.aop.pet.*.bark())")
//	@Around("execution(* com.kh.aop.pet.*.bark()) && !bean(cat)")//bean(): advice를 적용할 bean의 아이디를 적는곳
	@Around("execution(* com.kh.aop.pet.*.bark()) && !@annotation(com.kh.aop.annotation.NoLogging)")
	public String barkAdvice(ProceedingJoinPoint joinPoint) {
		String result = null;
		
		try {
			System.out.println("안녕?");
			result = (String) joinPoint.proceed();
			
			System.out.println(result);
			
		} catch (Throwable e) {
			System.out.println();
		}
		
		return result;
	}
}
