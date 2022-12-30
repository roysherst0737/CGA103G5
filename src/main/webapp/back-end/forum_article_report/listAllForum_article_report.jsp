<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.forum_article_report.model.*"%>
<%@ page import="com.forum_article.model.*"%>

<%
Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
List<Forum_article_report_VO> list = forum_article_report_Svc.getAll();
pageContext.setAttribute("list", list);

Forum_article_VO forum_article_VO = (Forum_article_VO) request.getAttribute("forum_article_VO");


Forum_article_report_VO forum_article_report_VO = (Forum_article_report_VO) request.getAttribute("forum_article_report_VO");
%>

<!DOCTYPE html>
<html lang="zh">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar【後端】</title>
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
<style>
.button {
	text-decoration: none; /* 去除下底線 */
	display: inline-block; /* 變成行內區塊 */
	font-size: 10px; /* 文字大小 */
	color: white; /* 文字顏色 */
	background: gray; /* 按鈕背景顏色 */
	padding: 5px 10px 5px 10px; /* 文字到邊框的間距 */
	border: 1px solid black; /* 邊框設定 */
	border-radius: 5px; /* 邊框圓角設定 */
}
</style>
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
							<h3 class="mb-0 font-weight-bold">討論區管理員</h3>
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="listAllForum_article_report.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href="select_page.jsp"><img src="./images/search2.png"
												width="30px" height="30px"></a>
										</button>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="row  mt-3">
						<div class="col-lg-12 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title">討論區文章檢舉管理</h4>
									<table id="dataTables" class="table stripe table-hover"
										style="width: 100%">
										<thead>
											<tr>
												<th>檢舉編號</th>
												<th>會員編號</th>
												<th>文章編號</th>
												<th>檢舉內容</th>
												<th>檢舉時間</th>
												<th>檢舉原因</th>
												<th>管理員編號</th>
												<th>處理時間</th>
												<th>處理狀態</th>
												<th>處理註記</th>
												<th>違規/合格</th>
												<th>審核</th>
												
											</tr>
										</thead>
										<%@ include file="page1.file"%>
										<c:forEach var="forum_article_report_VO" items="${list}"
											begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
											<br>
											<tr>
												<FORM METHOD="post"
													ACTION="<%=request.getContextPath()%>/back-end/forum_article_report/forum_article_report.do"
													style="margin-bottom: 0px;">
												<td>${forum_article_report_VO.frm_art_rpt_no}</td>
												<td>${forum_article_report_VO.mem_no}</td>
												<td>${forum_article_report_VO.frm_art_no}</td>
												<td>${forum_article_report_VO.getForum_article_VO().art_content}</td>
												<td>${forum_article_report_VO.rpt_time}</td>
												<td>${forum_article_report_VO.rpt_content}</td>
												<td>${forum_article_report_VO.mng_no}</td>
												<td>${forum_article_report_VO.rpt_done_time}</td>
												<td>${forum_article_report_VO.rpt_status==0 ? "已處理" : "待處理"}</td>
<%-- 												<td>${forum_article_report_VO.rpt_result==1 ? "違規" : "合格"}</td> --%>
<%-- 												<td><input type="text" value="${forum_article_report_VO.rpt_note}" name="rpt_note"> </td> --%>
												<td>
														<select size="1" name="rpt_note" value="<%=(forum_article_report_VO == null) ? "" : forum_article_report_VO.getRpt_result()%>">
          													<option value="無違規" <c:if test="${'1' eq forum_article_report_VO.getRpt_result()}">selected</c:if>>無違規</option>
          													<option value="違反規章" <c:if test="${'0' eq forum_article_report_VO.getRpt_result()}">selected</c:if>>違反規章</option>
       													</select>	
												</td>
												<td>
														<select size="1" name="rpt_result" value="<%=(forum_article_report_VO == null) ? "" : forum_article_report_VO.getRpt_result()%>">
          													<option value="1" <c:if test="${'1' eq forum_article_report_VO.getRpt_result()}">selected</c:if>>合格</option>
          													<option value="0" <c:if test="${'0' eq forum_article_report_VO.getRpt_result()}">selected</c:if>>違規</option>
       													</select>	
												</td>
												<td>
														<input type="submit" value="審核" class="button"> 
														<input type="hidden" name="frm_art_rpt_no" value="${forum_article_report_VO.frm_art_rpt_no}"> 
														<input type="hidden" name="art_status" value="${forum_article_report_VO.getForum_article_VO().art_status}">
														<input type="hidden" name="frm_art_no" value="${forum_article_report_VO.frm_art_no}">
														<input type="hidden" name="action" value="update">
															
												</td>
													</FORM>
											</tr>
										</c:forEach>
									</table>
									<%@ include file="page2.file"%>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<footer class="footer"></footer>
				<script>
					$(function() {
						$(".footer").load("../partials/_footer.html");
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

	<script>
		function getContextPath() {
			return window.location.pathname.substring(0,
					window.location.pathname.indexOf('/', 2));
		}
	</script>
	<script src="../vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="../js/off-canvas.js"></script>
	<script src="../js/hoverable-collapse.js"></script>
	<script src="../js/template.js"></script>
	<script src="../js/settings.js"></script>
	<script src="../js/todolist.js"></script>
	<!-- endinject -->
	<!-- plugin js for this page -->
	<script src="../vendors/progressbar.js/progressbar.min.js"></script>
	<script src="../vendors/chart.js/Chart.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- Custom js for this page-->

	<script src="../js/dashboard.js"></script>
	<!-- End custom js for this page-->
</body>

</html>