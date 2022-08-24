package com.order.model;

import java.util.*;

public interface Order_DAO_interface {
	
	public void insert(Order_VO orderVO);
    public void update(Order_VO orderVO);
    public void delete(Integer order_no);
    public Order_VO findByPrimaryKey(Integer order_no);
    public List<Order_VO> getAll();

}
