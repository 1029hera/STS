package com.lec.spring.aop01;

import com.lec.spring.beans.Logger;
import com.lec.spring.beans.Service;

public class MyService11 extends Service{

	// 전통적인 방법,  핵심기능 '안' 에 공통기능이 삽입되어 있는 형태.
	@Override
	public void doAction() {
		new Logger().logIn();  // 공통기능
		
		// 핵심기능
		System.out.println("MyService11 의 doAction()");
		
		new Logger().logOut();   // 공통기능
	}

}
