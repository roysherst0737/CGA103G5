<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.prod_pic.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    Prod_pic_Service prod_picSvc = new Prod_pic_Service();
    List<Prod_pic_VO> list = prod_picSvc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有商品照片 - listAllProd_pic.jsp</title>

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
	width: 800px;
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
		<tr>
			<td>
				<h3>所有商品照片 - listAllProd_pic.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>商品照片編號</th>
			<th>商品編號</th>
			<th>商品照片</th>
			<th>商品照片名稱</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="prod_picVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${prod_picVO.prod_pic_no}</td>
				<td>${prod_picVO.prod_no}</td>
				<td>
					<c:choose>
						<c:when test="${prod_picVO.prod_pic != null}">
							<img src="<%=request.getContextPath()%>/prod_pic?prod_pic_no=${prod_picVO.prod_pic_no}&action=getOnePic">
						</c:when>
						<c:when test="${prod_picVO.prod_pic == null}">
							<img src="<%=request.getContextPath()%>/backend/prod_pic/images/APACHE_Badge.ico" class="no-img">
						</c:when>
					</c:choose>
				</td>
				<td>${prod_picVO.prod_pic_name}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/prod_pic/prod_pic.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="prod_pic_no" value="${prod_picVO.prod_pic_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/prod_pic/prod_pic.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="prod_pic_no" value="${prod_picVO.prod_pic_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>