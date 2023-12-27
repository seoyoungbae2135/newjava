package poly;

import inherit_test.house;

public class fan extends house{
	
	public static int makedate=2023; //클래스가 다르기때문에 변수명이 같아도 2개가 다르게 존재한다.
	
	public int sn=1234;
	
	fan(){}
	fan(String brand){
		super(brand);
	}
	
	@Override
	public void power() { // 부모클래스(house)의 추상메서드를 
		onoff = !onoff;
	}

}
