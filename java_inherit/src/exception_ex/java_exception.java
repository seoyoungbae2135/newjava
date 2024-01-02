package exception_ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;


public class java_exception {
	
	static Scanner scan = new Scanner(System.in);
	
	static String myAge(String birth) throws StringIndexOutOfBoundsException{  //try catch를 모두 주석처리하고 throws ~~ 처리한다(오류를 넘긴다)
//		Date today = new Date();   // 날짜를 다루는 Date 클래스, getXxxx() 메서드로 날짜
		
		Calendar today = Calendar.getInstance(); // import해야한다
		
//		System.out.println( today.get("년도 : "+Calendar.YEAR)); //년도를 호출
//		System.out.println( 1+today.get("월 : "+Calendar.MONTH)); //월은 1을 더한다
//		System.out.println( today.get(Calendar.DATE));
//		
//		System.out.println( today.get(Calendar.WEEK_OF_YEAR)); //몇째주인지 호출
//		
//		System.out.println(today.get(Calendar.DAY_OF_WEEK)); //요일호출 1=일요일
//		
//		today.set(2020,1,1); // 내가원하는 날짜로 세팅 월은 +1한다 1은 2월이다
//		System.out.println("이달의 마지막 날 : "+today.getActualMaximum(Calendar.DATE)); //세팅한 날짜의 마지막날 호출
				
		int year = today.get(Calendar.YEAR);
		String age = null;
		//try {
		
		//throw - 예외(오류)를 발생시키는 방법
		//  throw를 가지고있는 메서드는 반드시 throws가 있어야 한다
		//	throw를 통해 해당메서드가 어떤오류를 안고있는지 인지시켜줄 수 있고, 예외처리를 강요한다
		//	예외처리에 대한 관리를 용이하게 해준다
		//throws - 예외를 넘겨주는 방법
		
		if(birth.length() != 8) { //입력한 생년월일이 8자리가 아니라면
			throw new StringIndexOutOfBoundsException("method:myage - 생년월일은 8자리입력하세요");
		}
		if(!birth.matches("[+-]?\\d*(\\.\\d+)?")) { // 숫자확인하는 정규표현식 숫자와 소수점확인
			throw new NumberFormatException("method:myage - 숫자만 입력하세요");
		}
		int myYear = Integer.parseInt(birth.substring(0, 4)); // 문자열을 정수로 변경 = Integer.parseInt
		age = (year-myYear) + "세";
		return age;
		//}catch(Exception e) {
			//System.out.println("올바른 생년월일을 입력하세요(19990101)");
		//}		
		//return age;
		
//		finally {  // try구문에서 오류가 발생하거나 발생하지 않아도 무조건 실행되는 구문
//			return "0세";
//		}
		

		
//		System.out.println( 1900+today.getYear() ); //년도를 나타내기위하여 1900을 더한다. 1900년 이전은 1900 - 
//		System.out.println( 1+today.getMonth() ); //월을 나타내기위하여 1+를 한다
//		System.out.println( today.getDate() ); //날짜를 나타낸다
		

	}

	public static void main(String[] args) {
		
		//자동 자원 반환 예외처리 - 파일열기와 같은 외부파일을 사용하게될 겅우
		//					사용한 메모리와 cpu듣등을 close를 통해 반환해야한다.
		//					자동자원반환 예외처리는 코드의 복잡성을 줄여준 예외처리이다
		// try ( 파일열기){
		// }catch(예외클래스){
		// }
			
		try (BufferedReader bf = new BufferedReader(new FileReader("c:/test/book.txt"))) //파일 읽어오기
		{
			while(true) { //파일의 마지막까지 읽고 정지하는 반복문
				String line = bf.readLine();
				if(line==null) break;
				System.out.println( line );
			}
		}catch(Exception e) {
			System.out.println("파일로드및 반환실패");
		}
		
//		BufferedReader bf = null; 자동자원반환예외처리를 사용하지않을 경우 이와같이 복잡해진다 이하106줄까지
//		try {
//			bf = new BufferedReader(new FileReader("c:/test/book.txt")); //파일을 읽고 쓰고에 사용하는 클래스 import해야한다
//			System.out.println( bf.readLine());
//			System.out.println(bf.readLine());
//			
//			// bf.close();  //열기내부에서 파일닫기를 할 경우, 오류가 나면 실행이 안되므로 파일닫기가 안된디
//			
//		}catch(Exception e) {   // 파일불러오기는 try catch를 적용해야한다
//			System.out.println("파일읽기 실패");
//		}finally {
//			try {
//				bf.close();
//			}catch(Exception e) {
//				System.out.println("파일닫기실패");
//			}
//		}
		
		
//		try {  //finally를 사용하지않을 경우 따로 try처리를 해야한다
//		bf.close(); // 파일닫기도 try catch를 해야한다
//		}catch(Exception e) {
//			
//		}
		
		
//		String birth = null;
//		
//		System.out.print("생년월일 : ");
//		birth = scan.nextLine();
//		
//		try {  // throws 처리하고 해당메서드를 실행하는 위치에 try catch 처리한다
//			String age = myAge(birth);
//			System.out.println( age );
//		}catch(Exception e) {
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
		
		//예외처리 
//		String name = null;
//		int score = 0;
//		int[] num = {};
//		try {
//			score = scan.nextInt();
//			
//			System.out.println("이름 : "+ name.concat("님"));
//			System.out.println( score/ num.length);
//		}catch(java.lang.NullPointerException n) {  //값이없는 오류에 대한 오류처리메서드 NullPointerException
//			System.out.println("이름을 입력하세요");
//			
//		}catch(java.lang.ArithmeticException e) {
//			System.out.println("성적을 입력하세요");
//		}catch(Exception e) { //최상위 오류 예외처리 메서드
//			e.printStackTrace(); //개발과정에서 오류를 확인하기위한 코드 개발완료후 주석처리
//		}
//		
//		System.out.print("정상실행"); //오류발생시 try내부는 실행이 중지되지만 try catch 외부는 실행이 진행된다.
		
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
