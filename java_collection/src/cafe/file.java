package cafe; // 20240105

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import customer.member;

public class file {
	
	public static List<member> member_load(){
		List<member> list = new ArrayList<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/member.txt")))
		{
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				member data = new member(temp[0], temp[1], temp[3], temp[2], temp[4], i(temp[5]));//public member의 순서대로한다.
				list.add(data);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("member파일 로드실패");
			
		}
		
		return null;
	}
	
	// List 대신 HashMap 적용
	public static HashMap<String, menu> menu_load() {
		
		HashMap<String, menu> list = new HashMap<>(); // menu.txt파일 읽어오기위한 
		
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/menu.txt"))){  // menu.txt파일 읽어오기위한 
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				menu data = new menu(temp[0] , i(temp[1]) , i(temp[2]) , i(temp[3]) , i(temp[4]) , i(temp[5]) , 
						temp[6].equals("커피") ? Category.커피 : temp[6].equals("음료") ? 
								Category.음료 : Category.빽스치노); // temp[6]도 메서드로 만들어 적용가능
				list.put(temp[0] , data); //key와 value형식
				
			}
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("menu파일 로드 실패");
		}
		return null; //return 이 필히 들어가야한다 public static List<menu> menu_load(){} 가 반환타입이므로
	}
	
	
	public static int i(String number) {  //정수로 변환시켜주는 메서드를 만들어서 menu data 객체에 적용(다른곳에도 적용가능)
		return Integer.parseInt(number); 
	}
	
	
	// 아래는 원본, List 적용시 코드
	
//	public static List<menu> menu_load() {
//		
//		List<menu> list = new ArrayList<>(); // menu.txt파일 읽어오기위한 
//		
//		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/menu.txt"))){  // menu.txt파일 읽어오기위한 
//			while(true) {
//				String line = bf.readLine();
//				if(line == null) break;
//				String[] temp = line.split(",");
//				
//				menu data = new menu(temp[0] , i(temp[1]) , i(temp[2]) , i(temp[3]) , i(temp[4]) , i(temp[5]) , 
//						temp[6].equals("커피") ? Category.커피 : temp[6].equals("음료") ? 
//								Category.음료 : Category.빽스치노); // temp[6]도 메서드로 만들어 적용가능
//				list.add(data);
//				
//			}
//			return list;
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println("menu파일 로드 실패");
//		}
//		return null; //return 이 필히 들어가야한다 public static List<menu> menu_load(){} 가 반환타입이므로
//	}
	
	


}
