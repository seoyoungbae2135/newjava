package thread_test1; //20240109-8 데몬쓰레드

import java.util.Scanner;

public class test4 {

	public static void main(String[] args) {
		Runnable r = new notepad();
		Thread th = new Thread(r);
		th.start();

	}

}

class notepad implements Runnable{
	@Override
	public void run() { // 메서드생성
		autoSave dm = new autoSave();
		dm.setDaemon(true); // 데몬쓰레드지정
		dm.start(); // 데몬쓰레드 시작
		
		System.out.println("주 쓰레드 시작");
		Scanner scan = new Scanner(System.in);
		while(true) {
			System.out.print("아무거나입력(x-종료) : ");
			String word = scan.nextLine();
			if(word.equals("x")) break;
		}
		
		System.out.println("주 쓰레드 종료");
	}
}

class autoSave extends Thread{  //데몬쓰레드로 만들기 위하여 주쓰레드에 autoSave 클래스 객체생성
	@Override
	public void run() {
		while(true) {
			System.out.println("자동저장 시작");
			System.out.println("자동저장 완료");
			try { sleep(5000);
			}catch(Exception e) { break; }
		}
	}
}

