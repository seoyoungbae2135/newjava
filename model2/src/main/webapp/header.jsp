<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 20240122-5 --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="header">
	<div id="top">
		<ul class="top_list">
			<c:if test="${ sessionScope.user == null }"> <!-- 로그인 하지않았을때 보이는 메뉴 -->
				<li><a href="/members/signIn">로그인</a></li> <!-- 20240124-1 수업 참조 -->
				<li><a href="/members/signup">회원가입</a></li> <!-- 20240124-1 수정 수업 참조 "/members?cmd=signup"에서 변경, web.xml 변경에 의해 cmd 사용안함-->
			</c:if>
			
			<c:if test="${ sessionScope.user != null }"> <!-- 로그인 했을때 보이는 메뉴 -->
				<li><a href="/members/myWrite">${ sessionScope.user.name }</a></li> <!-- 20240124-1, 8 수업 참조 -->
				<li><a href="/members/myPage">내정보</a></li> <!-- 20240124-1 수업 참조 -->
				<li><a href="/members/logout">로그아웃</a></li> <!-- 20240124-1 수업 참조 -->
			</c:if>	
			<li><a href="">HELP</a></li>
		</ul>
	</div>
	<div id="nav">
		<ul class="menu_list">
			<li class="menu"><a href="">WHY</a></li>
			<li class="menu"><a href="">WHO</a></li>
			<li class="menu"><a href="/board.do">STUDY</a></li>
			<li class="menu"><a href="">TEST</a></li>
		</ul>
	</div>
</div>