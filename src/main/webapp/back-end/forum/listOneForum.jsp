<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.forum.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
	Forum_VO forum_VO = (Forum_VO) request.getAttribute("forum_VO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>討論區資料 - listOneForum.jsp</title>

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
		 <h3>討論區資料 - ListOneForum.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>討論區編號</th>
		<th>討論區名稱</th>
		<th>討論區狀態</th>
	</tr>
	<tr>
		<td>${forum_VO.frm_no}</td>
		<td>${forum_VO.frm_name_no}</td>
		<td>${forum_VO.frm_status}</td>
	</tr>
</table>

</body>
</html>