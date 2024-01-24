<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 20240124-6~7 --%>   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${ fail !=null }">
	<script>alert("아이디또는 비밀번호가 잘못되었습니다")</script>
</c:if> 
    
<div id="signin_wrap">
	<form id="signFm" method="post" action="/members/signExcute">
		<input type="hidden" name="cmd" value="dao">
		<div id="login_wrap">
			<div class="login_input">
				<input type="email" name="email" id="email" placeholder="이메일">	
			</div>
			<div class="login_input">
				<input type="password" name="pin" id="pin" placeholder="비밀번호">
			</div>
			<div class="login_bt">
				<a href="javascript:login()">Login</a>
			</div>
			<div class="find_sign">
				<a href="/members/forget">아이디/비밀번호찾기</a>
				<a href="/members/signup">회원가입</a>
			</div>
		</div>
	</form>
</div>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>