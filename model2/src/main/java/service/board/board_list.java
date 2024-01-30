package service.board;
// 20240126-1~ 
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;

public class board_list implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// 20240129-4 게시글 10개씩 불러오기, 
		int page=1;
		int row=0;
		if(request.getParameter("page") !=null ) {
			page = Integer.parseInt( request.getParameter("page"));
		}
		
		row = (page - 1) * 10; 
		
		List<board> list = dao.Allselect( row ); //20240129-3
		
		int total = dao.DbCount();
		
		request.setAttribute("DBtotal", total); //20240129-4
		request.setAttribute("list", list); //20240129-3
		request.setAttribute("prt", "board/index");
		
		return "/";
	}
}
