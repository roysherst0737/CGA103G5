<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.question_list.model.*"%>
<%@ page import="com.question.model.*"%>
<%@ page import="com.mem.model.*"%>

<%
Question_list_Service question_listSvc = new Question_list_Service();
List<Question_list_VO> list = question_listSvc.getAllFromFirmSurveyNo(Integer.parseInt(request.getQueryString()));
pageContext.setAttribute("list", list);

int i = 1;
int j = 1;
int k;
if (list.size() % 2 != 0) {
	k = list.size() / 2;
} else {
	k = (list.size() / 2) - 1;

}
pageContext.setAttribute("k", k);
int l = 1;

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

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
<link rel="stylesheet" href="../css/custom.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<style>
button.b1 {
	height: auto;
	padding: 5px;
}

div.o1 {
	padding: 7px;
	display: flex;
	align-items: center;
	margin: 5px;
}

div.inside {
	padding-left: 30px;
	margin: 0px;
}

div.d1 {
	border: 3px solid #e8eff9;
	border-radius: 3px;
}

div.d1:hover {
	border: 3px solid #d2b36b;
}

div.row {
	margin: 11px;
}

.open_div>div {
	padding-left: 30px;
}

.open_div>button {
	float: right;
}

div.col-sm-12>button.btn {
	width: 50px;
	height: 30px;
	padding: 0px;
	margin: 0px;
	font-weight: bolder;
}

div.col-sm-12>button.btn-warning {
	background-color: #ffc107;
}

div.col-sm-12>button.btn-warning:hover {
	background-color: #e0a800;
}

.main-top {
	height: 53.5px;
}

a.booking {
	background: #f5c242;
	position: absolute;
	bottom: 0;
	left: 0px;
	padding: 10px 20px;
	font-weight: 700;
	color: #ffffff;
}

a.booking:hover {
	background: #000000;
	color: #ffffff;
}
.box{
  width: 450px;
  height: 80px;
  background: #ecd6c7;
  margin: 0 auto;/*區塊置中*/
}

</style>

</head>

<body>
	<div id=top_nav_mainTop>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>
	<!-- 主內容 -->
	
	
	<c:choose>

<c:when test="${k < 0}">
 <div class="box">
    <font size="100" class="font">活動方尚未新增題目</font>
  </div>

</c:when>

<c:otherwise>
	<div class="main-panel">
		<div class="content-wrapper">
			<FORM METHOD="post" ACTION="ans_list.do" name="form1"
				id="google-form" class="forms-sample">
				<div class="row">
					<div class="col-md-6 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">

								<table id="dataTables" class="stripe table-hover"
									style="width: 100%">
									<c:forEach var="question_listVO" items="${list}" end="<%=k%>">
										<label class="label-input100" for="message">問題<%=l++%>：${question_listVO.questionVO.que}
										</label>
										<div class="wrap-input100" data-validate="Message is required">
											<textarea name="ans<%=i++%>" id="message" class="input100"
												placeholder="Write your answer" rows="5" cols="70"></textarea>
											<span class="focus-input100"></span>

										</div>
										<input type="hidden" name="question_no<%=j++%>"
											value="${question_listVO.questionVO.question_no}">
									</c:forEach>
								</table>

							</div>
						</div>
					</div>
					<div class="col-md-6 grid-margin stretch-card">
						<div class="card">
							<div class="card-body">
								<h4 class="card-title"></h4>

								<c:forEach var="question_listVO" items="${list}"
									begin="<%=k+1%>">
									<label class="label-input100" for="message">問題<%=l++%>：${question_listVO.questionVO.que}
									</label>
									<div class="wrap-input100" data-validate="Message is required">
										<textarea name="ans<%=i++%>" id="message" class="input100"
											placeholder="Write your answer" rows="5" cols="70"></textarea>
										<span class="focus-input100"></span>

									</div>
									<input type="hidden" name="question_no<%=j++%>"
										value="${question_listVO.questionVO.question_no}">
								</c:forEach>


								<input type="hidden" name="action" value="insert"> <input
									type="hidden" name="firm_survey_no"
									value="<%=Integer.parseInt(request.getQueryString())%>">
								<input type="hidden" name="mem_no" value="${user.mem_no}">
								<input type="hidden" name="question_amount" value="<%=i - 1%>">
								<input type="submit" value="確認送出" class="btn btn-primary mr-2">
								<button type="reset" class="btn btn-light">重填</button>
							</div>
						</div>
					</div>
				</div>
			</FORM>


			<!-- Modal1確認視窗 -->
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
				aria-labelledby="exampleModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="exampleModalLabel">Lonely Bar</h5>
							<button type="button" class="close" data-dismiss="modal"
								aria-label="Close">
								<span aria-hidden="true">&times;</span>
							</button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">取消</button>
							<a style="width: auto; height: auto;" class="btn btn-primary"
								href="<%=request.getContextPath()%>/PubStates">確認</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</c:otherwise>

</c:choose>
	
	
	




	<!-- content-wrapper ends -->

	<!-- 	</div> -->
	<!-- End Gallery  -->

	<!-- Start Instagram Feed  -->
	

	<!-- End Instagram Feed  -->

	<!-- !!!!!!此行以下都不要修改!!!!!!-->
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
		src="<%=request.getContextPath()%>/front-end/js/bootstrap.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/mem/js/permission_value.js"></script>
	<!-- ALL PLUGINS -->
	<script
		src="<%=request.getContextPath()%>/front-end/js/jquery.superslides.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/bootstrap-select.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/bootsnav.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/images-loded.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/owl.carousel.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/baguetteBox.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/form-validator.min.js"></script>
	<script
		src="<%=request.getContextPath()%>/front-end/js/contact-form-script.js"></script>
	<script id="customjs"
		src="<%=request.getContextPath()%>/front-end/js/custom.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/file-upload.js"></script>

</body>

</html>