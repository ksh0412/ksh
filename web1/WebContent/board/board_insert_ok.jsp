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
		String bititle = request.getParameter("bititle");
		String bicontent = request.getParameter("bicontent");
		String bipwd = request.getParameter("bipwd");
		String creusr = request.getParameter("creusr");
		String credat = request.getParameter("credat");
		
		int result=0;
		String result1="";

		if (bititle != null && bicontent != null && bipwd != null && creusr != null && credat != null) {
			BoardInfo bi = new BoardInfo();
			bi.setBititle(bititle);
			bi.setBicontent(bicontent);
			bi.setBipwd(bipwd);
			bi.setCreusr(creusr);
			bi.setCredat(credat);

			Connection con = null;
			PreparedStatement ps = null;
			try {
				con = DBConn2.getCon();
				String sql = "insert into board_info(bititle,bicontent,bipwd,creusr,credat)";
				sql += "values(?,?,?,?,now())";
				ps = con.prepareStatement(sql);
				ps.setString(1, bi.getBicontent());
				ps.setString(2, bi.getBititle());
				ps.setString(3, bi.getBipwd());
				ps.setString(4, bi.getCreusr());
				result = ps.executeUpdate();
				if (result == 1) {
					con.commit();
					result1+="작성완료";
				}
			} catch (Exception e) {
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
var result="<%=result1%>";
alert(result);
if(<%=result%>==1){
location.href="<%=rootPath%>/board/board_select.jsp";
}else{
	history.back();
}
</script>
</body>
</html>