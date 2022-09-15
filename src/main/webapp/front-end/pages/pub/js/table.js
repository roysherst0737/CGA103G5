(window.onload = function () {
	const div = document.querySelector('.mydiv');
	const week = [0, '禮拜一', '禮拜二', '禮拜三', '禮拜四', '禮拜五', '禮拜六', '禮拜日'];
	const div_1 = document.querySelector('#div_1');
	const pub_no=document.querySelector('#pub_no');
	const today = new Date();
	const tempday = new Date();
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
				btn1.innerHTML = '<div style="display:none">'+tempday.getTime()+'</div><button data-toggle="modal"data-target="#exampleModalCenter" class="btn-inverse-secondary" style="border-radius: 10px;padding: 5px;">預約訂位	</button>';
				table_div.appendChild(span1, table_div.lastChild);
				if (y != 2 && !(y == 3 && thisWeek > i)) {
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
			const day = element.target.parentElement.firstChild.textContent;
			console.log(day)
			let json = JSON.stringify({
			pub_no: pub_no.textContent,
			pub_reservation_date: day,
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
				if (successful) {
					console.log(successful)
					console.log(message)
				} else {
					console.log(successful)
					console.log(message)
				}
			});

		})
	})
});