<%@page import="studyhtml5.UserVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    UserVO vo = (UserVO)session.getAttribute("user");
    boolean login = vo.getUserId() == null?false:true;
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>세션확인</h2>
<hr/>
<%
if(login == true){
	out.print("userId:" +vo.getUserId()+"<br/>");
	out.print("userId:" +vo.getPasswd()+"<br/>");
	out.print("userId:" +vo.getName()+"<br/>");
}
%>
</body>
</html>