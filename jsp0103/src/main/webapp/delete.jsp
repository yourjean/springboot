<%@page import="jdbc.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% //자바 부분 ))삭제 실행
	String empno = request.getParameter("empno"); //사번 받아오기(삭제 눌렀을때)
	int num = Integer.parseInt(empno);
	Dao dao = Dao.getInstance(); //싱글턴으로 getInstance사용
	dao.deleteEmpTemp(num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script> //자스부분))
alert("사번 <%=num%>이 삭제되었습니다.");
window.location.href = 'list.jsp';
</script>
</body>
</html>