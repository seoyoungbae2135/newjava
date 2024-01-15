package thread_test1; //20240109-7 yield 메서드

public class test3 {

	public static void main(String[] args) {
		Runnable r1 = new yield_th();
		Thread th1 = new Thread(r1);
		
		th1.start();
		for(int i=1; i<=10; i++) {
			System.out.println("main 메서드"+ i);
			
			if(i==7) yield_th.isOk=true;
			try { Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}

}

class yield_th implements Runnable{
	static boolean isOk = false;
	
	@Override
	public void run() {
		int i=1;
		while(true) {
			if( isOk) {
				System.out.println(" 쓰레드 작업 시작한다.! ");
			}else {
				Thread.yield(); // yield 메서드 적용하여 
			}
			System.out.println("2번째 쓰레드 "+i);
			i++;
			try { Thread.sleep(1000);
			}catch(Exception e) {}
		}
	}
}

