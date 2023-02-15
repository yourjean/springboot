<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	if (id.equals(pass)) {
		session.setAttribute("MID", "ok");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
로그인 성공
</form>
</body>
</html>
<% } else { %>
<script type="text/javascript">
alert("로그인 실패");
history.go(-1); //뒷페이지로 감

</script>
<%} %>