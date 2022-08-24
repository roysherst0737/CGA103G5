package com.cart.model;

import java.io.Serializable;

public class Cart_VO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer mem_no;
	private Integer prod_no;
	private Integer prod_qty;
	
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
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
}
