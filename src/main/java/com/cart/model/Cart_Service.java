package com.cart.model;

import java.util.List;
import java.util.Set;

public class Cart_Service {
	
	private Cart_DAO_interface dao;
	
	public Cart_Service() {
		dao = new Cart_DAO();
	}
	
	// 用會員編號取得購物車中所有的商品編號	
	Boolean check=false; // false:商品不存在，true:商品存在
	public Cart_VO addCart(Integer mem_no, Integer prod_no, Integer prod_qty) {
		
		//判斷若購物車裡面有同樣商品，再加入一次購物車就會增加商品數量
		Set<Integer> oldCart= dao.getAdd_to_Cart(mem_no);
		oldCart.forEach(e -> {
			if (e == prod_no ) {
				check = true;				
			}
		});
		
		Cart_VO cartVO = new Cart_VO();		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		if(check) {			
			cartVO = dao.selectByMem_noAndProd_no(mem_no, prod_no);
			cartVO.setProd_qty(cartVO.getProd_qty() + 1);
			dao.update(cartVO);
			
		}else {
			dao.insert(cartVO);
		}
		
		return cartVO;
	}
	
	// 用會員編號取得購物車中所有的商品編號	
	Boolean check2=false; // false:商品不存在，true:商品存在
	public Cart_VO minusCart(Integer mem_no, Integer prod_no, Integer prod_qty) {
		
		//判斷若購物車裡面有同樣商品，再加入一次購物車就會增加商品數量
		Set<Integer> oldCart= dao.getCart_Minus(mem_no);
		oldCart.forEach(e -> {
			if (e == prod_no ) {
				check2 = true;				
			}
		});
		
		Cart_VO cartVO = new Cart_VO();		
		cartVO.setMem_no(mem_no);
		cartVO.setProd_no(prod_no);
		cartVO.setProd_qty(prod_qty);
		if(check2) {			
			cartVO = dao.selectByMem_noAndProd_no(mem_no, prod_no);
			cartVO.setProd_qty(cartVO.getProd_qty() - 1);
			dao.update(cartVO);			
		}else if (cartVO.getProd_qty() == 1){
			cartVO = dao.selectByMem_noAndProd_no(mem_no, prod_no);
			cartVO.setProd_qty(1);
			}else {
				dao.insert(cartVO);
			}		
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