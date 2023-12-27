package inherit_test;

public class computer extends house{

	float cpu; // cpu 성능
	int ram; // 램 용량
	
	computer(){}
	computer(String brand, float cpu, int ram){
		super(brand);
		this.cpu=cpu;
		this.ram=ram;
	}
	
	@Override   //에너테이션 이라고한다. 자식클래스에서 Override를 사용하지않을경우 부모클래스처럼 추상클래스로 변경해야한다
	void power() {
		onoff = !onoff;
		System.out.println( "컴퓨터 전원 : "+ onoff);
	}
	
	@Override
	public String toString() {
		return super.brand+" , cpu : "+cpu+"Gh ram : "+ram+"Gb";
	}
}









