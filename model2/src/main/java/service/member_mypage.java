package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.member_dao;
import DTO.LoginHistory;
import DTO.member;

//20240124-4

public class member_mypage implements member_action{
	private member_dao dao = new member_dao();
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//현재 로그인항 회원의 정보는 세션객체의 user에 저장되어있다.
		member user = (member)request.getSession().getAttribute("user"); //member type으로 강제 형변환 ->(member)
		//로그인 기록을 가져오기위해 
		List<LoginHistory> login_list = dao.getHistory( user.getNum() );
		
		request.setAttribute("login_list", login_list);
		request.setAttribute("prt", "member/info");
		return "/";
	}

}
