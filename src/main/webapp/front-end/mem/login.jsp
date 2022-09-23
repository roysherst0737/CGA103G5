<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>會員登入</title>
<!-- base:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/Logo2.png" />
</head>
<%
String previous_page = request.getHeader("referer");
String original_URL = request.getRequestURL().toString();
String servlet_URL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/front-end/mem/MemLoginServlet";
String memUpdate_URL = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/front-end/mem/MemUpdateServlet";
if((!previous_page.equals(original_URL))&&(!previous_page.equals(servlet_URL))&&(!previous_page.equals(memUpdate_URL))){
	session.setAttribute("previous_page", previous_page);
}

%>

<body>
	<div class="container-scroller">
		<div class="container-fluid page-body-wrapper full-page-wrapper">
			<div class="content-wrapper d-flex align-items-center auth px-0">
				<div class="row w-100 mx-0">
					<div class="col-lg-4 mx-auto">
						<div class="auth-form-light text-left py-5 px-4 px-sm-5">
							<div class="brand-logo">
							<a href="<%=request.getContextPath()%>/front-end/index.jsp">
								<img src="<%=request.getContextPath()%>/front-end/images/Logo3.png" alt="logo">
								</a>
							</div>
							<h1>登入</h1>
								<c:if test="${not empty errorMsgs}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message.value}</li>
									</c:forEach>
								</ul>
								</c:if>
							<form class="pt-3" action="<%=request.getContextPath()%>/front-end/mem/MemLoginServlet" method="post">
								<div class="form-group">
									帳號<input type="text" class="form-control form-control-lg"
										id="exampleInputEmail1" placeholder="account"
										name="mem_account">
								</div>
								<div class="form-group">
									密碼<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="password"
										name="mem_password">
								</div>
								<div class="mt-3">
								<input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit" value="登入" />
								</div>
								<div
									class="my-2 d-flex justify-content-between align-items-center">
									<div class="form-check">
										<label class="form-check-label text-muted"> <input
											type="checkbox" class="form-check-input"> Keep me
											signed in
										</label>
									</div>
									<a href="Forgot_password.jsp" class="auth-link text-black">Forgot password?</a>
								</div>
								<div class="mb-2">
									<button type="button"
										class="btn btn-block btn-facebook auth-form-btn">
										<i class="typcn typcn-social-facebook-circular mr-2"></i>Connect
										using facebook
									</button>
								</div>
								<div class="text-center mt-4 font-weight-light">
									Don't have an account? <a href="register.jsp"
										class="text-primary">Create</a>
								</div>
								<input type="hidden" name="Login" value="Mem_Login">
							</form>
							
						</div>
					</div>
				</div>
			</div>
			<!-- content-wrapper ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- container-scroller -->
	<!-- base:js -->
	<script src="<%=request.getContextPath()%>/back-end/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- inject:js -->
	<script src="<%=request.getContextPath()%>/back-end/js/off-canvas.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/hoverable-collapse.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/template.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/settings.js"></script>
	<script src="<%=request.getContextPath()%>/back-end/js/todolist.js"></script>
	<!-- endinject -->
</body>

</html>
