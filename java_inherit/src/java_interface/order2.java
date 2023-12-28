package java_interface;


interface Request{
	public String getOrder();
}

class Customer{
	protected String menu;
	public Customer(String menu) { this.menu=menu; }
}
//단골손님
class CustomerA extends Customer implements Request{
	public CustomerA(String menu) { super(menu); }
	public String getOrder() {
		return "손님 A에게 "+menu+"을 준다.";
	}
}
class CustomerB extends Customer implements Request{
	public CustomerB(String menu) { super(menu); }
	public String getOrder() {
		return " 손님 B에게 "+menu+"을 준다.";
	}
}
//식당
class Restaurant{
	public void giveFood(Request res) {
		System.out.println( res.getOrder());
	}
}

public class order2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Restaurant owner = new Restaurant();
		Request a= new CustomerA("청국장");
		Request b= new CustomerB("삼겹살");
		owner.giveFood(a);
		owner.giveFood(b);

	}
	//식당주문시스템을 만드는데 손님에게서주문요청이 들어오면 어떤손님이든 
	// getOrder() 메서드로 실행해야한다.
	
	//interface는 자바프로그램 개발에 가이드라인을 제공하는 역할을 한다.
	//개발에 규칙을 정해놔야 혼동없이 개발할 수 있다
	//interface사용은 협업, 낮은 종속성, 다중상속을 위해 사용한다.

}
