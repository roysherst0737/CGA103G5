<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- Start Main Top -->
<%String url = request.getRequestURL().toString();
 session.setAttribute("url", url);

%>
<div class="main-top">
	<div class="container-fluid">
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
				<div class="right-phone-box">
					<p>
						Call US : <a href="<%=request.getContextPath()%>/front-end/#"> +886 912 123 456</a>
					</p>
				</div>
				<div class="our-link">
					<ul>
						<li><a href="<%=request.getContextPath()%>/front-end/my-account.jsp"><i class="fa fa-user s_color"></i> 會員專區 </a></li>
						<li><a href="<%=request.getContextPath()%>/front-end/about.jsp"><i class="fas fa-location-arrow"></i>
								我們的地址 </a></li>
						<li><a href="<%=request.getContextPath()%>/front-end/contact-us.jsp"><i class="fas fa-headset"></i>
								聯絡我們 </a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
	<!-- 以下為註冊/登入-->
					<c:choose>

						<c:when test="${empty sessionScope.user}"> 
							<button type="button" class="btn btn-warning">
								<a href="<%=request.getContextPath()%>/front-end/mem/register.jsp" style="color: black">註冊</a>
							</button>
							<button type="button" class="btn btn-outline-light me-2">
								<a href="<%=request.getContextPath()%>/front-end/mem/login.jsp" style="color: white">登入</a>
							</button>
						</c:when>

						<c:otherwise> 
							<form action="MemLogoutServlet" method="post">
								<input type="button" class="btn btn-warning" value="${sessionScope.user.getMem_nickname()}" onclick="location.href='<%=request.getContextPath()%>/front-end/MemLogoutServlet'"/>
								<input type="hidden" name="Logout" value="Mem_Logout">
							</form>
						</c:otherwise>

					</c:choose>
	<!-- 以上為註冊/登入-->
				<div class="text-slid-box">
					<div id="offer-box" class="carouselTicker">
						<ul class="offer-box">
							<li><i class="fab fa-opencart"></i> 全新基酒上架 快來選購！</li>
							<li><i class="fab fa-opencart"></i> 調酒材料5~8折，不要錯過！</li>
							<li><i class="fab fa-opencart"></i> 琳瑯滿目的調酒器材8折起！</li>
							<li><i class="fab fa-opencart"></i> 世外桃源酒吧新開幕 經典調酒6折起！</li>
							<li><i class="fab fa-opencart"></i> 法國原裝進口葡萄酒 盡在商品專區</li>
							<li><i class="fab fa-opencart"></i> 室外調酒趴踢 熱烈舉行！</li>
							<li><i class="fab fa-opencart"></i> 寂寞嗎？來討論區揪團喝酒^^</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- End Main Top -->
<!-- Start Navigation -->
<header class="main-header">

	<nav class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
		<div class="container">
			<!-- Start Header Navigation -->
			<div class="navbar-header">
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbar-menu"
					aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/front-end/index.jsp"><img id="logo3" src="<%=request.getContextPath()%>/front-end/images/Logo3.png" width="200px"
						height="80px" class="logo" alt=""></a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav ml-auto" data-in="fadeInDown" data-out="fadeOutUp">
					<li class="nav-item active"><a class="nav-link" href="<%=request.getContextPath()%>/front-end/index.jsp">首頁</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/front-end/about.jsp">關於我們</a></li>
					<li class="dropdown"><a href="<%=request.getContextPath()%>/front-end/#" class="nav-link dropdown" data-toggle="dropdown"
							style="font-weight: 1000;">購物專區</a>
						<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/front-end/prod/shop.jsp" style="color: #f5c242; font-weight:bold;">商品總覽</a></li>
							<li><a href="<%=request.getContextPath()%>/front-end/prod/cart.jsp" style="color: #f5c242; font-weight:bold;">購物車</a></li>
							<li><a href="<%=request.getContextPath()%>/front-end/prod/checkout.jsp" style="color: #f5c242; font-weight:bold;">前往結帳</a></li>
						</ul>
					</li>
					<li class="nav-item dropdown"><a id="pub_map" class="nav-link"
							href="<%=request.getContextPath()%>/PubMap">酒吧地圖</a>
							<ul class="dropdown-menu">
							<li><a href="<%=request.getContextPath()%>/PubMap" style="color: #f5c242; font-weight:bold;">酒吧地圖</a></li>
							<li><a href="<%=request.getContextPath()%>/PubApplication" style="color: #f5c242; font-weight:bold;">酒吧註冊申請</a></li>
							<li><a href="<%=request.getContextPath()%>/PubStates" style="color: #f5c242; font-weight:bold;">酒吧狀態</a></li>
						</ul>
							
					</li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/front-end/act/actlist.jsp">活動專區</a></li>
					<li class="nav-item"><a class="nav-link" href="<%=request.getContextPath()%>/front-end/gallery.html">討論園地</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->

			<!-- Start Atribute Navigation -->
			<div class="attr-nav">
				<ul>
					<li class="user"><a href="<%=request.getContextPath()%>/front-end/mem/my-account.jsp"><img id="user" src="<%=request.getContextPath()%>/front-end/images/user.png"
								width="28px" height="28px" /></a></li>
					<li class="cart"><a href="<%=request.getContextPath()%>/front-end/prod/cart.jsp"><img id="shopping" src="<%=request.getContextPath()%>/front-end/images/shopping-cart.png"
								width="35px" height="35px" /></a></li>
				</ul>
			</div>
			<!-- End Atribute Navigation -->
		</div>
	</nav>
</header>
<!-- End Navigation -->


