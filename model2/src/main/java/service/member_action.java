package service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 20240124-4 intreface 파일
public interface member_action {

		public String action(HttpServletRequest request, HttpServletResponse response) throws IOException; //추상객체생성
}
