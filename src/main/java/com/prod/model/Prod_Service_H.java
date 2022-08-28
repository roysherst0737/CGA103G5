package com.prod.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import com.prod_pic.model.Prod_pic_VO;
import com.prod_type.model.Prod_type_VO;

public class Prod_Service_H {
	private Prod_DAO_H_impl dao;

	public Prod_Service_H() {
		dao = new Prod_DAO_H_impl();
	}

	public Prod addProd(Integer prod_type_no, String prod_name, Integer prod_pic_no, Integer prod_price, 
			Integer prod_stock, Timestamp off_time, String prod_detail) {
		
		Prod prod = new Prod();
		
		Prod_type_VO prod_typeVO= new Prod_type_VO();
		prod_typeVO.setProd_type_no(prod_type_no);
		prod.setProd_type_VO(prod_typeVO);

		prod.setProd_name(prod_name);
		
		Prod_pic_VO prod_picVO= new Prod_pic_VO();
		prod_picVO.setProd_pic_no(prod_pic_no);
		prod.setProd_pic_VO(prod_picVO);
		
		prod.setProd_price(prod_price);
		prod.setProd_stock(prod_stock);
		prod.setOff_time(off_time);
		prod.setProd_detail(prod_detail);

		dao.insert(prod);

		return prod;
	}

	public Prod updateProd(Integer prod_no, Integer prod_type_no, String prod_name, Integer prod_pic_no, Integer prod_price, 
			Integer prod_stock, Integer prod_status, Timestamp off_time, String prod_detail) {

		Prod prod = new Prod();
		prod.setProd_no(prod_no);
		
		Prod_type_VO prod_typeVO= new Prod_type_VO();
		prod_typeVO.setProd_type_no(prod_type_no);
		prod.setProd_type_VO(prod_typeVO);

		prod.setProd_name(prod_name);
		
		Prod_pic_VO prod_picVO= new Prod_pic_VO();
		prod_picVO.setProd_pic_no(prod_pic_no);
		prod.setProd_pic_VO(prod_picVO);
		
		prod.setProd_price(prod_price);
		prod.setProd_stock(prod_stock);
		prod.setProd_status(prod_status);
		prod.setOff_time(off_time);
		prod.setProd_detail(prod_detail);

		dao.update(prod);

		return prod;
	}

	public void deleteProd(Integer prod_no) {
		dao.deleteById(prod_no);
	}

	public Prod getOneProd(Integer prod_no) {
		return dao.selectById(prod_no);
	}

	public List<Prod> getAll() {
		return dao.getAll();
	}
	
	public List<Prod> getAll(Map<String, String[]> map) {
		return dao.getAll(map);
	}
}