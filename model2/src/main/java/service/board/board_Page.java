package service.board;
//20240126-5
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class board_Page implements board_action{
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//로그인 안했을때 주소입력하여 강제 진입시 없는 페이지로이동하고 alert띄움, 잘못된 접근에 사용
		if(request.getSession().getAttribute("user")==null) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("" + "<script>alert('로그인후 이용하세요'); history.back();</script>" );
			return null;
		}
		request.setAttribute("prt", "board/write");
		
		return "/";
	}
}
