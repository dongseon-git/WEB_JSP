<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>request header 정보</h2>
<hr/>
<%--
http 프로토콜의 헤더에는 웹브라우저 종류(userAgent), 언어,호스
getHeaderNames() 요청과 관련된 모든 해더의 이름을 구한다.                                                                    
getHeader(name) 이름이 name인 해더의 값을 String으로 구한다.                                                                    
 --%>
 
<%
Enumeration<String> names = request.getHeaderNames();
while(names.hasMoreElements()){
	String headerName = names.nextElement();
	//System.out.println("headerName:"+headerName);
	out.println(headerName+":"+request.getHeader(headerName)+"<br/>");
}
out.println("<hr/>");
String userAgent = request.getHeader("user-agent");
String host = request.getHeader("host");
out.println("userAgent" + userAgent+"<br/>");
out.println("host" + host+"<br/>");
%>
</body>
</html>