package com.manager_authfunc.model;

import java.io.Serializable;

public class Manager_authfunc_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mng_authfunc_no;
	private String mng_authfunc_name;
	
	public Integer getMng_authfunc_no() {
		return mng_authfunc_no;
	}
	public void setMng_authfunc_no(Integer mng_authfunc_no) {
		this.mng_authfunc_no = mng_authfunc_no;
	}
	public String getMng_authfunc_name() {
		return mng_authfunc_name;
	}
	public void setMng_authfunc_name(String mng_authfunc_name) {
		this.mng_authfunc_name = mng_authfunc_name;
	}
	
}
