package com.prod_type.model;

import java.io.Serializable;

public class Prod_type_VO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer prod_type_no;
	private String prod_type_name;
	
	public Integer getProd_type_no() {
		return prod_type_no;
	}
	public void setProd_type_no(Integer prod_type_no) {
		this.prod_type_no = prod_type_no;
	}
	public String getProd_type_name() {
		return prod_type_name;
	}
	public void setProd_type_name(String prod_type_name) {
		this.prod_type_name = prod_type_name;
	}
}