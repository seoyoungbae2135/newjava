/**
 * 20240126-4
 */
 
 $(function(){
	
	$("#keyword").on("keyup",function(e){
		if( e.keyCode==13){
			$("#searchFm").submit();
		}
	});
	$(".search_box i").on("click",function(){
		$("#searchFm").submit();
	});
	
});