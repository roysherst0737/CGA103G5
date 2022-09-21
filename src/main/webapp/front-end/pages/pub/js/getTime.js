(function($) {
	$(window).on('load', function() {
		const time = document.querySelectorAll('#time');
		time.forEach((e, index) => {
			getOpenTimeSetDiv(e, index);
			
		});
		function getOpenTimeSetDiv(e, index) {
			if (e.textContent.indexOf(0) == -1) {
				e.textContent = "00:00~24:00"
			} else {
				let a = getDate(e.textContent);
				e.textContent = a;
			}

			



		}
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
			str+="  　　　　預約人數:"+total  + "  人";
			return str;
		}




	});
}(jQuery));