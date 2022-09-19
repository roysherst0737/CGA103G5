package com.manager.model;

import java.io.Serializable;

import com.manager_auth.model.Manager_auth_Service;
import com.manager_auth.model.Manager_auth_VO;

public class Manager_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mng_no;
	private String mng_account;
	private String mng_password;
	private String mng_name;
	private String mng_phone;
	private byte[] mng_pic;
	private Integer mng_status;
	private Integer mng_authfunc_no;
	public Integer getMng_no() {
		return mng_no;
	}
	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}
	public String getMng_account() {
		return mng_account;
	}
	public void setMng_account(String mng_account) {
		this.mng_account = mng_account;
	}
	public String getMng_password() {
		return mng_password;
	}
	public void setMng_password(String mng_password) {
		this.mng_password = mng_password;
	}
	public String getMng_name() {
		return mng_name;
	}
	public void setMng_name(String mng_name) {
		this.mng_name = mng_name;
	}
	public String getMng_phone() {
		return mng_phone;
	}
	public void setMng_phone(String mng_phone) {
		this.mng_phone = mng_phone;
	}
	public byte[] getMng_pic() {
		return mng_pic;
	}
	public void setMng_pic(byte[] mng_pic) {
		this.mng_pic = mng_pic;
	}
	public Integer getMng_status() {
		return mng_status;
	}
	public void setMng_status(Integer mng_status) {
		this.mng_status = mng_status;
	}
	public Integer getMng_authfunc_no() {
		return mng_authfunc_no;
	}
	public void setMng_authfunc_no(Integer mng_authfunc_no) {
		this.mng_authfunc_no = mng_authfunc_no;
	}
	// for join mng_authfunc_no from mng_no
    public Manager_auth_VO getManager_auth_VO() {
	    Manager_auth_Service manager_authSvc = new Manager_auth_Service();
	    Manager_auth_VO manager_auth_VO = manager_authSvc.getOneManager_auth(mng_no);
	    return manager_auth_VO;
    }
}
