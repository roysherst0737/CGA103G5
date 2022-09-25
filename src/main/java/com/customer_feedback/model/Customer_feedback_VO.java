package com.customer_feedback.model;

import java.io.Serializable;

public class Customer_feedback_VO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer SN;
	private Integer mem_no;
	private Integer order_no;
	private Integer prod_no;
	private Integer pub_no;
	private Integer act_no;
	private Integer mng_no;
	private Integer feedback_status;
	
	public Integer getSN() {
		return SN;
	}
	public void setSN(Integer sN) {
		SN = sN;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Integer getOrder_no() {
		return order_no;
	}
	public void setOrder_no(Integer order_no) {
		this.order_no = order_no;
	}
	public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public Integer getAct_no() {
		return act_no;
	}
	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}
	public Integer getMng_no() {
		return mng_no;
	}
	public void setMng_no(Integer mng_no) {
		this.mng_no = mng_no;
	}
	public Integer getFeedback_status() {
		return feedback_status;
	}
	public void setFeedback_status(Integer feedback_status) {
		this.feedback_status = feedback_status;
	}
	
	
}
