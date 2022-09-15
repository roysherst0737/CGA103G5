package com.order_detail.model;

import java.io.Serializable;

public class Order_detail_VO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer order_no;
	private Integer prod_no;
	private Integer prod_qty;
	private Integer prod_price;
	private Integer mem_no;
	
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public Integer getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(Integer prod_qty) {
		this.prod_qty = prod_qty;
	}
	public Integer getProd_price() {
		return prod_price;
	}
	public void setProd_price(Integer prod_price) {
		this.prod_price = prod_price;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
}
