package inherit_test;

public abstract class house {  //class 전단에 abstract -> 추상메서드 정의  
	
	public static int makedate=20231209; //클래스변수
	
	public boolean onoff;  // 다른 패키지에있는 자식클래스에서도 사용하려면  
	String brand;
	public int sn=10000; //시리얼넘버
	
	protected house(){ // 기본 생성자 메서드
		onoff=false;
		System.out.println("나는 부모 house 클래스 생성자");
	}
	
	protected house(String brand){ 
		this.brand= brand;
	}
	
//	void power() {  //오버라이딩을 하기위하여 부모클래스에 해당 메서드가 있어야한다
//		onoff = !onoff;
//		System.out.println( "전원 : " + onoff);
//	}
	public abstract void power(); //추상메서드 -> 부모클래스는 오버라이딩을 실핼하지는 않기때문에 메모리를 절약하기위하여 추상메서드 처리한다.
	//추상메서드를 가진클래스는 반드시 추상클래스가 되어야 한다.
	
	//부모클래스가 추상클래스라면 자식클래스는 부모의 모든 추상클래스를 구현해야한다
	//부모에게받은 추상메서드를 자식이 구현하지 않는다면 자식클래스는 추상클래스가 되어야한다
	//추상클래스는 객체생성이 안된다
	//추상메서드는 내용이 없는 메서드라서 메모리 공간을 할당받지 못한다.
	//메모리공간을 할당받지 못하기때문에 추상메서드를 가진 클래스는 객체공간 할당 못받는다.
	
}