package service;
//20240131-5
import java.io.IOException;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.member_dao;

public class member_findAuth implements member_action{
	private member_dao dao = new member_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String email = request.getParameter("email");
		
		String[] emails = dao.findAllEmail();
		
		if( Arrays.asList(emails).contains(email)) { //회원가입된 이메일인가? 확인
			final String username="ybsho62@naver.com";
			final String password="6Z1XSJKDVY49";
			// 인증번호를 이메일로 발송하는 코드 (try catch 까지)
			Properties prop = new Properties();
			prop.put("mail.smtp.starttls.enable", "true"); //tls 사용여부, 사용하겠다
			prop.put("mail.smtp.auth", "true"); //smtp 서버인증
			prop.put("mail.smtp.host", "smtp.naver.com");//이메일전송 smtp서버명
			prop.put("mail.smtp.port", "587");//smtp포트번호
			
			Session session = Session.getInstance(prop, 
					new javax.mail.Authenticator() {
						protected PasswordAuthentication getPasswordAuthentication() {
							return new PasswordAuthentication(username,password);
						}
					});
			// 비밀번호 생성을 위한 인증번호생성(3분동안만 사용가능)
			String auth = "";
			for(int i=1; i<=6; i++) {
				int tmp = (int)(Math.random()*10);
				auth = auth+tmp;
			}
			
			try { //메세지 생성
				MimeMessage msg = new MimeMessage(session);
				msg.setFrom(new InternetAddress(username) );//보내는이메일 세팅한것
				msg.setRecipients(Message.RecipientType.TO,
						InternetAddress.parse( email )); //받는 이메일(게시글 작성자)
				
				msg.setSubject("비밀번호 변경 - 인증번호"); //제목
				
				msg.setText( "인증번호 : "+auth ,
						"UTF-8"); //인증번호 발송
				
				Transport.send(msg);
				
				
			}catch(MessagingException e) {
				System.out.println("이메일 전송실패");
				e.printStackTrace();
			}
			
			request.getSession().setAttribute("num", auth);
			request.getSession().setMaxInactiveInterval(180); //180초동안 세션이 살아있다가 이후 세션삭제
			
			request.setAttribute("email", email);
			request.setAttribute("prt", "member/inputAuthNum");
		}else { //회원가입 안된 이메일 주소일 경우
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().append("" 
					+ "<script>alert('등록되지않은 이메일 입니다'); history.back();</script>" );
			return null;
		}
		
		return "/";
	}

}
