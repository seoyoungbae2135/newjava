package study121801;

import java.util.Arrays;

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
		
		//자바에서 기본배열을 생성하여 다룰때
		//배열에 저장할 데이터 정하기(저장 데이터에 따라 데이터 타입 정해여함
		//몇개의 데이터를 저장할 것인지 갯수 정화기
		//타입과 갯수에 맞는 배열생성
		//타입 - 문자열, 갯수 - 7
		//String[] names = new String[7];
		
		//10명의 학생이 저장된 배열 만들기
		int[] score = new int[10];
		
		for(int i=0; i<score.length; i++) {
			score[i] = (int)(Math.random()*51)+50;
		}
		System.out.println(score); //주소만 출력된다.
		System.out.println(Arrays.toString(score));//베열에 들어있는 값만 확인
		
		Arrays.sort(score); //정렬
		System.out.println(Arrays.toString(score));
		
		// 두개의 배열에 저장된값을 하나의 배열로 합치기
		int[] a= {10,20,30,40};
		int[] b=new int[] {11,22,33,44}; //a와 동일하게 저장됨
		int[] c = new int[8];
//		for(int i=0; i<a.length; i++) {
//			c[i] = a[i];  // a인덱스값이 c배열의 0,1,2,3 인덱스에 저장됨
//			c[i+4] = b[i]; //b인덱스값이 c배열의 4,5,6,7인덱스에 저장됨 
//		}
		// arraycopy(복사대상배열, 복사배열시작인덱스, 복사저장할배열, 저장시작인덱스, 몇개복사)
		System.arraycopy(a, 0, c, 0, a.length ); // a배열의 0번인덱스부터 c배열의 0번인덱스에 a길이만큼 복사
		System.arraycopy(b, 0, c, 4, b.length ); // b배열의 0번인덱스부터 c배열의 4번인덱스에 b길이만큼 복사
		System.out.println(Arrays.toString(c));
		
		int[] data = {170, 168, 182, 174, 175, 169, 177};
		//data배열에는 3학년1반의 키가저장되어있다.
		//키가 175이상만 출력하세요.
		//me
		int[] height = new int[10];
		for(int i=0; i<data.length; i++) {
			if( data[i] >= 175 ) {
				height[i] = data[i];
			}
		}
		System.out.println(Arrays.toString( height));
		//teacher
		for( int i=0; i<data.length; i++) {
			if(data[i] >= 175)
				//System.out.println("175이상인학생 - "+(i+1)+"번째 학생 키 :"+ data[i]);
				System.out.println(data[i]);
		}
	}
}





























