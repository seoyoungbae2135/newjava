package DAO;
// 20240123-5~6, 2024

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DTO.LoginHistory;
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
	
	// 회원정보 수정 20240125-7 웹페이지 내정보에서 이미지 불러오고 수정버튼 눌렀을때 dbeaver에 이미지이름 저장 및 static/image에 이미지가 들어오는 확인
	public void update(member user) {
		String sql="update member set name=? , tel=? where id=?";
		try {
			pt= conn.prepareStatement(sql);
			pt.setString(1, user.getName());
			pt.setString(2, user.getTel());
			pt.setInt(3, user.getNum());
			pt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("회원 정보 수정 실패");
			e.printStackTrace();
		}
	}
	
	//이미지 불러오기 20240125-4
	public void getPicture(member user) {
		String sql="select * from picture where member_id=? ";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, user.getNum());
			rs = pt.executeQuery();
			if( rs.next()) {
				user.setImage( rs.getString("img_name"));
			}
		}catch(SQLException e) {
			System.out.println("회원이미지 가져오기 실패");
			e.printStackTrace();
		}
	}
	
	//이미지 저장 20240125-3 
	public void pictureInsert(String img, int id) {
		String sql = "insert into picture(member_id, img_name) values(?,?)";
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1, id);
			pt.setString(2, img);
			pt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("이미지저장 실패");
			e.printStackTrace();
		}
	}
	
	//로그인 기록 불러오기 20240125-3
	public List<LoginHistory> getHistory(int id){ //컬렉션으로 불러오기 작업
		String sql="select * from loginhistory where member_id=? order by login_date desc"; //asc(내림차순) desc(오름차순)
		List<LoginHistory> list = new ArrayList<>();
		try {
			pt = conn.prepareStatement(sql);
			pt.setInt(1,  id);
			rs = pt.executeQuery();
			while(rs.next()) {
				list.add(new LoginHistory( rs.getInt("id"), rs.getString("ipaddr"), rs.getTimestamp("login_date")));
			}
			return list;
			
		}catch(SQLException e) {
			System.out.println("로그인기록 조회 실패");
			e.printStackTrace();
		}
		return null;
	}
	//로그인 기록 저장 20240125-3
	public void login_record(int id, String ip) {
		String sql="insert into loginhistory(member_id, ipaddr, login_date) "; //DB table에 저장할 객체생성
		sql += "values("+id+" , '"+ip+"', now() )";
		try {
			st = conn.createStatement();
			st.executeUpdate(sql);
		}catch(SQLException e) {
			System.out.println("로그인기록 저장실패");
			e.printStackTrace();
		}
	}
	
	//로그인 처리 메서드
	public member findByemailpw(String email, String pw) {
		
		String sql = "select * from member where email=? and pw=?";
		try {
			pt = conn.prepareStatement(sql);
			pt.setString(1, email);
			pt.setString(2, pw);
			rs = pt.executeQuery();
			if( rs.next()) { //참일경우 로그인 성공
				return new member(rs.getInt("id"), email, 
						rs.getString("name"), rs.getString("tel"));
			}
			
		}catch(SQLException e) {
			System.out.println("로그인 인증 데이터베이스 조회 실패");
			e.printStackTrace();
		}
		
		return null; //로그인 실패(이메일 또는 비번 틀림)
	}
	
	public String[] findAllEmail() {
		List<String> list = new ArrayList<>();
		String sql ="select email from member";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while( rs.next()) {
				list.add(rs.getString("email"));
			}
			if( list.isEmpty()) return null;
			else return list.toArray(new String[list.size()]);
		}catch(SQLException e) {
			System.out.println("이메일 조회 실패");
			e.printStackTrace();
		}
		return null;
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






