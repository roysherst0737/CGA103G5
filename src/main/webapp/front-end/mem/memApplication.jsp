<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="zh">
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
<link rel="shortcut icon" href="./images/favicon.ico"
	type="image/x-icon">
<link rel="lonelybar-icon" href="./images/Logo2.png">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css">
<!-- Site CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/style.css">
<!-- Responsive CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/responsive.css">
<!-- Custom CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/custom.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front-end/css/pub.css">

<!-- plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->

<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/vertical-layout-light/style.css">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<style>
.main-top {
	padding:0.1px;
}
.btn-warning{
    background-color: #ffc107;
    width: 52px;
    height: 33.5px;
    padding: 0px;
    font-size: small;
    font-weight: bolder
}
input.btn-warning:hover{
 	background-color:#e0a800;
    color:black; !important;
}
.container-fluid{
	padding:0px;
}
.col-lg-6{
	padding:0px;
}
button.b1{
	height: auto;
    padding: 5px;
}
div.o1{
padding:7px;
	display: flex;
    align-items: center;
    margin: 5px;
}
div.inside {
	padding-left:30px; 
	margin:0px;
	
}
div.d1{
border: 3px solid #e8eff9;  
border-radius:3px;
}
div.d1:hover{
border: 3px solid #d2b36b; 
}
div.row {
	margin:11px;
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
</style>
</head>

<body>

	<!-- !!!!!! 可修改部分：從第142行開始到footer !!!!!!-->
	<div id=top_nav_banner>
		<%@ include file="/front-end/partials/_mainTop.jsp"%>
	</div>
	<!-- !!!!!! 從以下開始修改到footer !!!!!!-->
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>個人資料</h2>

<!-- 					<ul class="breadcrumb"> -->
<!-- 						<li class="breadcrumb-item active">酒吧註冊申請 /</li> -->
<!-- 						<li></li> -->
<!-- 						<li class="breadcrumb-item"><a -->
<%-- 							href="<%=request.getContextPath()%>/front-end">首頁</a></li> --%>
<!-- 					</ul> -->
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Gallery  -->
<!-- 	<div class="products-box"> -->
<!-- 		<div class="container"> -->
<!-- 			<div class="row"> -->
<!-- 				<div class="col-lg-12"> -->
<!-- 					<div class="title-all text-center"> -->
<!-- 						<h1>酒吧申請</h1> -->
<!-- 						<p>一、請確實填寫資料。</p> -->
<!-- 						<p>二、經審核後即可上架。</p> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->
		<!-- 主內容 -->
		<div class="main-panel">
			<div class="content-wrapper">
			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
				<form class="pt-3" action="MemUpdateServlet" method="post">
					<div class="row">
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
				                    <p class="card-description">
				                      我的檔案									  
				                    </p>
				                    <p class="card-description">
									  管理你的檔案以保護你的帳戶
				                    </p>
				                    
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">帳號</label>
				                          <div class="col-sm-9">
                           					 <input type="text" class="form-control" disabled="disabled" value="${sessionScope.user.getMem_account()}">
                          				  	 <input type="hidden" name="mem_account" value="${sessionScope.user.getMem_account()}">
                          				  </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">密碼</label>
				                          <div class="col-sm-9">
				                            <a class="form-control" href="change_password.jsp">變更密碼</a>
				                          </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">性別</label>
				                          <div class="col-sm-9">
<!-- 				                            <select class="form-control"> -->
<!-- 				                              <option>男</option> -->
<!-- 				                              <option>女</option> -->
<!-- 				                              <option>多元性別</option> -->
<!-- 				                            </select> -->
												<div class="form-group row">
				                           			  <div class="col-sm-3">
				                           				 <div class="form-check">
				                           				   <label class="form-check-label">
				                              				  <input type="radio" class="form-check-input" name="gender" id="genderRadios1" value="1" >
				                                				男
				                             					 <i class="input-helper"></i><i class="input-helper"></i></label>
				                            			</div>
				                          			 </div>
				                          			 <div class="col-sm-3">
				                           				 <div class="form-check">
				                           				   <label class="form-check-label">
				                            				   <input type="radio" class="form-check-input" name="gender" id="genderRadios0" value="0" >
				                              					  女
				                              						<i class="input-helper"></i><i class="input-helper"></i></label>
				                          				  </div>
				                       				   </div>	
				                          			 <div class="col-sm-5">
				                           				 <div class="form-check">
				                           				   <label class="form-check-label">
				                            				   <input type="radio" class="form-check-input" name="gender" id="genderRadios2" value="2" >
				                              					  多元性別
				                              						<i class="input-helper"></i><i class="input-helper"></i></label>
				                          				  </div>
				                       				   </div>	
				                       				   <input type="hidden" id ="gender_value"  value="${sessionScope.user.getMem_gender()}" name="mem_gender">                      		
				                          			 </div>
				                          </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">姓氏</label>
				                          <div class="col-sm-9">
                           					 <input type="text" class="form-control" value="${sessionScope.user.getMem_last_name()}" name="mem_last_name">
                          				  </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">名字</label>
				                          <div class="col-sm-9">
                           					 <input type="text" class="form-control" value="${sessionScope.user.getMem_first_name()}" name="mem_first_name">
                          				  </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">暱稱</label>
				                          <div class="col-sm-9">
                           					 <input type="text" class="form-control" value="${sessionScope.user.getMem_nickname()}" name="mem_nickname">
                          				  </div>
				                        </div>
				                        <div class="form-group row">
				                          <label class="col-sm-3 col-form-label">連絡電話</label>
				                          <div class="col-sm-9">
                           					 <input type="tel" class="form-control" value="${sessionScope.user.getMem_tel_no()}" name="mem_tel_no">
                          				  </div>
				                        </div>				                       				                        				                       			                   
				                	</div>
								</div>
							</div>
						<div class="col-md-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"></h4>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">手機號碼</label>
			                          <div class="col-sm-9">
                          				<input type="tel" class="form-control" value="${sessionScope.user.getMem_cel_no()}" name="mem_cel_no">
                         			  </div>
				                    </div>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">電子郵件</label>
			                          <div class="col-sm-9">
                          				<input type="email" class="form-control" value="${sessionScope.user.getMem_email()}" name="mem_email">
                         			  </div>
				                    </div>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">身分證字號</label>
			                          <div class="col-sm-9">
                          				<input type="text" class="form-control" value="${sessionScope.user.getMem_id()}" name="mem_id">
                         			  </div>
				                    </div>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">生日</label>
			                          <div class="col-sm-9">
                          				<input type="date" class="form-control" value="${sessionScope.user.getMem_birth()}" name="mem_birth">
                         			  </div>
				                    </div>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">地址</label>
			                          <div class="col-sm-9">
                          				<input type="text" class="form-control" value="${sessionScope.user.getMem_addr()}" name="mem_addr">
                         			  </div>
				                    </div>
									<div class="form-group row">
			                          <label class="col-sm-3 col-form-label">權限</label>
			                          <div class="col-sm-9">
                          				<input type="text" class="form-control"  id= "permission"  disabled="disabled">
                          				<input type="hidden" id ="permission_value"  value="${sessionScope.user.getMem_permission()}"  name="mem_permission"> 
                         			  </div>
				                    </div>								
									<button id="btn" type="submit" class="btn btn-primary mr-2">確認送出</button>
									<button type="reset" class="btn btn-light">重填</button>
								</div>
							</div>
						</div>
					</div>
					<input type="hidden" name="Update" value="Mem_Update">
					<input type="hidden" name="status" value="${sessionScope.user.getStatus()}">
					<input type="hidden" name="mem_no" value="${sessionScope.user.getMem_no()}">
					<input type="hidden" name="mem_cert_status" value="${sessionScope.user.getMem_cert_status()}">
				</form>


				<!-- Modal1確認視窗 -->
				<div class="modal fade" id="exampleModal" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel"
					aria-hidden="true">
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



			<!-- content-wrapper ends -->
		</div>

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
	<script src="<%=request.getContextPath()%>/front-end/js/bootstrap.min.js"></script>
	<script src="<%=request.getContextPath()%>/front-end/mem/js/permission_value.js"></script>
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