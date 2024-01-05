package javaset; //20240104 4

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class set_study1 {

	public static void main(String[] args) {
//		HashSet<Integer> set = new HashSet<Integer>();
//		
//		set.add(10);
//		set.add(15);
//		set.add(20);
//		set.add(60);
//		set.add(12);
//		set.add(14);
//		set.add(34);
//		
//		System.out.println( set );
		
		HashSet<String> 안경쓴사람 = new HashSet<String>();
		HashSet<String> 팥붕어빵 = new HashSet<String>();
		HashSet<String> 슈붕어빵 = new HashSet<String>();
		
		안경쓴사람.add("남기현"); 안경쓴사람.add("이가림"); 안경쓴사람.add("김민수");
		안경쓴사람.add("노재홍"); 안경쓴사람.add("송재영"); 안경쓴사람.add("김정환");
		안경쓴사람.add("강동욱"); 안경쓴사람.add("김의찬"); 안경쓴사람.add("서종우");
		
		팥붕어빵.add("노재홍"); 팥붕어빵.add("서영배"); 팥붕어빵.add("김의찬");
		팥붕어빵.add("강동욱"); 팥붕어빵.add("김정환"); 팥붕어빵.add("박종권");
		
		슈붕어빵.add("남기현"); 슈붕어빵.add("이가림"); 슈붕어빵.add("이다희");
		슈붕어빵.add("김민수"); 슈붕어빵.add("여영근"); 슈붕어빵.add("송재영");
		슈붕어빵.add("인호성"); 슈붕어빵.add("서종우"); 
		
		HashSet<String> 팥X안경 = new HashSet<String>(); // 슈좋아하는 안경쓴사람
		Iterator<String> it = 안경쓴사람.iterator();  // 일회용으로 재사용 불가
		while(it.hasNext()) {
			String name = it.next();
			if( 슈붕어빵.contains(name) ) {
				팥X안경.add( name );
			}
			//System.out.println( name );
		}
		System.out.println(팥X안경);
		
		// 차집합
		// 팥을 좋아하는 사람등 중에 안경쓰지 않은 사람
		HashSet<String> 안경X팥좋아 = new HashSet<String>();
		it = 팥붕어빵.iterator();  
		while(it.hasNext() ) {
			String name = it.next();
			if( !안경쓴사람.contains(name) ) { 
				안경X팥좋아.add(name);
			}
		}
		System.out.println( 안경X팥좋아 );
		
		//합집합
		// 안경을 착용하고있거나 슈를 좋아하거나 하는 사람들
		HashSet<String> 안경과슈 = new HashSet<String>();
		it = 슈붕어빵.iterator();
		while(it.hasNext() ) {
			안경과슈.add(it.next() );
		}
		it = 안경쓴사람.iterator();
		while(it.hasNext()) {
			안경과슈.add(it.next());
		}
		System.out.println( 안경과슈 );
		
//		HashSet 메서드를 통한 교집합구하기
		팥X안경.clear();
		팥X안경.addAll(안경쓴사람);
		팥X안경.retainAll(슈붕어빵); //교집합 메서드
		System.out.println(팥X안경);
//		메서드를 사용하여 차집합
		안경X팥좋아.clear();
		안경X팥좋아.addAll(팥붕어빵);
		안경X팥좋아.removeAll(안경쓴사람); // 차집합 메서드
		System.out.println(안경X팥좋아);
		
//		메서드를 사용하여 합집합 구하기
		안경과슈.clear();
		안경과슈.addAll(안경쓴사람);
		안경과슈.addAll(슈붕어빵); 
		System.out.println(안경과슈);
		
		// 부분집합 - A집합의 값 일부가 B집합으로 만들어진 경우 B집합은 A의 부분집합이라고한다
		System.out.println(안경쓴사람.containsAll(팥붕어빵)); // 부분집합이 아니어서 false
		System.out.println(안경과슈.containsAll(슈붕어빵)); // 슈붕어빵이 부분집합이므로 true
		
		List<String> names = new ArrayList<String>(안경과슈);
		
		System.out.println( names );
		
		
		
	}

}

//교집합 - 두개이상의 집합에 공통으로 존재하는 값의 집합체
//차집합 - A집합과 B집합에서 A집합에만 존재하는 값
//합집합 - A집합과 B집합을 합쳤을때 중복을 제외한 값 

// Set(인터페이스) - 입력한 데이터 순서유지 안됨(힙메모리공간을 사용하기때문에 
//							메모리 주소, 크기 등에 의해 순서가 변경이된다. ) 
//					   - 중복데이터를 허용하지않는다.
//					   - 데이터들의 그룹화목적으로 사용( 수학의 집합 개념으로 만든 구조 )
//					   - HashSet : 수학에서의 집합을 표현하기위한 클래스
//					   - TreeSet : 검색, 정렬의 목적으로 사용되는 클래스