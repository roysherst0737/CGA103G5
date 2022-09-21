var couponStatus = document.getElementById("status_value");

window.onload=function(){
	if(couponStatus.value == 0){
		$("#couponRadios1").attr("checked",true)
		$("#couponRadios2").attr("checked",)
	}else if(couponStatus.value == 1){
	$("#couponRadios1").attr("checked",)
		$("#couponRadios2").attr("checked",true)
	}
}