<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.BoardInfo"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = DBConn2.getCon();
			String sql = "select binum,bititle,bicontent,bipwd,creusr,credat from board_info";
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			String tableStr = "<table border='1'>";
			tableStr += "<tr>";
			tableStr += "<td>번호</td>";
			tableStr += "<td>제목</td>";
			tableStr += "<td>내용</td>";
			tableStr += "<td>비밀번호</td>";
			tableStr += "<td>작성자</td>";
			tableStr += "<td>작성일자</td>";
			tableStr += "</tr>";
			while (rs.next()) {
				tableStr += "<tr>";
				tableStr += "<td>" + rs.getInt("binum") + "</td>";
				tableStr += "<td>" + rs.getString("bititle") + "</td>";
				tableStr += "<td>" + rs.getString("bicontent") + "</td>";
				tableStr += "<td>" + rs.getString("bipwd") + "</td>";
				tableStr += "<td>" + rs.getString("creusr") + "</td>";
				tableStr += "<td>" + rs.getString("credat") + "</td>";
				tableStr += "</tr>";
			}
			tableStr += "</table>";
			out.println(tableStr);
		} catch (Exception e) {
			System.out.println(e);
		}finally{
			if(ps!=null){
				ps.close();
				ps = null;
			}
			DBConn2.closeCon();
		}
	%>
<form action ="/board/board_delete_ok.jsp">
지울 글 번호 : <input type="text" name="binum" id="binum"/></br>
비밀번호 : <input type="text" name="bipwd" id="bipdw"/></br>
<input type="submit" value="확인"/>
<input type="button" value="뒤로가기" onclick="doMovePage('cancel')"/>
</form>
</body>
</html>