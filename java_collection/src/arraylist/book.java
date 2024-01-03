package arraylist; //20240103

public class book implements Comparable<book>  { // 정렬을 하기위하여 book클래스에 implements Comparable<book> 추가
	private String title;
	private String writer;
	private int year;
	
	public book() {}
	public book(String title, String writer, int year) {
		this.title=title;
		this.writer=writer;
		this.year=year;
	}
	
	@Override // 정렬을 하기위하여 
	public int compareTo(book b) {  // Comparable이라는 인터페이스는 Override할때 compareTo(클래스명(book))으로 매개변수를 적용해야한다
//		return this.title.compareTo(b.title);  //  문자열을 기준으로 정렬 사전적순서로 정렬
		return this.title.compareTo(b.title) * -1;  // 문자열도 역순정렬은 * -1 을 적용하여 음수와 양수를 바꾼다 
//		return this.year - b.year;  // this.year은 첫번째데이터, b.year은 다음데이터 비교하여(-) 양수일때 위치가 바뀐다
//		return (this.year - b.year)*-1; //역순정렬은 음수를 양수로 양수를 음수로 변경
	}
	
	@Override
	public String toString() {
		return "제목 : "+title+" 저자 : "+writer+" 출간년도 : "+year+"년";
	}
	
	@Override
	public boolean equals(Object o) {  // java API 에 있는  코드 적용, 검색메서드작성, 검색에 equals 필요
		String title = (String)o;
		
		return this.title.equals(title);
		
//		book tmp = (book)o; // 비교할 객체
//		boolean same1 = this.title.equals(tmp.title);
//		boolean same2 = this.writer.equals(tmp.writer);
//		boolean same3 = this.year == tmp.year;
//		return same1 && same2 && same3;    // 책제목, 저자, 출간년도 모두 일치하는것으로 검색의 경우
			
//		return this.title.equals(tmp.title); // 책제목으로 검색하는것이므로 title, 저자검색이면 writer, 년도검색이면 year 
	}
	
	/*
	 *  String[] n = new String[]{"가","나","다","라",마"};
	 *  
	 *  for( int i=0; i<n.length(); i++){
	 *  	if( n[i].equals("다") ) {
	 *  		return i;
	 *  	}
	 *  }
 	 *  
	 */
	
	// get, set 메서드
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	

}
