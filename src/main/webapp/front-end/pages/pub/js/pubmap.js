(function ($) {
	$(window).on('load', function () {
		$('#rate_submit').on('click', function () {
			let pub_rate="";
			let pub_comment=document.querySelector('#mem_rate').value;
			document.querySelectorAll('.ipt_rate').forEach(e=>{
				if(e.checked){
					pub_rate= e.value;
				}
			});
			let pub_no=document.querySelector('#pub_no').textContent;
			let mem_no="1";
			
			
			let json = JSON.stringify({
			pub_rate: pub_rate,
			pub_comment: pub_comment,
			pub_no: pub_no,
			mem_no: mem_no,
		});
		console.log(json)
		fetch('PubRate', {
			method: 'POST',
			headers: {
				'Content-Type': 'application/json',
			},
			body: json,
		}).then(resp => resp.json())
			.then(body => {
				const { successful } = body;
				const { message } = body;
				if (successful) {
					alert(message)
				} else {
					alert(message + "請聯繫管理員協助處理")
				}
			});
		})
	});
	//	設定按鈕
	$('.mybtn').on('click', function (e) {
		let msg = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes[5];
		document.querySelector('#exampleModalLongTitle').textContent = getDataById(msg, 'pub_name');
		document.querySelector('#pub_no').textContent = getDataById(msg, 'pub_no');
		document.querySelector('#mydetail').textContent = getDataById(msg, 'pub_detail');
		document.querySelector('#myimg').src = e.target.parentElement.parentElement.parentElement.parentElement.parentElement.childNodes[3].src;
	});

	$('.ipt_rate').on('change',function(e){
				let path ="";
			document.querySelectorAll('.img_rate').forEach((img,index)=>{
				if(index==0){path=img.src}
				if((index+1)>e.target.value){
					console.log('t')
					img.src=path.replace('str_yes.svg','str_no.svg')
				}else{
					img.src=path.replace('str_no.svg','str_yes.svg')
				}
		})
	})
	function getDataById(msg, e) {
		return msg.getElementsByClassName(e)[0].textContent;
	}
}(jQuery));