package com.lec.spring.aop03;

import org.aspectj.lang.annotation.*;

@Aspect
public class LogAspect3 {

	@Pointcut("within(com.lec.spring.aop03.*)")
	public void pc1() {}
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {}
	
	@Pointcut("execution(* com.lec.spring.aop*.My*.*Action(..))")
	public void pc3() {}

	@Pointcut("execution(* com.lec.spring.*3.My*.do*(..))")
	public void pc4() {}
	
	//@Before("pc1()")
	//@Before("pc2()")
	//@Before("pc3()")
	//@Before("pc4()")
	//@Before("pc1() || pc2()")
	//@Before("pc1() && pc2()")
	@Before("!(pc3() && pc4())")
	public void beforeAdvice() {
		System.out.print("[Advice] ");
	}
}











	

