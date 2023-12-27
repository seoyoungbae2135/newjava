package inherit_test;

public class tv extends house{

	int ch=7; //채널  , 명시적 초기화
	int vol=15; //소리
	
	{   // 초기화블럭에 의한 초기화, 동작순서는 명시적초기화 -> 초기화블럭
		ch=10;  
		vol=12;
	}
	public tv(){ // 기본 생성자 메서드
		System.out.println("tv 클래스의 생성자입니다.");
		
	}
	
	public tv(String brand){ // 매개변수가 있는 생성자메서드
		super(brand);
	}
	
	void channel_up() {
		this.ch++;
	}
	void channel_down() {
		this.ch--;
	}
	
	@Override
	public void power() {
		onoff = !onoff;
		System.out.println( "TV 전원 : "+ onoff);
	}
	
	@Override
	public String toString() {  //문자열 출력은 toString이라는 메서드를 주로 사용한다.
		return super.brand+" , 전원 : "+onoff +" 현재채널:"+ch+" 볼륨:"+vol; //변수앞에 super를 명시하여 해당변수가 부모것임을 표시한다
	}
}