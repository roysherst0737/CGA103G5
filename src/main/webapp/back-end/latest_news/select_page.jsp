<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Latest_news: Home</title>

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
   <tr><td><h3>IBM Latest_news: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Latest_news: Home</p>

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
  <li><a href='listAllLatest_news.jsp'>List</a> all Latest_newss.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="latest_news.do" >
        <b>輸入最新消息編號 (如7001):</b>
        <input type="text" name="latest_news_no" value="${param.latest_news_no}"><font color=red>${errorMsgs.latest_news_no}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="latest_news_Svc" scope="page" class="com.latest_news.model.Latest_news_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="latest_news.do" >
       <b>選擇最新消息編號:</b>
       <select size="1" name="latest_news_no">
         <c:forEach var="latest_news_VO" items="${latest_news_Svc.all}" > 
          <option value="${latest_news_VO.latest_news_no}">${latest_news_VO.latest_news_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="latest_news.do" >
       <b>選擇消息內容:</b>
       <select size="1" name="latest_news_no">
         <c:forEach var="latest_news_VO" items="${latest_news_Svc.all}" > 
          <option value="${latest_news_VO.latest_news_no}">${latest_news_VO.news_status}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>最新消息管理</h3>

<ul>
  <li><a href='addLatest_news.jsp'>Add</a> a new Latest_news.</li>
</ul>

</body>
</html>