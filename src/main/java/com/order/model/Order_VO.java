package com.order.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class Order_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer order_no;
	private Integer mem_no;
	private Integer coupon_no;
	private Timestamp order_time;
	private Timestamp sold_time;
	private Integer order_price_total;
	private Integer dis_price_total;
	private Integer order_status;
	private Integer payment_method;
	private Integer pickup_method;
	private Integer shipping_fee;
	private Integer tracking_no;
	private String receiver_name;
	private String receiver_address;
	private String receiver_phone;
	
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(Integer coupon_no) {
		this.coupon_no = coupon_no;
	}
	public Timestamp getOrder_time() {
		return order_time;
	}
	public void setOrder_time(Timestamp order_time) {
		this.order_time = order_time;
	}
	public Timestamp getSold_time() {
		return sold_time;
	}
	public void setSold_time(Timestamp sold_time) {
		this.sold_time = sold_time;
	}
	public Integer getOrder_price_total() {
		return order_price_total;
	}
	public void setOrder_price_total(Integer order_price_total) {
		this.order_price_total = order_price_total;
	}
	public Integer getDis_price_total() {
		return dis_price_total;
	}
	public void setDis_price_total(Integer dis_price_total) {
		this.dis_price_total = dis_price_total;
	}
	public Integer getOrder_status() {
		return order_status;
	}
	public void setOrder_status(Integer order_status) {
		this.order_status = order_status;
	}
	public Integer getPayment_method() {
		return payment_method;
	}
	public void setPayment_method(Integer payment_method) {
		this.payment_method = payment_method;
	}
	public Integer getPickup_method() {
		return pickup_method;
	}
	public void setPickup_method(Integer pickup_method) {
		this.pickup_method = pickup_method;
	}
	public Integer getShipping_fee() {
		return shipping_fee;
	}
	public void setShipping_fee(Integer shipping_fee) {
		this.shipping_fee = shipping_fee;
	}
	public Integer getTracking_no() {
		return tracking_no;
	}
	public void setTracking_no(Integer tracking_no) {
		this.tracking_no = tracking_no;
	}
	public String getReceiver_name() {
		return receiver_name;
	}
	public void setReceiver_name(String receiver_name) {
		this.receiver_name = receiver_name;
	}
	public String getReceiver_address() {
		return receiver_address;
	}
	public void setReceiver_address(String receiver_address) {
		this.receiver_address = receiver_address;
	}
	public String getReceiver_phone() {
		return receiver_phone;
	}
	public void setReceiver_phone(String receiver_phone) {
		this.receiver_phone = receiver_phone;
	}
}