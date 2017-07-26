<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,com.mvc.api.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert</title>
</head>
<body>
	<%
		List<User> uList = new ArrayList<User>();
		uList.add(new User("张无忌"));
		uList.add(new User("杨过"));
		uList.add(new User("慕容子宁"));
		uList.add(new User("郭靖"));
		request.setAttribute("uList", uList);
	%>
	<c:forEach var="user" items="${uList}">
		${user.name}
	</c:forEach>
	
	<c:forEach var="d" items="${dd}">
		${d}
	</c:forEach>
</body>
</html>