<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>

    <div class="container">
	<table id="table" data-height="460"
		class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="giNum" class="text-center">번호</th>
				<th data-field="giName" class="text-center">차이름</th>
				<th data-field="giDesc" class="text-center">차종</th>
				<th data-field="viNum" class="text-center">회사no.</th>
				<th data-field="viName" class="text-center">회사이름</th>
			</tr>
		</thead>
		<tbody id="result_tbody">
		</tbody>
	</table>
	<button id="btnInsert" class="btn btn-primary"  type="button">상품등록</button>
	</div>
	<div class="jb-center" style="text-align: center">
	<ul class="pagination" id = "page">
	</ul>
	</div>
	<select id="s_vendor" class = "selectpicker">
	</select>
 <label> 상품이름 : </label><input type="text" id="giName" name="giName">
 <input type="button" id="search" name="search" value="검색">
 
 <script>
 var thisNowPage = 0;
 var thisBlockCnt = 0;
 var thisTotalPage = 0;
 
 $("#btnInsert").click(function(){
	 location.href = "/goods/goods_insert.jsp";
 })
 
 $("#search").click(function(){
	 var giName = $("#giName").val().trim();
	 var viNum = $("#s_vendor").val().trim();
	 var param = {};
	 if(giName=="" && viNum==""){
		 alert("회사선택이나 제품명을 입력해주세요.");
		 return;
	 }
	 if(giName!=""){
	 param["giName"] = giName;
	 }
	 if(viNum!=""){
	 param["viNum"] = viNum;
	 }
	 param["command"] = "list";
	 var page = {};
	 page["nowPage"] = "1";
	 param["page"] = page;
	 movePageWithAjax(param, "list.goods", callBack);
 })
 
 $(document).ready(function(){ 
	 var page={};
	 page["nowPage"] = "1";
	 var param = {};
	 param["page"] = page;
	 param["command"] = "list";
	 movePageWithAjax(param, "/list.goods", callBack);
 });
 
 function callBack(results){
	var goodsList = results.list;
	var pageInfo = results.page;
	var vendorList = results.vendorList;
	var search = results.search;
	var selStr = "<option value=''>회사선택</option>";
	for(var i=0, max=vendorList.length;i<max;i++){
		var selectStr = "";
		if(search.viNum==vendorList[i].viNum){
			selectStr = "selected";
		}
			selStr += "<option value='" + vendorList[i].viNum + "' "+ selectStr + ">" + vendorList[i].viName	+ "</option>";
		}
	$("#s_vendor").html(selStr);
	var param = {};
	if(search.giName!=""){
		param["giName"] = search.giName;
	}
	if(search.viNum!=""){
		param["viNum"] = search.viNum;
	}
	makePagination(pageInfo, "page");
	setEvent(pageInfo, param, "/list.goods");
	$('#table').bootstrapTable('destroy');
	var str = "";
	for(var i=0, max=goodsList.length; i<max; i++){
		str+="<tr data-view='" + goodsList[i].giNum + "'>";
		str+="<td class='text-center'>"+goodsList[i].giNum+"</td>";
		str+="<td class='text-center'>"+goodsList[i].giName+"</td>";
		str+="<td class='text-center'>"+goodsList[i].giDesc+"</td>";
		str+="<td class='text-center'>"+goodsList[i].viNum+"</td>";
		str+="<td class='text-center'>"+goodsList[i].viName+"</td></tr>";
	}
	$("#result_tbody").html(str);
	$("tbody[id='result_tbody']>tr[data-view]").click(function(){
		var param = {};
		param["giNum"] = this.getAttribute("data-view");
		param["command"] = "view";
		var page = {};
		page["nowPage"] = pageInfo.nowPage;
		param["page"] = page;
		movePageWithAjax(param,"/list.goods", callBackView);
	})
// 	$('#table').bootstrapTable({
// 		data: goodsList
// 	});
 }
function callBackView(result){
// 	alert(result.url);
// 	alert(result.resultGoods.giNum);
// 	alert(result.page.nowPage);
	var url = result.url+"?nowPage=" + result.page.nowPage + "&giNum=" + result.resultGoods.giNum
			+ "&giName=" + result.resultGoods.giName + "&giDesc=" + result.resultGoods.giDesc
			 + "&viNum=" + result.resultGoods.viNum + "&viName=" + result.resultGoods.viName;
	location.href= url;
}
// // 					var vendorList = results.vendorList;
// // 					var goodsList = results.goodsList;
// // 					var pageHm = results.pageHm;
					
// // 					var blockCnt=new Number(pageHm.blockCnt);
// // 					thisBlockCnt = blockCnt;
// // 					var nowPage = new Number(pageHm.nowPage);
// // 					thisNowPage = nowPage;
// // 					var startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
// // 					var endBlock = startBlock+blockCnt-1;
// // 					var totalPageCnt = new Number(pageHm.totalPageCnt);
// // 					thisTotalPage = totalPageCnt;
// // 					if(endBlock>totalPageCnt){
// // 						endBlock = totalPageCnt;
// 					}
					
// 					makePagination(startBlock, endBlock, pageHm.nowPage, totalPageCnt, "page");
					
// 					for(var i=0, max=vendorList.length;i<max;i++){
// 						$("#s_vendor").append("<option value='"+vendorList[i].vinum+"'>"+vendorList[i].viname+"</option>")
// 					}
// 					$('#table').bootstrapTable('destroy');
// 					$('#table').bootstrapTable({
// 						data : goodsList
// 					});
 
 
//  $("#search").click(function(){ 
// 	 var ginum = $("#ginum").val;
// 	 var param={};
// 	 param["ginum"] = ginum;
// 	 movePageWithAjax(param, "/test/goods_ok.jsp", callBack);
//  })
 
//  function movePageWithAjax(page){
// 	 var ginum=$("#ginum").val();
	 
// 	 var param={};
// 	 param["ginum"] = ginum;
// 	 param["nowPage"] = page;
// 		param = JSON.stringify(param);
// 	 var a = {
// 				type : "POST",
// 				url : "/test/goods_ok.jsp",
// 				dataType : "json",
// 				beforeSend : function(xhr) {
// 					xhr.setRequestHeader("Accept", "application/json");
// 					xhr.setRequestHeader("Content-Type", "application/json");
// 				},
// 				data : param,
// 				success : function(results) {
// 					var vendorList = results.vendorList;
// 					var goodsList = results.goodsList;
// 					var pageHm = results.pageHm;
					
// 					var pageStr = "<li><a> << </a></li>";
// 					pageStr += "<li><a> < </a></li>";
// 					var blockCnt=new Number(pageHm.blockCnt);
// 					var nowPage = new Number(pageHm.nowPage);
// 					var startBlock = Math.floor((nowPage-1)/blockCnt)*10+1;
// 					var endBlock = startBlock+blockCnt-1;
// 					var totalPageCnt = new Number(pageHm.totalPageCnt);
// 					if(endBlock>totalPageCnt){
// 						endBlock = totalPageCnt;
// 					}
// 					for(var i = startBlock, max=endBlock;i<=max;i++){
// 						if(i==pageHm.nowPage){
// 							pageStr += "<li class = 'active'><a>" + i + "</a></li>";	
// 						}else{
// 						pageStr += "<li><a>" + i + "</a></li>";
// 						}
// 					}
// 					pageStr += "<li><a> > </a></li>";
// 					pageStr += "<li><a> >> </a></li>";
					
// 					$("#page").html(pageStr);
// 					for(var i=0, max=vendorList.length;i<max;i++){
// 						$("#s_vendor").append("<option value='"+vendorList[i].vinum+"'>"+vendorList[i].viname+"</option>")
// 					}
// 					$('#table').bootstrapTable('destroy');
// 					$('#table').bootstrapTable({
// 						data : goodsList
// 					});
// 					setEvent();
// 				},
// 				error : function(xhr, status, e) {
// 					alert("에러 : " + e);
// 				},
// 				done : function(e) {
// 				}
// 			}
// 			$.ajax(a);
//  }
 </script>