package study121801;

public class main_class {
	
	public static void main(String[] args) {
		
		// 자바스크립트 - let a = new Array();
		//           let b = [10,20,30,40];
		//			a.push(3123); b.push(233)
		
		int[] arr1 = {102, 20};
		System.out.println( arr1[0]);
		
		int[] arr2 = new int[10]; //1차원 배열의 공간이 10개 만들어진다 반드시 몇개만들것인지 지정해야한다
		// new int[10]
		//(new)새로운공간 int(정수타입)[10](10공간연속으로 생성)
		//배열공간을 지정후 늘릴수없다. 정적배열(동적배열도 있다.)
		
		for( int i=0; i<arr2.length; i++) {
			arr2[i]=i*10;
		}
		System.out.println( arr2[2]);
		
		for( int i=0; i<arr2.length; i++) {
			System.out.println( arr2[i]);
		}
	}
}