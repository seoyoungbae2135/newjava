<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--20240123-4 --%>

${ emailList[0] }

<div id="signup_wrap">
	<form id="signupFm" method="post" action="/members" >
		<input type="hidden" name="cmd" value="signSave">
	
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

