package com.lec.spring.config02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.spring.Score;
import com.lec.spring.Student;

public class ConfigMain02 {
	public static void main(String[] args) {
		System.out.println("MAIN 시작");
		
		// 'JAVA 설정 파일' 사용한 컨텍스트 생성
		AnnotationConfigApplicationContext ctxA =
				new AnnotationConfigApplicationContext(AppConfig02.class);
		System.out.println("-- ctxA 생성 --\n");
		
		
		Score score1 = ctxA.getBean("score1", Score.class);
		System.out.println(score1);
		
		Student stu1 = null;
		stu1 = ctxA.getBean("stu1", Student.class);
		System.out.println(stu1);
		
		System.out.println(stu1.getScore() == score1);
		
		
		AppConfig02 cfg = new AppConfig02();
		System.out.println(cfg.score1() == cfg.stu1().getScore());
		
		
		ctxA.close();
	}
}








