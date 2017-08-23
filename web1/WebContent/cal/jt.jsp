<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

<table border="1">
</br>
<input type= "text" id="num1" name="num1">
<input type= "text" id="op" name="op" value="+">
<input type= "text" id="num2" name="num2">
<input type="text" id="result" name="result">
<input type= "button" id="num4" name="num4" value="=">
</table>
<script>
$("#num4").click(function(){
	var num2=$("#num2").val;
	var num1=$("#num1").val;
	var op=$("#op").val;
	
	var param={};
	param["num1"]=num1;
	param["num2"]=num2;
	param["op"]=op;
	param=JSON.stringify(param);
	var a = {
			type : "POST",
			url : "/cal/cal_ok.jsp",
			dataType : "json",
			beforeSend : function(xhr) {
				xhr.setRequestHeader("Accept", "application/json");
				xhr.setRequestHeader("Content-Type", "application/json");
			},
			data : param,
			success : function(result) {
				$("#result").val(result.num);
			},
			error : function(xhr, status, e) {
				alert("에러 : " + e);
			},
			complete : function() {
				alert("무조건실행")
			}
		};
	$.ajax(a);
});
</script>