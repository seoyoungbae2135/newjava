package thread_test1; //20240109-4 Thread

public class test1 {

	public static void main(String[] args) {
		myThread th1 = new myThread(); // myThread 클래스의 객체생성
		th1.start(); // 쓰레드 실행 run이아니고 start로해야한다
		for(int i=1; i<=10; i++) {
			System.out.println("main메서드 "+ i);
			try { Thread.sleep(500);//천천히 동작하게하기위하여 Thread.sleep(1000)적용, try catch 필요
			}catch(Exception e) {}
		}
		
		Runnable th2 = new thread2();  // 2번째쓰레드클래스 동작 객체생성
		Thread th22 = new Thread(th2); // 별도의 Thread 객체를 만들어야 동작한다
		th22.start();
		

	}

}
//인터페이스로 쓰레드 클래스 만드는 2번째
class thread2 implements Runnable{ // 
	
	@Override
	public void run() {
		System.out.println("나는 인터페이스로 작업한 쓰레드일껄?");
		
	}
}

// myThread 클래스 생성 thread class를 상속받는다
class myThread extends Thread{ //메인 메서드외부에 class 생성, Thread 클래스의 자식클래스로해야한다
	@Override
	public void run() { // 메서드명은 run으로 해야한다
		for(int i=1; i<=10; i++) {
			System.out.println("나는 쓰레드");
			try { Thread.sleep(500);//try catch 필요
			}catch(Exception e) {}
		}
		
	}
}

//프로세스 - cpu에의해실행중인 프로그램
//			프로그램에 대한 정보를 가지고있다
//쓰레드 - 프로세스안에서 실질적으로 실행되는단위

//단일쓰레드 - 하나의 작업만 이루어지는 프로그램, 순차적실행
//멀티쓰레드 - 여러작업을 동시에 실행시키는 프로그램, 비동기
//			멀티쓰레드 사용시 공유자원에 대해 주의해야한다
//공유자원 - 

//쓰레드관련 메서드
//run() : 쓰레드의 실행코드가 작성되는 메서드 - 쓰레드 stack first input
//start() : 쓰레드가 시작되도록 요청하는 메서드 - run메서드를 호출한다.
//sleep(밀리세컨드) : 지정한 시간동안 현재 쓰레드를 일시 중지 시킨다. 멀티쓰레드에 적용
//join() : 현재쓰레드가 끝날때까지 기다린다. 멀티쓰레드에서 필요한 메서드. 멀티쓰레드에 적용
//yield() : 현재 쓰레드의 실행시간을 다른 쓰레드에게 양보한다. 멀티쓰레드에 적용
//데몬 쓰레드 : 주 쓰레드의 작업을 보조하는 쓰레드 
//			주 쓰레드가 종료되면 강제적으로 종료된다
//


