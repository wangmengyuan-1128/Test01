<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">添加员工</h1>
<form action="<%=request.getContextPath()%>/EmpAdd" method="post" align="center">
	姓名：<input type="text" name="name" /> <br/>
	年龄：<input type="text" name="age" /> <br/>
	地址：<input type="text" name="address" /> <br/>
	生日：<input type="text" name="birthday" /> <br/>
	UID ：<input type="text" name="uid" /> <br/>
	 <input type="submit" />
</form>
</body>
</html>