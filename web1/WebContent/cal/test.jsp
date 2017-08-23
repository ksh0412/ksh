<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<body>
<input type="button" id="id" name="id" value="테이블생성"  />
</body>
<script>
var list = [{"result":"4","calnum":"6","op":"+","num1":"2","num2":"2"},
	   {"result":"4","calnum":"7","op":"+","num1":"2","num2":"2"},
	   {"result":"1","calnum":"8","op":"-","num1":"4","num2":"3"},
	   {"result":"6","calnum":"9","op":"*","num1":"2","num2":"3"},
	   {"result":"2","calnum":"10","op":"/","num1":"10","num2":"5"}];
	$("#id").click(function(){
	   for(var i=0, max=list.length;i<max;i++){
		   var lists=list.split(",");
	      var m = list[i];
	      alert(lists);
	   }
	});

</script>




<div id="div" name="div"></div>