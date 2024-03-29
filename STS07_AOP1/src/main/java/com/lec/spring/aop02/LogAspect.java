package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.spring.beans.Logger;

// Aspect = (Advice + PointCut)들을 모아놓은 클래스

@Aspect  // 이 클래스가 Aspect 역할을 하는 클래스
public class LogAspect {
 
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {}
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}
	
	
	
	//@Before("within(com.lec.spring.aop02.*)")
	@Before("pc1()")
	public void beforeAdvice() {
		System.out.println("[Before] ");
		new Logger().logIn();
	}

	//@After("within(com.lec.spring.aop02.*)")
	//@After("execution(* com.lec.spring.aop02.MyService22.*(..))")
	@After("pc2()")
	public void afterAdvice() {
		System.out.println("[After] ");
		new Logger().logOut();
	}
	
	// Around advice
	@Around("within(com.lec.spring.aop02.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
		// joinPoint 메소드 이름
		String signatureStr = joinPoint.getSignature().toShortString();
		
		// 1. joinPoint 메소드 수행전
		System.out.println("[Around] " + signatureStr + " 시작");
		
		long st = System.currentTimeMillis();  // joinPoint 시작시간 체크
		
		try {
			// 2. joinPoint 메소드 수행
			Object obj = joinPoint.proceed();   // 
			return obj;
		} finally {
			// 3. joinPoint 메소드 수행후
			long et = System.currentTimeMillis(); // joinPoint 종료시간 체크
			System.out.println("[Around] " + signatureStr + " 종료, 경과시간 : " + (et - st));
		}
	}
	
}

























