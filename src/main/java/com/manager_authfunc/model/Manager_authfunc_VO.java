package com.manager_authfunc.model;

import java.io.Serializable;

import com.manager_auth.model.Manager_auth_Service;
import com.manager_auth.model.Manager_auth_VO;

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
	public Manager_auth_VO getManager_auth_VO() {
		Manager_auth_Service manager_authSvc = new Manager_auth_Service();
		Manager_auth_VO manager_auth_VO = manager_authSvc.getOneManager_auth(mng_authfunc_no);
		return manager_auth_VO;
	}
}
