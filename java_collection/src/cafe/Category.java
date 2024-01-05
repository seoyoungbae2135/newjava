package cafe; //20240105-4

public enum Category {
		//A,B,C    // 상수생성. 기본적으로 0, 1, 2 가 입력된다
	커피, 음료, 빽스치노  // 커피:0, 음료:1, 빽스치노:2 와같이 기본적으로 순차적 값을 갖는다 
	
//	final private int num;  // 상수값을 변경하려면 변수를 만들고 
//	private Category(int num) { //메서드와같이 만들어야한다
//		this.num=num    // 그리고 상수에 커피(10) 와 같이 숫자를입력한다
//	}
}

// enum - 열거형
//		enum에 생성된 요소들의 값을 변경하려면 클래스의 생성자 메서드 사용법과 동일하게 해야한다 
//상수에 이름을 부여하여 사용할 수 있도록 해주는 방법 - enum
//자바스크립트에서 상수선언 - const num = 10;
//자바에서 상수선언 - final int num=10;
