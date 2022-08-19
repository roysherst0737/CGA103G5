package com.cart.model;

import java.sql.Timestamp;
import java.util.List;

public class Cart_Service {
	
	private Cart_DAO_interface dao;
	
	public Cart_Service() {
		dao = new Cart_DAO();
	}
	
	public Cart_VO addCart(Integer mem_no, Integer prod_no, Integer prod_qty, Timestamp add_time) {
		
		Cart_VO cartVO = new Cart_VO();
		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		cartVO.setAdd_time(add_time);		
		dao.insert(cartVO);
		
		return cartVO;
	}
	
	public Cart_VO updateCart(Integer mem_no, Integer prod_no, Integer prod_qty, Timestamp add_time) {
		
		Cart_VO cartVO = new Cart_VO();
		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		cartVO.setAdd_time(add_time);
		dao.update(cartVO);
		
		return cartVO;
	}
	
	public void deleteCart(Integer mem_no) {
		dao.delete(mem_no);
	}
	
	public Cart_VO getOneCart(Integer mem_no) {
		return dao.findByForeignKey(mem_no);
	}
	
	public List<Cart_VO> getAll() {
		return dao.getAll();
	}
}
