package DAO;
// 20240123-5~6

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DTO.member;

public class member_dao {
	private Connection conn=null; //접속
	private Statement st=null; //sql 질의문
	private PreparedStatement pt=null; //sql 질의문
	private ResultSet rs=null; //결과
	
	public member_dao() {
		DriverLoad();
		ConnectionDB();
	}
	
	public void insert(member data) {
		String sql="insert into member(email, pw, name, tel) values(?,?,?,?)";
		try {
			pt=conn.prepareStatement(sql);
			pt.setString(1, data.getEmail());
			pt.setString(2, data.getPassword());
			pt.setString(3, data.getName());
			pt.setString(4, data.getTel());
			pt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("회원가입 데이터베이스 저장실패");
			e.printStackTrace();
		}
	}
	
	private void DriverLoad() { // DB드라이버 로드
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			System.out.println("드라이버로드실패");
		}
	}
	private void ConnectionDB() {
		String url="jdbc:mysql://localhost:3306/ybsho62";
		String user="ybsho62";
		String password="123456";
		try {
			conn=DriverManager.getConnection(url,user,password);
		}catch(SQLException e) {
			System.out.println("데이터베이스접속실패");
		}
	}
}






