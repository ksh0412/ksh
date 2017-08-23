<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

<table border = '1'>
<tr>
<th data-field = tnum> 번호 </th>
<th data-field = tname> 이름 </th>
<th data-field = tinfo> 형태 </th>
<th data-field = thome> 주소 </th>
<th data-field = tph> 전번 </th>
</tr>
<tbody id = "id_tbody">
</tbody>
</table>
<div id="s_div">
</div>

<script>
$(document).ready(function(){
	var command = "list";
	var param = {};
	param["command"] = command;
	
	movePageWithAjax(param, "/list.testpage", callBack);
})

function movePageWithAjax(pParam,pUrl,pCallBackFunc, pMethod){
	var param = JSON.stringify(pParam);
	$.ajax({ 
    		type     : pMethod ? pMethod:"POST"
	    ,   url      : pUrl
	    ,   dataType : "json" 
	    ,   beforeSend: function(xhr) {
	        xhr.setRequestHeader("Accept", "application/json");
	        xhr.setRequestHeader("Content-Type", "application/json");
	    }
	    ,   data     : param
	    ,   success : pCallBackFunc
	    ,   error : function(xhr, status, e) {
		    	alert("에러 : "+e);
		},
		complete  : function() {
		}
	});
}

function callBack(result){
	var tl = result.testList;
	var page = result.page;
	var str = "";
	for(var i=0, max=tl.length; i<max; i++){
		str += "<tr>";
		str += "<td> " + tl[i].tnum + "</td>";
		str += "<td> " + tl[i].tname + "</td>";
		str += "<td> " + tl[i].tinfo + "</td>";
		str += "<td> " + tl[i].thome + "</td>";
		str += "<td> " + tl[i].tph + "</td>";
		str += "</tr>";
	}
	$("#id_tbody").html(str);
	
	makePagination(page);
	setEvent(page);
}

function makePagination(page){
	var endBlock = page.endBlock;
	var startBlock = page.startBlock;
	var startRow = page.startRow;
	var nowPage = page.nowPageCnt;
	var str="<table border='1'>";
	str+="<tr>"
	str+="<td>◁◁</td>";
	str+="<td>◁</td>";
	for(var i = startBlock,max = endBlock; i<=max; i++){
		if(i==nowPage){
			str+="<td>"+i+"(현재페이지)</td>";
		}else{
		str+="<td>"+i+"</td>";
		}
	}
	str+="<td>▷</td>";
	str+="<td>▷▷</td>";
	str+="</tr>"
	str+="</table>";
	$("#s_div").html(str);
}
function setEvent(page){
	$("div[id='s_div']>table>tbody>tr>td").click(function(){
		var goPage = new Number(this.innerHTML);
		var endPage = page.totalPageCnt;
		if(isNaN(goPage)){
			if(this.innerHTML=="◁"){
				page.nowPageCnt=page.nowPageCnt-10;
			}if(this.innerHTML=="◁◁"){
				page.nowPageCnt=1;
			}if(this.innerHTML=="▷"){
				page.nowPageCnt=page.nowPageCnt+10;
			}if(this.innerHTML=="▷▷"){
				page.nowPageCnt=endPage;
			}
			goPage = page.nowPageCnt;
		}
		param={};
		param["nowPageCnt"] = goPage;
		param["command"] = "list";
		movePageWithAjax(param,"/*.testpage", callBack);
	})
}
</script>