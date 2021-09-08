package com.lec.spring.di01;

import com.lec.spring.MessageBean;
import com.lec.spring.MessageEng;

/*
	Dependency Injection (DI, 의존주입)
	필요한 객체는 누가 만들어 사용하나?
	
	방법1 : 직접 생성하여 사용
*/


public class DIMain01 {

	public static void main(String[] args) {
		System.out.println("Main 시작");
		MessageBean msg = null;
		
		// 필요한 MessageBean 객체를
//		msg = new MessageKor(); // 직접 만들어 (new) 사용
//		msg.sayHello();
		
		// 나중에 다시 설계 변경이 되어 다른 것을 수행하려면
		msg = new MessageEng();
		msg.sayHello();
		
		// 결국 Main을 재컴파일 해야 한다 (심지어 수정되어야 할 수도 있다)
		
		System.out.println("Main 종료");

	}

}
