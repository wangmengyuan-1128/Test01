<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">显示emp数据</h1>
<table  border="1" align="center" width="75%">
	<tr align="center">
		<th>ID</th>
		<th>姓名</th>
		<th>年龄</th>
		<th>地址</th>
		<th>生日</th>
		<th>uid</th>
		<th>操作</th>
	</tr>
	
	<c:forEach  items="${empList}" var="emp">
		<tr align="center">
			<td>${emp.id}</td>
			<td>${emp.name}</td>
			<td>${emp.age}</td>
			<td>${emp.address}</td>
			<td>${emp.birthday}</td>
			<td>${emp.uid}</td>
			<td>
				<a href="${pageContext.request.contextPath}/deleteEmp?id=${emp.id}">删除</a>
				<a href="${pageContext.request.contextPath}/updateEmp?id=${emp.id}">修改</a>
			</td>
		</tr>
	</c:forEach>
	
</table>
</body>
</html>