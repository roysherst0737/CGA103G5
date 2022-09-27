var permission = document.getElementById("permission_value");
var gender = document.getElementById("gender_value");
console.log(gender);
console.log(permission);

window.onload=function(){
	permission_value();
	gender_value();
}

function permission_value(){
	if(permission.value == 0){
		$("#permissionRadios0").attr("checked",true)
		$("#permissionRadios1").attr("checked",)
	}else if(permission.value == 1){
		$("#permissionRadios0").attr("checked",)
		$("#permissionRadios1").attr("checked",true)
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
	}else {
		$("#genderRadios0").attr("checked",)
		$("#genderRadios1").attr("checked",)	
		$("#genderRadios2").attr("checked")	
		}
}

