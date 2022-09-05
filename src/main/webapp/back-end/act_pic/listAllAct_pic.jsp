<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act_pic.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Act_pic_Service act_picSvc = new Act_pic_Service();
List<Act_pic_VO> list = act_picSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有活動照片 - listAllAct_pic.jsp</title>

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
				<h3>所有活動照片 - listAllAct_pic.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動照片編號</th>
			<th>活動編號</th>
			<th>活動照片</th>
			<th>活動照片名稱</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="act_picVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${act_picVO.act_pic_no}</td>
				<td>${act_picVO.act_no}</td>
				<td><img
					src="<%=request.getContextPath()%>/Show_Act_pic_Servlet?act_pic_no=${act_picVO.act_pic_no}"
					width=150px height=100px></td>
				<td>${act_picVO.act_pic_name}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act_pic/act_pic.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="act_pic_no" value="${act_picVO.act_pic_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act_pic/act_pic.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="act_pic_no" value="${act_picVO.act_pic_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>