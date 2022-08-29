<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ page import="com.mem.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  Mem_VO memVO = (Mem_VO) request.getAttribute("memVO"); //MemServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>會員資料 - listOneMem.jsp</title>

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
		 <h3>會員資料 - ListOneMem.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員編號</th>
		<th>會員帳號</th>
		<th>會員密碼</th>
		<th>會員性別</th>
		<th>會員姓氏</th>
		<th>會員名字</th>
		<th>會員暱稱</th>
		<th>會員連絡電話</th>
		<th>會員手機號碼</th>
		<th>會員電子郵件</th>
		<th>會員身分證字號</th>
		<th>會員生日</th>
		<th>會員地址</th>
		<th>會員權限</th>
		<th>會員狀態</th>
		<th>會員創建日期</th>
		<th>認證狀態</th>
	</tr>
	<tr>
		<td><%=memVO.getMem_no()%></td>
		<td><%=memVO.getMem_account()%></td>
		<td><%=memVO.getMem_password()%></td>
		<td><%=memVO.getMem_gender()%></td>
		<td><%=memVO.getMem_last_name()%></td>
		<td><%=memVO.getMem_first_name()%></td>
		<td><%=memVO.getMem_nickname()%></td>
		<td><%=memVO.getMem_tel_no()%></td>
		<td><%=memVO.getMem_cel_no()%></td>
		<td><%=memVO.getMem_email()%></td>
		<td><%=memVO.getMem_id()%></td>
		<td><%=memVO.getMem_birth()%></td>
		<td><%=memVO.getMem_addr()%></td>
		<td><%=memVO.getMem_permission()%></td>
		<td><%=memVO.getStatus()%></td>
		<td><%=memVO.getMem_build_time()%></td>
		<td><%=memVO.getMem_cert_status()%></td>
	</tr>
</table>

</body>
</html>