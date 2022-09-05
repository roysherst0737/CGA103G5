<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.act.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
Act_Service actSvc = new Act_Service();
List<Act_VO> list = actSvc.getAll();
pageContext.setAttribute("list", list);
%>


<html>
<head>
<title>所有活動 - listAllAct.jsp</title>

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
				<h3>所有活動 - listAllAct.jsp</h3>
				<h4>
					<a href="select_page.jsp">回首頁</a>
				</h4>
			</td>
		</tr>
	</table>

	<table>
		<tr>
			<th>活動編號</th>
			<th>酒吧編號</th>
			<th>活動名稱</th>
			<th>活動描述</th>
			<th>活動地址</th>
			<th>上架時間</th>
			<th>下架時間</th>
			<th>當前報名人數</th>
			<th>容納人數上限</th>
			<th>容納人數下限</th>
			<th>報名開始時間</th>
			<th>報名結束時間</th>
			<th>活動開始時間</th>
			<th>活動結束時間</th>
			<th>活動狀態</th>
			<th>申請上下架/修改時間</th>
			<th>申請狀態</th>
		</tr>
		<%@ include file="page1.file"%>
		<c:forEach var="actVO" items="${list}" begin="<%=pageIndex%>"
			end="<%=pageIndex+rowsPerPage-1%>">

			<tr>
				<td>${actVO.act_no}</td>
				<td>${actVO.pub_no}</td>
				<td>${actVO.act_name}</td>
				<td>${actVO.act_detail}</td>
				<td>${actVO.act_loc}</td>
				<td>${actVO.act_launch_time}</td>
				<td>${actVO.act_off_time}</td>
				<td>${actVO.current_count}</td>
				<td>${actVO.max_count}</td>
				<td>${actVO.min_count}</td>
				<td>${actVO.sign_up_begin_time}</td>
				<td>${actVO.sign_up_end_time}</td>
				<td>${actVO.act_start_time}</td>
				<td>${actVO.act_end_time}</td>
				<td>${actVO.act_status}</td>
				<td>${actVO.apply_time}</td>
				<td>${actVO.apply_status}</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act/act.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="修改"> <input type="hidden"
							name="act_no" value="${actVO.act_no}"> <input
							type="hidden" name="action" value="getOne_For_Update">
					</FORM>
				</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/back-end/act/act.do"
						style="margin-bottom: 0px;">
						<input type="submit" value="刪除"> <input type="hidden"
							name="act_no" value="${actVO.act_no}"> <input
							type="hidden" name="action" value="delete">
					</FORM>
				</td>
			</tr>
		</c:forEach>
	</table>
	<%@ include file="page2.file"%>

</body>
</html>