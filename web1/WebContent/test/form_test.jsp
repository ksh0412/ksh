<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>get parameter방식</p>
<form action = "test.formtest" method = "get">
아이디: <input type = "text" name = "id"><br>
비밀번호: <input type = "text" name = "pwd"><br>
<input type = "submit" value = "전송">
</form>

<p>POST JSON방식</p>
<form action = "test.formtest" method = "post">
아이디: <input type = "text" name = "id" id = "id"><br>
비밀번호: <input type = "text" name = "pwd" id = "pwd"><br>
<input type = "button" value = "전송" onclick = "postTest()">
<input type = "button" onclick = "testAdjacent()" value = "test">
</form>
div 시작
<div id = "div1">
test
</div>
div 종료
<script>
var obj = document.getElementById("div1");
function testAdjacent(){
obj.insertAdjacentHTML("beforebegin", "<div>test1</div>");
}
function postTest(){
	var params = {};
	params["id"] = $("#id").val();
	params["pwd"] = $("#pwd").val();
	params = JSON.stringify(params);
// 	var params = $("#testForm").serializeArray();
// 	params = JSON.stringify(params);
// 	alert(params)
	
	$.ajax({ 
		type     : "POST"
    ,   url      : "*.formtest"
    ,   dataType : "json" 
    ,   beforeSend: function(xhr) {
        xhr.setRequestHeader("Accept", "application/json");
        xhr.setRequestHeader("Content-Type", "application/json");
    }
    ,   data     : params
    ,   success : function(result){
    	var divObj = document.getElementById("div1");
    	divObj.insertAdjacentHTML("beforeend","<br>"+result.id+"<br>")
    	divObj.insertAdjacentHTML("beforeend",result.pwd)
    }
    ,   error : function(xhr, status, e) {
	    	alert("에러 : "+e);
	},
	complete  : function() {
	}
});

}
</script>
</body>
</html>