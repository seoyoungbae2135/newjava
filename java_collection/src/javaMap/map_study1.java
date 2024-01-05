package javaMap; // 20240104-7 

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class map_study1 {

	public static void main(String[] args) {
		HashMap<String, String> hash = new HashMap<>(); //<key, value>형태로 타입지정
		
		hash.put("김민수", "오늘도 웹툰"); //데이터입력은 put 메서드 적용
		hash.put("박종권", "영상?웹툰?보고있나?");
		hash.put("서종우", "짝궁머해요?");
		hash.put("남기현", "언제까지잘꺼야?????????");
		hash.put("김민수", "쉬었다올게요");
		
		System.out.println( hash );
		
		System.out.println( hash.get("박종권") );
		
		Set<String> keys = hash.keySet();  // map에는 추가저장 불가
		//keys.add("하하하");
		System.out.println( keys );
		
		Collection<String> val = hash.values();
		//val.add("아하");
		System.out.println( val ); 
		
		hash.remove("서종우"); //삭제 - 키와 value 삭제
		System.out.println( hash );
		
		hash.replace("김민수", "주제는 무었인고?"); //데이터 수정
		System.out.println( hash );
		
		System.out.println( hash.containsKey("김민자") ); //key와 일치하는 값 존재여부 없으면 false출력
		System.out.println( hash.containsValue("영상?웹웹웹툰...?"));//value 존재여부
		
		hash.forEach( //내부메서드를 만들어 사용
				(key, value) ->{
					System.out.println(key+"  "+value);
				}
		);

	}

}

// Map(인터페이스) - HashMap : 단일검색, 해시테이블 이라는 배열에 접근하기 때문에 검색시간이 일정하다
//							  - TreeMap : 범위검색, 이진트리구조를 사용하기때문에 기본정렬을 유지, 검색시간은 데이터양에 비례한다.
//							  - key:value의 구조로 입력,  key는 중복을 허용하지않는다.  value 중복가능
//								HashMap에서 key는 null을 허용하지만 TreeMap은 허용하지 않는다.
