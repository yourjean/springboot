<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table class="aa" border="1"></table>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script>
$(function(){
	var list = ['hong', 'kim', 'lee', 'park'];
	$.each(list, function(i,v){
		console.log(v);
		$('.aa').append('<tr><td>'+v+'</td></tr>');
	});
});
</script>
</body>
</html>