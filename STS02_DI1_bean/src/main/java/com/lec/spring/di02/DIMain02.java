package com.lec.spring.di02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.MessageBean;

public class DIMain02 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		
		// 스프링 설정파일 resource 명시
		String configLocation = "classpath:appCtx.xml";
		
		// ApplicationContext 객체를 만드는 시점에서 bean 객체가 생성된다. 확인해보자 (생성자!)
		AbstractApplicationContext ctx =
				new GenericXmlApplicationContext(configLocation);
		System.out.println("컨테이너 생성!");
		
		
		// 외부에서 만들어진 객체가 주입(Injection)
		MessageBean msg = ctx.getBean("messageBean", MessageBean.class);
									// ↑ bean 의 id 값이다, ↑ bean 의 타입 (다형성 적용되었음에 주목!)
		
		msg.sayHello();
		
		ctx.close();
		System.out.println("Main 종료");

	}

}
