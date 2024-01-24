package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//20240124-4

public class member_mypage implements member_action{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setAttribute("prt", "member/info");
		return "/";
	}

}
