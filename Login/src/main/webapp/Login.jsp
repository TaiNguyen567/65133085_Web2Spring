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
		String u = request.getParameter("uname");
		String p = request.getParameter("upass");
		
		if(u.equals("ABC") && p.equals("MNK")){
			response.sendRedirect("UserProfile.html");
		}
		else{
			response.sendRedirect("Login.html");
		}
	%>
</body>
</html>