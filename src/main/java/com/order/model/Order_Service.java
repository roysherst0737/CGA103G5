package com.order.model;

import java.sql.Timestamp;
import java.util.List;

public class Order_Service {
	
	private Order_DAO_interface dao;
	
	public Order_Service() {
		dao = new Order_DAO();
	}
	
	public Order_VO addOrder(Integer mem_no, Integer coupon_no, Timestamp sold_time, Integer order_price_total, Integer dis_price_total, Integer order_status, Integer payment_method, Integer pickup_method, Integer shipping_fee, Integer tracking_no, String receiver_name, String receiver_address, String receiver_phone) {
		
		Order_VO orderVO = new Order_VO();
		
		orderVO.setMem_no(mem_no);
		orderVO.setCoupon_no(coupon_no);
		orderVO.setSold_time(sold_time);
		orderVO.setOrder_price_total(order_price_total);
		orderVO.setDis_price_total(dis_price_total);
		orderVO.setOrder_status(order_status);
		orderVO.setPayment_method(payment_method);
		orderVO.setPickup_method(pickup_method);
		orderVO.setShipping_fee(shipping_fee);
		orderVO.setTracking_no(tracking_no);
		orderVO.setReceiver_name(receiver_name);
		orderVO.setReceiver_address(receiver_address);
		orderVO.setReceiver_phone(receiver_phone);
		dao.insert(orderVO);
		
		return orderVO;
	}
	
	public Order_VO updateOrder(Integer order_no, Integer mem_no, Integer coupon_no, Timestamp order_time, Timestamp sold_time, Integer order_price_total, Integer dis_price_total, Integer order_status, Integer payment_method, Integer pickup_method, Integer shipping_fee, Integer tracking_no, String receiver_name, String receiver_address, String receiver_phone) {
		
		Order_VO orderVO = new Order_VO();
		
		orderVO.setOrder_no(order_no);
		orderVO.setMem_no(mem_no);
		orderVO.setCoupon_no(coupon_no);
		orderVO.setOrder_time(order_time);
		orderVO.setSold_time(sold_time);
		orderVO.setOrder_price_total(order_price_total);
		orderVO.setDis_price_total(dis_price_total);
		orderVO.setOrder_status(order_status);
		orderVO.setPayment_method(payment_method);
		orderVO.setPickup_method(pickup_method);
		orderVO.setShipping_fee(shipping_fee);
		orderVO.setTracking_no(tracking_no);
		orderVO.setReceiver_name(receiver_name);
		orderVO.setReceiver_address(receiver_address);
		orderVO.setReceiver_phone(receiver_phone);
		dao.update(orderVO);
		
		return orderVO;
	}
	
	public void deleteOrder(Integer order_no) {
		dao.delete(order_no);
	}
	
	public Order_VO getOneOrder(Integer order_no) {
		return dao.findByPrimaryKey(order_no);
	}
	
	public List<Order_VO> getAll() {
		return dao.getAll();
	}
}