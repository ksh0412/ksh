<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/header.jsp"%>
	
	<div class = "container">
	<table border='1' id = "table">
    <tr>
    <th data-field = "viNum" class = "text-center">번호</th>
    <th data-field = "viName" class = "text-center">회사명</th>
    <th data-field = "viDesc" class = "text-center">회사종류</th>
    <th data-field = "viAddress" class = "text-center">주소</th>
    <th data-field = "viPhone" class = "text-center">연락처</th>
    </tr>
    <tbody id="result_tbody"></tbody>
    </table>
    <input type = "button" id = "regist" value="회사등록"></br>
    <select id = "si">
    </select>
    <input type = "text" id = "viName"><input type = "button" id = "search" value = "검색">
    
    </div>
    
    <script>
    $(document).ready(function(){
    	var param = {};
    	param["command"] = "list"
    	movePageWithAjax(param, "/list.vendor", callBack);
    });
    
    function movePageWithAjax(pParam, url, callBack, pMethod){
	var param = JSON.stringify(pParam);
	$.ajax({ 
    		type     : pMethod ? pMethod:"POST"
	    ,   url      : url
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : param
	    ,   success : callBack
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}
    function callBack(result){
    	var vendorList = result.vendorList;
    	var str = "";
    	for(var i=0, max=vendorList.length; i<max; i++){
    		str += "<tr data-view='"+vendorList[i].viNum+"'>";
    		str += "<th class = 'text-center'>" + vendorList[i].viNum + "</th>"
    		str += "<th class = 'text-center'>" + vendorList[i].viName +"</th>"
    		str += "<th class = 'text-center'>" + vendorList[i].viDesc +"</th>"
    		str += "<th class = 'text-center'>" + vendorList[i].viAddress +"</th>"
    		str += "<th class = 'text-center'>" + vendorList[i].viPhone +"</th>"
    		str += "</tr>"
    	}
    	$("#result_tbody").html(str);
    	var selStr = "<option value =''> 회사정보 </option>"
    	for(var i = 0, max = vendorList.length; i<max; i++){
    		selStr += "<option value = '"+vendorList[i].viNum+"' > "+vendorList[i].viName+" </option>"
    	}
    	$("#si").html(selStr);
    	$("tbody[id='result_tbody']>tr[data-view]").click(function(){
    		var viNum = this.getAttribute("data-view");
    		var param ={};
    		param["command"] = "view";
    		param["viNum"] = viNum;
    		movePageWithAjax(param, "/list.vendor", callBackView);
    	})
    	function callBackView(result){
    		location.href = result.url + "?viNum=" + result.resultVendor.viNum + "&viName=" + result.resultVendor.viName + "&viDesc=" + result.resultVendor.viDesc
    				+ "&viAddress=" + result.resultVendor.viAddress + "&viPhone=" + result.resultVendor.viPhone;
    	}
    	
    	$("#regist").click(function(){
    		location.href = "/vendor/vendor_insert.jsp" + "?viNum=" + result.number;
    	})
    	
    	$("#search").click(function(){
    		var viName = $("#viName").val().trim();
    		var command = "list";
    		var param = {};
    		param["command"] = command;
    		param["viName"] = viName;
    		movePageWithAjax(param, "/list.vendor", callBack);
    	})
    }
    </script>