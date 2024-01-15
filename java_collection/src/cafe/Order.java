package cafe; //20240105-3

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Order { //
	
	static Scanner scan = new Scanner(System.in);
	
	// 전체 메뉴 보여주는 메서드 - 분류(커피,음료,치노) 선택 -> 해당분류에서 제품이름입력하여 주문
	// 커피메뉴를 선택하여보다가 음료메뉴를 보고싶으면 이동하여 보이게 해줘야한다.
	public static void kiosk(HashMap<Category,Set<menu>> cafeMenu ) { //Order_Count.java의 classTask를 가져온다
		System.out.println("\n==========주문==========\n");
		Category main = Category.커피;
		while(true) {
			System.out.println("1.커피 2.음료 3.빽스치노");
			// System.out.println( cafeMenu.get(main)); //코드동작 확인 용 
			Set<menu> list = cafeMenu.get(main);
			Iterator<menu> tmp = list.iterator();
			while( tmp.hasNext()) {
				System.out.println( tmp.next());
			}
			System.out.print( "주문메뉴 선택 및 항목선택 : ");
			String input = scan.nextLine();
			//메뉴를 입력했는가?, 분류번호를 입력했는가?
			if( isInteger( input)) //정수변환가능 - 분류번호 입력
				main = SelectCategory(file.i(input)); // 참이면(정수를입력했다면) main참조변수를 변경
			else   // 메뉴를 입력했다면
			{	
				progress(input ); // 입력한 메뉴를 넘겨준다
				break;
			}
		}
	}
	
	// 주문 진행하는 메서드 : 주문할 제품을 선택했다면 결제 진행까지 되는 메서드
	private static void progress(String orderMenu) {
		if( Order_Counter.Menu.containsKey(orderMenu) ) { //내가선택한 메뉴가 map의 키값인가?
			
			menu select = Order_Counter.Menu.get(orderMenu); //내가선택한 메뉴의 Menu클래스 객체
			//핫? 아이스?, 추가선택유도 
			int price = 0;
			if( select.getCost1() !=0 && select.getCost2() !=0 ) {
				System.out.print("1.HOT  2.ICE : ");
				int HI = scan.nextInt();
				price = HI == 1? select.getCost1() : select.getCost2();
			}else {
				price = select.getCost1() !=0 ? select.getCost1() : select.getCost2();
			}
			DecimalFormat df = new DecimalFormat("\u20A9###,###원"); // 금액(숫자)에 1000단위마다 , 표시. \u20A9는 유니코드
			System.out.println("\n====== 주문내역 ======\n");
			System.out.println( select );
			System.out.printf("카페인 : %dmg , 칼로리 : %dkcal , 용량 : %dml \n", 
					select.getCaffeine(), select.getCalorie(), select.getMl());
			System.out.println(" 결제금액 : "+df.format(price));
			
			save_history( select.getMenu_name(), price );
		}
		//내가선택한 메뉴가 map의 키값이 아니라면 다시 메뉴를 선택하게 해줘야 한다.
	}
	
	// 주문내역을 Order_history를 통해 저장 메서드
	private static void save_history(String menu, int price) {
		String id = Order_Counter.user.getId();
		
		String url = "jdbc:mysql://localhost:3306/ybsho62";// mySQL 연결하기위해 필요한 사항 dbeaver에서 가져온다. 띄어쓰기있으면 안됨
		String user = "ybsho62";
		String password = "123456";
		
		try {  // 드라이버 로드에러발생 가능성있으므로 try catch 적용
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버 로드. mysql은 버전이 바뀌면 ("내용들이")이 변경되므로 안되면 찾아봐야한다
		}catch( ClassNotFoundException e) {
			System.out.println("드라이버 로드실패");
		}
		
		Connection conn=null; //임폴트는 java.sql, mysql접속상태값저장
		ResultSet set=null; //mysql로부터 데이터를 받는다.
		PreparedStatement pt=null; //mysql에 query문 전달. pt:찬조변수, query문 전달명령어는 7종류가 있다
		//PrepardStatement는 병렬전송이다. 데이터베이스사용은 예외처리를 반드시 해야한다(try catch)안하면 오류
		try {  // 접속에러발생이 있을수있으므로 try catch 적용
			conn = DriverManager.getConnection(url,user,password); //
			System.out.println("접속성공");
		}catch(SQLException e) {
			System.out.println("접속실패");
			e.printStackTrace();
		}
		
		//데이터베이스에 데이터저장 쿼리 만들어서 전달
		
		// insert into 테이블명 (컬럼명,컬럼명,....) value(?,?,?,....) ?는 컬럼갯수에 맞춰서 넣는다.
		String sql="insert into history(customer, menu, price) values(?,?,?)"; // (customer, menu, price)에 values(?,?,?)를 넣겠다
		//데이터베이스 데이터저장쿼리도 예외처리 필수
		try {
			pt = conn.prepareStatement(sql); //prepareStatment는 PrepardStatement를 사용하기위한 객체
			pt.setString(1, id ); //첫번째 물음표에 들어갈 내용
			pt.setString(2, menu); //2번째물음표
			pt.setInt(3, price);
			
			pt.executeUpdate(); // 데이터베이스에 쿼리문 전달
			System.out.println("데이터저장성공");
		}catch(SQLException e) {
			System.out.println("데이터삽입실패");
			e.printStackTrace();
		}
	}
	
	private static Category SelectCategory(int num) {
		switch(num) {
		case 1: return Category.커피;
		case 2: return Category.음료;
		case 3: return Category.빽스치노;
		}
		return Category.커피;
	}
	// isInteger 메서드 생성
	private static boolean isInteger(String str) {// is가붙는 이름은 참, 거짓을 나타내는 메서드나 함수이름에 일반적으로 붙여사용 , has는 있냐? 없냐? 에 붙여 이름짓는다
		try {
			Integer.parseInt(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
		
}

















