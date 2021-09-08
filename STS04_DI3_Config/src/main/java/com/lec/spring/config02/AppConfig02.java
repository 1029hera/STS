package com.lec.spring.config02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.Score;
import com.lec.spring.Student;

//JAVA 를 이용한 DI 설정
//클래스 이름앞에 반드시 어노테이션 명시 필요
//@Configuration --> 이 클래스는 '스프링 설정'에 사용되는 클래스 입니다. 
//결국 IOC 컨테이너 역할을 하게 됨
@Configuration
public class AppConfig02 {

	@Bean
	public Score score1() {   // bean 의 id(name) 가 score1 인 bean 생성, 타입은 Score
		return new Score(100, 80, 75, "좋아요");
	}
	
	@Bean
	public Student stu1() {  // bean 의 id(name) 이 stu1 인 bean 생성, 타입은 Student
		return new Student("홍길동", 34, score1());
	}
	
}

















