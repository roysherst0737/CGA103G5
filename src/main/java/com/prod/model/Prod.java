package com.prod.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.prod_pic.model.Prod_pic_Service;
import com.prod_pic.model.Prod_pic_VO;
import com.prod_type.model.Prod_type_Service;
import com.prod_type.model.Prod_type_VO;

public class Prod implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer prod_no;
	private Integer prod_type_no;
	private String prod_name;
	private Integer prod_pic_no;
	private Integer prod_price;
	private Integer prod_stock;
	private Integer prod_status;
	private Timestamp launch_time;
	private Timestamp off_time;
	private String prod_detail;

	@SuppressWarnings("unused")
	private Prod_type_VO prod_typeVO;

	@SuppressWarnings("unused")
	private Prod_pic_VO prod_picVO;
	
    public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public Integer getProd_type_no() {
		return prod_type_no;
	}
	public void setProd_type_no(Integer prod_type_no) {
		this.prod_type_no = prod_type_no;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public Integer getProd_pic_no() {
		return prod_pic_no;
	}
	public void setProd_pic_no(Integer prod_pic_no) {
		this.prod_pic_no = prod_pic_no;
	}
	public Integer getProd_price() {
		return prod_price;
	}
	public void setProd_price(Integer prod_price) {
		this.prod_price = prod_price;
	}
	public Integer getProd_stock() {
		return prod_stock;
	}
	public void setProd_stock(Integer prod_stock) {
		this.prod_stock = prod_stock;
	}
	public Integer getProd_status() {
		return prod_status;
	}
	public void setProd_status(Integer prod_status) {
		this.prod_status = prod_status;
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
	public String getProd_detail() {
		return prod_detail;
	}
	public void setProd_detail(String prod_detail) {
		this.prod_detail = prod_detail;
	}
	
	// for join prod_type from prod_type_no
	public Prod_type_VO getProd_type_VO() {
    	Prod_type_Service prod_typeSvc = new com.prod_type.model.Prod_type_Service();
    	Prod_type_VO prod_typeVO = prod_typeSvc.getOneProd_type(prod_type_no);
	    return prod_typeVO;
    }
	
	// for join prod_pic from prod_pic_no
	public Prod_pic_VO getProd_pic_VO() {
    	Prod_pic_Service prod_picSvc = new com.prod_pic.model.Prod_pic_Service();
    	Prod_pic_VO  prod_picVO = prod_picSvc.getOneProd_pic(prod_pic_no);
	    return prod_picVO;
    }

	public void setProd_type_VO(Prod_type_VO prod_typeVO) {
		this.prod_typeVO = prod_typeVO;
	}
	
	public void setProd_pic_VO(Prod_pic_VO prod_picVO) {
		this.prod_picVO = prod_picVO;
	}
}
