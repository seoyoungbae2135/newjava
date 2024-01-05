package cafe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class file {
	
	public static List<menu> menu_load() {
		
		List<menu> list = new ArrayList<>(); // menu.txt파일 읽어오기위한 
		
		try(BufferedReader bf = new BufferedReader(new FileReader("c:/test/menu.txt"))){  // menu.txt파일 읽어오기위한 
			while(true) {
				String line = bf.readLine();
				if(line == null) break;
				String[] temp = line.split(",");
				
				String[] cal = temp[4].split("/");
				String[] ml = temp[5].split("/");
				
				for( int i=0; i<cal.length; i++) {
					menu data = new menu(temp[0] , i(temp[1]) , i(temp[2]) , i(temp[3]) , i(cal[i]) , i(ml[i]) , 
							temp[6].equals("커피") ? Category.커피 : temp[6].equals("음료") ? 
									Category.음료 : Category.빽스치노); // temp[6]도 메서드로 만들어 적용가능
					list.add(data);
				}
			}
			return list;
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("menu파일 로드 실패");
		}
		return null;
	}
	public static int i(String number) {  //정수로 변환시켜주는 메서드를 만들어서 menu data 객체에 적용(다른곳에도 적용가능)
		return Integer.parseInt(number);
	}

}
