<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.forum_article_report.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	Forum_article_report_VO forum_article_report_VO = (Forum_article_report_VO) request.getAttribute("forum_article_report_VO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>所有討論區文章檢舉資料 - listOneForum_article_report.jsp</title>

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
		 <h3>所有討論區文章檢舉資料 - ListOneForum_article_report.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>文章檢舉編號</th>
		<th>會員編號</th>
		<th>文章編號</th>
		<th>檢舉時間</th>
		<th>檢舉文章內容</th>
		<th>管理員編號</th>
		<th>文章處理完成時間</th>
		<th>文章處理狀態</th>
		<th>文章處理結果</th>
		<th>文章處理註記</th>
	</tr>
	<tr>
		<td>${forum_article_report_VO.frm_art_rpt_no}</td>
			<td>${forum_article_report_VO.mem_no}</td>
			<td>${forum_article_report_VO.frm_art_no}</td>
			<td>${forum_article_report_VO.rpt_time}</td>
			<td>${forum_article_report_VO.rpt_content}</td>
			<td>${forum_article_report_VO.mng_no}</td> 
			<td>${forum_article_report_VO.rpt_done_time}</td>
			<td>${forum_article_report_VO.rpt_status}</td>
			<td>${forum_article_report_VO.rpt_result}</td>
			<td>${forum_article_report_VO.rpt_note}</td>
	</tr>
</table>

</body>
</html>