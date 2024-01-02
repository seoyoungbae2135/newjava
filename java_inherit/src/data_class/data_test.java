package data_class;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

public class data_test {

	public static void main(String[] args) {
		
		book[] info = new book[10];
		
		try (BufferedReader bf = new BufferedReader(new FileReader("c:/test/book.txt"))) //파일불러오기
		{
			int i=0;
			while(true) {  //파일내용를 마지막줄까지 
				String line = bf.readLine();
				if(line==null) break;
				String[] temp = line.split(",");
				
				book data = new book(temp[0], temp[1], temp[2]);
				info[i] = data;
				i++;
			}
			
		}catch(Exception e) {
			System.out.println("파일로드및 반환실패 ");
			e.printStackTrace();
		}
		
		System.out.println(Arrays.toString(info));
		
	}

}
