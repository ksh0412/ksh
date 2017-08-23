<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.google.gson.*"%>
<%@ page import="java.util.*"%>

<%
Gson g = new Gson();
HashMap<String,String> hm = g.fromJson(request.getReader(),HashMap.class);
ResultSet rs= null;
String ginum1="";
String sql="";
int rowCnt=10;
int nowPage=1;
int blockCnt=10;
int totalPageCnt=0;
int totalBlockCnt=0;
int totalCnt=0;

Connection con=null;
PreparedStatement ps=null;
ArrayList<Map<String,Object>> goodsList=new ArrayList<Map<String,Object>>();
ArrayList<Map<String,String>> vendorList=new ArrayList<Map<String,String>>();

try{
	con=DBConn2.getCon();
	
	if(hm!=null&&hm.get("nowPage")!=null){
		nowPage=Integer.parseInt(hm.get("nowPage"));
	}

	if(hm!=null){
		ginum1=hm.get("ginum");
	}
	int ginum=0;
	
	if(ginum1!=null && !ginum1.equals("")){
		ginum=Integer.parseInt(ginum1);
	}

	sql="select count(1) from goods_info gi, vendor_info vi" 
			+" where gi.vinum=vi.vinum";
	ps = con.prepareStatement(sql);
	rs = ps.executeQuery();
	
	while(rs.next()){
		totalCnt=rs.getInt(1);
	}
	
	
	if(totalCnt !=0){
		int mod = totalCnt%rowCnt;
		totalPageCnt=totalCnt/rowCnt;
		if(mod!=0){
			totalPageCnt +=1;
		}
	}
	
	if(totalPageCnt !=0){
		int mod = totalPageCnt% blockCnt;
		totalBlockCnt = totalPageCnt / blockCnt;
		if(mod !=0){
			totalBlockCnt +=1;
		}
	}
	
	sql="select gi.ginum,gi.giname,gi.gidesc,vi.vinum,vi.viname from goods_info gi, vendor_info vi" 
			+" where gi.vinum=vi.vinum";
	
	if(ginum!=0){
		sql += " and gi.ginum=?";
	}

	sql+= " order by gi.ginum";
	sql+= " limit ?,?";
	ps = con.prepareStatement(sql);
	if(ginum!=0){
		ps.setInt(1,ginum);
		ps.setInt(2,(nowPage-1)*rowCnt);
		ps.setInt(3,rowCnt);
	}
	ps.setInt(1,(nowPage-1)*rowCnt);
	ps.setInt(2,rowCnt);
	rs = ps.executeQuery();
	while(rs.next()){
		Map<String, Object>rhm=new HashMap<String, Object>();
		rhm.put("ginum", rs.getInt("ginum"));
		rhm.put("giname", rs.getString("giname"));
		rhm.put("gidesc", rs.getString("gidesc"));
		rhm.put("vinum", rs.getString("vinum"));
		rhm.put("viname", rs.getString("viname"));
		goodsList.add(rhm);
	}
	
	sql="select * from vendor_info";
	
	ps = con.prepareStatement(sql);
	rs = ps.executeQuery();
	while(rs.next()){
		Map<String, String>rhm=new HashMap<String, String>();
		rhm.put("vinum", rs.getString("vinum"));
		rhm.put("viname", rs.getString("viname"));
		vendorList.add(rhm);
	}
	System.out.println(totalCnt);
	System.out.println(totalPageCnt);
	System.out.println(totalBlockCnt);
	
}catch(Exception e){
	System.out.println(e);
}finally{
	if(ps!=null){
		ps.close();
		ps=null;
	}
	DBConn2.closeCon();
}

HashMap<String, Integer> pageHm = new HashMap<String, Integer>();
pageHm.put("nowPage", nowPage);
pageHm.put("totalPageCnt", totalPageCnt);
pageHm.put("totalBlockCnt", totalBlockCnt);
pageHm.put("blockCnt", blockCnt);
pageHm.put("totalCnt", totalCnt);

HashMap<String,Object> resultHm = new HashMap<String,Object>();
resultHm.put("vendorList",vendorList);
resultHm.put("goodsList",goodsList);
resultHm.put("pageHm", pageHm);
String json=g.toJson(resultHm);

System.out.println(json);
out.print(json);

%>