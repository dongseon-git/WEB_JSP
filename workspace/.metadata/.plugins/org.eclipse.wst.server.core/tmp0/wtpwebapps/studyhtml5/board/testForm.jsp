<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file = "/com/common.jsp" %>
    <%
    LOG.debug("contPath:" +contPath);
    %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<meta charset="UTF-8">
<link rel="shortcut icon" type="image/x-icon" href="<%=contPath %>/favicon.ico">

<!--reset 스타일 시트 -->
<!-- link rel="stylesheet" type="text/css" href="<%=contPath %>/asset/css/reset.css" -->
<link rel="stylesheet"  type="text/css" href="<%=contPath %>/asset/css/jQuery-ui.css">
<!--스타일 시트 -->
<style type="text/css">
</style>
<title>Insert title here</title>
<!-- jquery -->
<script type="text/javascript" src="<%=contPath %>/asset/js/jquery-1.12.4.js"></script>
<!-- jQuery UI -->
<script type="text/javascript" src="<%=contPath %>/asset/js/jQuery-ui.js"></script>

</head>
<body>
<h2>view->controller call</h2>
<hr/>
<div>
    <input type="button" value="전송" onclick="doSave();"> 
    </div>
    <form action="<%=contPath %>/board/board.do" name="boardFrm" id="boardFrm" >

      
    </form>
    
    <script type="text/javascript">
$(document).ready(function(){
    console.log(`document ready`);
});
function doSave(){
    console.log(`doSave()`);
    let frm = document.getElementById("boardFrm");
    frm.submit();
    
}
</script>
</body>
</html>