package service;
// 20240123-6

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.member_dao;
import DTO.member;

// 20240123-5

public class member_service {

	private member_dao mdao = new member_dao();
	
	public String insert(HttpServletRequest request, HttpServletResponse response) throws IOException  { //throws IOException - try catch 대신 적용(넘기는  
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pin");
		String name = request.getParameter("name");
		String tel = request.getParameter("tel");
		
		mdao.insert( new member(email, pw, name, tel) );
		
		response.sendRedirect( "/members?cmd=signIn" ); // 로그인 후 보여줄 페이지 주소
		
		return null;
	}
}
