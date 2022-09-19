<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.manager.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO"); //Manager_Servlet.java(Concroller), 存入req的manager_VO物件
  
  Manager_Service manager_Svc = new Manager_Service();
%>

<html>
<head>
<title>員工資料 - listOneManager.jsp</title>

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
		 <h3>員工資料 - ListOneManager.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>管理員編號</th>
		<th>管理員帳號</th>
		<th>管理員密碼</th>
		<th>管理員姓名</th>
		<th>管理員手機</th>
		<th>管理員照片</th>
		<th>管理員狀態</th>
	</tr>
	<tr>
		<td><%=manager_VO.getMng_no()%></td>
		<td><%=manager_VO.getMng_account()%></td>
		<td><%=manager_VO.getMng_password()%></td>
		<td><%=manager_VO.getMng_name()%></td>
		<td><%=manager_VO.getMng_phone()%></td>
		<td><img src="<%=request.getContextPath()%>/ManagerImage?mng_no=${manager_VO.mng_no}" width=60px height=60px></td>
		<td><%=manager_VO.getMng_status()%></td>
	</tr>
</table>

</body>
</html>