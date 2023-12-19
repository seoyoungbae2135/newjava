
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
		
		temp = "상상만 해도 웃음이 나요 ";
		System.out.println(temp.concat(song));
		

	}

}
