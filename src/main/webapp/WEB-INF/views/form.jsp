<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>  

<html>
<head>
<meta content="Context-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<h2>Hello World!</h2>
	
	${name}
	
	<sf:form action="form" method="post" modelAttribute="user">
		name:<sf:input path="name" /><sf:errors path="name" /><br/>
		<input type="submit" value="提交" />&nbsp;<input type="reset" value="重置" />
	</sf:form>
	
</body>
</html>
