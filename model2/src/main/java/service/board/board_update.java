package service.board;
//20240130-1 게시판 수정
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;

public class board_update implements board_action{
	private board_dao dao=new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String title = request.getParameter("title");
		String email = request.getParameter("email");
		String lang = request.getParameter("lang");
		String content = request.getParameter("content");
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		board b = new board(0, title, null, email, lang, content);
		b.setId(id);
		dao.update(b);
		
		response.sendRedirect("/board_read.do?id="+id);//sendRedirect를 이용 변경된 내용을 다시 불러온다
		
		return null;
	}
}
