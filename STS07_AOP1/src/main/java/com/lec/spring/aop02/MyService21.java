package com.lec.spring.aop02;

import com.lec.spring.beans.Service;

public class MyService21 extends Service{

	@Override
	public void doAction() {
		// 공통기능 코드가 없다!?
		
		// 핵심기능
		printInfo();
		
	}

}
