package thread_test1; // 20240109-6 join 메서드

public class test2 {

	public static void main(String[] args) {
		System.out.println("메인 메서드 push");
		Runnable r1 = new thread1();
		Thread th1 = new Thread(r1);
		th1.start();
		
		try {
			th1.join(); // join에 의해서 main 메서드의 실행이 대기 th1실행이 끝나고 아래실행
		}catch(Exception e) {
			
		}
		System.out.println(" main 메서드 pop");

	}

}

class thread1 implements Runnable{
	@Override
	public void run() {
		System.out.println("쓰레드 1번 메서드");
		two();
		System.out.println("1번 pop");
	}
	public void two() {
		System.out.println("쓰레드 2번 메서드");
		three();
		System.out.println("2번 pop");
	}
	public void three() {
		System.out.println("쓰레드 3번 메서드");
		System.out.println("3번 pop");
	}
}

