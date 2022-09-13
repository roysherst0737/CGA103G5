<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.manager.model.*"%>

<%
  Manager_VO manager_VO = (Manager_VO) request.getAttribute("manager_VO");
%>

<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - #dailyui Day 1. Sign Up Login page</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/back-end/manager_login/mngStyle.css">

</head>
<body>
<!-- partial:index.partial.html -->
<link href="https://fonts.googleapis.com/css?family=Lato" rel="stylesheet">

<link rel='stylesheet prefetch' href='https://fonts.googleapis.com/icon?family=Material+Icons'>
<body>
  <div class="cotn_principal">
<div class="cont_centrar">

  <div class="cont_login">
<div class="cont_info_log_sign_up">
  <!-- LOGIN -->
      <div class="col_md_login">
<div class="cont_ba_opcitiy">
        
        <h2>LOGIN</h2>  
  <p>Lorem ipsum dolor sit amet, consectetur.</p> 
  <button class="btn_login" onclick="cambiar_login()">LOGIN</button>
  </div>
  </div>
    <!-- SIGNUP -->
<div class="col_md_sign_up">
<div class="cont_ba_opcitiy">
  <h2>SIGN UP</h2>

  
  <p>Lorem ipsum dolor sit amet, consectetur.</p>

  <button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
</div>
  </div>
       </div>

    
    <div class="cont_back_info">
       <div class="cont_img_back_grey">
       <img src="https://images.unsplash.com/photo-1453831362806-3d5577f014a4?dpr=1&auto=compress,format&fit=crop&w=1199&h=812&q=80&cs=tinysrgb&crop=" alt="" />
       </div>
       
    </div>
    <!-- ÐÐ½Ð¸Ð¼Ð¸ÑÐ¾Ð²Ð°Ð½Ð½ÑÐµ LOGIN Ð¸ SIGNUP Ð¿Ð¾ÑÐ»Ðµ Ð½Ð°Ð¶Ð°ÑÐ¸Ñ Ð½Ð° ÐºÐ½Ð¾Ð¿ÐºÑ -->
    
<div class="cont_forms" >
    <div class="cont_img_back_">
       <img src="https://images.unsplash.com/photo-1453831362806-3d5577f014a4?dpr=1&auto=compress,format&fit=crop&w=1199&h=812&q=80&cs=tinysrgb&crop=" alt="" />
       </div>
 <div class="cont_form_login">
<a href="#" onclick="ocultar_login_sign_up()" ><i class="material-icons">&#xE5C4;</i></a>
   <h2>LOGIN</h2>
   <form method='post' action="<%=request.getContextPath()%>/login">
 <input type="text" name="mng_account" placeholder="Account" />
<input type="password" name="mng_password" placeholder="Password" />
<input type="hidden" name="action" value="login">
<button class="btn_login" onclick="cambiar_login()">LOGIN</button>
</form>
  </div>
  
   <div class="cont_form_sign_up">
<a href="#" onclick="ocultar_login_sign_up()"><i class="material-icons">&#xE5C4;</i></a>
     <h2>SIGN UP</h2>
     <FORM METHOD='post' ACTION="<%=request.getContextPath()%>/register" name="form1" enctype="multipart/form-data">
<input type="text" name="mng_account" placeholder="Account" /><p>
<input type="password" name="mng_password" placeholder="Password" />
<input type="password" placeholder="Confirm Password" /><p>
<input type="text" name="mng_name" placeholder="Username" /><p>
<input type="text" name="mng_phone" placeholder="Phone" />
<input type="file" name="mng_pic" placeholder="Picture" /><p>
管理員狀態: <input type="checkbox" name="mng_status" value=1 /><p>
<input type="hidden" name="mng_status" value=0>
<input type="hidden" name="action" value="register">
<button class="btn_sign_up" onclick="cambiar_sign_up()">SIGN UP</button>
</FORM>
  </div>

    </div>
    
  </div>
 </div>
</div>
  
    <script src="js/index.js"></script>

</body>
<!-- partial -->
  <script  src="<%=request.getContextPath()%>/back-end/manager_login/mngScript.js"></script>

</body>
</html>
