const mem_p = document.querySelector('#mem_p');
const btn = document.querySelector('#btn');
const pub_name = document.querySelector('#fpub_name');
const pub_nop = document.querySelector('#fpub_nop');
const pub_address = document.querySelector('#fpub_address');
const pub_lng = document.querySelector('#fpub_lng');
const pub_lat = document.querySelector('#fpub_lat');
const pub_img = document.querySelector('#pub_img');
const pub_detail = document.querySelector('#fpub_detail');
const firm_name = document.querySelector('#firm_name');
const firm_addr = document.querySelector('#firm_addr');
const firm_tel_no = document.querySelector('#firm_tel_no');
const firm_email = document.querySelector('#firm_email');
const firm_tax_id = document.querySelector('#firm_tax_id');
const img_set = document.querySelector('#img_set');
let file_check = false;


const week = [0, '禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
//	建立表單
for (let i = 1; i < 8; i++) {
	this['m' + i + '_div'] = document.createElement('div');
	this['div' + i] = document.querySelector('#div' + i);
	this['m' + i + '_div'].innerHTML = `
	<div class="modal fade" id="exampleModal`+ i + `" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel`+ i + `"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel`+ i + `">編輯營業時間</h5>
								<button type="button" class="close" onclick="close_dialog()"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body1 container">
								<div class="row d1">
									<div class="col-6" style="display:flex;">
										<div style="display: flex; justify-content:center;align-items: center; ">
											<label>`+ week[i] + `</label>
										</div>
										<div >
											<div class="row inside">
												<input id="open_24_`+ i + `" class="form-check-input" type="radio" name="m` + i + `"
													id="M`+ i + `all" value="24小時營業" onchange="radio(this,` + i + `)"> <label class="" for="M` + i + `all">24小時營業
												</label>
											</div>
											<div class="row inside">
												<input id="open_close_`+ i + `" class="form-check-input" type="radio" name="m` + i + `"
													id="m`+ i + `off" value="未營業" onchange="radio(this,` + i + `)"checked> <label class="" for="m` + i + `off">未營業</label>
											</div>
											<div class="row inside">
												<input id="open_self_`+ i + `" class="form-check-input" type="radio" name="m` + i + `"
													id="m`+ i + `self" value="自選" onchange="radio(this,` + i + `)"> <label class="" for="m` + i + `self">自選</label>
											</div>
										</div>
									</div>
									<div id="oc`+ i + `"class="col-6" style="padding: 10px;display:none">
									<div >
									<div style="display: flex;justify-content:space-around;"><label>開始時間</label><label>結束時間</label></div>
									<div style="display: flex;">
										<select id="open_`+ i + `"  class="form-select form-select-sm mb-0" aria-label=".form-select-lg example" style="height:30px; font-size: smaller;" onchange=select(this,` + i + `)>
										  <option value="0">00:00</option>
										  <option value="1">01:00</option>
										  <option value="2">02:00</option>
										  <option value="3">03:00</option>
										  <option value="4">04:00</option>
										  <option value="5">05:00</option>
										  <option value="6">06:00</option>
										  <option value="7">07:00</option>
										  <option value="8">08:00</option>
										  <option value="9">09:00</option>
										  <option value="10">10:00</option>
										  <option value="11">11:00</option>
										  <option value="12">12:00</option>
										  <option value="13">13:00</option>
										  <option value="14">14:00</option>
										  <option value="15">15:00</option>
										  <option value="16">16:00</option>
										  <option value="17">17:00</option>
										  <option value="18">18:00</option>
										  <option value="19">19:00</option>
										  <option value="20">20:00</option>
										  <option value="21">21:00</option>
										  <option value="22">22:00</option>
										  <option value="23">23:00</option>
										</select>
											<select id="close_`+ i + `"class="form-select form-select-sm mb-0"  aria-label=".form-select-lg example" style="margin-left: 5px; height:30px;font-size: smaller;">
										  <option disabled value="0">00:00</option>
										  <option selected="selected" value="1">01:00</option>
										  <option value="2">02:00</option>
										  <option value="3">03:00</option>
										  <option value="4">04:00</option>
										  <option value="5">05:00</option>
										  <option value="6">06:00</option>
										  <option value="7">07:00</option>
										  <option value="8">08:00</option>
										  <option value="9">09:00</option>
										  <option value="10">10:00</option>
										  <option value="11">11:00</option>
										  <option value="12">12:00</option>
										  <option value="13">13:00</option>
										  <option value="14">14:00</option>
										  <option value="15">15:00</option>
										  <option value="16">16:00</option>
										  <option value="17">17:00</option>
										  <option value="18">18:00</option>
										  <option value="19">19:00</option>
										  <option value="20">20:00</option>
										  <option value="21">21:00</option>
										  <option value="22">22:00</option>
										  <option value="23">23:00</option>
										  <option value="24">24:00</option>
										</select>
										</div>
										</div>
									</div>
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary" onclick="close_dialog()">取消</button>
								<button type="button" style="width: auto; height: auto;" class="btn btn-primary" onclick=btnCheck(`+ i + `)>確認</button>
							</div>`;

	this['div' + i].appendChild(this['m' + i + '_div'], this['div' + i].lastChild);
}


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
				mem_p.textContent = "會員編號:" + body.mem_no;
				pub_name.value = body.pub_name;
				pub_nop.value = body.pub_nop;
				pub_address.value = body.pub_address;
				pub_lng.value = body.pub_lng;
				pub_lat.value = body.pub_lat;
				pub_detail.value = body.pub_detail;
				firm_name.value = body.firm_name;
				firm_addr.value = body.firm_addr;
				firm_tel_no.value = body.firm_tel_no;
				firm_email.value = body.firm_email;
				firm_tax_id.value = body.firm_tax_id;
				img_set.src = body.pub_pics[0].pub_pic;
				const myFile = dataURLtoFile(body.pub_pics[0].pub_pic, 'pic');

				const dataTransfer = new DataTransfer();
				dataTransfer.items.add(myFile);
				pub_img.files = dataTransfer.files;
				aa(body.pub_open);

			} else {
				alert("message" + "，請聯絡資訊人員");
			}
			// btn.removeAttribute("data-toggle");
			// btn.removeAttribute("data-target");
		});
}
function dataURLtoFile(dataurl, filename) {

	var arr = dataurl.split(','),
		mime = arr[0].match(/:(.*?);/)[1],
		bstr = window.atob(arr[1]),
		n = bstr.length,
		u8arr = new Uint8Array(n);

	while (n--) {
		u8arr[n] = bstr.charCodeAt(n);
	}

	return new File([u8arr], filename, { type: mime });
}
//function getModel(i, pub_no, mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address
//	, pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id) {
$(document).ready(function() {
btn.addEventListener('click', async () => {
//	if (pub_name.value.length < 1) {
//		errormsg(pub_name, '酒吧名稱不得為空')
//		return;
//	}
//	const pub_nopLength = pub_nop.value.length;
//	if (pub_nopLength < 1 || pub_nopLength > 100) {
//		errormsg(pub_nop, '酒吧可接受預約人數須介於1~100人')
//		return;
//	}
//
//	if (pub_address.value.length < 1) {
//		errormsg(pub_address, '酒吧地址不得為空')
//		return;
//	}
//
//	if (pub_detail.value.length < 1) {
//		errormsg(pub_detail, '酒吧描述不得為空')
//		return;
//	}
//	if (firm_name.value.length < 1) {
//		errormsg(firm_name, '廠商名稱不得為空')
//		return;
//	}
//	if (firm_addr.value.length < 1) {
//		errormsg(firm_addr, '廠商地址不得為空')
//		return;
//	}
//
//	const indiaRegex = /0\d{9}/;
//	if (!indiaRegex.test(firm_tel_no.value)) {
//		errormsg(firm_tel_no, '電話格式錯誤');
//		return;
//	}
//	const emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
//
//	if (!emailRule.test(firm_email.value)) {
//		errormsg(firm_email, '廠商email格式錯誤');
//		return;
//	}
//	if (!isTax(firm_tax_id)) {
//		//            errormsg(firm_tax_id, this.msgTax)
//		return;
//	}
//	if (!file_check) {
//		document.querySelector('.file-upload-browse').focus();
//		errormsg(pub_img, '只能傳送JPG,JPEG,PNG,且不得為空');
//		return
//	}
	let img = null;
	btn.setAttribute("data-toggle", "modal");
	btn.setAttribute("data-target", "#exampleModal");
	if (pub_img.files[0]) {
		img = await convertBase64(pub_img.files[0])
		console.log(img)
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
	console.log(json)
//	fetch('PubUpdate', {
//		method: 'POST',
//		headers: {
//			'Content-Type': 'application/json',
//		},
//		body: json,
//	})
//		.then(resp => resp.json())
//		.then(body => {
//			const { successful } = body;
//			const { message } = body;
//			if (successful) {
//				document.querySelector('.modal-body').innerHTML = message + `<br>請等候管理員審核，點擊確認跳轉`
//			} else {
//				document.querySelector('.modal-body').innerHTML = message + `<br>請聯繫客服協助處理`
//			}
//			btn.removeAttribute("data-toggle");
//			btn.removeAttribute("data-target");
//		});

});});

pub_img.addEventListener('change', function (e) {
	var file_id = e.target.id;
	if ($("#" + file_id).prop("files").length) {
		setImg();
		file_check = check_multifile_logo($("#" + file_id).prop("files")[0]['name']);
	}
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
				o = o < 10 ? "0" + o : o;
				c = c < 10 ? "0" + c : c;
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
function close_dialog() {
	document.querySelectorAll('#exampleModal1, #exampleModal2, #exampleModal3, #exampleModal4, #exampleModal5, #exampleModal6, #exampleModal7').forEach(e => { e.classList.remove("show") });
	document.querySelectorAll('#exampleModal1, #exampleModal2, #exampleModal3, #exampleModal4, #exampleModal5, #exampleModal6, #exampleModal7').forEach(e => { e.style.display = "none" });
	if (document.querySelectorAll('body .modal-backdrop').length == 2) {
		document.querySelector('body >div:last-child').remove();
	}
}
function repeatStr(str, num) {
	let s = "";
	for (let i = 0; i < num; i++) {
		s += str;
	}
	return s;
}

function aa(open) {
	const m1 = open.substring(0, 1 * 24);
	const m2 = open.substring(1 * 24, 2 * 24);
	const m3 = open.substring(2 * 24, 3 * 24);
	const m4 = open.substring(3 * 24, 4 * 24);
	const m5 = open.substring(4 * 24, 5 * 24);
	const m6 = open.substring(5 * 24, 6 * 24);
	const m7 = open.substring(6 * 24, 7 * 24);
	const week = ['禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
	let a = new Array();
	var vars = {};
	for (i = 1; i < 8; i++) {
		vars['m' + i] = open.substring((i - 1) * 24, i * 24)
		getOpenTimeSetButton(vars['m' + i], i);
		//        console.log( vars['m'+i]);
	}
	function getOpenTimeSetButton(m, index) {
		if (m.indexOf(1) == -1) {
			document.querySelector('#open_close_' + index).setAttribute('checked', '');
			document.querySelector('#b' + index + '').textContent = '未營業';
		} else if (m.indexOf(0) == -1) {
			document.querySelector('#open_24_' + index).setAttribute('checked', '');
			document.querySelector('#b' + index + '').classList.remove('btn-danger');
			document.querySelector('#b' + index + '').classList.add('btn-info');
			document.querySelector('#b' + index + '').textContent = '24小時營業';

		} else {
			document.querySelector('#b' + index + '').classList.remove('btn-danger');
			document.querySelector('#b' + index + '').classList.add('btn-info');
			document.querySelector('#open_self_' + index).setAttribute('checked', '');
			document.querySelector('#oc' + index).style.display = '';
			let a = checkOpenTime(m);
			document.querySelector('#open_' + index).value = a[0];
			document.querySelector('#close_' + index).value = a[1];
			select(document.querySelector('#open_' + index), index);
			btnCheck(index);
		}
	}

	function checkOpenTime(m) {
		//		暫時不會有多時段
		let str = "";
		let check = true;
		let a1 = 0;//起時
		let b1 = 0;//末時
		lable: for (let i = 0; i < 25; i++) {
			if (check) {
				if (i == 0 && m.indexOf(1, i) == -1) {
					str = "未營業";
					break lable;
				}
				if (m.indexOf(1, i) !== -1) {
					i = m.indexOf(1, i)
				} else {
					break lable;
				}

				if (i < 10) {
					str += "0" + (i) + ":00~";
					a1 = i;
				} else {
					a1 = i;
					str += i + ":00~";
				}
				check = !check;
			} else {
				if (m.indexOf(0, i) == -1) {
					str += "24:00";
					b1 = i;
					break lable;
				} else {
					i = m.indexOf(0, i)
				}
				if (i < 10) {
					str += "0" + (i) + ":00  \\  ";
					b1 = i;
				} else {
					str += (i) + ":00  \\  ";
					b1 = i;
				}
				check = !check;
			}
		}
		//        return str.trim().lastIndexOf('\\') + 1 == str.trim().length ? str.substring(0, str.length - 5) : str;
		return [a1, b1];
	}
	//    const week = ['禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
	//        let a = new Array();
	//        var vars = {};
	//    for (i = 0; i < 7; i++) {
	//	      vars['m'+i] = open.substring(i*24, (i+1) * 24)
	//        a[i] = week[i] + ' : ' + checkOpenTime( vars['m'+i],i+1);
	////        console.log( vars['m'+i]);
	//    }
	//    return a;
}
async function setImg() {
	if (pub_img.files[0]) {
		img_set.src = await convertBase64(pub_img.files[0])
	}
}