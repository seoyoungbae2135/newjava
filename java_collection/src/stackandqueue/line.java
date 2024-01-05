package stackandqueue; //20240104

import java.util.Scanner;
import java.util.Stack;

public class line {
	static Scanner scan = new Scanner(System. in);
	public static void main(String[] args) {
//		Stack<String> stack = new Stack<String>(); //콜렉션에 있는 클래스이므로 <타입> 지정을 해야한다.
		
//		stack.push("치즈버거");  // 데이터 입력시 push 사용
//		stack.push("한우불고기");
//		stack.push("모짜렐라인더버거");
//		stack.push("데리버거");
//		stack.push("새우버거");
//		
//		System.out.println( stack );
//		System.out.println( stack.pop() ); // 마지막데이터 출력(출력하면 stack에서 없어진다)
//		System.out.println( stack.empty() ); // stack에 데이터 유, 무 출력- 있으면 false
//		System.out.println( stack.peek() ); // 
//		System.out.println( stack.search("데리버거") );
		
		Stack<String> back = new Stack<String>();
		Stack<String> front = new Stack<String>();
		String now = "네이버메인";
		
		// 네이버에서 페이지이동시 스택에 저장되는 방법 구현
		while(true) {
			now = pageMove(back, front, now);
		}
	}
	
	static String pageMove(Stack<String> back, Stack<String> front, String now) {
		System.out.print("이동할 페이지 입력(뒤-1, 앞-2) : ");
		String url = scan.nextLine();
		
		if( url.equals("1") ) {
			if( back.empty() ) {
				System.out.println("방문한 페이지가 없습니다.");
				url=now;
			}else {
				url=back.pop();
				front.push(now); // 현재값이 front에 저장
			}
		}
		else if( url.equals("2") ) {
			if( front.empty() ) { // 프론트가 비어있다면
				System.out.println("방문한 페이지가 없습니다"); //출력
				url=now;
			}else { //프론트에 방문한 페이지가 있다면
				url = front.pop(); // front데이터 출력
				back.push( now ); // 현재페이지를 back 에 입력
			}
		}else {
			back.push(now);
		}
		
		System.out.println("현재페이지 : "+url);
		System.out.println("\n=========뒤==========");
		System.out.println( back );
		System.out.println("\n=========앞==========");
		System.out.println( front + "\n\n" );
		
//		back.push(now); // 현재페이지 back에 입력
		
		return url;
	}

}

// stack -선형자료구조이며 FILO (첫번째 입력된 값이 마지막에 출력된다)
//								  LIFO (마지막에 입력된 값이 첫번째로 출력된다)
//		사용처 - 계산기, 프로그램의 실행취소 및 되살리기, 웹브라우저의 뒤로 앞으로버튼 등등
//		스택에서 입력은 push, 출력은 pop
