/**
 * 20240126-4
 */
 
 $(function(){
	
	4("#keyword").on("keyup",function(e){
		if( e.keyCode==13){
			$("#searchFm").submit();
		}
	});
	$(".search_box i").on("click",function(){
		$("#searchFm").submit();
	});
	
});