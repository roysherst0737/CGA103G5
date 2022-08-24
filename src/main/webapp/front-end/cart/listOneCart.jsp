<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.cart.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  Cart_VO cartVO = (Cart_VO) request.getAttribute("cartVO");
%>

<html>
<head>
<title>購物車資料 - listOneCart.jsp</title>

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

<table id="table-1">
	<tr><td>
		 <h3>員工資料 - ListOneCart.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>商品編號</th>
		<th>商品數量</th>
	</tr>
	<tr>
		<td><%=cartVO.getMem_no()%></td>
		<td><%=cartVO.getProd_no()%></td>
		<td><%=cartVO.getProd_qty()%></td>
	</tr>
</table>

</body>
</html>