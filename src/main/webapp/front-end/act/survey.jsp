<%@ page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.firm_survey.model.*"%>
<%@ page import="com.question_list.model.*"%>
<%@ page import="com.ans_list.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.prod.model.*"%>


<%
Firm_survey_Service firm_surveySvc = new Firm_survey_Service();
Set<Integer> set = firm_surveySvc.getAll_from_act_no(Integer.parseInt(request.getQueryString()));
pageContext.setAttribute("set", set);
int i = 1;
int j = set.size();
pageContext.setAttribute("j", j);

Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

Ans_list_Service ans_listSvc = new Ans_list_Service();
Set<Integer> set2 = ans_listSvc.getAllfirm_survey_no((Integer) user.getMem_no());
pageContext.setAttribute("set2", set2);

Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);

String surveyUrl = request.getRequestURL().toString() + "?" + request.getQueryString();
session.setAttribute("surveyUrl", surveyUrl);
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
.btn {
	width: auto;
	height: auto;
}
#remind {
			color:#f5c242; 
			font-size: 28px; 
			font-weight:bold;
			}
		#remind:hover {	
			color:black;
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
					<h2>我的報名</h2>

				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Cart  -->
	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>活動問卷</th>

									<th>填寫</th>
								</tr>
							</thead>
							<tbody>
                                 <c:if test="${j == 0 }">
                                      <td>
                                   <a href="<%=request.getContextPath()%>/front-end/act/my_sign_up.jsp" id="remind">活動方尚未新增問卷，點擊回上一頁</a>
                                            </td>
                                      </c:if>


								<c:forEach var="set" items="${set}">
									<tr>
										<td>活動問卷<%=i++%></td>
										<c:choose>
											<c:when test="${set2.contains(set)}">
												<td><input type="button" value="已填寫"></td>
											</c:when>
											<c:otherwise>
												<td><input type="button" value="填寫"
													onclick="location.href='<%=request.getContextPath()%>/front-end/act/writesurvey.jsp?${set}'"></td>
											</c:otherwise>
										</c:choose>
									</tr>
								</c:forEach>
								
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
			<!-- !!!!!!此行以下都不要修改!!!!!!-->
			<!-- Start Instagram Feed  -->
			<div class="instagram-box">
				<%@ include file="/front-end/partials/_InstagramBox.jsp"%>
			</div>
			<!-- End Instagram Feed  -->
			<!-- Start Footer  -->
			<footer>
				<%@ include file="/front-end/partials/_footer.jsp"%>
			</footer>
			<!-- End Footer  -->

			<!-- Start copyright  -->
			<div class="footer-copyright">
				<p class="footer-company">
					All Rights Reserved. &copy; 2022 <a href="#">LonelyBar</a> Design
					By : <a href="https://html.design/">CGA103G5</a>
				</p>
			</div>
			<!-- End copyright  -->

			<a href="#" id="back-to-top" title="Back to top"
				style="display: none;">&uarr;</a>

			<!-- ALL JS FILES -->
			<script
				src="<%=request.getContextPath()%>/front-end/js/popper.min.js"></script>
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
			<script
				src="<%=request.getContextPath()%>/front-end/js/inewsticker.js"></script>
			<script
				src="<%=request.getContextPath()%>/front-end/js/isotope.min.js"></script>
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