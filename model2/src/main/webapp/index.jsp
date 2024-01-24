<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 20240122-5~ jsp model2 --%>
<%-- core 라이브러리를 사용하는 방법 prefix는 별명지정 core는 c로 별칭 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- formatting 라이브러리를 사용하는 방법, 이하는 여기서는 사용하지않으므로 주석처리 --%>
<%--@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" --%>
<%-- functions 라이브러리를 사용하는 방법 --%>
<%--@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" --%>
<%-- sql 라이브러리를 사용하는 방법 --%>
<%--@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" --%>
<%-- xml 라이브러리를 사용하는 방법 --%>
<%--@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" --%>

<%-- 
	String part = "main";
	if(request.getAttribute("part") !=null ){
		part= (String)request.getAttribute("part");
	} 이것을 jstl로 나타내면 아래 <c:set .... 와같다
--%>

<%-- core set : var=변수명, value=값, scope=영역(request,page(기본),application, session)
	 core if : test-조건식, 조건식이 참일경우에 대해서만 처리가능
	 core choose : switch문과 비슷한 동작을 한다.
	 	  when : test-조건식 , choose내부에 여러개의 when을 만들 수 있다.
	 	  otherwise : choose내부의 when태그중에 일치하는 조건이 없으면 otherwise가 실행된다.
	 core forEach : for문과 비슷한 동작, var-내부변수명, begin-시작값, end-종료값, step-증감값
	 	  c:forEach var="i" begin="1" end="10" step="1"
	 	  c:forEach var="name" items="people"  , people은 배열 또는 컬렉션
	 core redirect : url-처리할 페이지 주소
	 
 --%>

<c:set var="part" value="main" scope="page" />
<c:if test="${prt != null }" > 
	<c:set var="part" value="${prt }"/>
</c:if>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 애플반 </title>
<!-- 부트스트랩 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">
<!--Jquery-->
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" crossorigin="anonymous"></script>    

<link rel="stylesheet" href="http://localhost:8080/static/css/default.css"> <%-- 절대경로로 변경 20240124-2 수업참조--%>
<script src="http://localhost:8080/static/js/init.js"></script> <%-- 절대경로로 변경 20240124-2 수업참조--%>

<%-- part 파라미터의 유무에 따라 추가 css,js --%>
<link rel="stylesheet" href="http://localhost:8080/static/css/${part }.css"> <%-- 절대경로로 변경 20240124-2 수업참조--%>
<script src="http://localhost:8080/static/js/${part }.js"></script> <%-- 절대경로로 변경 20240124-2 수업참조--%>
</head>
<body>
	<div id="wrap">
		<%@ include file="header.jsp" %>

		<div id="main">
			<c:import url="${part }.jsp" charEncoding="UTF-8"/> <!-- prt에 있는 주소값으로 이동 -->
		</div>
		
		<%@ include file="footer.jsp" %>
	</div>

</body>
</html>


<!-- 
	
	회원가입 - 로그인 
	게시판 - 목록, 글쓰기, 수정, 삭제, 댓글 
		
	jstl - jsp standard tag library
		core - 변수(배열, 객체등), 조건문, 반복문
		 
		formatting - 날짜, 시간, 숫자, 통화단위, 텍스트 등을 표시하는 방법
		functions -메서드를 사용할 수 있는 라이브러리
		database - 데이터베이스 상호작용 라이브러리
		xml - xml문서를 생성 조작하기위한 라이브러리
-->




















