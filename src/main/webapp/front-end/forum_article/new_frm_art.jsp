<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.forum.model.*"%>
<%@ page import="com.forum_article.model.*"%>
<%@ page import="com.forum_article_report.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.article_message.model.*"%>
<%@ page import="com.article_message_report.model.*"%>

<%
Forum_Service forum_Svc = new Forum_Service();
List<Forum_VO> list2 = forum_Svc.getAll();
pageContext.setAttribute("list2", list2);
Forum_article_VO forum_article_VO = (Forum_article_VO) request.getAttribute("forum_article_VO");
//登入會員
Object Objuser = session.getAttribute("user");
Mem_VO user = (Mem_VO) Objuser;

Integer mem_no = user.getMem_no();

// Forum_article_Service fArticleSvc = new Forum_article_Service();
// List<Forum_article_VO> list_fArticle = fArticleSvc.getAll();
// int max =  Collections.max(list_fArticle);
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

    tbody.tby {
      text-align: center;
      font-family: Verdana;
      font-weight: 400;
      color: #404040;
      width: 964px;
      font-size: 13px;
      border-collapse: collapse;
    }

    h2 {
      text-align: center;
      color: #FFB326;

    }

    th {
      text-align: center;

    }

    #form-style {
      padding: 90px;
      color: #696969;
    }
  </style>
 	<script type="text/javascript">
    function setsubmit() {
      if (mylink.value == 0)
        window.location = '#';
      if (mylink.value == frm - act)
        window.location = '#';
      if (mylink.value == frm - grp)
        window.location = '#';
      if (mylink.value == frm - pub - eva)
        window.location = '#';
      if (mylink.value == frm - prd - eva)
        window.location = '#';
    }
 	 </script>

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
<!-- 					<h2>購物商城</h2> -->
<!-- 					<ul class="breadcrumb"> -->
<!-- 						<li class="breadcrumb-item"><a -->
<%-- 							href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">回商城</a></li> --%>
<!-- 						<li class="breadcrumb-item active">總覽</li> -->
<!-- 					</ul> -->
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	  <h1></h1>
	  <h1></h1>
	  <div class="container" id="form-style">
	    <div class="card" style="border:1px solid;">
	      <form action="new_article.do" method="post" enctype="multipart/form-data" name="form1">
	        <h2 class="card-title" style="font-weight:bold;margin:10px; margin-top:30px;">發表文章</h3>
	          <table class="table">
	            <tbody>
	              <tr>
	                <th>討論區</th>
	                	<td>
	                		<select name="frm_no" id="allianceSelection" style="width:30%; margin:1%;">
	                 		<c:forEach var="forum_VO" items="${list2}">
	                    	<option value="${forum_VO.frm_no}">${forum_VO.frm_name_no}</option>

	                        </c:forEach>	
	                  		</select>
	                  	</td>
	              </tr>
	              <tr>
	                <th>標題</th>
	                <td><input type="text" name="art_title" maxlength="50" value="" style="width:70%; margin:1%;" /></td>
	              </tr>
	              <%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>
	              <tr>
	                <th>內容</th>
	                <td><textarea name="art_content" value=""rows="6" cols="40" required style="width:70%; margin:1%;color: #FFB326;" /></textarea></td>
	              </tr>
	              <tr>
	                <th>上傳圖片</th>
	                <td><input name="art_img" type="file"></td>
	              </tr>
	              <tr>
	                <th></th>
	                <td>
	                  <input type="hidden" name="action" value="insert">
	                   <input type="hidden" name="mem_no" value="<%=mem_no%>">
	                    <input type="submit" value="送出新增" class="form-control input" style="width:70%; font-size:18px; color: #FFB326; font-weight:bold">
	                  
	       </td>
	              </tr>
	            </tbody>
	          </table>
	      </form>

	    </div>
	  </div>


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