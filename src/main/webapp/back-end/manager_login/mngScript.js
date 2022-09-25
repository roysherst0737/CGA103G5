function cambiar_login() {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_login";  
document.querySelector('.cont_form_login').style.display = "block";
document.querySelector('.cont_form_sign_up').style.opacity = "0";               

setTimeout(function(){  document.querySelector('.cont_form_login').style.opacity = "1"; },400);  
  
setTimeout(function(){    
document.querySelector('.cont_form_sign_up').style.display = "none";
},200);  
  }

function cambiar_sign_up(at) {
  document.querySelector('.cont_forms').className = "cont_forms cont_forms_active_sign_up";
  document.querySelector('.cont_form_sign_up').style.display = "block";
document.querySelector('.cont_form_login').style.opacity = "0";
  
setTimeout(function(){  document.querySelector('.cont_form_sign_up').style.opacity = "1";
},100);  

setTimeout(function(){   document.querySelector('.cont_form_login').style.display = "none";
},400);  


}    



function ocultar_login_sign_up() {

document.querySelector('.cont_forms').className = "cont_forms";  
document.querySelector('.cont_form_sign_up').style.opacity = "0";               
document.querySelector('.cont_form_login').style.opacity = "0"; 

setTimeout(function(){
document.querySelector('.cont_form_sign_up').style.display = "none";
document.querySelector('.cont_form_login').style.display = "none";
},500);  
  
  }
  
var submitBtn = document.querySelector(".btn_sign_up1");
var pswd1 = document.getElementById("mng_password");
var pswd2 = document.getElementById("mng_cnf_password");

function FsubmitBtn(value) {

	if(pswd1 !== "" || pswd2 !== "") {
  		if(pswd1.value!=pswd2.value) {
		alert("輸入的密碼不一致！");
		pswd2.focus();
		return false;
		}
	} else if(pswd1 === "" || pswd2 === ''){
		alert("密碼必須填寫");
		return false;
	}else {
		alert("true");
	return true;
	}
	}
	
submitBtn.addEventListener("click", FsubmitBtn);