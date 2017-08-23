<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="/common/header.jsp"%>

<div class = "container">  
<table border = '1'>상세정보
<tr>
<td class = 'text-center'>번호</td>
<td class = 'text-center'><%=request.getParameter("viNum") %></td>
</tr>
<tr>
<td class = 'text-center'>회사이름</td>
<td class = 'text-center'><%=request.getParameter("viName") %></td>
</tr>
<tr>
<td class = 'text-center'>회사종류</td>
<td class = 'text-center'><%=request.getParameter("viDesc") %></td>
</tr>
<tr>
<td class = 'text-center'>주소</td>
<td class = 'text-center'><%=request.getParameter("viAddress") %></td>
</tr>
<tr>
<td class = 'text-center'>연락처</td>
<td class = 'text-center'><%=request.getParameter("viPhone") %></td>
</tr>
</table>
<input type = "button" id = "modify" value = "수정하기">
<input type = "button" id = "back" value = "뒤로가기">
<input type = "button" id = "delete" value = "정보삭제">
<input type = "button" id = "go" value = "리스트로 한번에 가기">
</div>

<script>
$("#back").click(function(){
	history.back();
});

$("#go").click(function(){
	location.href = "/vendor/vendor_list.jsp";
});

$("#modify").click(function(){
	location.href = "/vendor/vendor_update.jsp" + "?viNum=" + <%=request.getParameter("viNum") %>
})

$("#delete").click(function(){
	var viNum = <%=request.getParameter("viNum") %>;
	var param = {};
	param["command"] = "delete"
	param["viNum"] = viNum;
	movePageWithAjax(param, "/list.vendor", callBackView);
});

function callBackView(result){
	alert(result.msg);
	location.href = result.url;
}
</script>