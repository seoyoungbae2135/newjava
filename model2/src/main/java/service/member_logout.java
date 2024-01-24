package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 20240124-4, 8

public class member_logout implements member_action{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException  {
		request.getSession().removeAttribute("user"); // 로그아웃 클릭시 현재화면 지우고
		response.sendRedirect("/");                   //  처음화면으로 복귀
		return null;
	}

}
