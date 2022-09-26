<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act.model.*"%>
<%@ page import="com.act_pic.model.*"%>
<%@ page import="com.act_sign_up.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.prod.model.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.sql.Timestamp"%>


<%
Act_Service actSvc = new Act_Service();
Act_VO actVO = actSvc.getOneAct(Integer.parseInt(request.getQueryString()));
request.setAttribute("actVO", actVO);

Act_pic_Service act_picSvc = new Act_pic_Service();
List<Act_pic_VO> act_picList = act_picSvc.get_from_act_no(actVO.getAct_no());
pageContext.setAttribute("act_picList", act_picList);

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

if (user != null) {
	Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
	Set<Integer> set = act_sign_upSvc.getAct_sign_up((Integer) user.getMem_no());
	pageContext.setAttribute("set", set);
}

String url = request.getRequestURL().toString() + "?" + request.getQueryString();
session.setAttribute("url", url);

int i = 0;
int j = 0;
String[] numberArr = { "Second", "Third", "Fourth", "Fifth", "Sixth", "Seventh", "Eighth", "Ninth" };

// actVO.getSign_up_begin_time();
// actVO.getSign_up_end_time();

Date date = new Date();
// SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
// System.out.println(dateFormat.format(date));

int compareTime = 0;
Timestamp timestamp = new Timestamp((new Date()).getTime());
if (actVO.getSign_up_begin_time().compareTo(timestamp) > 0) {
	compareTime = -1;
} else {
	compareTime = 0;
}
if (actVO.getSign_up_end_time().compareTo(timestamp) < 0) {
	compareTime = 1;
} else {
	compareTime = 0;
}
pageContext.setAttribute("compareTime", compareTime);
%>



<!DOCTYPE html>



<html lang="zh-Hant">
<!-- Basic(head都不用動) -->

<head>
<meta charset="utf-8">

<!-- Mobile Metas -->
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Site Metas -->
<title>朧醴 LonelyBar</title>
<meta name="keywords" content="LonelyBar Index">
<meta name="description" content="This is template from Theme Wagon.">
<meta name="author" content="Theme Wagon">

<!-- Site Icons -->
<link rel="shortcut icon" href="../images/favicon.ico"
	type="image/x-icon">
<link rel="lonelybar-icon" href="../images/Logo2.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet" href="../css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet" href="../css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet" href="css/custom.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>


<style>
.btn {
	width: auto;
	height: auto;
}
</style>

</head>

<body>



	<div id=top_nav_mainTop>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>

	<!-- !!!!!! 從以下開始修改到Start Instagram Feed" !!!!!!-->

	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Act Detail</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a
							href="<%=request.getContextPath()%>/front-end/act/actlist.jsp">Act</a></li>
						<li class="breadcrumb-item active">Act Detail</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Shop Detail  -->
	<div class="shop-detail-box-main">
		<div class="container">
			<div class="row">
				<div class="col-xl-5 col-lg-5 col-md-6">
					<div id="carousel-example-1"
						class="single-product-slider carousel slide" data-ride="carousel">
						<div class="carousel-inner" role="listbox">


							<div class="carousel-item active">
								<c:forEach var="act_picVO" items="${act_picList}" begin="0"
									end="0">
									<img class="d-block w-100"
										src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
										alt="First slide" width="400" height="400">
								</c:forEach>
							</div>

							<c:forEach var="act_picVO" items="${act_picList}" begin="1">
								<div class="carousel-item">
									<img class="d-block w-100"
										src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
										alt="<%=numberArr[i++]%> slide" width="400" height="400">
								</div>
							</c:forEach>


						</div>
						<a class="carousel-control-prev" href="#carousel-example-1"
							role="button" data-slide="prev"> <i class="fa fa-angle-left"
							aria-hidden="true"></i> <span class="sr-only">Previous</span>
						</a> <a class="carousel-control-next" href="#carousel-example-1"
							role="button" data-slide="next"> <i class="fa fa-angle-right"
							aria-hidden="true"></i> <span class="sr-only">Next</span>
						</a>


						<ol class="carousel-indicators">
							<c:forEach var="act_picVO" items="${act_picList}">
								<li data-target="#carousel-example-1" data-slide-to="<%=j++%>"
									class="active"><img class="d-block w-100 img-fluid"
									src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
									alt="" /></li>
							</c:forEach>

						</ol>
					</div>
				</div>

				<div class="col-xl-7 col-lg-7 col-md-6">
					<div class="single-product-details">
						<h1><%=actVO.getAct_name()%></h1>
						<h4>
							活動地點 ☞
							<%=actVO.getAct_loc()%></h4>

						<h4>
							報名人數限制 ☞
							<%=actVO.getMax_count()%>
						</h4>
						<h4>
							當前報名人數 ☞
							<%=actVO.getCurrent_count()%>
						</h4>
						<h4>
							報名開始時間 ☞
							<%
						String time = actVO.getSign_up_begin_time().toString();
						%>
							<span id="begin"><%=time.toString().substring(0, time.length() - 5)%></span>
						</h4>
						<h4>
							報名結束時間 ☞
							<%
						time = actVO.getSign_up_end_time().toString();
						%>
							<span id="end"><%=time.toString().substring(0, time.length() - 5)%></span>
						</h4>
						<h4>
							活動開始時間 ☞
							<%
						time = actVO.getAct_start_time().toString();
						%>
							<%=time.toString().substring(0, time.length() - 5)%>
						</h4>
						<h4>
							活動結束時間 ☞
							<%
						time = actVO.getAct_end_time().toString();
						%>
							<%=time.toString().substring(0, time.length() - 5)%>
						</h4>

						<h4>活動內容：</h4>
						<p><%=actVO.getAct_detail()%></p>
						<ul>
							<li>
								<div class="form-group quantity-box">



									<FORM METHOD="post" ACTION="my_sign_up.do" name="form1">
										<table>

											<tr>
												<td>攜伴人數：</td>
												<td><input type="number" name="accompany_count"
													size="45" min="0"
													max="<%=actVO.getMax_count() - actVO.getCurrent_count() - 1%>"
													value="0" /></td>
											</tr>
										</table>

										<br> <input type="hidden" name="act_no"
											value="<%=actVO.getAct_no()%>"> <input type="hidden"
											name="mem_no" value="${user.mem_no}"> <input
											type="hidden" name="action" value="insert">


										<c:choose>
											<c:when test="${compareTime != 0}">
												<input type="button" value="不在報名期間內" disabled>
											</c:when>

											<c:when test="${empty sessionScope.user}">
												<input type="button" value="我要報名" onclick="confirmTest0()">
											</c:when>
											<c:when test="${actVO.current_count == actVO.max_count}">
												<input type="button" value="報名已到上限" disabled>
											</c:when>
											<c:otherwise>

												<c:choose>
													<c:when test="${set.contains(actVO.getAct_no())}">
														<input type="submit" value="已報名" disabled>
													</c:when>
													<c:otherwise>
														<input id="sign_up" type="submit" value="我要報名"
															onclick="confirmTest2()">
													</c:otherwise>

												</c:choose>

											</c:otherwise>

										</c:choose>

									</FORM>

								</div>
							</li>
						</ul>

						<div class="price-box-bar">
							<div class="cart-and-bay-btn">
								<a class="btn hvr-hover" data-fancybox-close="" href="#">Buy
									New</a> <a class="btn hvr-hover" data-fancybox-close="" href="#">Add
									to cart</a>
							</div>
						</div>

						<div class="add-to-btn">
							<div class="add-comp">
								<a class="btn hvr-hover" href="#"><i class="fas fa-heart"></i>
									Add to wishlist</a> <a class="btn hvr-hover" href="#"><i
									class="fas fa-sync-alt"></i> Add to Compare</a>
							</div>
							<div class="share-bar">
								<a class="btn hvr-hover" href="#"><i class="fab fa-facebook"
									aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
									class="fab fa-google-plus" aria-hidden="true"></i></a> <a
									class="btn hvr-hover" href="#"><i class="fab fa-twitter"
									aria-hidden="true"></i></a> <a class="btn hvr-hover" href="#"><i
									class="fab fa-pinterest-p" aria-hidden="true"></i></a> <a
									class="btn hvr-hover" href="#"><i class="fab fa-whatsapp"
									aria-hidden="true"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>





		</div>
	</div>
	<!-- End Cart -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
	<!-- Start Instagram Feed  -->
	<!-- End Instagram Feed  -->
	<!-- Start Footer  -->
	<footer>
		<%@ include file="/front-end/partials/_footer.jsp"%>
	</footer>
	<!-- End Footer  -->

	<!-- Start copyright  -->
	<div class="footer-copyright">
		<p class="footer-company">
			All Rights Reserved. &copy; 2022 <a href="#">LonelyBar</a> Design By
			: <a href="https://html.design/">CGA103G5</a>
		</p>
	</div>
	<!-- End copyright  -->

	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>

	<!-- ALL JS FILES -->
	<script src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/form-validator.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/bootsnav.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/baguetteBox.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/bootstrap-select.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/images-loded.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/contact-form-script.js"></script>
	<!-- 該文件需部屬較慢 -->
	<script id="customjs"
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
</body>

</html>