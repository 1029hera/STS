package com.lec.spring.di04;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("Main4 시작");

		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:studentCtx.xml");
		System.out.println("컨테이너 생성\n");
		
		Student stu1 = (Student)ctx.getBean("Choi");
		System.out.println(stu1);
		Student stu2 = (Student)ctx.getBean("Moon");
		System.out.println(stu2);
		
		System.out.println();
		
		// 생각해볼문제
		stu2.getScore().setKor(100);
		System.out.println(stu2);
		System.out.println(stu1);
		
		ctx.close();
		System.out.println("Main4 종료");
	}

}



