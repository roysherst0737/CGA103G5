package com.manager_auth.model;

import java.io.Serializable;


public class Manager_auth_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mng_no;
	private Integer mng_authfunc_no;
	
	public Integer getMng_no() {
		return mng_no;
	}
	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}
	public Integer getMng_authfunc_no() {
		return mng_authfunc_no;
	}
	public void setMng_authfunc_no(Integer mng_authfunc_no) {
		this.mng_authfunc_no = mng_authfunc_no;
	}

}
