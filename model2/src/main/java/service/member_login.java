package service;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.member_dao;
import DTO.member;
//20240124-4
public class member_login implements member_action{
	private member_dao dao = new member_dao(); // 데이터베이스를 사용하는 객체에 적용
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if( request.getParameter("cmd")==null) {
			request.setAttribute("prt", "member/signin");
			return "/";
		}else { //이메일과 비번으로 로그인 처리
			String email = request.getParameter("email");
			String pw = request.getParameter("pin");
			
			member user = dao.findByemailpw(email, pw);
			if( user == null) { //로그인 실패
				request.setAttribute("fail", "1");
				request.setAttribute("prt", "member/signin");
				return "/";
			}else { //로그인 성공
				dao.login_record(user.getNum(), request.getRemoteAddr()); //request.getRemoteAddr() -> 사용자 주소
				dao.getPicture(user);//이미지불러오기 20240125-8
				request.getSession().setAttribute("user", user);
			}
			response.sendRedirect("/");
			return null;
		}
	}

}
