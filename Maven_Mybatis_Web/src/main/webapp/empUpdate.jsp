<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">修改用户信息</h1>
<form action="<%=request.getContextPath()%>/update" method="post" style="text-align: center">
	<!-- 隐藏域 存放id  -->
  <input type="hidden"  name="id" value="${emp.id}"/>
    姓名：<input type="text" name="name" value="${emp.name}" ><br><br>
    年龄：<input type="text" name="age" value="${emp.age}" ><br><br>
    地址：<input type="text" name="address" value="${emp.address}"><br><br>
    生日：<input type="text" name="birthday" value="${emp.birthday}"><br><br>
 uid：<input type="text" name="uid" value="${emp.uid}"><br><br>
  <input type="submit" value="修改">
</form>
</body>
</html>