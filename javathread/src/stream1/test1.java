package stream1; //20240110-2

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class test1 {

	public static void main(String[] args) {
		
		// 배열 스트림
		String[] arr = new String[] {"desk", "table", "orange"};
		Stream<String> stream = Arrays.stream(arr);
		
		stream.forEach(System.out::println); // forEach는 반복문 stream에서 메서드사용시 메서드앞에 ::을 붙여야한다
		Arrays.stream(arr).forEach(System.out::println); 
		
		stream = Arrays.stream(arr, 1, 2); // 1번인데스부터 포함 2번인덱스제외 stream은 1회성이므로 재사용하려면 재지정해야한다 
		stream.forEach(System.out::println); // 재사용시 위와같이 재지정
		
		//컬렉션 스트림
		List<String> list = Arrays.asList(arr);
		Stream<String> stream2 = list.stream();
		
		System.out.println( stream2.count() );
		
		// 스트림 빌더 
		Stream<String> stream3 = Stream.<String>builder().add("a")  //builder를 사용하여 직접 변수를 저장
									.add("b").add("c").add("d").build();
		
		Stream<Integer> stream4 = Stream.iterate(1 , n-> n+1).limit(10);
		
		stream4.forEach(System.out::println);
		
		//기본 데이터 타입형 스트림
		IntStream intStream = IntStream.range(1,  11); // 정수형태 스트림 범위는 끝 수 +1 한다
		LongStream longStream = LongStream.range(1,  101); //long형 스트림 1부터 100까지 
		DoubleStream floatStream = new Random().doubles(5); //double형 스트림. 실수이므로 난수발생으로 입력 예
		
		intStream.forEach(System.out::println);
		
		IntStream charStream = "banana".chars(); //문자스트림은 IntStream으로 저장
		
		
		List<String> names = new ArrayList<>();
		names.add("이성계"); names.add("정약용"); names.add("정도전");
		names.add("이만기"); names.add("김유신"); names.add("김신");
		names.add("박문수"); names.add("문익점"); names.add("박만용");
		
		// filter - 참과 거짓에 따라 동작, if문의 조건식과 비슷한식을 구사하면된다.
		
		Stream<String> 박 = names.stream().filter( name -> name.contains("박") );
		//names List의 첫변째 값부터 마지막값까지 차례대로 name이라는 매개변수에 전달하여 처리한다
		
		박.forEach(System.out::println);
		
		Stream<String> 문 = names.stream().filter( name -> name.contains("박"));// contains는 메서드형태로 해야한다 
		문.forEach(System.out::println);
 		
		names.stream().filter( name -> name.length()==2).forEach(System.out::println);//이름중 2글자인 이름만 출력
		
		// map - 데이터값들을 특정값으로 변환 해주는 작업
		Stream<String> 이름 = names.stream().map( name -> name.substring(1) );
		이름.forEach(System.out::println);
		
		
		//stream 예제
//		ArrayList<String> list = new ArrayList<>();
//		list.add("a"); list.add("b"); list.add("c");
//		list.add("d");
//		
//		list.stream().filter("b"::equals).forEach(System.out::println); 
		//stream을 사용하면 아래 for문 또는 Iterator로 구현한 것과 동일한 결과 출력
		
//		for( String val : list) { //for문으로 list에서 b만 출력
//			if(val.equals("b"))
//				System.out.println("값있다. "+val);
//		}
		
//		Iterator<String> it = list.iterator(); // Iterator로 list에서 b만 출력
//		while( it.hasNext() ) {
//			String val = it.next();
//			if( val.equals("b"))
//				System.out.println("값있다. "+val);
//		}

	}

}

// stream - 데이터의 흐름, 컬렉션 프레임워크에 여러개의 메서드를 조합하여
// 원하는 결과를 얻을 수 있는데 stream을 이용하면 코드의 양을 줄이고 간단하게 표현 할 수 있다.
// 배열과 컬렉션을 함수형 이라는 형태로 처리가 가능하다.
// stream은 병렬처리가 가능하다. 둘이상의 작업을 동시에 진행가능(쓰레드 이용)
// stream사용 : (배열 또는 컬렉션). 맵핑.필터링.결과만들기 -> 결과물
// stream 사용하지 않으면 맵핑작업을 위한 메서드를 통해 반환을 받아 필터링을 위한메서드에
// 매개변수로 전달하여 최종 결과값 반환작업을 해야하지만 stream을 사용하면 
// 간단하게 표현할 수 있다.



