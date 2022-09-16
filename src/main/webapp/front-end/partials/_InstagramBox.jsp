<div class="main-instagram owl-carousel owl-theme" style="padding: 0;">
	<c:forEach var="prodVO" items="${list}">
	<div class="item">
		<div class="ins-inner-box">
			
			<img src="<%=request.getContextPath()%>
			/ShowProd_picForProd?prod_no=${prodVO.getProd_pic_VO().prod_pic_no}" width=280px height=200px>
			
			<div class="hov-in">
				<a href="#"><i class="fab fa-instagram"></i></a>
			</div>				
		</div>
	</div>
	</c:forEach>
</div>
