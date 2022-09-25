package com.order_detail.model;

import java.util.*;

public interface Order_detail_DAO_interface {
	
	public void insert(Order_detail_VO order_detailVO);
    public void update(Order_detail_VO order_detailVO);
    public void delete(Integer order_no, Integer prod_no);
    public Order_detail_VO findByPrimaryKey(Integer order_no, Integer prod_no);
    public List<Order_detail_VO> getAll();
    
}
