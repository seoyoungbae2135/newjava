<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Arrays" %>    

<%--20240123-4 ~  --%>

<%-- ${ emailList[0] } --%> <%-- EL표현식 lib에 등록된 jstlel파일 의해 그대로 동작 20240124-2 수업참조  --%>

<div id="signup_wrap">
	<form id="signupFm" method="post" action="/members/signSave"> <!-- 20240124-1 수업 참조  -->
		<input type="hidden" name="cmd" value="dao">  <!-- 20240124-1, 5 수업 참조  -->
		
		<div class="myphoto">
			<div class="photo"></div>
			<input type="file" name="face" id="face">
			<label for="face">내 사진 업로드</label>
		</div>
		
		<div class="input_data">
			<label for="email">E-MAIL</label>
			<input type="email" name="email" id="email" required> <!-- required->필수입력으로 설정  -->
			<span class="email_msg"></span>
		</div>
		<div class="input_data">
			<label for="pin">Password</label>
			<input type="password" name="pin" id="pin" required>
		</div>
		<div class="input_data">
			<label for="pin2">Check Password</label>
			<input type="password" id="pin2">
		</div>
		<div class="input_data">
			<label for="name">Name</label>
			<input type="text" name="name" id="name">
		</div>
		<div class="input_data">
			<label for="tel">Tel.</label>
			<input type="text" name="tel" id="tel">
		</div>
		
		<div class="signBt">
			<button type="button" id="bt" class="active inactive" disabled>Sign</button>
		</div>
	</form>
</div>

<%-- 20240124-2 수업참조, 자바스크립트에서 사용가능한 배열로 가져오기, db에 있는 email을 클라이언트에서 입력되는 email과 비교하기 위하여--%>
<script>
	var temp = '${ Arrays.toString(emailList) }';
	temp = temp.substring(1, temp.length-1);
	let email = temp.split(",");
	console.log( email);
	
	$("#email").on("blur", function() { // 커서가 빠졌을때(blur)
		if( $(this).val() != '' ) { // 문자가 있다면
			if( email.indexOf($(this).val()) == -1 ){ // 비교해서 같은 메일주소가 없다면
				$(".email_msg").text("사용가능한 이메일 입니다")
				$(".email_msg").removeClass("warning");
			}else {                                   // 있다면
				$(".email_msg").text("등록된 이메일 입니다");
				$(".email_msg").addClass("warning");
			}
		}
	});
	
</script>

