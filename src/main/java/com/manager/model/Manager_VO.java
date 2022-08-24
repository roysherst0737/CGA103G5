package com.manager.model;

import java.sql.Date;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Manager_VO implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	private Integer mng_no;
	private String mng_account;
	private String mng_password;
	private String mng_name;
	private String mng_phone;
	final Base64.Encoder encoder = Base64.getEncoder();
	private byte[] mng_pic;
	private Integer mng_status;
	
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
	public String getMng_pic() {
		if(mng_pic!=null) {String encodedText = encoder.encodeToString(mng_pic);
		return encodedText;}
		return null;
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
	
}
