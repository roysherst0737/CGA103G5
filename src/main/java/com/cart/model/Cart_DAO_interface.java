package com.cart.model;

import java.util.*;

public interface Cart_DAO_interface {
	
	public void insert(Cart_VO cartVO);
    public void update(Cart_VO cartVO);
    public void deleteAll(Integer mem_no);
    public void deleteProd(Integer prod_no);
    public Cart_VO findByForeignKey(Integer mem_no);
    public List<Cart_VO> getAll();
    public Set<Integer> getAdd_to_Cart(Integer mem_no);
    
    public Cart_VO selectByMem_noAndProd_no(Integer mem_no, Integer prod_no );
}
