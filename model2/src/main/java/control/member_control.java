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

import service.member_action;
import service.member_service;

/** 20240122-8~ 20240123
 * Servlet implementation class member_control
 * //servlet class를 호출하는 주소 -> /members 에서 /member_control로 변경 20240124-2 수업참조
 */
@WebServlet("/member_control") 
public class member_control extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Map<String, member_action> target = new HashMap<>(); //20240124-4 수업참조
    /**
     *  private member_service ms = new member_service();  //20240124-4 수업참조
     */
    /**
     * @see HttpServlet#HttpServlet()
     */
    public member_control() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {  // init 객체는 한번만 동작
		ResourceBundle rb = ResourceBundle.getBundle("class_bundle/member"); // 20240124-4 수업 properties파일을 가져오는 
		Enumeration key = rb.getKeys(); // 20240124-4 수업
		while( key.hasMoreElements()) { // 다음에 있는가 check
			String k = (String)key.nextElement(); //signup, signupSave, myPage ...등등
			String value = rb.getString(k); //member.properties의 키에 맞는 value 가져오기
			try {                          // 20240124-4 수업
				Class<?> hcl = Class.forName(value); //문자열을 클래스화 시켜준 것(객체 생성하려면 클래스가 메모리에 로드되어야 한다.)
				member_action hinst = (member_action)hcl.newInstance(); //객체생성
				target.put(k, hinst);
			}catch(Exception e) {
				System.out.println("member.properties 파일작업 실패");
				e.printStackTrace();  // 20240124-4 수업
			}
		}
			//System.out.println( target.keySet() );
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
		
		//response.sendRedirect("/main.jsp"); //주소창에 localhost:8080/member_control 입력시 main.jsp 페이지로 이동
// cmd를 사용하지 않아 삭제		
//		String cmd = request.getParameter("cmd");
//		
//		if( cmd.equals("signup")) {  // index페이지의 회원가입을 클릭하면 
//			
//			//response.sendRedirect("/"); // index페이지로 이동(현재의 index페이지로 이동, 페이지변화없음)
//			//response.sendRedirect("/member/signup.jsp"); //model2프로젝트의 member폴더/signup.sjp 페이지로 이동
//		}
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		response.getWriter().append("my site 하하하하"); //웹에 출력된다
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		process(request, response);
	}
	// GET, POST 요청에 대한 일괄처리 메서드 (20240123 10:46)
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서버는 대부분 사용자의 주소요정에 동작한다. 주소요청이 없으면 대부분 동작하지 않는다
		// 사용자가요청한 주소를 보고 그에 맞는 응답페이지 제공이나 값을 제공한다
		//서블렛은 사용자의요청을 목적에 맞게 처리하기위한 클래스이다
		// 서버대신해서 요청을 처리해주는 역할을 한다 
		request.setCharacterEncoding("UTF-8");
		
		String uri = request.getRequestURI(); //20240124-2 수업참조
		//String path = request.getContextPath(); //20240124-2 수업참조
		// System.out.println(uri+" "+url); //20240124-2 수업참조
		
		String cmd = uri.substring(9); //20240124-2 수업참조  .getParameter("cmd"); // 요청주소의 cmd 파라미터값 가져오기
		String view ="/"; //사용자에게 제공할 기본 페이지 "/"는 index.jsp
		
		//System.out.println(cmd);
		member_action mem = target.get(cmd); // 20240124-4 수업
		view = mem.action(request, response); // properties 파일내용을 연결
		
		
		if( view != null) {
			RequestDispatcher rds = request.getRequestDispatcher(view); //제공할 페이지 
			rds.forward(request,  response); 
			// 기존의 사용자 브라우저의 내용을 교체하는 방식
			// 주소는 변경되지않는다.
		}
	}
}

//아래 if문을 지우고 다형성을 구현하여 재작성 원래위치는 String view = "/"; 임  20240124-4 수업
//if(cmd.equals("signup")) { //요청파라미터가 signup일경우 회원가입페이지를 요청한다
//	request.setAttribute("prt", "member/signup"); //prt에 value값 저장 
//	request.setAttribute("emailList", ms.emailList());
//	//회원가입페이지를 제공하기위해 request객체를 이용한 것일뿐 반드시 이와같은 방법이 아니어도 된다
//	//사용자 요청에 의한 페이지제공은 정적페이지(.html, .jsp 등)그대로 제공할 수도 있고
//	//위와같이 include방식으로 제공할 수도있다
//}else if( cmd.equals("signSave")) { // 모두 입력 후 sign버튼 클릭시 
//	view = ms.insert(request, response);
//}





/*
 * RequestDispatcher
 * 	- 클라이언트의 요청이 들어오면 원하는 값으로 요청을 넘기거나
 * 		특정값에 처리를 요청하고 처리결과를 얻어오는 기능
 * 	서블렛에 의해서 사용자가 요청한 페이지를 제공하는 방법으로
 * 	response.sendRedirect가 있는데 사용자의 브라우저 주소를 변경하는
 * 	방법이라서 다시한번 재요청이 들어온다
 * 
 * 	dispatcher를 사용하면 요청에 대한 페이지를 forward 또는 include하여 제공한다.
 * 
 * 	model2는 MVC 패턴이다
 * 		M: Model - 데이터저장 객체
 * 		V: View - 클라이언트에게 제공하는 페이지
 * 		C: Controller - 클라이언트의 요청을 처리
 * 
 * 		control(서블렛) <--> Service <--> Database (Controller)
 * 
 * 		DAO - data access object (데이터베이스에 접근하기위한 객체)
 * 		DTO - data transfer object (데이터를 저장해두는 객체)->Model에 해당
 * 		VO - value object(데이터 저장객체 - 읽기전용)
 * 		Entity - 테이블 생성과 테이블 값 저장, 읽기, 수정, 삭제와 관련있는 클래스
 * 
 */
