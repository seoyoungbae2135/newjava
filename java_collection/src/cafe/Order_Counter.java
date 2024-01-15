package cafe; // 20240105

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import customer.Order_History;
import customer.member;



// 20240105-3

public class Order_Counter {
	static Scanner scan =new Scanner(System.in);
	static HashMap<String,menu> Menu = null; // List를 HashMap으로 변경	
//	static List<menu> Menu = null;  // List 일때
	static List<member> buyer = null;
	
	static member user = null;   //로그인 성공한 회원 객체 저장 참조변수

	public static void main(String[] args) {
		Menu = file.menu_load();
		buyer = file.member_load();
		
		//스토리 - 회원이 로그인하여 주문(모바일또는 PC) 한다.
		//		로그인부터 주문과정 까지를 제작 
		
		System.out.println( buyer.get(0).getId());
		// System.out.println( Menu.get(4).getMenu_name());
		
		user = login(); // login 반환
		
		//관리자 로그인시 관리자메뉴로만 보이게 주문안됨
		if(user.getMid()==1000000) {
			System.out.println("1. 판매내역");
			System.out.println("2. 메뉴관리");
			System.out.println("3. 재고관리");
			System.out.print("선택 : ");
			int sel = scan.nextInt();
			history_list(); // method 생성
			
		}else {
			//주문
			HashMap<Category, Set<menu>> cafeMenu = classTask(); //아래 HashMap return을 받는 메서드
			Order.kiosk(cafeMenu);
		}

	}
	
	private static void history_list() {
		//데이터베이스사용(연결)
		//1. 데이터베이스 드라이버 로드
		//2. 데이터베이스 connection - 데이터베이스 url, 데이터베이스 계정
		//						 - 데이터베이스 계정 비밀번호
		//3. 쿼리문(query 또는 sql질의문) 작성
		//4. 쿼리문 전달 - Statement, PreparedStatement
		//5. 쿼리문의 결과를 받아야한다면 ResultSet 필요
		
		try { //1. 데이터베이스 드라이버 로드
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) { //
			System.out.println("드라이버로드실패");
		}
		//2. 데이터베이스 connection - 데이터베이스 url, 데이터베이스 계정
		//						 - 데이터베이스 계정 비밀번호
		Connection conn=null; //연결하기위한 참조변수 (conn)를 만들어야한다
		try {
			String url="jdbc:mysql://localhost:3306/ybsho62";
			String user="ybsho62";
			String password="123456";
			conn = DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			System.out.println("접속실패");
			e.printStackTrace();
		}
		
		PreparedStatement pt = null;
		ResultSet res = null; // 결과를 받아야하므로 참조변수 필요
		
		//3. 쿼리문(query 또는 sql질의문) 작성		
		// select 컬럼명 from 테이블명; 와 같이 작성
		// select * from 테이블명 -> 모든 컬럼을 조회하기
		String sql="select * from history";  // 여기쿼리문은 ? 가없으므로 바로 쿼리전달
		List<Order_History> list = new ArrayList<>(); //가져온 db를 저장하기위한 list 참조변수 생성
		try {
			
			pt = conn.prepareStatement(sql); 
			res = pt.executeQuery(); //쿼리전달하고 결과받기 database값이 res로 들어온다
			
			while(res.next()) {  // 마지막data까지만 가져와서 res에 저장하기위한 반복문 
				Order_History data = new Order_History(  // 객체를만들고
						res.getInt("num"), res.getString("customer"),
						res.getString("menu"), res.getInt("price")
				);	
				list.add(data);//list에 저장한다
			}
			
		}catch(SQLException e) {
			System.out.println("데이터조회실패");
			e.printStackTrace();
		}
		//컬렉션 프레임워크 전용 순회 인터페이스 - Iterrator
		Iterator<Order_History> it = list.iterator();
		while( it.hasNext()) {
			System.out.println( it.next());
		}
		
				
	}
	
	public static HashMap<Category, Set<menu>> classTask(){
		Set<menu> 커피 = new HashSet<>();
		Set<menu> 음료 = new HashSet<>();
		Set<menu> 빽스치노 = new HashSet<>();
		
		Iterator<String> it = Menu.keySet().iterator();  // 여러곳에서 사용하기위하여 맵으로 분류한 것
		while(it.hasNext()) {
			String key = it.next();
			if(Menu.get(key).getType()==Category.커피) {
				커피.add(Menu.get(key));
			}else if( Menu.get(key).getType()==Category.음료) {
				음료.add(Menu.get(key));
			}else if(Menu.get(key).getType()==Category.빽스치노) {
				빽스치노.add(Menu.get(key));
			}
		}
		HashMap<Category, Set<menu>> map = new HashMap<Category, Set<menu>>();
		
		map.put(Category.커피, 커피);
		map.put(Category.음료, 음료);
		map.put(Category.빽스치노, 빽스치노);
		
		
		return map;
	}
	
	public static member login() {  //로그인 메서드
		System.out.println("\n==========로그인==========\n");
		System.out.print("아이디 : ");
		String id = scan.nextLine();
		System.out.print("비밀번호 : ");
		String pw = scan.nextLine();
		
		member temp = new member(id,pw);
		int idx=0;
		if((idx=buyer.indexOf( temp )) !=-1) { //아이디와 비밃번호가 일치하면
			System.out.println("로그인성공");
			return buyer.get( idx );
		}  //아이디와 비밀번호가 맞지않으면
			System.out.println("로그인실패");
		return login(); //로그인 실패시 다시호출 -> 재귀호출
		
		//ArrayList에 저장되어있는 객체들과 비교를 하기위해서는 
		//반복문을 통해 객체 하나씩을 가져와서 값 비교를 해준다.
		//또는 ArrayList에 저장된 객체의 클래스에 비교하기위한 관련 메서드를 구현한다.(equals)
	}
	
	

}
