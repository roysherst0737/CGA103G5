<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.forum_article_report.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	Forum_article_report_Service forum_article_report_Svc = new Forum_article_report_Service();
    List<Forum_article_report_VO> list = forum_article_report_Svc.getAll();
    pageContext.setAttribute("list",list);
%>


<html>
<head>
<title>所有討論區文章檢舉資料 - listAllForum_article_report.jsp</title>

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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有討論區文章檢舉資料 - listAllForum_article_report.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>文章檢舉編號</th>
		<th>會員編號</th>
		<th>文章編號</th>
		<th>檢舉時間</th>
		<th>檢舉文章內容</th>
		<th>管理員編號</th>
		<th>文章處理完成時間</th>
		<th>文章處理狀態</th>
		<th>文章處理結果</th>
		<th>文章處理註記</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="forum_article_report_VO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			<td>${forum_article_report_VO.frm_art_rpt_no}</td>
			<td>${forum_article_report_VO.mem_no}</td>
			<td>${forum_article_report_VO.frm_art_no}</td>
			<td>${forum_article_report_VO.rpt_time}</td>
			<td>${forum_article_report_VO.rpt_content}</td>
			<td>${forum_article_report_VO.mng_no}</td> 
			<td>${forum_article_report_VO.rpt_done_time}</td>
			<td>${forum_article_report_VO.rpt_status}</td>
			<td>${forum_article_report_VO.rpt_result}</td>
			<td>${forum_article_report_VO.rpt_note}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="frm_art_rpt_no"  value="${forum_article_report_VO.frm_art_rpt_no}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/emp/emp.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="frm_art_rpt_no"  value="${forum_article_report_VO.frm_art_rpt_no}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>