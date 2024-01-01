package exception_ex;

import java.util.Scanner;

public class java_exception {
	
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		
		String name = null;
		int score = 0;
		int[] num = {};
		try {
			score = scan.nextInt();
			
			System.out.println("이름 : "+ name.concat("님"));
			System.out.println( score/ num.length);
		}catch(java.lang.NullPointerException n) {
			System.out.println("이름을 입력하세요");
			
		}catch(java.lang.ArithmeticException e) {
			System.out.println("성적을 입력하세요");
		}
		
//		try {
//			String name;
//			name = scan.nextLine();
//			System.out.println( name.charAt(0) );
//		}catch( Exception d ) {  // 예외처리 최상위 언어 Exception 만 적어도 처리된다. 여러개의 오류일 경우에도 사용. 특정오류에 대해서 다르게 처리하려면 오류내용 모두 기입해야한다
//			System.out.println("이름을 입력하새요");
//			
//		}
		
		
//		try {  //try안에 오류가 발생할 소지가 있는 코드를 넣는다.
//			int num = 10;
//		
//			System.out.println( num/0 );
//		
//			System.out.println("아무문제없다"); // 
//		
//		}catch(java.lang.ArithmeticException e) { // ()안에 오류명과 변수명을 넣는다
		
//			System.out.println(e.getMessage()); // 오류메세지 출력
//			e.printStackTrace(); //오류에 대한 상세내용 출력
//			System.out.println("0으로 나누기 할 수 없습니다"); // 사용자에게 나타내는 오류메세지
//		}
//		System.out.println("예외처리되었다");

	}

}
