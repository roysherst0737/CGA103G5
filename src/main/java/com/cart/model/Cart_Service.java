package com.cart.model;

import java.util.List;
import java.util.Set;

public class Cart_Service {
	
	private Cart_DAO_interface dao;
	
	public Cart_Service() {
		dao = new Cart_DAO();
	}
	
	public Cart_VO addCart(Integer mem_no, Integer prod_no, Integer prod_qty) {
		
		Cart_VO cartVO = new Cart_VO();
		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		dao.insert(cartVO);
		
		return cartVO;
	}
	
	public Cart_VO updateCart(Integer mem_no, Integer prod_no, Integer prod_qty) {
		
		Cart_VO cartVO = new Cart_VO();
		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		dao.update(cartVO);
		
		return cartVO;
	}
	
	public void deleteCartByMem(Integer mem_no) {
		dao.deleteAll(mem_no);
	}
	
	public void deleteCartByProd(Integer prod_no) {
		dao.deleteProd(prod_no);
	}
	
	public Cart_VO getOneCart(Integer mem_no) {
		return dao.findByForeignKey(mem_no);
	}
	
	public List<Cart_VO> getAll() {
		return dao.getAll();
	}
	
	public Set<Integer> getAdd_to_Cart(Integer mem_no) {
		return dao.getAdd_to_Cart(mem_no);
	}
}