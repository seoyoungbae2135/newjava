package DTO;
// 20240126-7
import java.util.Date;

public class board {
	private int id;
	private int hit;
	private int member_id;
	private String title;
	private String writer;
	private String answer_mail;
	private String lang;
	private Date wdate;
	private String content;
	private int reply_cnt; // 20240131-4 추가, get set 추가
	
	// 글 작성할때 사용되는 메서드
	public board(int mid , String title, String writer , String answer_mail,
			String lang, String content) {
		this.member_id=mid;
		this.title=title;
		this.writer=writer;
		this.answer_mail=answer_mail;
		this.lang=lang;
		this.content=content;
		
	}
	// 
	public board(int id, int hit, int mid, String title, String writer, String answer_mail, 
			String lang, String content, Date wdate) {
		this(mid,title,writer,answer_mail,lang,content);
		this.id=id;
		this.hit=hit;
		this.wdate=wdate;
	}
	// 20240131-4 추가 댓글달린 갯수 표시
	public board(int id, int hit, int mid, String title, String writer, String answer_mail, 
			String lang, String content, Date wdate, int cnt) {
		this(mid,title,writer,answer_mail,lang,content);
		this.id=id;
		this.hit=hit;
		this.wdate=wdate;
		this.reply_cnt=cnt;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getAnswer_mail() {
		return answer_mail;
	}
	public void setAnswer_mail(String answer_mail) {
		this.answer_mail = answer_mail;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Date getWdate() {
		return wdate;
	}
	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getReply_cnt() {
		return reply_cnt;
	}
	public void setReply_cnt(int reply_cnt) {
		this.reply_cnt = reply_cnt;
	}
	
}
