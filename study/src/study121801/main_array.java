
package study121801;

import java.util.Arrays;
import java.util.Scanner;

public class main_array {
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// 16개의 정수를 중복없이 배열에 저장하기
//		int[] number = new int[16];
//		
//		for(int i=0; i<number.length; i++) {
//			number[i] = (int)(Math.random()*50)+1;
//			for( int k=0; k<i; k++) {
//				if(number[k] == number[i]) {
//					i--;
//					break;
//				}
//			}
//			
//		}
		//자바슼립트에서 존재여부 - indexOf(특정값), includes(특정값)
		//자바배열은 indexOf(특정값), includes(특정값)가 없다.
		//indexOf(특정값), includes(특정값)로 존재여부를 알수있지만,
		// String과 List클래스에서만 사용가능. asList.을 붙여서
		
//		System.out.println( Arrays.toString(number));
		
		//number배열을 한줄에 4개씩 4줄로 출력하세요
		//me
//		int[] num1 = new int[4];
//		for(int i=0; i<number.length; i++) {
//			System.arraycopy(num1, 0, number, 0, 3)
//		}
		//teach
//		System.out.println("┌──┬──┬──┬──┐");
//		for(int i=0; i<number.length; i++) {
//			if(i%4==0)
//				System.out.printf("│\n├──┼──┼──┼──┤\n");
//			//System.out.print( number[i] +" ");
//			System.out.printf( "│ %2d ", number[i] );// %2d를 사용하여 자릿수를 맞춰서 출력할 수 있다 
//		}
//		System.out.printf("│\n└──┴──┴──┴──┘");
		
		int[][] arr2 = new int[3][2]; // 이치원배열 아래와같이 6개데이터가 저장된다 
		arr2[0][0] = 100;
		arr2[0][1] = 30;
		
		arr2[1][0] = 50;
		arr2[1][1] = 10;
		
		arr2[2][0] =112;
		arr2[2][1] =125;
		
		int[][] bingo1 = new int[4][4];
		int[][] bingo2 = {{}, {}, {}, {}};  //이와같이 만들어도 4*4 2차원 배열이 만들어진다
		int[][] bingo = new int[][] {  // 이와같이 만들어도 된다.
			{24,12,45,11}, {9,4,12,31}, {5,41,39,17}, {1,50,43,22}
		};
		
//		for( int i=0; i<bingo.length; i++) {
//			for(int k=0; k<bingo[i].length; k++) {
//				System.out.printf(" %2d ",bingo[i][k]);
//			}
//			System.out.println();
//		}
		
		//bingo 배열에서 25이하는 숫자대신 ★(한글 ㅁ에 한자키)을 출력하세요
		// teacher
		for( int i=0; i<bingo.length; i++) {
			
			for(int k=0; k<bingo[i].length; k++) {
				if( bingo[i][k] <= 25)
					System.out.printf(" %2s ","★"); // %2s 는 문자출력
				else
					System.out.printf(" %2d ",bingo[i][k]); 
			}
			System.out.println();
		}
		
		// 크기가 서로다른 이차원배열
		// int[] a, b, c;
//		int[][] arr5= new int[3][];
//		int[] a = new int[] {1,2,3,4,5};
//		int[] b = {10,20,30};
//		int[] c = {11,22,33,44,55,66,77};
//		
//		arr5[0] = a;
//		arr5[1] = b;
//		arr5[2] = c;
//		
//		for(int i=0; i<arr5.length; i++) {
//			for(int k=0; k<arr5[i].length; k++ ) {
//				System.out.print(arr5[i][k]+" ");
//			}
//			System.out.println();
//		}
		//자비스크립트 - 배열에 정수나 실수나 문자열을 복합적으로 저장할 수 있다
		// 자바 - 배열생성시 부여한 데이터 타입에 맞는 데이터만 저장가능
		
//		int num11 = scan.nextInt();
//		scan.nextLine();  // 숫자입력후 문자입력시 엔터를 빼오는 코드를 삽입해야한다
//		String word = scan.nextLine();
//		
//		System.out.println(num11+" "+word);
		
		String[][] info =new String[3][3];
		
		for(int i=0; i<info.length; i++) {
			System.out.print("이름 : ");
			info[i][0] = scan.nextLine();
			System.out.print("나이 : ");
			int age = scan.nextInt();
			info[i][1] = Integer.toString(age); //숫자를 문자열로 변경
						//문자열을 숫자로변경 - Integer.parseInt();
						// Float.parseFloat(); Double.parseDouble();  실수로 변경, 
			scan.nextLine(); //숫자(나이)입력후 문자입력이 안되므로 입력버퍼에서 엔터를 제거한다
			System.out.print("직업 : ");
			info[i][2] = scan.nextLine();
		}
		for(int i=0; i<info.length; i++) {
			for(int k=0; k<info[i].length; k++) {
				
				System.out.printf("이름 :%s 나이 : %s 직업 : %s \n",
						info[i][k], info[i][k], info[i][k]);  
			}
		}
		// 1차원배열만 잘 다룰 수 있으면 된다.
		// 그럼 자연스레 2차원배열도 된다.
		
		
	}
}





















