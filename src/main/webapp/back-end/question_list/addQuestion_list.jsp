<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.question_list.model.*"%>

<%
Question_list_VO question_listVO = (Question_list_VO) request.getAttribute("question_listVO");

String queryString = request.getQueryString();

String[] queryStringSplit = queryString.split("\\?");

int firm_survey_no = Integer.parseInt(queryStringSplit[0]);

if (queryStringSplit.length > 1) {
	pageContext.setAttribute("queryStringSplit", queryStringSplit[1]);
} else {
	pageContext.setAttribute("queryStringSplit", "");
}
%>

<!DOCTYPE html>
<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後台】</title>
<!-- base:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css" />
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon"
	href="<%=request.getContextPath()%>/back-end/images/favicon.png" />
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<script>
	let path = window.location.pathname.substring(0, window.location.pathname
			.lastIndexOf("/"));
	path = path.substring(0, path.lastIndexOf("/"));
</script>
</head>

<body>
	<!-- 主頁面 -->
	<div class="container-scroller">
		<!-- 引入nav(頂部含廣告) -->
		<script src="<%=request.getContextPath()%>/back-end/js/nav.js"></script>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_settings-panel.html -->
			<!-- 引入浮動視窗 -->
			<script
				src="<%=request.getContextPath()%>/back-end/js/floating_window.js"></script>
			<!-- partial -->
			<!-- partial:partials/_sidebar.html -->
			<nav class="sidebar sidebar-offcanvas" id="sidebar"></nav>
			<!-- 引入sidebar 用JQ方式 -->
			<script>
				$(function() {
					$("#sidebar").load(
							window.location.pathname.substring(0,
									window.location.pathname.indexOf('/', 2))
									+ "/back-end/partials/_sidebar.html");
				});
			</script>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="row">
						<div class="col-sm-6">
							<h3 class="mb-0 font-weight-bold">活動管理員</h3>
							<p>上次登入：21小時前</p>
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a
												href="<%=request.getContextPath()%>/back-end/firm_survey/listAllFirm_survey.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a
												href="<%=request.getContextPath()%>/back-end/firm_survey/addFirm_survey.jsp"><img
												src="./images/plus.png" width="30px" height="30px"></a>
										</button>

										<button
											class="btn bg-white btn-sm dropdown-toggle btn-icon-text border mr-2"
											type="button" id="dropdownMenu3" data-toggle="dropdown"
											aria-haspopup="true" aria-expanded="false">
											<i class="typcn typcn-calendar-outline mr-2"></i>Last 7 days
										</button>
										<div class="dropdown-menu"
											aria-labelledby="dropdownMenuSizeButton3"
											data-x-placement="top-start">
											<h6 class="dropdown-header">Last 14 days</h6>
											<a class="dropdown-item" href="#">Last 21 days</a> <a
												class="dropdown-item" href="#">Last 28 days</a>
										</div>
									</div>
								</div>
								<div class="pr-1 mb-3 mr-2 mb-xl-0">
									<button type="button"
										class="btn btn-sm bg-white btn-icon-text border">
										<i class="typcn typcn-arrow-forward-outline mr-2"></i>Export
									</button>
								</div>
								<div class="pr-1 mb-3 mb-xl-0">
									<button type="button"
										class="btn btn-sm bg-white btn-icon-text border">
										<i class="typcn typcn-info-large-outline mr-2"></i>info
									</button>
								</div>
							</div>
						</div>
					</div>
					<div class="row  mt-3">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<%-- 錯誤表列 --%>
									<c:if test="${not empty errorMsgs}">
										<font style="color: red">請修正以下錯誤:</font>
										<ul>
											<c:forEach var="message" items="${errorMsgs}">
												<li style="color: red">${message}</li>
											</c:forEach>
										</ul>
									</c:if>
									<h4 class="card-title">新增題目清單</h4>
									<FORM METHOD="post" ACTION="question_list.do" name="form1">
										<table id="dataTables" class="stripe table-hover"
											style="width: 100%">
											<jsp:useBean id="questionSvc" scope="page"
												class="com.question.model.Question_Service" />





											<div id="opts"></div>
											<div class="row">
												<div class="col-md-12 col-sm-12  col-xs-12">
													<div class="form-group">

														<button id="fat-btn" class="btn btn-primary" type="button">增加
														</button>

													</div>
												</div>
											</div>

											<tr>
												<td>問卷編號:</td>
												<td><input type="TEXT" name="1" size="45"
													value="<%=firm_survey_no%>" disabled></td>
											</tr>



										</table>
										<br> <input type="hidden" name="action" value="insert">
										<input type="hidden" name="firm_survey_no"
											value="<%=firm_survey_no%>"> <input type="hidden"
											name="queryString"
											value="<%=Integer.parseInt(queryStringSplit[0])%>"> <input
											type="submit" value="送出新增">
									</FORM>


								</div>
								<!-- content-wrapper ends -->
								<!-- partial:partials/_footer.html -->
								<!-- 引入footer 用JQ方式 -->
								<footer class="footer"></footer>
								<script>
									$(function() {
										$(".footer")
												.load(
														window.location.pathname
																.substring(
																		0,
																		window.location.pathname
																				.indexOf(
																						'/',
																						2))
																+ "/back-end/partials/_footer.html");
									});
								</script>
								<!-- partial -->
							</div>
							<!-- main-panel ends -->
						</div>
						<!-- page-body-wrapper ends -->
					</div>
					<!-- container-scroller -->
					<!-- base:js -->
					<script
						src="<%=request.getContextPath()%>/back-end/vendors/js/vendor.bundle.base.js"></script>
					<!-- endinject -->
					<!-- Plugin js for this page-->
					<!-- End plugin js for this page-->
					<!-- inject:js -->
					<script
						src="<%=request.getContextPath()%>/back-end/js/off-canvas.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/js/hoverable-collapse.js"></script>
					<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
					<script src="<%=request.getContextPath()%>/back-end/js/settings.js"></script>
					<script src="<%=request.getContextPath()%>/back-end/js/todolist.js"></script>
					<!-- endinject -->
					<!-- plugin js for this page -->
					<script
						src="<%=request.getContextPath()%>/back-end/vendors/progressbar.js/progressbar.min.js"></script>
					<script
						src="<%=request.getContextPath()%>/back-end/vendors/chart.js/Chart.min.js"></script>
					<!-- End plugin js for this page -->
					<!-- Custom js for this page-->

					<script
						src="<%=request.getContextPath()%>/back-end/js/dashboard.js"></script>
					<script
						src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
					<!-- End custom js for this page-->
</body>

<script>
	let i = 1;
	$(function() {
		$("#fat-btn")
				.click(
						function() {
							if ($(".number:last").val() == "") {
								alert(1);
							} else {
								var htm = "";

								htm += "    <tr>";
								htm += "    <td>選擇題目:</td>";
								htm += "    <td><select size='1' name='question_no" + i + "'>";
								htm += "    <option value='不選擇'>不選擇";
								htm += "    <c:forEach var='questionVO' items='${questionSvc.all}'>";
								htm += "    <c:if test='${queryStringSplit.contains(questionVO.question_no.toString()) == false}'>";
								htm += "    <option value='${questionVO.question_no}'>${questionVO.question_no}.${questionVO.que}";
								htm += "    </c:if>";
								htm += "    </c:forEach>";
								htm += "    </select></td>";
								htm += "    </tr>";
								htm += "    <input type='hidden' name='question_amount[]' value='" + i + "'>";
								i++;

								$("#opts").append(htm);
							}
						});
	});
</script>


</html>