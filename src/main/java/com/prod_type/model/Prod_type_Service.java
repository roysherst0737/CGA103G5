package com.prod_type.model;

import java.util.List;
import java.util.Set;

import com.prod.model.Prod_VO;

public class Prod_type_Service {
	
	private Prod_type_DAO_interface dao;
	
	public Prod_type_Service() {
		dao = new Prod_type_DAO();
	}
	
	public Prod_type_VO addProd_type(String prod_type_name) {
		
		Prod_type_VO prod_typeVO = new Prod_type_VO();
		
		prod_typeVO.setProd_type_name(prod_type_name);
		dao.insert(prod_typeVO);
		
		return prod_typeVO;
	}
	
	public Prod_type_VO updateProd_type(Integer prod_type_no, String prod_type_name) {
		
		Prod_type_VO prod_typeVO = new Prod_type_VO();
		
		prod_typeVO.setProd_type_no(prod_type_no);
		prod_typeVO.setProd_type_name(prod_type_name);
		dao.update(prod_typeVO);
		
		return dao.findByPrimaryKey(prod_type_no);
	}
	
	public void deleteProd_type(Integer prod_type_no) {
		dao.delete(prod_type_no);
	}
	
	public Prod_type_VO getOneProd_type(Integer prod_type_no) {
		return dao.findByPrimaryKey(prod_type_no);
	}
	
	public List<Prod_type_VO> getAll() {
		return dao.getAll();
	}
	
	public Set<Prod_VO>getProdsByProd_type(Integer prod_type_no) {
		return dao.getProdsByProd_type(prod_type_no);
	}
}