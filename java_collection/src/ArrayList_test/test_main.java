package ArrayList_test;  //20240103 - 7, 8교시

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;



public class test_main {

	public static void main(String[] args) {
		
		ArrayList<food> list = load();
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i) );
			System.out.println("박물관이 살아있다");
		}

	}
	
	public static ArrayList<food> load() {
		ArrayList<food> list = new ArrayList<food>();
		
		try(BufferedReader bff = new BufferedReader(new FileReader ("c:/test/food.txt")) )
		{
			while(true) {
				String line = bff.readLine();
				if(line == null ) break;
				String[] temp = line.split("-");
				food data = new food(temp[0], Integer.parseInt (temp[1]), temp[2]);
				list.add( data );
			}
			
		}catch(Exception e) {
			System.out.println("파일 로드 및 반환 실패");
			e.printStackTrace();
		}
		return list;
	}

}


