<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="java.util.*" %>
<%@ page import="com.google.gson.*" %>
<%@ page import="java.io.*" %>

<%
String id = null;
String pwd = null;
UserInfo ui = null;
Gson g = new Gson();
ui = g.fromJson(request.getReader(), UserInfo.class);

String result="";
String login = "false";
if(ui!=null){
	
	Connection con = null;
	PreparedStatement ps = null;
	try{
		con = DBConn2.getCon();
		String sql = "select username, age, address, hp1,hp2,hp3,userpwd from user_info where userid=?";
		ps=con.prepareStatement(sql);
		ps.setString(1,ui.getUserId());
		ResultSet rs= ps.executeQuery();
		while(rs.next()){
			String userPwd = rs.getString("userpwd");
			String userName = rs.getString("username");
			int age = rs.getInt("age");
			String address=rs.getString("address");
			String hp1 = rs.getString("hp1");
			String hp2 = rs. getString("hp2");
			String hp3 = rs.getString("hp3");
			if(userPwd.equals(ui.getUserPwd())){
				login = "ok";
				result="로그인 성공";
				session.setAttribute("userid",ui.getUserId());
				session.setAttribute("username",userName);
				session.setAttribute("age",age);
				session.setAttribute("address", address);
				session.setAttribute("hp1",hp1);
				session.setAttribute("hp2",hp2);
				session.setAttribute("hp3",hp3);
			}else{
				result="비밀번호 틀렸어";
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
	if(result.equals("")){
		result="그런 아이디 없어";
	}
}else{
	result="로그아웃";
	//세션 초기화
	session.invalidate();
}
HashMap hm=new HashMap();
hm.put("login",login);
hm.put("msg",result);
String json=new Gson().toJson(hm);
out.write(json);
%>