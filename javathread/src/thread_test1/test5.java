package thread_test1; //20240109-8 동기화

public class test5 {

	public static void main(String[] args) {
		Runnable r = new myApp(); // 한개의 객체를 생성하여 2개의 쓰레드를 만들어 사용
		
		Thread th1 = new Thread(r); // 2개의쓰레드
		Thread th2 = new Thread(r);

		//쓰레드의 이름을 짓는다/
		th1.setName("1번");
		th2.setName("2번");
		
		th1.start();
		th2.start();
				
				
	}

}

// 자바스크립트에서 비동기문제해결을 위한 async 는 json함수에, 

class Bank{
	private int myMoney = 1000000;
	public int getMyMoney() {
		return myMoney;
	}
	
	// 쓰레드 동기화 임계영역 설정과 락 이 필요하다
	// 임계영역 - 둘 이상의 쓰레드가 동시에 접근해서는 안되는 코드부분
	// 쓰레드가 임계영역에 접근하면 해당쓰레드는 락을 가지게된다
	// 해당 쓰레드가 락을 반납하기전까지는 다른쓰레드는 임계영역에 접근하지못한다.
	// 메서드의 반환타입앞에 synchronized를 붙이거나
	// 특정코드를 블럭지정한다 -> synchronized(this){ 코드 }
	// withdraw 메서드 임계영역 설정 - synchronized
	public synchronized boolean withdraw(int money) { 
		//계좌 잔고가 출금할 금액보다 크기가 같으면 출금가능
		if(myMoney >= money) {
			try { Thread.sleep(1000); //실행딜레이를 위하여 try catch 사용
			}catch(Exception e) {}
			
			myMoney -= money;

			return true;
		}
		return false;
	}
}

class myApp implements Runnable{
	Bank my = new Bank();
	@Override
	public void run() {
		while( my.getMyMoney() > 0) {
			int money = (int)(Math.random()*5+1)*10000;
			
			boolean fail = my.withdraw(money);
			
			String thName = Thread.currentThread().getName();
			if(fail) {
				System.out.printf("쓰레드 : %s 출금 : %d원 잔고 : %d원\n",
						thName, money, my.getMyMoney());
				
			}else {
				System.out.println( thName +" 잔액부족");
			}
			
		}
			
		//System.out.println( Thread.currentThread().getName() ); // 쓰레드 이름 출력 
	}
}

