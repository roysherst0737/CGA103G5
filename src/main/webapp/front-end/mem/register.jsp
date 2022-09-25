<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>朧醴 LonelyBar</title>
<!-- base:css -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/front-end/images/favicon.ico"
	type="image/x-icon">
<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/typicons.font/font/typicons.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<!-- endinject -->
<link rel="shortcut icon" href="<%=request.getContextPath()%>/images/Logo2.png" />
</head>

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
							<h4>還不是會員？</h4>
							<h6 class="font-weight-light">註冊加入我們！只需要幾秒時間即可享有我們的服務！</h6>
							<form class="pt-3" action="MemRegisterServlet" method="post">
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputUsername1" placeholder="輸入帳號"
										name="mem_account">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-lg"
										id="exampleInputPassword1" placeholder="輸入密碼"
										name="mem_password">
								</div>
								<div class="form-group">
									<select class="form-control form-control-lg"
										id="exampleFormControlSelect1" name="mem_gender">
										<option selected disabled>選擇性別</option>
										<option>男</option>
										<option>女</option>
										<option>多元性別</option>
									</select>
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputlast_name1" placeholder="輸入姓氏"
										name="mem_last_name">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputfirst_name1" placeholder="輸入名字"
										name="mem_first_name">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputnickname1" placeholder="輸入暱稱"
										name="mem_nickname">
								</div>
								<div class="form-group">
									<input type="tel" class="form-control form-control-lg"
										id="exampleInputtel_no1" placeholder="輸入家用電話"
										name="mem_tel_no">
								</div>
								<div class="form-group">
									<input type="tel" class="form-control form-control-lg"
										id="exampleInputcel_no1" placeholder="輸入手機"
										name="mem_cel_no">
								</div>
								<div class="form-group">
									<input type="email" class="form-control form-control-lg"
										id="exampleInputemail1" placeholder="輸入email" name="mem_email">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputid1" placeholder="輸入身分證字號" name="mem_id">
								</div>
								<div class="form-group">
									<input type="date" class="form-control form-control-lg"
										id="exampleInputbirth1" placeholder="輸入生日"
										name="mem_birth">
								</div>
								<div class="form-group">
									<input type="text" class="form-control form-control-lg"
										id="exampleInputaddr1" placeholder="輸入住址" name="mem_addr">
								</div>


								<div class="form-group">
									<select class="form-control form-control-lg"
										id="exampleFormControlSelect2" name="mem_permission">
										<option selected disabled>會員類別</option>
										<option>一般會員</option>
										<option>廠商會員</option>
									</select>
								</div>

<!-- 								<div class="mb-4"> -->
<!-- 									<div class="form-check"> -->
<!-- 										<label class="form-check-label text-muted"> <input -->
<!-- 											type="checkbox" class="form-check-input"> -->
<!-- 										</label> -->
<!-- 									</div> -->
<!-- 								</div> -->
								<div class="mt-3">
									<input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit" value="SIGN UP" />
								</div>
								<div class="text-center mt-4 font-weight-light">
									已是會員？ <a href="login.jsp"
										class="text-primary">登入</a>
								</div>
								<input type="hidden" name="Register" value="Mem_Register">
							</form>
							<c:if test="${not empty errorMsgs}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>
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
