<%@page import="jdbc.Emp"%>
<%@page import="jdbc.Dao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
a.btn{
display:block;
width:60px;
line-height:30px;
text-allign:center;

}

</style>
</head>
<body>
<a href="insertEmpForm.jsp">사원 등록</a>
<table border="1">
		<tr>
			<td>사번</td>
			<td>이름</td>
			<td>
					<select onChange="order(this.value)">
						<option value="0">부서별</option>
						<option value="1">오름차순</option>
						<option value="2">내림차순</option>
					</select>
			</td>
			<td>삭제</td>
		</tr>
		<%
		Dao ed = Dao.getInstance();
		for (Emp emp : ed.selectEmpTempAll()) {
		%>
		<tr>
			<td><a href="updateEmpForm.jsp?empno=<%=emp.getEmpno()%>"><%=emp.getEmpno()%></a></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getDeptno()%></td>
			<td><a class="btn" href="delete.jsp?empno=<%=emp.getEmpno()%>">삭제</a></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>