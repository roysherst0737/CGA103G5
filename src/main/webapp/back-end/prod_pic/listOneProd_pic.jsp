<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod_pic.model.*"%>

<%
	Prod_pic_VO prod_picVO = (Prod_pic_VO) request.getAttribute("prod_picVO");
%>

<html>
<head>
<title>商品照片 - listOneProd_pic.jsp</title>

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
	width: 650px;
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

<table id="table-1">
	<tr><td>
		 <h3>商品照片 - ListOneProd_pic.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>商品照片編號</th>
		<th>商品編號</th>
		<th>商品照片</th>
		<th>商品照片名稱</th>
	</tr>
			<tr>
				<td>${prod_picVO.prod_pic_no}</td>
				<td>${prod_picVO.prod_no}</td>
				<td>
					<img src="<%=request.getContextPath()%>/Show_Images_Servlet?prod_pic_no=${prod_picVO.prod_pic_no}" width=300px height=200px>
				</td>
				<td>${prod_picVO.prod_pic_name}</td>
</table>

</body>
</html>