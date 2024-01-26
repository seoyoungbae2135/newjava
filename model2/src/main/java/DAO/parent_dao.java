package DAO;
// 20240126-6
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class parent_dao {
	protected Connection conn=null; //접속
	protected Statement st=null; //sql 질의문
	protected PreparedStatement pt=null; //sql 질의문
	protected ResultSet rs=null; //결과
	
	public parent_dao() {
		DriverLoad();
		ConnectionDB();
	}
	private void DriverLoad() { // DB드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로드실패");
		}
	}
	private void ConnectionDB() {  // db 연결 메서드
		String url="jdbc:mysql://localhost:3306/ybsho62"; // dbeaver db ybsho62 url 
		String user="ybsho62";
		String password="123456";
		try {
			conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			System.out.println("데이터베이스접속실패");
		}
	}
}
