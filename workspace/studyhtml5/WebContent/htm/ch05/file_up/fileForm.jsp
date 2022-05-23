<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>파일 업로드</title>
</head>
<body>
    <h2>파일업로드</h2>
    <hr/>
    <form name="fileForm" action="fileUpload.jsp" method="post" enctype="multipart/form-data">
        <table border="1" >
            <tr>
                <td width="100"><label for="user">작성자</label></td>
                <td width="100"><input type="text"  name="user" id="user" size="20"/></td>
            </tr>
            <tr>
                <td><label for="title">제목</label></td>
                <td><input  type="text" name="title" id="title" size="20"/></td>
            </tr>	        
            <tr>
                <td><label for="uploadFile">파일</label></td>
                <td><input type="file" name="uploadFile" id="uploadFile"  /></td>
            </tr> 
            <tr>
                <td><label for="uploadFile2">파일2</label></td>
                <td><input type="file" name="uploadFile2" id="uploadFile2"  /></td>
            </tr>               
            	        
            <tr>
                <td colspan="2"><input type="submit" value="파일전송"/></td>
            </tr>
        </table>
    </form>
</body>
</html>