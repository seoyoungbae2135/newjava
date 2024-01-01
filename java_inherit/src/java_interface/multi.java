package java_interface;

public class multi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsbCable k = new keyboard(); //
		k.plugNplay();
		k.keyValue();
		
		Bluetooth k1 = new keyboard();
		k1.SetBluetooth();
		k1.keyValue();
		
		keyboard k2 = new keyboard();
	}

}

interface Passing{
	public void keyValue(); // 키보드값 받아오기
}


interface UsbCable extends Passing{ // passing메서드를 연결하기위하여 extends Passing 
	public void plugNplay();
}

interface Bluetooth extends Passing{
	public void SetBluetooth();
}
interface Wifi extends Passing{
	public void DirectWifi();
}

class keyboard implements UsbCable, Bluetooth, Wifi{
	
	@Override
	public void keyValue() {
		System.out.println("키보드 값 받음");
	}
	
	@Override
	public void plugNplay() {
		System.out.println("꽂으면 바로 사용가능");
	}
	@Override
	public void SetBluetooth() {
		System.out.println("블루투스 연결하여 들록하면 사용가능");
	}
	@Override
	public void DirectWifi() {
		System.out.println("다이렉트 와이파이 활성화해서 연결 후 사용");
	}
}

// 자바의 다중상속
// 자바에서 클래스들의 상속은 단일상속만 가능하다.
// 자바에서 다중상속은 인터페이스들을 사용한다.
// 다중상속을 통해서 다양한 다형성을 구현할 수 있다

// 키보드 구매 했다
// 컴퓨터와 연결방식 - usb, 블루투스, 리시버, wifi, 
// git hurb


// pc웹또는 모바일웹 UI 설계 - 피그마
// 주제:동물원
// 페이지 수 : 3페이지 (메인페이지. 서브페이지 2개)
// 각 페이지 표현할 내용은 알아서 제한없이
// 아이디어 창의성 색의 조화가 가장 우수한 조는 gift





