package control;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.board.board_action;

/** 20240126-1 member_control과 동일하게 작성 단 member_ ... 부분은 board_ ...로
 *  주석은 member_control참조
 * Servlet implementation class board_control
 */
@WebServlet("/board_control")
public class board_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private Map<String, board_action> target = new HashMap<>();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public board_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		ResourceBundle rb = ResourceBundle.getBundle("class_bundle/board"); // 20240124-4 수업 properties파일을 가져오는 
		Enumeration key = rb.getKeys(); // 
		while( key.hasMoreElements()) { // 다음에 있는가 check
			String k = (String)key.nextElement(); //signup, signupSave, myPage ...등등
			String value = rb.getString(k); //member.properties의 키에 맞는 value 가져오기
			try {                          // 
				Class<?> hcl = Class.forName(value); //문자열을 클래스화 시켜준 것(객체 생성하려면 클래스가 메모리에 로드되어야 한다.)
				board_action hinst = (board_action)hcl.newInstance(); //객체생성
				target.put(k, hinst);
			}catch(Exception e) {
				System.out.println("board.properties 파일작업 실패");
				e.printStackTrace();  // 20240124-4 수업
			}
		}
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); 
		
		String cmd = uri.substring(1);
		String view ="/";
		
		board_action brd = target.get(cmd);
		view = brd.action(request, response);
		
		if( view != null) {
			RequestDispatcher rds = request.getRequestDispatcher(view); //제공할 페이지 
			rds.forward(request,  response); 
		}
	}

}
