package com.lec.spring.aop01;

import com.lec.spring.beans.Logger;
import com.lec.spring.beans.Service;

public class MyService12 extends Service{

	
	@Override
	public void doAction() {
		new Logger().logIn();  // 공통기능
		
		// 핵심기능
		System.out.println("MyService12 의 doAction()");
		
		new Logger().logOut();   // 공통기능
	}

}
