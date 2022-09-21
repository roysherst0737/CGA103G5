<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en" >
<head>
    <meta charset="utf-8">

    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Site Metas -->
    <title>朧醴 LonelyBar【商品結帳】</title>
    <meta name="keywords" content="LonelyBar Index">
    <meta name="description" content="This is template from Theme Wagon.">
    <meta name="author" content="Theme Wagon">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="../images/favicon.ico" type="image/x-icon">
    <link rel="lonelybar-icon" href="../images/Logo2.png">
  	<link rel="stylesheet" href="./style.css">

</head>
<body>
<div class="mainscreen">
      <div class="card">
        <div class="leftside">
          <img
            src="./images/payment-icon/PaymentPage2.jpg"
            class="product"
            alt="Shoes"
          />
        </div>
        <div class="rightside">
          <form action="">
            <h1>信用卡結帳 <span style="color: red; font-size: 10px;">*非真實信用卡結帳，可隨意填寫資料</span> </h1>            
            <h2>付款資訊</h2>
            <p>持卡人姓名</p>
            <input type="text" class="inputbox" name="name" required />
            <p>信用卡卡號</p>
            <input type="number" class="inputbox" name="card_number" id="card_number" required />

            <p>信用卡種類</p>
            <select class="inputbox" name="card_type" id="card_type" required>
              <option value="">--選擇信用卡種類--</option>
              <option value="Visa">Visa</option>
              <option value="MasterCard">MasterCard</option>
              <option value="Maestro">Maestro</option>
              <option value="Cirrus">Cirrus</option>
              <option value="Skrill">Skrill</option>
            </select>
		<div class="expcvv">

            <p class="expcvv_text" style="font-size:16px;">到期日</p>
            <input type="month" class="inputbox" name="exp_date" id="exp_date" required />

            <p class="expcvv_text2" style="font-size:10px;">CVV(卡片背面末三碼)</p>
            <input type="password" class="inputbox" name="cvv" id="cvv" required />
        </div>
            <p></p>
            <button type="submit" class="button" style="font-weight:bold;">完成付款</button>
          </form>
        </div>
      </div>
    </div>
  
</body>
</html>