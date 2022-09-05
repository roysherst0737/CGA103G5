<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act_sign_up.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Act_sign_up_Service act_sign_upSvc = new Act_sign_up_Service();
List<Act_sign_up_VO> list = act_sign_upSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有活動報名 - listAllAct_sign_up.jsp</title>

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
				<h3>所有活動報名 - listAllAct_sign_up.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>報名編號</th>
			<th>活動編號</th>
			<th>會員編號</th>
			<th>報名時間</th>
			<th>攜伴人數</th>
			<th>報名狀態</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="act_sign_upVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${act_sign_upVO.sign_up_no}</td>
				<td>${act_sign_upVO.act_no}</td>
				<td>${act_sign_upVO.mem_no}</td>
				<td>${act_sign_upVO.sign_up_time}</td>
				<td>${act_sign_upVO.accompany_count}</td>
				<td>${act_sign_upVO.sign_up_status}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act_sign_up/act_sign_up.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="sign_up_no" value="${act_sign_upVO.sign_up_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act_sign_up/act_sign_up.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="sign_up_no" value="${act_sign_upVO.sign_up_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>