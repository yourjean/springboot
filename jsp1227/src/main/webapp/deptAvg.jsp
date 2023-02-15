<%@page import="jdbc.Emp"%>
<%@page import="jdbc.EmpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	int num = Integer.parseInt(request.getParameter("empno"));
	EmpDao ed = EmpDao.getInstance(); // 싱글톤? 이라서 이렇게 불러옴
	Emp emp = ed.select(num);
	out.print(emp);
	%>
</body>
</html>