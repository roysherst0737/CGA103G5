package com.cart.model;

import java.util.*;

public interface Cart_DAO_interface {
	
	public void insert(Cart_VO cartVO);
    public void update(Cart_VO cartVO);
    public void delete(Integer mem_no);
    public Cart_VO findByForeignKey(Integer mem_no);
    public List<Cart_VO> getAll();

}
