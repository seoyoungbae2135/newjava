package java_interface;

public interface unit {
	
	public void move(); //interface에서는 abstract를 붙이지 않아도 추상메서드로 인식
	public void attack();
	public void dead();
	
// 추상클래스에는 abstract를 붙였지만 interface 는 붙이지 않아도 추상클래스이다
//	abstract class score{
//		abstract void method();
//	}
	
//	public final int run=10; //final 제어자가 붙은 변수(상수) 선언가능
//	public static void output() { //클래스메서드 정의 가능
//		
//	}
//	public void input() { //인스턴스메서드 정의블가
//		
//	}
//	
//	static int num=0; //클래스변수 선언가능하지만 초기값지정 필수
	//int num; 인스턴스 변수선언불가
}
