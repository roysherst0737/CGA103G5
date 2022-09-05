<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.latest_news.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	Latest_news_VO latest_news_VO = (Latest_news_VO) request.getAttribute("latest_news_VO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>最新消息資料 - listOneLatest_news.jsp</title>

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
		 <h3>最新消息資料 - ListOneLatest_news.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>最新消息編號</th>
		<th>消息內容</th>
		<th>消息狀態</th>
	</tr>
	<tr>
		<td>${latest_news_VO.latest_news_no}</td>
		<td>${latest_news_VO.news_content}</td>
		<td>${latest_news_VO.news_status}</td>
	</tr>
</table>

</body>
</html>