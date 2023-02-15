<%@page import="java.util.List"%>
<%@page import="jdbc.*"%>
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
	Dao edd = Dao.getInstance();
	
	String empnoS = request.getParameter("empno");
	String mgrS = request.getParameter("mgr");
	String salS = request.getParameter("sal");
	String commS = request.getParameter("comm");
	String deptnoS = request.getParameter("deptno");
	try {
		int empno = Integer.parseInt(empnoS);
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = Integer.parseInt(mgrS);
		String hiredate = request.getParameter("hiredate");
		int sal = Integer.parseInt(salS);
		int comm = Integer.parseInt(commS);
		int deptno = Integer.parseInt(deptnoS);
		Emp emp = new Emp(empno, ename, job, mgr,
				          hiredate, sal, comm, deptno);
		int result = edd.insertEmpTemp(emp);
		out.println(result+"건 입력완료!");
	} catch (java.lang.NumberFormatException e) {
		int empno = 0;
		String ename = request.getParameter("ename");
		String job = request.getParameter("job");
		int mgr = 0;
		String hiredate = request.getParameter("hiredate");
		int sal = 0;
		int comm = 0;
		int deptno = 0;
		//????
	}
	
	
%>
<script>
alert("사번 <%=empnoS%>이 저장됨");
window.location.href = 'list.jsp';'
</script>
</body>
</html>





