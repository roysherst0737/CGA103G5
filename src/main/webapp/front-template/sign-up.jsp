<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

			<!-- SEO Meta Tags -->
			<meta name="description"
				content="Tivo is a HTML landing page template built with Bootstrap to help you crate engaging presentations for SaaS apps and convert visitors into users.">
			<meta name="author" content="Inovatik">

			<!-- OG Meta Tags to improve the way the post looks when you share the page on LinkedIn, Facebook, Google+ -->
			<meta property="og:site_name" content="" />
			<!-- website name -->
			<meta property="og:site" content="" />
			<!-- website link -->
			<meta property="og:title" content="" />
			<!-- title shown in the actual shared post -->
			<meta property="og:description" content="" />
			<!-- description shown in the actual shared post -->
			<meta property="og:image" content="" />
			<!-- image link, make sure it's jpg -->
			<meta property="og:url" content="" />
			<!-- where do you want your post to link to -->
			<meta property="og:type" content="article" />

			<!-- Website Title -->
			<title>Sign Up - Tivo - SaaS App HTML Landing Page Template</title>

			<!-- Styles -->
			<link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700&display=swap&subset=latin-ext"
				rel="stylesheet">
			<link href="css/bootstrap.css" rel="stylesheet">
			<link href="css/fontawesome-all.css" rel="stylesheet">
			<link href="css/swiper.css" rel="stylesheet">
			<link href="css/magnific-popup.css" rel="stylesheet">
			<link href="css/styles.css" rel="stylesheet">

			<!-- Favicon  -->
			<link rel="icon" href="images/favicon.png">
		</head>

		<body data-spy="scroll" data-target=".fixed-top">

			<!-- Preloader -->
			<div class="spinner-wrapper">
				<div class="spinner">
					<div class="bounce1"></div>
					<div class="bounce2"></div>
					<div class="bounce3"></div>
				</div>
			</div>
			<!-- end of preloader -->


			<!-- Navigation -->
			<nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top">
				<div class="container">

					<!-- Text Logo - Use this if you don't have a graphic logo -->
					<!-- <a class="navbar-brand logo-text page-scroll" href="index.html">Tivo</a> -->

					<!-- Image Logo -->
					<a class="navbar-brand logo-image" href="index.html"><img src="images/logo.svg"
							alt="alternative"></a>

					<!-- Mobile Menu Toggle Button -->
					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-awesome fas fa-bars"></span> <span
							class="navbar-toggler-awesome fas fa-times"></span>
					</button>
					<!-- end of mobile menu toggle button -->

					<div class="collapse navbar-collapse" id="navbarsExampleDefault">
						<ul class="navbar-nav ml-auto">
							<li class="nav-item"><a class="nav-link page-scroll" href="index.html#header">HOME <span
										class="sr-only">(current)</span></a>
							</li>
							<li class="nav-item"><a class="nav-link page-scroll" href="index.html#features">FEATURES</a>
							</li>
							<li class="nav-item"><a class="nav-link page-scroll" href="index.html#details">DETAILS</a>
							</li>

							<!-- Dropdown Menu -->
							<li class="nav-item dropdown"><a class="nav-link dropdown-toggle page-scroll"
									href="index.html#video" id="navbarDropdown" role="button" aria-haspopup="true"
									aria-expanded="false">VIDEO</a>
								<div class="dropdown-menu" aria-labelledby="navbarDropdown">
									<a class="dropdown-item" href="article-details.html"><span class="item-text">ARTICLE
											DETAILS</span></a>
									<div class="dropdown-items-divide-hr"></div>
									<a class="dropdown-item" href="terms-conditions.html"><span class="item-text">TERMS
											CONDITIONS</span></a>
									<div class="dropdown-items-divide-hr"></div>
									<a class="dropdown-item" href="privacy-policy.html"><span class="item-text">PRIVACY
											POLICY</span></a>
								</div>
							</li>
							<!-- end of dropdown menu -->

							<li class="nav-item"><a class="nav-link page-scroll" href="index.html#pricing">PRICING</a>
							</li>
						</ul>
						<span class="nav-item"> <a class="btn-outline-sm" href="log-in.html">LOG IN</a>
						</span>
					</div>
				</div>
				<!-- end of container -->
			</nav>
			<!-- end of navbar -->
			<!-- end of navigation -->


			<!-- Header -->
			<header id="header" class="ex-2-header">
				<div class="container">
					<div class="row">
						<div class="col-lg-12">
							<h1>Sign Up</h1>
							<p>
								Fill out the form below to sign up for Tivo. Already signed up?
								Then just <a class="white" href="log-in.html">Log In</a>
							</p>
							<!-- Sign Up Form -->
							<div class="form-container">
								<form id="signUpForm" data-toggle="validator" data-focus="false"
									action="MemRegisterServlest" method="post">
									<div class="form-group">
										account<input type="text" class="form-control-input" id="saccount"
											name="mem_account" required> <label class="label-control"
											for="saccount"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										password<input type="text" class="form-control-input" id="spassword"
											name="mem_password" required> <label class="label-control"
											for="spassword"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										gender<input type="text" class="form-control-input" id="sgender"
											name="mem_gender" required> <label class="label-control"
											for="sgender"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										last_name<input type="text" class="form-control-input" id="slast_name"
											name="mem_last_name" required> <label class="label-control"
											for="slast_name"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										first_name<input type="text" class="form-control-input" id="sfirst_name"
											name="mem_first_name" required> <label class="label-control"
											for="sfirst_name"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										nickname<input type="text" class="form-control-input" id="snickname"
											name="mem_nickname" required> <label class="label-control"
											for="snickname"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										tel_no<input type="tel" class="form-control-input" id="stel_no"
											name="mem_tel_no" required> <label class="label-control"
											for="stel_no"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										cel_no<input type="tel" class="form-control-input" id="scel_no"
											name="mem_cel_no" required> <label class="label-control"
											for="scel_no"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										email<input type="email" class="form-control-input" id="semail" name="mem_email"
											required> <label class="label-control" for="semail"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										id<input type="text" class="form-control-input" id="sid" name="mem_id" required>
										<label class="label-control" for="sid"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										birth<input type="date" class="form-control-input" id="sbirth" name="mem_birth"
											required> <label class="label-control" for="sbirth"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										addr<input type="text" class="form-control-input" id="saddr" name="mem_addr"
											required> <label class="label-control" for="saddr"></label>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										permission<input class="form-control-input" id="type" type="text"
											list="typelist" placeholder="會員類別" name="mem_permission">
										<datalist id="typelist">
											<option>一般會員</option>
											<option>廠商會員</option>
										</datalist>
									</div>
									<div class="form-group checkbox">
										<input type="checkbox" id="sterms" value="Agreed-to-Terms" required>I agree with
										Tivo's <a href="privacy-policy.html">Privacy Policy</a> and <a
											href="terms-conditions.html">Terms Conditions</a>
										<div class="help-block with-errors"></div>
									</div>
									<div class="form-group">
										<input type="submit" class="form-control-submit-button" />SIGN
											UP
									</div>

									<input type="hidden" name="Register" value="Mem_Register">

								</form>


${errorMsgs}-----
							</div>
							<c:if test="${not empty errorMsgs}">
								<font style="color: red">請修正以下錯誤:</font>
								<ul>
									<c:forEach var="message" items="${errorMsgs}">
										<li style="color: red">${message}</li>
									</c:forEach>
								</ul>
							</c:if>
							<!-- end of form container -->
							<!-- end of sign up form -->

						</div>
						<!-- end of col -->
					</div>
					<!-- end of row -->
				</div>
				<!-- end of container -->
			</header>
			<!-- end of ex-header -->
			<!-- end of header -->


			<!-- Scripts -->
			<script src="js/jquery.min.js"></script>
			<!-- jQuery for Bootstrap's JavaScript plugins -->
			<script src="js/popper.min.js"></script>
			<!-- Popper tooltip library for Bootstrap -->
			<script src="js/bootstrap.min.js"></script>
			<!-- Bootstrap framework -->
			<script src="js/jquery.easing.min.js"></script>
			<!-- jQuery Easing for smooth scrolling between anchors -->
			<script src="js/swiper.min.js"></script>
			<!-- Swiper for image and text sliders -->
			<script src="js/jquery.magnific-popup.js"></script>
			<!-- Magnific Popup for lightboxes -->
			<script src="js/validator.min.js"></script>
			<!-- Validator.js - Bootstrap plugin that validates forms -->
			<script src="js/scripts.js"></script>
			<!-- Custom scripts -->
		</body>

		</html>