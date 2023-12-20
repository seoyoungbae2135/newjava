package study122001;  //packge이름이 다르면 import를 생성시켜야한다

import java.util.Arrays;

public class what_class {

	public static void main(String[] args) { //클래스메서드
		
		member.company="애플";
		
		member m1 = new member(); //member클래스의 인스턴스 생성
		m1.age=34;
		m1.name="이순신";
		m1.num=101;
		System.out.println(m1);
		m1.company="삼성";
		System.out.println(m1.company);
	}
		// TODO Auto-generated method stub
		//클래스 란 - 사용자 정의 데이터 타입
		//			기존의 기본 데이터 타입이 아닌 새로운 형태의 타입을 직접 정의하는 것
		//			기본 데이터 타입과의 차이점은 여러종류의 데이터를 다룰수도 있으며
		//			기능(메서드)을 정의 할 수 있다.
		//자바에서는 클래스중심으로 개발을 해야한다.(반드시는 아니고)
		
		// 변수 - 지역변수(중괄호안에서만들어지는 변수), 인스턴스변수, 클래스변수
		// 	인스턴스변수 - 클래스의 멤버변수(클래스 객체의 실제데이터를 저장하는 변수)
		// 	클래스변수 - 클래스의 전역변수 (공유변수)
		
//		car c1 = new car();  //c1은 참조변수로 주소만 저장한다, 클래스의 객체생성(인스턴스생성이 정확한표현)
//		c1.carNum=12300;  //변수입력
//		c1.carName="소나타"; //변수입력
//		
//		System.out.println( c1 ); // 주소만 출력된다 (출력값중 @ 다음이 주소) 아래 public String toString 메소드 적용하면 변수가 출력된다
//		System.out.println( c1.carName );
//		
//		car c2 = new car();
//		c2.carNum=32433;
//		c2.carName="제네시스";
//		
//		System.out.println(c2);
//		
//		car[] c = new car[10]; //배열로 만들수 있다, car 클래스의 참조변수공간 10개 만들어진다 인스턴스공간은 안만들어진다
//		
//		for(int i=0; i<c.length; i++) { // 인스턴스공간을 만들려면 for문 사용 
//			c[i] = new car();   //car클래스의 객체생성(인스턴스변수와 메서드 공간생성) 
//			c[i].carNum = i+10000+(int)(Math.random()*10000);
//			c[i].carName = "쏘렌토";
//		}
//		System.out.println( Arrays.toString( c ));
//	}

}


class car{ //클래스명이 car 인 클래스 정의, 클래스의 정의 부분이고 공간생성이 아니다.
	int carNum;   //인스턴스변수
	String carName;		//인스턴스변수
	
	public String toString() {  // 이와같이 하면 (c1) 만 해도 변수가 출력된다. toString메소드 사용 
		return carNum+" "+carName;
	}
}















