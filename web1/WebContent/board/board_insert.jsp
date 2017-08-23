<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

    <div class="container">
      <div class="starter-template">
<form action="/board/board_insert_ok.jsp">
<table border="1" class='table table-bordered table-hover'>
<tr>
	<td>제목 : 	</td>
	<td><input type="text" id="bititle" name="bititle" /></td>	<br />
	</tr>
	<tr>
	<td>내용 :	</td>
	<td><input type="text" id="bicontent" name="bicontent" /></td>	<br /> 
	</tr>
	<tr>
	<td>작성자 :	</td>
	<td><input type="text" id="creusr" name="creusr" value=<%=userId%> /></td>	<br />
	</tr>
	<tr>
	<td>작성일자 :	</td>
	<td><input type="date" id="credat" name="credat" /></td>	<br />
	</tr>
	<tr>
	<td>비밀번호 :	</td>
	<td><input type="text" id="bipwd" name="bipwd" /></td>	<br />
	</tr>
	</table>
	<input type="submit" value="작성" />
	<input type="button" value="뒤로가기" onclick="doMovePage('cancel')" />
	</form>
	</div>
	</div>
</body>
</html>