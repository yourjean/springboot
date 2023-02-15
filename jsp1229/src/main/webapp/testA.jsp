<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>The XMLHttpRequest Object</h2>
<button id="btn" onClick="getContent()">클릭</button>
	<div id="demo"></div>
<script>
function getContent(){
	var xhttp;
	xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(this.readyState == 4 && this.status == 200){
			document.getElementById('demo').innerHTML = xhttp.responseText;
		}
	}
	xhttp.open("GET","./list.jsp",true);
	xhttp.send();
}
</script>
</body>
</html>