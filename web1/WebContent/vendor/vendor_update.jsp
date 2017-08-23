<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

<div class = "container">
<table border = '1'> <%=request.getParameter("viNum")%>번 수정하기
<tr>
<td class = 'text-center'>번호</td>
<td class = 'text-center'><%=request.getParameter("viNum")%></td>
</tr>
<tr>
<td class = 'text-center'>회사이름</td>
<td class = 'text-center'><input type = "text" id = "viName"></td>
</tr>
<tr>
<td class = 'text-center'>회사종류</td>
<td class = 'text-center'><input type = "text" id = "viDesc"></td>
</tr>
<tr>
<td class = 'text-center'>주소</td>
<td class = 'text-center'><input type = "text" id = "viAddress"></td>
</tr>
<tr>
<td class = 'text-center'>연락처</td>
<td class = 'text-center'><input type = "text" id = "viPhone"></td>
</tr>
</table>
<input type = "button" id = "ok" value = "완료">
<input type = "button" id = "back" value = "뒤로가기">
<input type = "button" id = "go" value = "리스트로 한번에 가기">
</div>
<script>
$("#back").click(function(){
	history.back();
});

$("#go").click(function(){
	location.href = "/vendor/vendor_list.jsp";
});

$("#ok").click(function(){
	var viNum = <%=request.getParameter("viNum")%>;
	var viName = $("#viName").val();
	var viDesc = $("#viDesc").val();
	var viAddress = $("#viAddress").val();
	var viPhone = $("#viPhone").val();
	var param = {};
	param["command"] = "update"
	param["viNum"] = viNum;
	param["viName"] = viName;
	param["viDesc"] = viDesc;
	param["viAddress"] = viAddress;
	param["viPhone"] = viPhone;
	
	movePageWithAjax(param, "/list.vendor", callBackView);
})

function callBackView(result){
	alert(result.msg);
	location.href= result.url + "?viNum=" +<%=request.getParameter("viNum")%> + "&viName=" + $("#viName").val() + "&viDesc=" + $("#viDesc").val()
	 + "&viAddress=" + $("#viAddress").val() + "&viPhone=" + $("#viPhone").val();
}
</script>