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
String binum=request.getParameter("binum");
String bipwd=request.getParameter("bipwd");
String result="";
int resultNum=0;

if(binum!=null && bipwd!=null){
	BoardInfo bi = new BoardInfo();
	bi.setBinum(Integer.parseInt(binum));
	bi.setBipwd(bipwd);
	
	Connection con = null;
	PreparedStatement ps = null;
	result="삭제안된거같은데?";
	try{
		con = DBConn2.getCon();
		String sql="delete from board_info where binum=? and bipwd=?";
		ps = con.prepareStatement(sql);
		ps.setInt(1, bi.getBinum());
		ps.setString(2, bi.getBipwd());
		resultNum = ps.executeUpdate();
		if (resultNum == 1) {
			con.commit();
			result="삭제완료";
	}
	}catch (Exception e) {
		System.out.println(e);
	}finally{
		if(ps!=null){
			ps.close();
			ps = null;
		}
		DBConn2.closeCon();
	}
}
%>
<script>
alert("<%=result%>");
if(<%=resultNum%>==1){
location.href="<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>
</body>
</html>