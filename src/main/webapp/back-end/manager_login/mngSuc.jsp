<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manager.model.*"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>歡迎登入 朧醴 LonelyBar</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/manager_login/mngSucStyle.css">
<script src="<%=request.getContextPath()%>/back-end/manager_login/mngSucScript.js"></script>

</head>
<body>
<!-- partial:index.partial.html -->
<div id="container">
  <div id="success-box">
    <div class="dot"></div>
    <div class="dot two"></div>
    <div class="face">
      <div class="eye"></div>
      <div class="eye right"></div>
      <div class="mouth happy"></div>
    </div>
    <div class="shadow scale"></div>
    <div class="message"><h1 class="alert">登入成功!</h1><p>開始你的管理部分</p></div>
    <a href="<%=request.getContextPath()%>/back-end/manager_login/mngLogin.jsp">
    <button class="button-box" ><h1 class="green">continue</h1></button></a>
  </div>
  

<footer>
  
</footer>
<!-- partial -->
  
</body>
</html>
