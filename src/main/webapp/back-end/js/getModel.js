function getdate(pub_no) {
	let json = JSON.stringify({
		pub_no: pub_no,
	});

	fetch('PubEdit', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: json,
	})
		.then(resp => resp.json())
		.then(body => {
			const { successful } = body;
			const { message } = body;
			if (successful) {
				alert("work");
				//				document.querySelector('.modal-body').innerHTML = message + `<br>請等候管理員審核，點擊確認跳轉`
			} else {
				alert("fail");
				//				document.querySelector('.modal-body').innerHTML = message + `<br>請聯繫客服協助處理`
			}
			// btn.removeAttribute("data-toggle");
			// btn.removeAttribute("data-target");
		});
}

function getModel(i, pub_no, mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address
	, pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id) {
	if (pub_name.value.length < 1) {
		errormsg(pub_name, '酒吧名稱不得為空')
		return;
	}
	const pub_nopLength = pub_nop.value.length;
	if (pub_nopLength < 1 || pub_nopLength > 100) {
		errormsg(pub_nop, '酒吧可接受預約人數須介於1~100人')
		return;
	}

	if (pub_address.value.length < 1) {
		errormsg(pub_address, '酒吧地址不得為空')
		return;
	}

	if (pub_detail.value.length < 1) {
		errormsg(pub_detail, '酒吧描述不得為空')
		return;
	}
	if (firm_name.value.length < 1) {
		errormsg(firm_name, '廠商名稱不得為空')
		return;
	}
	if (firm_addr.value.length < 1) {
		errormsg(firm_addr, '廠商地址不得為空')
		return;
	}

	const indiaRegex = /0\d{9}/;
	if (!indiaRegex.test(firm_tel_no.value)) {
		errormsg(firm_tel_no, '電話格式錯誤');
		return;
	}
	const emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;

	if (!emailRule.test(firm_email.value)) {
		errormsg(firm_email, '廠商email格式錯誤');
		return;
	}
	if (!isTax(firm_tax_id)) {
		//            errormsg(firm_tax_id, this.msgTax)
		return;
	}
	if (!window.file_check) {
		document.querySelector('.file-upload-browse').focus();
		errormsg(pub_img, '只能傳送JPG,JPEG,PNG,且不得為空');
		return
	}
	let img = null;
	btn.setAttribute("data-toggle", "modal");
	btn.setAttribute("data-target", "#exampleModal");
	if (pub_img.files[0]) {
		img = convertBase64(pub_img.files[0])
	}
	let json = JSON.stringify({
		pub_name: pub_name.value,
		pub_nop: pub_nop.value,
		pub_address: pub_address.value,
		pub_lng: pub_lng.value,
		pub_lat: pub_lat.value,
		pub_open: getOpenTime(),
		img: img,
		pub_detail: pub_detail.value,
		firm_name: firm_name.value,
		firm_addr: firm_addr.value,
		firm_tel_no: firm_tel_no.value,
		firm_email: firm_email.value,
		firm_tax_id: firm_tax_id.value,
	});

	fetch('PubRegister', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: json,
	})
		.then(resp => resp.json())
		.then(body => {
			const { successful } = body;
			const { message } = body;
			if (successful) {
				document.querySelector('.modal-body').innerHTML = message + `<br>請等候管理員審核，點擊確認跳轉`
			} else {
				document.querySelector('.modal-body').innerHTML = message + `<br>請聯繫客服協助處理`
			}
			btn.removeAttribute("data-toggle");
			btn.removeAttribute("data-target");
		});

};

pub_img.addEventListener('change', function (e) {
	var file_id = e.target.id;
	file_check = check_multifile_logo($("#" + file_id).prop("files")[0]['name']);
	//    多檔案使用
	//    for (i = 0; i < $("#" + file_id).prop("files").length; i++) {
	if (file_check) {
	} else {
		errormsg(pub_img, "只能傳送JPG,JPEG,PNG");
	}
	//    }
});


function check_multifile_logo(file) {
	var extension = file.substr((file.lastIndexOf('.') + 1))
	if (extension === 'jpg' || extension === 'jpeg' || extension === 'gif' || extension === 'png' || extension === 'bmp') {
		return true;
	} else {
		return false;
	}
}




function errormsg(e, msgtext) {
	e.classList.add('is-invalid');
	e.focus();
	e.addEventListener('change', function e1() {
		if (e == pub_img) {
			if (e.parentElement.children.length > 3) {
				e.parentElement.removeChild(e.parentElement.lastChild);
			}
		} else {
			if (e.parentElement.children.length > 1) {
				e.parentElement.removeChild(e.parentElement.lastChild);
			}

		}
		e.classList.remove('is-invalid');
		e.removeEventListener('change', e1);
	});
	const msg = document.createElement('div')
	msg.style.color = "red";
	msg.textContent = msgtext;
	if (e == pub_img) {
		if (e.parentElement.children.length > 3) {
			e.parentElement.removeChild(e.parentElement.lastChild);
		}
	} else {
		if (e.parentElement.children.length > 1) {
			e.parentElement.removeChild(e.parentElement.lastChild);
		}

	}
	e.parentElement.appendChild(msg);
}
const convertBase64 = (file) => {
	return new Promise((resolve, reject) => {
		const fileReader = new FileReader();
		fileReader.readAsDataURL(file);

		fileReader.onload = () => {
			resolve(fileReader.result);
		};

		fileReader.onerror = () => {
			reject(false);
		};
	});
};
function isTax(tax) {
	const cx = [1, 2, 1, 2, 1, 2, 4, 1];
	const cnum = tax.value.split('');
	let sum = 0;
	function cc(num) {
		let total = num;
		if (total > 9) {
			let s = total.toString();
			const n1 = s.substring(0, 1) * 1;
			const n2 = s.substring(1, 2) * 1;
			total = n1 + n2;
		}
		return total;
	}
	if (tax.value.length !== 8) {
		errormsg(tax, '統一編號錯誤需8個字')
		return false;
	}
	cnum.forEach((item, index) => {
		if (tax.value.charCodeAt() < 48 || tax.value.charCodeAt() > 57) {
			errormsg(tax, '統編錯誤，要有 8 個 0-9 數字組合')
			return false;
		}
		sum += cc(item * cx[index]);
	});
	if (sum % 10 === 0) {
		return true;
	} else if (cnum[6] === '7' && (sum + 1) % 10 === 0) {
		return true;
	} else {
		errormsg(tax, '統編錯誤')
		return false;
	}
}
function btnCheck(e) {
	const radioButtons = document.querySelectorAll('input[name="m' + e + '"]');
	document.querySelector('#b' + e + '').classList.remove('btn-danger');
	document.querySelector('#b' + e + '').classList.add('btn-info');
	for (const radioButton of radioButtons) {
		if (radioButton.checked) {
			if (radioButton.value === '自選') {
				let o = document.querySelector('#open_' + e).value;
				let c = document.querySelector('#close_' + e).value;
				document.querySelector('#b' + e).textContent = o + ":00~" + c + ":00";
			} else {
				document.querySelector('#b' + e).textContent = radioButton.value;
			}
			break;
		}
	}
}
function select(self, e) {
	let c = document.querySelector('#close_' + e);
	c.options[parseInt(self.value) + 1].setAttribute("selected", "selected");
	for (let i = 0; i < 24; i++) {

		if (i <= parseInt(self.value)) {
			c.options[i].setAttribute("disabled", '');
		} else {
			c.options[i].removeAttribute("disabled");
		}
	}
}
function radio(but, e) {
	if (but.value == "自選") {
		document.querySelector('#oc' + e).style.display = '';
	} else {
		document.querySelector('#oc' + e).style.display = "none";
	}
}
function getOpenTime() {
	let pub_open = "";
	const blist = document.querySelectorAll('#b1,#b2,#b3,#b4,#b5,#b6,#b7');
	let str1 = "";
	blist.forEach((e, index) => {
		str1 = "";
		if (e.textContent === "未設定" || e.textContent === "未營業") {
			pub_open += "000000000000000000000000";
		} else if (e.textContent === "24小時營業") {
			pub_open += "111111111111111111111111";
		} else {
			str1 += repeatStr(0, document.querySelector('#open_' + (parseInt(index) + 1)).value);
			str1 += repeatStr(1, eval(document.querySelector('#close_' + (parseInt(index) + 1)).value - document.querySelector('#open_' + (parseInt(index) + 1)).value));
			str1 += repeatStr(0, 24 - str1.length);
			pub_open += str1;
		}
	});
	return pub_open
}
function repeatStr(str, num) {
	let s = "";
	for (let i = 0; i < num; i++) {
		s += str;
	}
	return s;
}