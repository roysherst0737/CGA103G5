<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>IBM Forum: Home</title>

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
   <tr><td><h3>IBM Forum: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for IBM Forum: Home</p>

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
  <li><a href='listAllForum.jsp'>List</a> all Forums.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="forum.do" >
        <b>輸入討論區編號:</b>
        <input type="text" name="frm_no" value="${param.frm_no}"><font color=red>${errorMsgs.frm_no}</font>
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="forum_Svc" scope="page" class="com.forum.model.Forum_Service" />
   
  <li>
     <FORM METHOD="post" ACTION="forum.do" >
       <b>選擇討論區編號:</b>
       <select size="1" name="frm_no">
         <c:forEach var="forum_VO" items="${forum_Svc.all}" > 
          <option value="${forum_VO.frm_no}">${forum_VO.frm_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="forum.do" >
       <b>選擇討論區名稱:</b>
       <select size="1" name="frm_no">
         <c:forEach var="forum_VO" items="${forum_Svc.all}" > 
          <option value="${forum_VO.frm_no}">${forum_VO.frm_name_no}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>員工管理</h3>

<ul>
  <li><a href='addForum.jsp'>Add</a> a new Forum.</li>
</ul>

</body>
</html>