(window.onload = function() {
	const div = document.querySelector('.mydiv');
	const week = [0, '禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
	const div_1 = document.querySelector('#div_1');
	const pub_no = document.querySelector('#pub_no');
	let nop=[];
	const today = new Date();
	const tempday = new Date();
	let longday;//選擇的日期
	let Location = 0;
	let thisWeek = today.getDay();
	thisWeek = thisWeek == 0 ? 7 : thisWeek;
	//	0 星期日
	//	1 星期一
	//	2 星期二
	//	3 星期三
	//	4 星期四
	//	5 星期五
	//	6 星期六

	//取得今天位置
	for (let y = 1; y < 5; y++) {
		for (let i = 1; i < 8; i++) {
			if (thisWeek == 0) {
				if (y == 3 && i == 7) {
					Location = -14;
				}
			} else {
				if (y == 3 && i == thisWeek) {
					Location = -7 - i
				}
			}
		}
	};
	tempday.setDate(tempday.getDate() + Location);
	let day_check = 1;
	for (let y = 1; y < 5; y++) {
		for (let i = 1; i < 8; i++) {
			const table_div = document.createElement('div');

			table_div.setAttribute("id", "day" + i);
			table_div.classList.add("myday")
			table_div.style.gridColumn = i;
			if (y == 1) {
				table_div.style.height = '33.3px';
				table_div.style.display = 'flex';
				table_div.style.justifyContent = 'center';
				table_div.style.alignItems = 'center';
				table_div.classList.add("div_title")

				table_div.textContent = week[i];

			} else {
				const span1 = document.createElement('div');
				tempday.setDate(tempday.getDate() + 1);
				span1.innerHTML = '<p>' + tempday.getDate() + '</p>';
				const btn1 = document.createElement('div');
				btn1.innerHTML = '<div style="display:none">' + tempday.getTime() + '</div><button data-toggle="modal"data-target="#exampleModalCenter" class="btn-inverse-secondary" style="border-radius: 10px;padding: 5px;">預約訂位	</button>';
				table_div.appendChild(span1, table_div.lastChild);
				if (y != 2 && !(y == 3 && thisWeek > i) && day_check < 8) {
					day_check++;
					table_div.appendChild(btn1, table_div.lastChild);
				}
			};


			if (y == 2) {
			}
			if (thisWeek == 0) {
				if (y == 3 && i == 7) {
					table_div.classList.add('today');
				}
			} else {
				if (y == 3 && i == thisWeek) {
					table_div.classList.add('today');
				}
			}


			if (i > 5) {
				table_div.classList.add('week' + i);
			}

			table_div.style.gridRow = y;
			div.appendChild(table_div, div.lastChild);

		}
	}
	//按鈕設定
	const btnlist = document.querySelectorAll('.btn-inverse-secondary');
	btnlist.forEach(e => {
		e.addEventListener('click', element => {
			 longday = element.target.parentElement.firstChild.textContent;
			let json = JSON.stringify({
				pub_no: pub_no.textContent,
				pub_reservation_date: longday,
			});

			fetch('PubGetDateforBooking', {
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
					const { pub_available } = body;
					if (successful) {

						const select = document.createElement('select');
						select.classList.add("form-select");
						select.setAttribute("aria-label", "Default select example");
						select.addEventListener('change', function() {
							const div2 = document.querySelector('#div2');
							document.querySelector('#rate_submit').style.display = '';
							div2.style.display = '';
							const ipt = document.querySelector('#ipt');
							ipt.removeAttribute('max');
							ipt.setAttribute('max',nop[select.value]);
							ipt.addEventListener('keyup',function(){
								if(this.value > nop[select.value]) {this.value = null};
							})
						});
						div_1.innerHTML = "";
						select.innerHTML = "<option selected disabled>請選擇時段</option>";
						for (i = 0; i < 24; i++) {
							let aa = pub_available.substring(3 * i, 3 * (i + 1));
							nop.push(parseInt(aa,10));
							if (aa === "000") {
								if (i < 9) {
									select.innerHTML += "<option value='" + i + "' disabled>時段:0" + i + ":00~0" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								} else if (i == 9) {
									select.innerHTML += "<option value='" + i + "' disabled>時段:0" + i + ":00~" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								} else {
									select.innerHTML += "<option value='" + i + "' disabled>時段:" + i + ":00~" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								}
							} else {
								if (i < 9) {
									select.innerHTML += "<option value='" + i + "' >時段:0" + i + ":00~0" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								} else if (i == 9) {
									select.innerHTML += "<option value='" + i + "' >時段:0" + i + ":00~" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								} else {
									select.innerHTML += "<option value='" + i + "' >時段:" + i + ":00~" + (i + 1) + ":00  &emsp;&emsp;&emsp;&emsp;&emsp;剩餘人數:" + aa + "</option>";
								}
							}
						}
						const div2 = document.createElement("div");
						div2.classList.add('div2');
						div2.setAttribute("id", "div2");
						div2.style.display = 'none';
						document.querySelector('#rate_submit').style.display = 'none';
						div2.innerHTML = `<label for='ipt'>預約人數:</label><input id='ipt' type='number'><p id="p_check"style="display:none;color:red">請輸入預約人數</p>`;
						div_1.appendChild(select, div_1.lastChild);
						div_1.appendChild(div2, div_1.lastChild);
					} else {
					}
				});

		})
	})

	//送出預定
	document.querySelector('#rate_submit').addEventListener('click', function() {
		const ipt = document.querySelector('#ipt');
		if(ipt.value===""){
			document.querySelector('#p_check').style.display="";
			ipt.focus();
			ipt.addEventListener('change',function(){
				document.querySelector('#p_check').style.display="none";
			});
			return;
		};
		let str = "";
		const select = document.querySelector('.form-select');
		str="000".repeat(select.value);
		str+=ipt.value<10?"00"+ipt.value:ipt.value<100?"0"+ipt.value:ipt.value;
		str=str.padEnd(72, '0');
		console.log(str);
		let json = JSON.stringify({
			mem_no:"1",
			pub_no: pub_no.textContent,
			pub_booking_date: longday,
			pub_booking_time:str,
		});
		fetch('Booking', {
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
				const { pub_available } = body;
				if(successful){
					alert("訂位成功")
					location.reload();
					
					
				}else{
					alert("訂位失敗請洽客服")
					location.reload();
				}
			});
	});
});