/**
 * 20240123-4 ~ 
 */
 
 $(function(){
 
 	$(".input_data input").on("keyup",function(){
		for(var i=0; i<$(".input_data input").length; i++){
			if($(".input_data input").eq(i).val() == '')
			break;
		}
		if( i == $(".input_data input").length){
			$("#bt").attr("disabled", false);
			$("#bt").removeClass("inactive");
		}
		else{
			$("#bt").attr("disabled", true); // 비활성화코드
			$("#bt").addClass("inactive");
		}
});
 
 	$("#bt").on("click",function(){
 		if( $("#pin").val() != $("#pin2").val() ){
 			alert("비밀번호를 확인해 주세요");
 			$("#pin").val("");
 			$("#pin2").val("");
 			$("#pin").focus();
 			$("#bt").attr("disabled", true); // 비번불일치시 비활성화
			$("#bt").addClass("inactive");
 		}else{
 			$("#signupFm").submit(); //form 내부의 데이터서버에 전달
 		}
 	});
 	
 });