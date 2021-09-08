package com.lec.spring.di05;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class DIMain05 {

	public static void main(String[] args) {
		System.out.println("Main5 시작");

		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:studentCtx2.xml");
		System.out.println("컨테이너 생성\n");
		
		
		System.out.println(ctx.getBean("score1"));
		System.out.println(ctx.getBean("score2"));
		
		ctx.close();
		System.out.println("Main5 종료");

	}

}
