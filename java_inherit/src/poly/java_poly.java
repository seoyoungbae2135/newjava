package poly;

import inherit_test.house;
import inherit_test.tv;

public class java_poly {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		house t = new tv("삼성"); // 다른패키지에서 사용하려면 import를 하고 해당 클래스에 protected을 적용해야한다
		t.power();  // 다른패키지에서 사용하려면 import를 하고 해당 클래스에 public을 적용해야한다
		
		System.out.println( t.sn );
		
		house fan1 = new fan("신일");
		
		System.out.println( fan1.sn );
		
		System.out.println( ((fan)fan1).sn );
		
		System.out.println( fan1.makedate );
		
		System.out.println( ((fan)fan1).makedate );// 

	}

}

//클래스의 변수나 메서드에는 일반적으로 public을사용한다.
//인스턴스변수는 private제어자로 생성하는게 좋다
//상속관계일때 부모클래스의 생성자는 protected
//부모클래스의 추상메서드는 public으로
//제어자를 붙여서 작성해야지 사용제한 설정할 수 있고 
//사용제한을 해줘야 실수방지및 불필요한 코드생성을 피할 수 있다

// 오버로딩 - 생성 - 동일한 클래스에서
// 오버라이딩 - 재정의 - 상속관계에서