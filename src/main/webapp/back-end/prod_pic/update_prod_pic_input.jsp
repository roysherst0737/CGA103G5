<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.prod_pic.model.*"%>

<%
	Prod_pic_VO prod_picVO = (Prod_pic_VO) request.getAttribute("prod_picVO");
%>

<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>商品照片修改 - update_prod_pic_input.jsp</title>

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
		 <h3>商品照片修改 - update_prod_pic_input.jsp</h3>
		 <h4><a href="select_page.jsp">回首頁</a></h4>
	</td></tr>
</table>

<h3>商品照片修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="prod_pic.do" name="form1">
<table>
	<tr>
		<td>商品照片編號:</td>
		<td><input type="TEXT" name="prod_pic_no" size="45" 
			 value="<%= (prod_picVO==null)? "3" : prod_picVO.getProd_no()%>" /></td>
	</tr>
	<tr>
		<td>商品編號:</td>
		<td><input type="TEXT" name="prod_no" size="45" 
			 value="<%= (prod_picVO==null)? "3" : prod_picVO.getProd_no()%>" /></td>
	</tr>
	<tr>
		<td>商品照片:</td>
		<td><input type="file" name="prod_pic" size="45"
			 value="<%= (prod_picVO==null)? "" : prod_picVO.getProd_pic()%>" /></td>
	</tr>
	<tr>
		<td>商品照片名稱:</td>
		<td><input type="TEXT" name="prod_pic_name" size="45"
			 value="<%= (prod_picVO==null)? "高級烈酒" : prod_picVO.getProd_pic_name()%>" /></td>
	</tr>
</table>

<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="prod_pic_no" value="<%=prod_picVO.getProd_pic_no()%>">
<input type="submit" value="送出修改"></FORM>
</body>
</html>