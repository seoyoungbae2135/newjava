package service.board;
// 20240126
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface board_action {
	
	public String action(HttpServletRequest request, HttpServletResponse response) throws IOException; //추상객체생성
}
