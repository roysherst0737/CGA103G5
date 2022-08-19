<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.cart.model.*"%>

<%
  Cart_VO cartVO = (Cart_VO) request.getAttribute("cartVO");
%>
--<%= cartVO==null %>--${cartVO.mem_no}--
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>員工資料新增 - addEmp.jsp</title>

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
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>購物車資料新增 - addCart.jsp</h3></td><td>
		 <h4><a href="select_page.jsp"><img src="images/tomcat.png" width="100" height="100" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料新增:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="cart.do" name="form1">
<table>
	<tr>
		<td>會員編號:</td>
		<td><input type="TEXT" name="mem_no" size="45" 
			 value="<%= (cartVO==null)? "1" : cartVO.getMem_no()%>" /></td>
	</tr>
	<tr>
		<td>商品編號:</td>
		<td><input type="TEXT" name="prod_no" size="45"
			 value="<%= (cartVO==null)? "1" : cartVO.getProd_no()%>" /></td>
	</tr>
	<tr>
		<td>商品數量:</td>
		<td><input type="TEXT" name="prod_qty" size="45"
			 value="<%= (cartVO==null)? "10" : cartVO.getProd_qty()%>" /></td>
	</tr>
	<tr>
		<td>加入購物車時間:</td>
		<td><input type="TEXT" name="sal" size="45"
			 value="<%= (cartVO==null)? "2022-06-06 08:08:08" : cartVO.getAdd_time()%>" /></td>

</table>
<br>
<input type="hidden" name="action" value="insert">
<input type="submit" value="送出新增"></FORM>
</body>