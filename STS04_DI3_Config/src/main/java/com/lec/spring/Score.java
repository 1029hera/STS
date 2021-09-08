package com.lec.spring;

import java.util.Arrays;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  // getter, setter, toString, equals, hashCode..
//@NoArgsConstructor // 기본생성자
//@AllArgsConstructor  // 모든 필드 생성자
public class Score {
	int kor;
	int eng;
	int math;
	String comment;
	
	public Score() {
		super();
		System.out.println("Score() 생성");
	}
	// ↑ 기본생성자가 없을때 어떤 일들이 발생하는지 보자
	
	public Score(int kor, int eng, int math, String comment) {
		super();
		System.out.printf("Score(%d, %d, %d, %s) 생성\n", kor, eng, math, comment);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.comment = comment;
	}
	
	public Score(int kor, int eng, String comment, int math) {
		System.out.printf("Score(%d, %d, %s, %d) 생성\n", kor, eng, comment, math);
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.comment = comment;
	}
	
	// 배열타입 매개변수의 생성자
	public Score(int [] arr) {
		System.out.printf("Score(%s)생성\n", Arrays.toString(arr));
		this.kor = arr[0];
		this.eng = arr[1];
		this.math = arr[2];
	}
	
	public void setXxx(int n) {
		this.math = n * 2;
	}
}



















