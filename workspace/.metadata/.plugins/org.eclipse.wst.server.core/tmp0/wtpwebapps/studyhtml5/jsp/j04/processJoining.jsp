<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!-- MemberInfo  memberInfo = new MemberInfo() -->   
<jsp:useBean id="memberInfo" class="com.pcwk.j04.MemberInfo"/>
<!-- MemberInfo set에 값을 메핑 -->
<jsp:setProperty name="memberInfo" property="*"/>
<!-- 비번 -->
<jsp:setProperty name="memberInfo" property="password"  value="<%=memberInfo.getId() %>"/>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원가입 정보</h2>
<hr/>
아이디:<%= memberInfo.getId() %><br/>
이름:<%=memberInfo.getName() %><br/>
이메일:<%=memberInfo.getEmail() %><br/>
비번:<jsp:getProperty property="password" name="memberInfo"/>
</body>
</html>