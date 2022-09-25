var permission = document.getElementById("permission_value");
var gender = document.getElementById("gender_value");

window.onload=function(){
	permission_value();
	gender_value();
}

function permission_value(){
	if(permission.value == 0){
		$("#permission").attr("value","一般會員")		
	}else if(permission.value == 1){
		$("#permission").attr("value","廠商會員")
	}
}

function gender_value(){
	if(gender.value == 0){
		$("#genderRadios0").attr("checked",true)
		$("#genderRadios1").attr("checked",)	
		$("#genderRadios2").attr("checked",)	
	}else if(gender.value == 1){
		$("#genderRadios0").attr("checked",)
		$("#genderRadios1").attr("checked",true)	
		$("#genderRadios2").attr("checked",)	
	}else if(gender.value == 2){
		$("#genderRadios0").attr("checked",)
		$("#genderRadios1").attr("checked",)	
		$("#genderRadios2").attr("checked",true)	
	}
}

