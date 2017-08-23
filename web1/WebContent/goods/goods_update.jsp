<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="com.test.common.DBConn2"%>
<%@ page import="com.test.dto.UserInfo"%>
	<div class="container-view"> 
		<table id="table"  data-height="460"	class="table table-bordered table-hover">
		<thead>
			<tr> 
				<th colspan="3" class="text-center"><h5 class="form-signin-heading">상품상세 페이지</h5></th>
			</tr>
			<tr>
				<td class="col-md-2">상품번호</td>
				<td class="col-md-4" colspan="2"><%=request.getParameter("giNum") %></td>
			<tr>
				<td>상품이름</td>
				<td colspan="2"><input type = "text" id = "giName" name = "giName" ></td>
			</tr>
			<tr>
				<td>상품설명</td>
				<td colspan="2"><input = "text" id = "giDesc" name = "giDesc"></td>
			</tr>
			<tr>
				<td>생산자번호</td>
				<td colspan="2"><%=request.getParameter("viNum") %></td>
			</tr>
			<tr>
				<td>생산자이름</td>
				<td colspan="2"><%=request.getParameter("viName") %></td>
			</tr>
			<tr>
				<td>
					<button id="btnUpdate" class="btn btn-md-2 btn-primary btn-block" 	type="button">수정</button>
				</td>
				<td>
					<button id="btnDelete" class="btn btn-md-2 btn-primary btn-block" 	type="button">취소</button>
				</td>
				<td>
					<button id="btnGoList" class="btn btn-md-2 btn-primary btn-block" 	type="button">리스트 이동</button>
				</td>
			</tr>
		</table>
	</div>
	<!-- /container -->
<script>
$("#btnDelete").click(function(){
	history.back();
});

function callBackView(result){
	alert(result.msg);
	if(result.url!=""){	
		location.href = result.url + "?nowPage=" + result.page.nowPage +"&giNum=" + <%=request.getParameter("giNum")%>
		 +"&giName=" + $("#giName").val() +"&giDesc=" + $("#giDesc").val() +"&viNum=<%=request.getParameter("viNum")%>" +"&viName=<%=request.getParameter("viName")%>";
	}
}
$("#btnUpdate").click(function(){
	var isUpdate = confirm("해당 상품을 수정 하시겠습니까?");
	if(isUpdate){
		var params = {};
		params["giNum"] = "<%=request.getParameter("giNum")%>";
		params["giName"] = $("#giName").val();
		params["giDesc"] = $("#giDesc").val();
		params["command"] = "update";
		var page = {};
		page["nowPage"] = "<%=request.getParameter("nowPage")%>";
		params["page"] = page;
		movePageWithAjax(params, "/list.goods", callBackView);
	}
});
$("#btnGoList").click(function(){
	location.href="/goods/goods_list.jsp?nowPage=" + <%=request.getParameter("nowPage")%>
});
</script>
</body>
</html>