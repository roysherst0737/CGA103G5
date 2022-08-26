<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Article_message_report: Home</title>

<style>
  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>IBM Article_message_report: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Article_message_report: Home</p>

<h3>資料查詢:</h3>

<%-- 錯誤表列 --%>
<%-- <c:if test="${not empty errorMsgs}"> --%>
<!-- 	<font style="color:red">請修正以下錯誤:</font> -->
<!-- 	<ul> -->
<%-- 		<c:forEach var="message" items="${errorMsgs}"> --%>
<%-- 			<li style="color:red">${message.value}</li> --%>
<%-- 		</c:forEach> --%>
<!-- 	</ul> -->
<%-- </c:if> --%>

<ul>
  <li><a href='listAllArticle_message_report.jsp'>List</a> all Article_message_reports.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="article_message_report.do" >
        <b>輸入檢舉留言編號 (如7001):</b>
        <input type="text" name="art_msg_rpt" value="${param.art_msg_rpt}"><font color=red>${errorMsgs.art_msg_rpt}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="article_message_report_Svc" scope="page" class="com.article_message_report.model.Article_message_report_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="article_message_report.do" >
       <b>選擇檢舉留言編號:</b>
       <select size="1" name="art_msg_rpt">
         <c:forEach var="article_message_report_VO" items="${empSvc.all}" > 
          <option value="${article_message_report_VO.art_msg_rpt}">${article_message_report_VO.art_msg_rpt}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="article_message_report.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="art_msg_rpt">
         <c:forEach var="article_message_report_VO" items="${article_message_report_Svc.all}" > 
          <option value="${article_message_report_VO.art_msg_rpt}">${article_message_report_VO.mem_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addArticle_message_report.jsp'>Add</a> a new Article_message_report.</li>
</ul>

</body>
</html>