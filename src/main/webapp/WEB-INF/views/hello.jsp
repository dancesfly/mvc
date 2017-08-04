<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.net.*"%>
<%
	//Cookie name = new Cookie("name", URLEncoder.encode(request.getParameter("name"),"utf-8"));
	Cookie name = new Cookie("name", request.getParameter("name"));
	Cookie url = new Cookie("url", request.getParameter("url"));

	response.addCookie(name);
	response.addCookie(url);
%>

<script type="text/javascript" src="${pageContext.request.contextPath}/statics/jquery-3.2.1.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		//alert(window.location.hash);
		//window.location.href = "hello";
		alert(${resourcesPath});
		$("button").click(function() {
			
			var id = "123";
			
			$.ajax({
				url : "/mvc/ajax",
				data: {id:id},
				success : function(result) {
					var name = result.name;
					$("#div1").append("<b>sdsd</b>");
				},
				error : function() {
					alert("sdsddd");
					$("#div1").html("error");
				}
			});
			alert($("#userid").val());
			$("#div2").show();
		});
	});
</script>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cookies = request.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			Cookie cookie = cookies[i];
			//String name1 = URLEncoder.encode(cookie.getName(), "utf-8");
			//name1 = URLEncoder.encode(name1, "utf-8");
			//name1 = URLEncoder.encode(name1, "utf-8");
			//name1 = URLEncoder.encode(name1, "utf-8");
			//name1 = URLEncoder.encode(name1, "utf-8");
			//name1 = URLEncoder.encode(name1, "GBK");
			String name1 = cookie.getName();
			String value = cookie.getValue();
			out.print("Cookie名:" + name1 + " &nbsp; Cookie值:" + value + "<br>");
		}
	%>
	
	Userid:<input type="text" id="userid">
	
	${akey} ---ddd- ${user.user.name}<br><br>
	<button>按钮</button>
	<div id="div1"></div>
	${param.name}
	<div id="div2" style="display: none;">隐形</div>
	
	${flag}
</body>
</html>