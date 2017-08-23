<%@ include file="/common/header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<script>
$(document).ready(function(){
	var nowUrl = "<%=nowUrl%>";
	var obj = $("a[href='" + nowUrl + "']").parent().attr("class","active");
});
</script>
<title>IOT MAIN</title>
<!-- <div class="container"> -->
<!--       <div class="starter-template"> -->
<!--         <h1>메인 화면</h1> -->
<%--         <p class="lead"><%=rootPath%>이거슨 메인 화면입니까?</p> --%>
<!--       </div>  -->
<!--     </div>/.container -->

<!--     </div>/.container -->

<div class="tp-banner-container">
	<div class="tp-banner">

		<!-- 슬라이드 1 -->
		<li data-transition="fade" data-slotamount="7" data-masterspeed="1500">

			<div class="starter-template">
				<h1>메인 화면</h1>
				<p class="lead"><%=rootPath%>이거슨 메인 화면입니까?
				</p>
			</div>
	</div>

</div>
<!-- MAIN IMAGE -->
<img src="http://soulaim.co.kr/theme/basic/img/bg_01.jpg" alt="slidebg1"
	data-bgfit="cover" data-bgposition="left top" data-bgrepeat="no-repeat">
<!-- 배경 -->
<div class="container">
	<!-- LAYERS -->
	<!-- LAYER NR. 1 -->


	<div class="tp-caption large_white_bold sft hidden-xs" data-x="right"
		data-y="center" data-hoffset="-80" data-voffset="0" data-speed="3000"
		data-start="1200" data-easing="Power4.easeOut">

		<div class="tp-caption large_white_bold lfr hidden-xs tp-name"
			data-x="top" data-y="left" data-hoffset="0" data-voffset="0"
			data-speed="3000" data-start="1300" data-easing="Power4.easeOut">

		</div>
	</div>
	<%@ include file="/common/bottom.jsp"%>