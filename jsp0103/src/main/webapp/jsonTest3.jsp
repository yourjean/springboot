<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="json"></div>
<script type="text/javascript">
var date = new Date(); //자스 Date 객체
var str = date.toJSON(); //Date객체를 JSON 형식의 문자열로 반환함
console.log(date);
console.lod(str);
document.getElementById("json").innerHTML = date + "<br>";
document.getElementById("json").innerHTML += str;
</script>
</body>
</html>