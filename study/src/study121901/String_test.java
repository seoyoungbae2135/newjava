
package study121901;

import java.util.Arrays;
import java.util.Scanner;

public class String_test {


	public static void main(String[] args) {
		
		//
		String song = "나는 바나나 알러지 원숭이 그래도 나는 바나나 좋아해";
		
		//1.원본은 유지하고 모든 바나나를 오렌지로 변경하여 출력하세요
		//2.과일알러지 있는 원숭이, 어떤과일에 알러지 있는지 출력하세요
		//  (알러지 문자열 앞의 과일 이름만 출력)
		//3.song문자열 앞에 "상상만해도 웃음이나요" 합쳐서 하나의 문자열로 출력하세요
		//me
		String org = song.replaceAll("바나나", "오렌지");
		System.out.println(org);
		
		String alg = song.substring(song.indexOf(" "),song.indexOf("알")); 
		System.out.println(alg);
		
		String plu = "상상만 해도 웃음이 나요";
		String info = plu.concat(" " +song);
		System.out.println(info);
		
		//teacher
		String temp = song.replaceAll("바나나", "오렌지");
		System.out.println(temp);
		
		String fruit = song.substring(song.indexOf(" ")+1, song.indexOf("알러지"));
		System.out.println(fruit);
		
		temp = "상상만 해도 웃음이 나요";
		System.out.println(temp.concat(song));
		
		// 과제
		song = "크리스마스에는 많은것을 원하지 않아요 # 내가 원하는건 딱 하나예요 #"
				+ "트리 아래의 선물같은것도 신경쓰지 않아요 # 당신을 원해요 #"
				+ "당신이 생각하는 것보다 더 # 내소원을 이뤄줘요 #"
				+ "내가 크리스마스에 원하는건 당신이예요";
		System.out.println(song);
				 
		/*
		 *1. #기준으로 한줄씩 출력하세요(#은 출력창에 나오면 안되요)
		 *2. 당신 이라는 단어 대신 "그대" 라고 바꾸어서 출력하세요
		 *3. 크리스마스를 영어로 번역하여 출력하세요(대문자로)
		 *4. 세번째#뒤의 가사가 무었인지 출력하세요.
		 */
		

	}

}
