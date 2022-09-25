<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
              <h5 class="mb-0">忘記您的密碼？</h5>
              <small class="font-weight-light">請輸入您的電子郵件，我們將寄送重置密碼的連結給您</small>
              <div>
             <%-- 錯誤表列 --%>
					<c:if test="${not empty errorMsgs}">
						<font style="color: red">請修正以下錯誤:</font>
						<ul>
							<c:forEach var="message" items="${errorMsgs}">
								<li style="color: red">${message}</li>
							</c:forEach>
						</ul>
					</c:if>
				</div>
              <form class="pt-3" method ="post" action = "MailServlet">
                <div class="form-group">
                  <input type="email" class="form-control form-control-lg" id="exampleInputEmail1" placeholder="電子郵件" name ="mem_email">
                </div>
                <div class="mt-3">
               <input class="btn btn-block btn-primary btn-lg font-weight-medium auth-form-btn" type="submit" value="寄送重置密碼連結" />
                    
                </div>
                <div class="text-center mt-4 font-weight-light">
                  <a href="login.jsp" class="auth-link text-black ">登入</a>
                </div>
                <div class="text-center mt-4 font-weight-light">
                  還沒有帳號？ <a href="register.jsp" class="text-primary">建立帳號</a>
                </div>
                <input type = "hidden" name = "action" value = "findbyemail">
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
