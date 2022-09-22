(window.onload = function () {
	const div = document.querySelector('.mydiv');
	const week = ['禮拜日', '禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
	const div_1 = document.querySelector('#div_1');
	const pub_no = document.querySelector('#pub_no');
	let nop = [];
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

	document.querySelectorAll('.day').forEach((e, index) => {
		e.textContent = tempday.getDate();
		e.classList.add("day_"+tempday.getDate());
		document.querySelector('#day_title' + (index + 1)).textContent = week[tempday.getDay()]
		tempday.setDate(tempday.getDate() + 1);
	})
	let id = "";
	let json = JSON.stringify({
		pub_no: pub_no.textContent,
	});
	fetch('getBookingByPub', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json',
		},
		body: json,
	})
		.then(resp => resp.json())
		.then(body => {
			body.forEach((e, index) => {
				const div=document.querySelector('.day_'+e.pub_booking_date.split("-")[2]).parentElement.parentElement;
				const div2=document.createElement('div');
				div2.classList.add("booking_div");
				div2.innerHTML=`<div class="mem`+e.mem_no+`"></div><div>`+getDate(e.pub_booking_time)+`</div>`;
				div.appendChild(div2,div.listChild);
				if (index == 0) {
					id += e.mem_no;
				} else {
					id += "," + e.mem_no;
				}
			})

			fetch('getNameByMem', {
				method: 'POST',
				headers: {
					'Content-Type': 'application/json',
				},
				body: id,
			}).then(resp => resp.json())
				.then(body => {
					body.forEach(e=>{
						document.querySelectorAll('.mem'+e.split("-")[0]).forEach(
							e1=>{
								e1.textContent=e.split("-")[1];
						});
					});
				})
		});
		function getDate(m) {
			//		暫時不會有多時段
			let str = "";
			let check =false;
			let total="";
			for (i = 0; i < 24; i++) {
				let aa = m.substring(3 * i, 3 * (i + 1));
				if (aa === "000"&&check) {
					if (i < 9) {
						str+="0"+i+":00";
					} else {
						str+=i+":00";
					}
					break;
				} else if(aa!=="000"){
					if (i < 9) {
						str+="0"+i+":00~";
						check=!check;
						total=aa;
					} else {
						str+=i+":00~";
						check=!check;
						total=aa;
					}
				}
				if(i==23){
					str+="24:00"
				}
			}
			str+="人數:"+total  + "  人";
			return str;
		}

	//寫入營業時間
	setDivData(document.querySelector('#open'));
	function setDivData(opendiv) {
		str = "";
		const week = aa(opendiv.textContent);
		const date = ['禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];

		week.forEach(e => {
			if (e.includes('未營業')) {

				//				const btn= document.querySelector('.btn_day'+(date.indexOf(e.substring(0,3))+1));
				//				btn.removeAttribute("data-target");
				//				btn.removeAttribute("data-toggle");
				//				btn.textContent="未營業";
			}
			str += "<div class='col align-self-center '>" + e + "</div>"
		});
		opendiv.innerHTML = str;
	}
});