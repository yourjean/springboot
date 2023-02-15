<%@page import="java.util.ArrayList"%>
<%@page import="jdbc.Emp"%>
<%@page import="java.util.List"%>
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
EmpDao ed = EmpDao.getInstance(); 
List<Emp> lst = ed.selectAll(0);
double avg = lst.stream().filter(n->n.getDeptno() == 10).mapToInt(Emp::getSal).average().getAsDouble(); //n으 emp
out.println(avg); //10번 부서 평균

List<Emp> dept10 = new ArrayList<>();
lst.stream().filter(n->n.getDeptno() == 10).forEach(x->dept10.add(x));

for (Emp emp : dept10){
	out.print(emp+"<br/?>");
}
%>




</body>
</html>