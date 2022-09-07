
const body = window.document.querySelector('body');
function getModel(i, pub_no, mem_no, pub_status, pub_nop, pub_rate_sum, pub_ratetotal, pub_time, pub_application, pub_address
    , pub_open, pub_detail, pub_name, pub_lng, pub_lat, firm_name, firm_addr, firm_tel_no, firm_email, firm_tax_id) {
    this['m' + i + '_div'] = document.createElement('div');
    this['m' + i + '_div'].innerHTML = `
	<div class="modal fade" id="exampleModal`+ i + `" tabindex="-1"
					role="dialog" aria-labelledby="exampleModalLabel`+ i + `"
					aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="exampleModalLabel`+ i + `">詳細資料</h5>
								<button type="button" class="close" data-dismiss="modal"
									aria-label="Close">
									<span aria-hidden="true">&times;</span>
								</button>
							</div>
							<div class="modal-body1 container">
								<div class="row d1">
                                this is test
								</div>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-secondary"	data-dismiss="modal">取消</button>
								<button type="button" data-dismiss="modal" style="width: auto; height: auto;" class="btn btn-primary" onclick=btnCheck(`+ i + `)>確認</button>
							</div>`;

    body.appendChild(this['m' + i + '_div'], body.firstChild);

};