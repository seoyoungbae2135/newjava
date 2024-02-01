package service.board;
//20240126
import java.io.IOException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.board_dao;
import DTO.board;
import DTO.member;
import DTO.reply;

public class board_reply implements board_action{
	private board_dao dao = new board_dao();
	
	@Override
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int bid = Integer.parseInt(request.getParameter("board_id"));
		String comment = request.getParameter("comment");
		
		member user = (member)request.getSession().getAttribute("user");
		
		reply rp = new reply(bid, user.getNum(), comment, user.getName());
		
		dao.reply_insert(rp);
		
		//게시글 작성자 이메일 가져오기 - 그래야 글 작성자에게 답글이 등록되었다고 메일을 보낼 수 있다 20240131-3
		board org = dao.selectDetail(bid);
		
		//메일보내기 20240131-1 이것은 네이버계정
		final String username="ybsho62@naver.com";
		final String password="6Z1XSJKDVY49";
		
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
		
		try { //메세지 생성
			MimeMessage msg = new MimeMessage(session);
			msg.setFrom(new InternetAddress(username) );//보내는이메일 세팅한것
			msg.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse(org.getAnswer_mail() )); //받는 이메일(게시글 작성자)
			
			msg.setSubject(org.getTitle()+"게시글에 답글 등록"); //제목
			msg.setText(org.getTitle()+" 의 글에 "+user.getName()+"님이 답글을 등록하었습니다."
					+"확인하시려면 아래 링크를 클릭해 주세요.\n"+
					"http://192.168.0.108/board_read.do?id="+bid,
					"UTF-8"); //내용
			Transport.send(msg);
			
			
		}catch(MessagingException e) {
			System.out.println("이메일 전송실패");
			e.printStackTrace();
		}
		
		response.sendRedirect("/board_read.do?id="+bid);
		
		return null;
	}
}
