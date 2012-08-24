$(function(){

	$("#safeCodeDiv").load("servlet/SafeCodeServlet" + "?time=" + Math.random());
	
	$("#safeCodeDiv").click(function(){
		//alert("ok");
		$("#safeCodeDiv").load("servlet/SafeCodeServlet" + "?time=" + Math.random());	
	}); 
});