<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>form요청</h2>
<hr/>
<form action="/studyhtml5/jsp/j01/j07_form_request.jsp" method="get">
이름:<input type="text" name="userNm" size="10"/><br/>
전화번호:<input type="text" name="userCell" size="10"/><br/>
좋아하는프로그램<br/> 
<input type="checkbox" name="lang" value="10"/>java<br/>
<input type="checkbox" name="lang" value="20"/>oracle<br/>
<input type="checkbox" name="lang" value="30"/>jsp<br/>
<input type="checkbox" name="lang" value="40"/>jquery<br/>
<input type="submit" value="전송">
</form>
</body>
</html>