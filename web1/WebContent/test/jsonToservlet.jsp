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
	<script>
		var testParam = {};
		testParam["giNum"] = "1";
		testParam["giName"] = "1";
		testParam["giDesc"] = "1";
		testParam["viNum"] = "1";
		testParam["viName"] = "1";
		testParam["viList"] = [{a:1}, {b:2}]
		var testParam2 = {};
		testParam2["giNum"] = "1";
		testParam2["giName"] = "1";
		testParam2["giDesc"] = "1";
		testParam2["viNum"] = "1";
		testParam2["viName"] = "1";
		function callBack(results){
			for(var i=0, max = results.length; i<max; i++){
				var result = results[i];
				alert(result.giDesc);
			}
		}
		movePageWithAjax([testParam, testParam2], "/test.goods", callBack);
	</script>
</body>
</html>