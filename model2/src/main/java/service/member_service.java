package service;
// 20240123-6

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import DAO.member_dao;
import DTO.member;

// 20240123-5

public class member_service implements member_action{

	private member_dao mdao = new member_dao();
	
	
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException  { //throws IOException - try catch 대신 적용(넘기는 코드)
		
		// 회원가입 이미지불러오기 20240129-1
		String path="C:\\ray\\njava\\newjava\\model2\\src\\main\\webapp\\static\\image"; 
		//request.getRealPath("/")+"static/image"; 와같이 해야하나 여기서는 표현안되므로 위와같이 한다 
		int size = 1024*1024*20; //그림파일크기 설정(단위:byte)
		
		
			//20240129-1 homework teacher 추가
			String email=null;
			String name=null;
			String pw=null;
			String tel=null;
			String face=null;
			try {
				MultipartRequest mr = new MultipartRequest(request, path, 
						size, "UTF-8", new DefaultFileRenamePolicy());
				
				// 20240129-2 homework teacher 수정
				
				
					email =mr.getParameter("email");
					name = mr.getParameter("name");
					pw = mr.getParameter("pin");
					tel = mr.getParameter("tel");
					
					Enumeration em = mr.getFileNames();  // 
					String files = (String)em.nextElement();
					face = mr.getFilesystemName(files);
				
				// 여기까지
				
			}catch(Exception e) {
				System.out.println("파일업로드실패");
				e.printStackTrace();
			}
//			String email = request.getParameter("email");
//			String pw = request.getParameter("pin");
//			String name = request.getParameter("name");
//			String tel = request.getParameter("tel");
		
			int id = mdao.insert( new member(email, pw, name, tel) );
			mdao.pictureInsert( face, id );  //20240129-1
		
			//response.sendRedirect( "/members?cmd=signIn" ); // 로그인 후 보여줄 페이지 주소
			response.sendRedirect( "/members/signIn" ); // 20240124-1 수업참조 cmd 사용안함 (윗줄을 이렇게 변경)
			return null;
		}
	
}
