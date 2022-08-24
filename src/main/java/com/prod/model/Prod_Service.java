package com.prod.model;

import java.sql.Timestamp;
import java.util.List;

public class Prod_Service {
	
	private Prod_DAO_interface dao;
	
	public Prod_Service() {
		dao = new Prod_DAO();
	}
	
	public Prod_VO addProd(String prod_type, String prod_name, Integer prod_price, Integer prod_status, Timestamp off_time, Integer prod_stock, String prod_detail) {
		
		Prod_VO prodVO = new Prod_VO();
		
		prodVO.setProd_type(prod_type);
		prodVO.setProd_name(prod_name);
		prodVO.setProd_price(prod_price);
		prodVO.setProd_status(prod_status);
		prodVO.setOff_time(off_time);
		prodVO.setProd_stock(prod_stock);
		prodVO.setProd_detail(prod_detail);
		dao.insert(prodVO);
		
		return prodVO;
	}
	
	public Prod_VO updateProd(Integer prod_no, String prod_type, String prod_name, Integer prod_price, Integer prod_status, Timestamp launch_time, Timestamp off_time, Integer prod_stock, String prod_detail) {
		
		Prod_VO prodVO = new Prod_VO();
		
		prodVO.setProd_no(prod_no);
		prodVO.setProd_type(prod_type);
		prodVO.setProd_name(prod_name);
		prodVO.setProd_price(prod_price);
		prodVO.setProd_status(prod_status);
		prodVO.setLaunch_time(launch_time);
		prodVO.setOff_time(off_time);
		prodVO.setProd_stock(prod_stock);
		prodVO.setProd_detail(prod_detail);
		dao.update(prodVO);
		
		return prodVO;
	}
	
	public void deleteProd(Integer prod_no) {
		dao.delete(prod_no);
	}
	
	public Prod_VO getOneProd(Integer prod_no) {
		return dao.findByPrimaryKey(prod_no);
	}
	
	public List<Prod_VO> getAll() {
		return dao.getAll();
	}
}