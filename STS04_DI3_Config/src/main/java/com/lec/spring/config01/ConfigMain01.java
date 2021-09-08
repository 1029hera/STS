package com.lec.spring.config01;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class ConfigMain01 {

	public static void main(String[] args) {
		System.out.println("Main시작");
		
		AbstractApplicationContext ctxA = 
				new GenericXmlApplicationContext("classpath:appCtx01_A.xml");
		System.out.println("-- ctxA 생성 --\n");
		
		Score score1 = (Score)ctxA.getBean("score1");
		System.out.println(score1);
		
		// 컨텍스트 객체는 여러개 만들수 있다
		AbstractApplicationContext ctxB = 
				new GenericXmlApplicationContext("classpath:appCtx01_B.xml");
		System.out.println("-- ctxB 생성 --\n");
		
		Score score2 = ctxB.getBean("score2", Score.class);
		System.out.println(score2);

		
		// 심지어, 여러개의 설정 파일로 부터 컨텍스트를 만들수 있다
		AbstractApplicationContext ctxAB =
				new GenericXmlApplicationContext(
						//"classpath:appCtx01_A.xml", "classpath:appCtx01_B.xml"
						"classpath:appCtx01_B.xml", "classpath:appCtx01_A.xml"
						);
		System.out.println("-- ctxAB 생성 --");
		
		Score score1_2 = ctxAB.getBean("score1", Score.class);
		Score score2_2 = ctxAB.getBean("score2", Score.class);
		
		System.out.println(score1_2);
		System.out.println(score2_2);
		
		System.out.println(score1 == score1_2); //???
		
		
		
		ctxA.close();
		ctxB.close();
		ctxAB.close();
	}

}








