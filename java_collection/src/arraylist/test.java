package arraylist;

public class test {

	public static void main(String[] args) {
		box<orange> o = new box<orange>();
		
		o.createBox(new orange());
		
		box<toy> t = new box<toy>();
		t.createBox(new toy());
		
//		b.createBox(new orange());
//		b.createBox(new toy());
//		b.createBox(new apple());

	}

}

// 제네릭 실습

class orange{
	public String toString() {
		return "오렌지박스";
	}
}
class toy{
	public String toString() {
		return "장난감박스";
	}
	
}
class apple{
	public String toString() {
		return "사과박스";
	}
}