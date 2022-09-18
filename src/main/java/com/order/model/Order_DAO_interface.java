package com.order.model;

import java.util.*;

import com.order_detail.model.Order_detail_VO;

public interface Order_DAO_interface {
	
	public void insert(Order_VO orderVO);
    public void update(Order_VO orderVO);
    public void delete(Integer order_no);
    public Order_VO findByPrimaryKey(Integer order_no);
    public List<Order_VO> getAll();
  //查詢某訂單的明細(一對多)(回傳 Set)
    public Set<Order_detail_VO> getOrder_detailsByOrder(Integer order_no);
    
    public Set<Integer> getCreateOrder(Integer mem_no);

}
