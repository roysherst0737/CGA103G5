<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.forum_article.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	Forum_article_VO forum_article_VO = (Forum_article_VO) request.getAttribute("forum_article_VO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>討論區文章資料 - listOneForum_article.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>
  table {
	width: 600px;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>討論區文章資料 - ListOneForum_article.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>文章編號</th>
		<th>討論區編號</th>
		<th>會員編號</th>
		<th>文章發布時間</th>
		<th>文章主旨</th>
		<th>文章內容</th>
		<th>圖片訊息</th>
		<th>文章狀態</th>
	</tr>
	<tr>
		<td>${forum_article_VO.frm_art_no}</td>
		<td>${forum_article_VO.frm_no}</td>
		<td>${forum_article_VO.mem_no}</td>
		<td>${forum_article_VO.art_time}</td>
		<td>${forum_article_VO.art_title}</td>
		<td>${forum_article_VO.art_content}</td> 
		<td>${forum_article_VO.art_img}</td>
		<td>${forum_article_VO.art_status}</td>
	</tr>
</table>

</body>
</html>