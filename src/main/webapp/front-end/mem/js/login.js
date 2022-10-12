function check() {
			var form = document.getElementById('form'); // 獲得form表單的id
			var mem_account = form.mem_account.value.replace(/(^\s*)|(\s*$)/g, ""); // 過濾user左右的空格
			var mem_password = form.mem_password.value.replace(/(^\s*)|(\s*$)/g, ""); // 過濾pwd左右的空格
			document.getElementById("result").innerHTML = "";
			document.getElementById("account").innerHTML = "";
			if (mem_account.length == 0 && mem_password.length == 0) {
				document.getElementById("result").innerHTML="帳號和密碼都不能為空";
				return false; // 返回假
			}else if (mem_account.length == 0) { // 獲得id=form的name=mem_account的value的長度
				document.getElementById("account").innerHTML="帳號不能為空";
				return false; // 返回假
			}else if (mem_password.length == 0) { // 獲得id=form的name=mem_password的value的長度
				document.getElementById("result").innerHTML="密碼不能為空";
				return false; // 返回假
			}else{
				document.getElementById("result").innerHTML="提交成功";
				return true; // 返回真
			}
		}