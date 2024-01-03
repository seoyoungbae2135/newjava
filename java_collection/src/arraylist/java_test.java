package arraylist; //20240103 

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class java_test {

	public static void main(String[] args) {
		
		ArrayList<book> list = load(); // load메서드로부터 텍스트 파일을 불러와 ArrayList에 저장
		for( int i=0; i < list.size(); i++) {  // 배열의크기는 size메서드로 알 수 있다
			System.out.println( list.get(i) ); //ArrayList에 저장되어있는 배열의 값을 가져오려면 get
		}
		//도서검색 - 검색어와 일치하는 값 찾기, 검색어가 포함되어있는 값 찾기
		//책제목으로 검색 - 검색어와 일치하는 값 찾기
		//검색 - 비교(일치하는 값 찾기 - 같다, 같지않다.   포함 값 찾기 - 범위검색(같다, 같지않다.))
		// 일치하는값 - indexOf,  포함 - contains  (equals가 필요)
		
		book temp = new book("난항상물음표", "노재홍", 2023 );
//		System.out.println( list.indexOf(temp) );  // book클래스의 검색 메서드를 리턴받아 검색결과 출력
		
		System.out.println( list.indexOf("난항상물음표") ); 
		
		
		//정렬  - 두개의 데이터를 비교하여 크고 작다를 따져서 위치를 변경하는 방법
		//기본데이터 타입에 대한 자바 내장클래스들은 비교, 정렬, 검색을 위한 메서드들을 가지고 있다.
		//사용자(개발자)정의 클래스는 비교, 정렬, 검색을 위한 메서드들이 없기때문에 
		// indexOf, contains, sort와 같은 메서드 사용시 필요한 메서드들을 구현해야한다.
		//두가지 방법이 있다, Colections 클래스, 
		Collections.sort( (List<book>) list );
		Iterator<book> it = list.iterator();  // Iterator도 <> 필요
		while(it.hasNext()) {  // 반복문은 while문만 적용
			book data = it.next(); 
			System.out.println( data );  // 출간년도로 정렬되어 출력
		}
//		list.sort(Comparator.naturalOrder());
		
	}
	
	public static ArrayList<book> load() {  // book.txt 파일 불러오기위한 메서드작성. return을 하기위하여 타입은 list와 동일하게 ArrayList<book>으로 한다
		ArrayList<book> list = new ArrayList<book>();  // book클래스를 ArrayList에 저장하겠다. list는 참조변수로 ArrayList객체공간(메모리)의 주소 저장, book클래스 객체만 저장된다
		// 외부파일을 불러오는 ArrayList를 사용하기위하여 try catch 적용
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/book.txt"))) //book.txt 파일을 불러오기 try( 중괄호안에 클래스와 파일경로를 입력하고 import한다 bf는 참조변수 )
		{
			while(true) {  // book.txt 파일의 내용을 마지막줄까지 읽어오기 위한 무한반복문
				String line = bf.readLine();
				if(line == null) break;   //마지막줄 까지 읽고 break
				String[] tmp = line.split(","); // 한줄을 " , " 기준으로  분리
				book data = new book(tmp[0], tmp[1], Integer.parseInt(tmp[2])); //분리된 data를 객체로 저장 
				list.add( data ); // list에 저장된 객체(data)를 추가
			}
		}catch(Exception e) {  // 최상위 예외코드
			System.out.println("파일 로드 및 반환 실패");
			e.printStackTrace();
		}
		
		return list; // 
		
	}

}
