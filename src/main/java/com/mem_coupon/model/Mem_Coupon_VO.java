package com.mem_coupon.model;

public class Mem_Coupon_VO implements java.io.Serializable{
	private Integer coupon_no ;
	private Integer mem_no;
	private Integer remain_amount;
	
	
	public Integer getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(Integer coupon_no) {
		this.coupon_no = coupon_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getRemain_amount() {
		return remain_amount;
	}
	public void setRemain_amount(Integer remain_amount) {
		this.remain_amount = remain_amount;
	}
	
	
}
