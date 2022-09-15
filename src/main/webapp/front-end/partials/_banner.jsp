<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="top_nav">
		<%@ include file="/front-end/partials/_mainTop.jsp" %>
</div>

<!-- Start Slider -->

<div id="slides-shop" class="cover-slides">

	<ul class="slides-container">
		<li class="text-center"><img src="images/background1.jpg" alt="">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="m-b-20">
							<strong>經典調酒產品</strong>
						</h1>
						<p class="m-b-40">輕輕鬆鬆打造屬於自己的室內小酒吧，不用出門即可Party All Night！</p>
						<p>
							<a class="btn hvr-hover" style="height: fit-content; width: fit-content;"
								href="<%=request.getContextPath()%>/front-end/prod/shop.jsp">立即購買</a>
						</p>
					</div>
				</div>
			</div>
		</li>
		<li class="text-center"><img src="./images/background3.jpg" alt="">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="m-b-20">
							<strong>展開一場品酒之旅吧!</strong>
						</h1>
						<p class="m-b-40">進入酒吧地圖，選擇自己喜歡的酒吧，徜徉於酒精的饗宴！</p>
						<p>
							<a class="btn hvr-hover" style="height: fit-content; width: fit-content;"
								href="gallery_fix.jsp">立即訂位</a>
						</p>
					</div>
				</div>
			</div>
		</li>
		<li class="text-center"><img src="./images/background5.jpg" alt="">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="m-b-20">
							<strong>好吃好玩在這裡</strong>
						</h1>
						<p class="m-b-40">各家廠商舉辦的有趣活動，不管有沒有酒精都能令人回味無窮！</p>
						<p>
							<a class="btn hvr-hover" style="height: fit-content; width: fit-content;"
								href="gallery.html">立即報名</a>
						</p>
					</div>
				</div>
			</div>
		</li>
		<li class="text-center"><img src="./images/background4.jpg" alt="">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<h1 class="m-b-20">
							<strong>快來搶好康!</strong>
						</h1>
						<p class="m-b-40">覺得我們賣太貴？快點來搶優惠券A好康！</p>
						<p>
							<a class="btn hvr-hover" style="height: fit-content; width: fit-content;"
								href="gallery.html">取得優惠</a>
						</p>
					</div>
				</div>
			</div>
		</li>
	</ul>
	<div class="slides-navigation">
		<a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a> <a href="#" class="prev"><i
				class="fa fa-angle-left" aria-hidden="true"></i></a>
	</div>
</div>

<!-- End Slider -->

<!-- 該文件需部屬較慢 -->
