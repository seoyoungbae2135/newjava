package inner;

import inner.computer.vga;

interface a{  // 익명클래스를 사용하기위하여 interface 적용
	public void view();
	public void haha();
}
class b{
	public void show() {
		System.out.println("나는 클래스B의 메서드다.");
	}
}




public class java_inner {

	public static void main(String[] args) {
		
		a a1 = new a() {
			@Override
			public void view() {
				System.out.println("나는 인터페이스를 이용한 익명클래스");
			}
			public void haha() {
				System.out.println("추가적인 메서드 구현도 가능");
			}
		};
		
		a1.view();
		a1.haha();
		
		b b1 = new b() {
			@Override
			public void show() {
				System.out.println("나는 익명 클래스입니다.");
			}
		};
		
		b1.show();
		
				
		
		computer com = new computer();
		
		com.print();
		
		computer.ram r = new computer().new ram(); // 내부 인스턴스 클래스의 실행 
		r.print();
		
		computer.vga v = new vga(); //내부 static 클래스는 import해서 실행
		
		com.OS_install();
	}

}

//내부 클래스
//	클래스내부에 인스턴스변수 클래스변수 선언하듯이 내부에 클래스를 정의하는 것
//	하나의 클래스가 여러 클래스와 관계(상속, 포함)를 맺지않고 하나의 특정 클래스와만
//	관계를 맺고 싶다면 외부에 클래스를 작성해서 관계를 맺는게 아니고 내부 클래스로 만들면 된다

// 내부클래스로 작성하면 클래스를 논리적으로 그룹화 할 수 있다
// 

/*
 * class car{
 * 
 * 		class wheel{ 내부클래스는 다른 외부 클래스에서 사용불가
 * 
 * 		}
 * 		class glass{
 * 
 * 		}
 * 		class hood{
 * 
 * 		}
 * }
 * 
 * 
 * 
 * 
 *  
 *  
 *  
 *
 */
