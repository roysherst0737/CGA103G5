<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.question_list.model.*"%>
<%@ page import="com.question.model.*"%>

<%
Question_list_Service question_listSvc = new Question_list_Service();
List<Question_list_VO> list = question_listSvc.getAllFromFirmSurveyNo(Integer.parseInt(request.getQueryString()));
pageContext.setAttribute("list", list);

String selected_question_no = "?";
for (int i = 0; i < list.size(); i++) {
	Question_list_VO abc = list.get(i);
	selected_question_no += (abc.getQuestion_no());
}

String url = request.getContextPath();
url += "/back-end/question_list/addQuestion_list.jsp?";
url += Integer.parseInt(request.getQueryString());
url += selected_question_no;
pageContext.setAttribute("url", url);

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
							
						</div>
						<div class="col-sm-6">
							<div class="d-flex align-items-center justify-content-md-end">
								<div class="mb-3 mb-xl-0 pr-1">
									<div class="dropdown">
										<button style="margin-right: 10px;">
											<a href="<%=request.getContextPath()%>/back-end/firm_survey/listAllFirm_survey.jsp"><img
												src="./images/home.png" width="30px" height="30px"></a>
										</button>
										<button style="margin-right: 10px;">
											<a href="<%=request.getContextPath()%>/back-end/firm_survey/addFirm_survey.jsp"><img src="./images/plus.png"
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
									<jsp:useBean id="prod_picSvc" scope="page"
										class="com.prod_pic.model.Prod_pic_Service" />
									<jsp:useBean id="prod_typeSvc" scope="page"
										class="com.prod_type.model.Prod_type_Service" />
									<h4 class="card-title">問卷題目管理</h4>
									<form>		
								
										<input type="button" value="新增問題"
											onclick="location.href='<%=url%>'">
									</form>
									<br>
									<div>問卷編號<%=request.getQueryString()%></div>
									<br>


									<table id="dataTables" class="stripe table-hover"
										style="width: 100%; font-size: 12px">
										<thead style="width: 100%; font-size: 13px">
											<tr>
												<th>已選題目編號</th>
												<th>問題內容</th>
<!-- 												<th>刪除</th> -->
											</tr>
										</thead>
										<tbody>

											<c:forEach var="question_listVO" items="${list}">

												<tr>
													<td>${question_listVO.question_no}</td>
													<td>${question_listVO.questionVO.que}</td>

<!-- 													<td> -->
<!-- 														<FORM METHOD="post" -->
<%-- 															ACTION="<%=request.getContextPath()%>/back-end/question_list/question_list.do" --%>
<!-- 															style="margin-bottom: 0px;"> -->
<!-- 															<input type="submit" value="刪除"> <input -->
<!-- 																type="hidden" name="question_no" -->
<%-- 																value="${question_listVO.question_no}"> <input --%>
<!-- 																type="hidden" name="firm_survey_no" -->
<%-- 																value="${question_listVO.firm_survey_no}"> <input --%>
<!-- 																type="hidden" name="queryString" -->
<%-- 																value="<%=Integer.parseInt(request.getQueryString())%>"> --%>

<!-- 															<input type="hidden" name="action" value="delete"> -->
<!-- 														</FORM> -->
<!-- 													</td> -->
												</tr>
											</c:forEach>
									</table>

									</tbody>
									</table>
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