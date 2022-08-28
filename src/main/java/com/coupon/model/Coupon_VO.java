package com.coupon.model;

import java.sql.Timestamp;

public class Coupon_VO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer coupon_no; 
	private String coupon_name; 
	private String coupon_code;
	private String coupon_content; 
	private Double coupon_discount; 
	private Integer coupon_amount; 
	private Timestamp launch_time; 
	private Timestamp off_time; 
	private Timestamp coupon_build_time; 
	private Integer status;
	
	public Integer getCoupon_no() {
		return coupon_no;
	}
	public void setCoupon_no(Integer coupon_no) {
		this.coupon_no = coupon_no;
	}
	public String getCoupon_name() {
		return coupon_name;
	}
	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}
	public String getCoupon_code() {
		return coupon_code;
	}
	public void setCoupon_code(String coupon_code) {
		this.coupon_code = coupon_code;
	}
	public String getCoupon_content() {
		return coupon_content;
	}
	public void setCoupon_content(String coupon_content) {
		this.coupon_content = coupon_content;
	}
	public Double getCoupon_discount() {
		return coupon_discount;
	}
	public void setCoupon_discount(Double coupon_discount) {
		this.coupon_discount = coupon_discount;
	}
	public Integer getCoupon_amount() {
		return coupon_amount;
	}
	public void setCoupon_amount(Integer coupon_amount) {
		this.coupon_amount = coupon_amount;
	}
	public Timestamp getLaunch_time() {
		return launch_time;
	}
	public void setLaunch_time(Timestamp launch_time) {
		this.launch_time = launch_time;
	}
	public Timestamp getOff_time() {
		return off_time;
	}
	public void setOff_time(Timestamp off_time) {
		this.off_time = off_time;
	}
	public Timestamp getCoupon_build_time() {
		return coupon_build_time;
	}
	public void setCoupon_build_time(Timestamp coupon_build_time) {
		this.coupon_build_time = coupon_build_time;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
