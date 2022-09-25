<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.forum.model.*"%>
<%@ page import="com.forum_article.model.*"%>
<%@ page import="com.forum_article_report.model.*"%>
<%@ page import="com.mem.model.*"%>
<%@ page import="com.article_message.model.*"%>
<%@ page import="com.article_message_report.model.*"%>
<%@ page import="com.prod.model.*"%>

<%
Prod_Service prodSvc = new Prod_Service();
List<Prod_VO> list = prodSvc.getAll();
pageContext.setAttribute("list", list);
//討論版
Forum_Service forum_Svc = new Forum_Service();
Forum_VO forum_VO = forum_Svc.getOneForum(Integer.parseInt(request.getQueryString()));
request.setAttribute("forum_VO", forum_VO);
//文章內容
Forum_article_Service forum_article_Svc = new Forum_article_Service();
Forum_article_VO forum_article_VO = forum_article_Svc.getOneForum_article(Integer.parseInt(request.getQueryString()));
request.setAttribute("forum_article_VO", forum_article_VO);

//留言列標
// Article_message_Service article_message_Svc = new Article_message_Service();
// Article_message_VO article_message_VO = article_message_Svc.getOneArticle_message(Integer.parseInt(request.getQueryString()));
// request.setAttribute("article_message_VO", article_message_VO);

// Set<Article_message_VO> set = forum_article_Svc.getArticle_messageByForum_article(forum_article_VO.getFrm_art_no());
// pageContext.setAttribute("set", set);

//留言顯示

Article_message_Service article_message_Svc = new Article_message_Service();
List<Article_message_VO> list1 = article_message_Svc.getAllfromfrm_art_no(forum_article_VO.getFrm_art_no());
pageContext.setAttribute("list1", list1);


//登入會員
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
    /* .mydiv {
      display: flex;
      justify-content: space-between;
      border: 1px solid;
      top: 10px;
    } */
    .mydiv {
      /* border: 1px solid; */
      height: 1px;
      /* top: 100px; */
    }

    #content-out {
      padding: 30px;
    }

    #content {
      padding: 10px;
      height: 50px;
    }


    /* h2 {
      text-align: center;
      width: 100%;
      font-weight: bold;
      margin-top: 30px;
    } */

    table {
      border-collapse: collapse;
      width: 60%;
    }

    tr {
      height: 50px;
    }

    div.forum-socialtool-box,
    div.forum-socialtool-box-v {
      width: 100%;
      min-width: 600px;
      text-align: center;
      clear: both;
      font-size: 12px;
      line-height: 12px;
      font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
      border-radius: 5px;
      -webkit-border-radius: 5px;
      -o-border-radius: 5px;
    }

    .forum-socialtool-box,
    .quote_result {
      position: relative;
    }

    h2 {
      top: 40px;
      left: 160px;
    }

    #rpt-btn {
      bottom: 88px;
      width: 80px;
      left: 95%;
    }

    #text {
      width: 80%;

    }

    #message {
      padding: 100px;
      left: 70px;
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

  <div class="" style="border:1px solid;">
    <div class="" id="title">
      <h2 class="title">
<%--       ${forum_VO.frm_name_no} --%>
        <!-- 討論區超連結 -->
<!--         <a class="title">>> -->
          <a href="#">${forum_article_VO.art_title}</a>
<!--         </a> -->
      </h2>
    </div>
    <table class="table table-bordered" style="width: 950px;margin:auto; margin-top:40px; margin-bottom:40px;">
      <tbody style="width:700px;" class="table-light">
        <div class="">
          <tr>
            <div class="forum-socialtool-box">
            </div>
            <td rowspan="7" style="width:18%;background: #B8CDF3;">
              <div class="">${forum_article_VO.mem_no}</div>
            </td>
            <td rowspan="7" id="content-out">
              <div class="mydiv">
                <div class="" id="content">${forum_article_VO.art_content}</div>
                <div class="dropdown" id="rpt-btn">
                  <a href="#" class="nav-link dropdown" data-toggle="dropdown" style="font-weight: 1000;">[檢舉]</a>
                  <ul class="dropdown-menu">
                    <li><a href="<%=request.getContextPath()%>/forum_article_report_Servlet?frm_art_rpt_no=${forum_article_report_VO.frm_art_rpt_no}">隱射或針對他人</a>
                    </li>
                    <li>
                    <input type="radio" name="tab" id="tab5" onclick="location.href='http://tw.yahoo.com'"/>
                    <a href="shop-detail.html">不雅言論</a></li>
                    <li><a href="cart.html">圖文不符</a></li>
                    <li><a href="checkout.html">其他</a></li>
                  </ul>
                </div>
              </div>
            </td>
          </tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
          <tr></tr>
        </div>
      </tbody>
      <tr>
        <td COLSPAN=2>
          <div class="">
          
          <c:forEach var="article_message_VO" items="${list1}">
			<c:if test="${article_message_VO.article_message_report_VO.msg_result==1}">
        	  <span id="idnamber">
            	  ${article_message_VO.mem_no}<a>：</a>
           	 </span>
          	  <span class="" style="width:82%; float:right;">
           	   ${article_message_VO.msg_content}
          	  </span>
           	 <span>
           	   <div class=" dropdown" id="rpt-btn2" style="left:870px; bottom:35px;">
           	     <a href="#" class="nav-link dropdown" data-toggle="dropdown" style="font-weight: 1000;">[檢舉]</a>
           	     <ul class="dropdown-menu">
           	       <li><a href="<%=request.getContextPath()%>/forum_article_report_Servlet?frm_art_rpt_no=${forum_article_report_VO.frm_art_rpt_no}">隱射或針對他人</a>
           	       </li>
           	       <li><a href="shop-detail.html">不雅言論</a></li>
           	       <li><a href="cart.html">辱罵他人</a></li>
           	       <li><a href="checkout.html">其他</a></li>
           	      </ul>
           	    </div>
           	  </span>
           	  </c:if>
           </c:forEach>
           </div>
         </td>
  </div>
  </td>
  </tr>
  <tr>
    <td COLSPAN=2>
      <form class="message">
        <div style="text-align:right;">
          <span>
            ${user.mem_no}<span>：</span>
          </span>
          <input type="text" name="欄位名稱" id="text" style="width:82%; float:right;">
        </div>
      </form>
    </td>
  </tr>

  </table>
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