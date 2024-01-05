package javaMap; //20240105-1

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Enumeration;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class map_study2 {

	public static void main(String[] args) {
		TreeMap<Integer, String> tree = new TreeMap<>(); // TreeMap은  2진트리구조이다. <key, value> 형태로 타입지정
		// TreeMap 보다는 HashMap을 많이 사용한다
		tree.put(101, "서울특별시"); //입력은 put 메서드를 적용한다.
		tree.put(204, "인천광역시");
		tree.put(406, "대전광역시");
		tree.put(201, "광주광역시");
		tree.put(701, "대구광역시");
		tree.put(702, "울산광역시");
		tree.put(703, "부산광역시");
		
		System.out.println( tree );  
		
		//검색  대부분 key값으로만 검색이 되는 메소드
		System.out.println( tree.ceilingEntry(500));//지정한 키값보다 크거나 같은 값중 가장 작은 키 : value 반환
		System.out.println(tree.ceilingKey(500)); //지정한 키값보다 크거나 같은 값중 가장 작은 키 반환
		System.out.println( tree.floorEntry(300)); // 지정한 키값보다 작거나 같은 값중 가장 큰 키 : value 반환
		System.out.println( tree.floorKey(300));// 지정한 키값보다 작거나 같은 값중 가장 큰 키 반환
		System.out.println(tree.higherEntry(406));
		// 지정한 키값보다 큰 값중 가장 가까운 key : value 반환
		// higherKey() - 키만반환
		// lowerEntry() - 지정한 키 값보다 작은 값중에서 가장가까운 엔트리 반환
		// lowerKey() - 키만 반환
		
		System.out.println( tree.firstEntry());
		// 현재맵에서 가장작은키를 가진 엔트리변환
		//firstKey() - 키만반환
		System.out.println( tree.lastEntry());
		//현재맵에서 가장 큰키를 가진 엔트리 반환
		// lastKey() - 키만반환
		
		System.out.println( tree.pollLastEntry());
		//가장큰 키를가진 엔트리를 반환하고 맵에서 삭제
		//pollFirstEntry() - 가장작은 키를가진 엔트리를 반환하고 맵에서 삭제
		System.out.println( tree );
		
		System.out.println( tree.headMap(500));
		//지정한 키값보다 작은 키값들을 반환한다. - 지정한 키 포함
		//tailMap() - 지정한 키값보다 큰 키값들을 반환한다 - 지정한 키 포함
		//headMap() - tailMap() 의 두번째인자를 false로 넘겨주면 지정한 키는 포함하지 않는다.
		
		System.out.println( tree.subMap(200, 600 )); 
		// subMap(from, to) - from 키값부터 to키값 전까지에 해당하는 엔트리들을 반환
		
				Properties prop = new Properties(); //map과 유사하게 사용 Iterator 사용하지않는다
				prop.put("월요일", "한주가 시작한다..."); //문자열만 입력,  숫자를 입력해도 문자열로 처리
				prop.put("금요일", "와 내일부터... 쉬는날이 아니네");
				prop.put("수요일", "수요일마다 야외수업?");
				prop.setProperty("화요일", "아직 2일 지났다"); // setProperty가 Properties의 전용입력 메서드임
				
				System.out.println(prop);
				
				System.out.println( prop.get("월요일")); // put으로 입력한것은 get으로 반환
				System.out.println( prop.getProperty("화요일")); // setProperty로 입력한것은 getProperty로 반환
				
				Enumeration em = prop.elements();
				while( em.hasMoreElements()) {
					
					System.out.println( em.nextElement());
				}
				
				String filename = "C:\\ray\\njava\\newjava\\java_collection\\src\\javaMap\\router.properties";
				//router.properties 파일 에서 마우스우측 클릭 -> 메뉴하단 properties 클릭 -> 박스에서 location 주소전체 박스잡아서 복사하여 붙여넣기
				
				Properties router = new Properties();
				
				try(FileReader fs = new FileReader(filename)) 
				{
					router.load(fs);
				}catch(IOException e) {
					e.printStackTrace();
				}
				System.out.println( router );
				
				System.out.println( router.getProperty("signup"));
				
				//ResourceBundle eb = ResourceBundle.getBundle("router"); //router.properties 파일 가져오기
				
				
		
	}

}
