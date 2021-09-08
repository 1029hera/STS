package com.lec.spring.di03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Score;

public class DIMain03 {

	public static void main(String[] args) {
		System.out.println("Main 시작");

		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:scoreCtx.xml");
		System.out.println("컨테이너 생성");
		
		Score score = null;
		
		score = ctx.getBean("myScore1", Score.class);
		System.out.println(score);
		
		score = (Score)ctx.getBean("myScore2");
		System.out.println(score);
		
		System.out.println(ctx.getBean("myScore3"));
		System.out.println(ctx.getBean("myScore4"));
		System.out.println(ctx.getBean("myScore5"));
		System.out.println(ctx.getBean("myScore6"));
		System.out.println(ctx.getBean("myScore7"));
		
		ctx.close();
		System.out.println("Main 종료");
	}

}
