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
	int pBinum = Integer.parseInt(request.getParameter("binum"));
	Connection con = null;
	PreparedStatement ps = null;
	int binum = 0;
	String pBipwd=request.getParameter("bipwd");
	String bititle = "";
	String bicontent = "";
	String bipwd = "";
	String creusr = "";
	String credat = "";
	try{
		con = DBConn2.getCon();
		String sql = "select binum, bititle, bicontent, bipwd, creusr, credat from board_info where binum=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1,pBinum);
		ResultSet rs = ps.executeQuery();
		rs.last();
		int rowCnt = rs.getRow();
		if(rowCnt==0){
%>
			<script>
				alert("<%=pBinum%>번 게시물은 이미 지워졌어 자시가");
				history.back();
			</script>
<%
		}
		rs.beforeFirst();
		while(rs.next()){
			binum = rs.getInt("binum");
			bititle = rs.getString("bititle");
			bicontent = rs.getString("bicontent");
			creusr = rs.getString("creusr");
			credat = rs.getString("credat");
			bipwd = rs.getString("bipwd");
			if(!bipwd.equals(pBipwd)){
				%>
				<script>
				alert("<%=pBinum%>번 글의 비밀번호 틀렸어");
				history.back();
				</script>
				<%
		}
		}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn2.closeCon();
	}
%>

    <div class="container">
<form action ="/board/board_update_ok.jsp">
<table border="1" class='table table-bordered table-hover'>
<tr>
<td>제목 : </td>
<td><input type="text" name="bititle" id="bititle" value="<%=bititle%>" /></td><br/>
</tr>
<tr>
<td>내용 : </td>
<td><textarea name="bicontent" id="bicontent" ><%=bicontent%></textarea> /></td><br/>
</tr>
<tr>
<td>글쓴이 : </td>
<td><input type="text" name="creusr" id="creusr" value="<%=creusr%>" /></td><br/>
</tr>
<tr>
<td>생성일자 :  </td>
<td><%=credat%></td><br/>
</tr>
<tr>
<td>비밀번호 : </td>
<td><input type="password" name="bipwd" id="bipwd" value="<%=bipwd%>"/></td><br/>
</tr>
</table>
<input type="hidden" name="binum" id="binum" value="<%=binum%>"/><br/>
<input type="submit" value="확인"/>
<input type="button" value="뒤로가기" onclick="doMovePage('cancel')"/>
</form>
</body>
</html>