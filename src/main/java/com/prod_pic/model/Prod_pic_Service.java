package com.prod_pic.model;

import java.util.List;

public class Prod_pic_Service {
	
	private Prod_pic_DAO_interface dao;
	
	public Prod_pic_Service() {
		dao = new Prod_pic_DAO();
	}
	
	public Prod_pic_VO addProd_pic(Integer prod_no, byte[] prod_pic, String prod_pic_name) {
		
		Prod_pic_VO prod_picVO = new Prod_pic_VO();
		
		prod_picVO.setProd_no(prod_no);
		prod_picVO.setProd_pic(prod_pic);
		prod_picVO.setProd_pic_name(prod_pic_name);
		dao.insert(prod_picVO);
		
		return prod_picVO;
	}
	
	public Prod_pic_VO updateProd_pic(Integer prod_pic_no, Integer prod_no, byte[] prod_pic, String prod_pic_name) {
		
		Prod_pic_VO prod_picVO = new Prod_pic_VO();
		
		prod_picVO.setProd_pic_no(prod_pic_no);
		prod_picVO.setProd_no(prod_no);
		prod_picVO.setProd_pic(prod_pic);
		prod_picVO.setProd_pic_name(prod_pic_name);
		dao.update(prod_picVO);
		
		return prod_picVO;
	}
	
	public void deleteProd_pic(Integer prod_pic_no) {
		dao.delete(prod_pic_no);
	}
	
	public Prod_pic_VO getOneProd_pic(Integer prod_pic_no) {
		return dao.findByPrimaryKey(prod_pic_no);
	}
	
	public List<Prod_pic_VO> getAll() {
		return dao.getAll();
	}	
}