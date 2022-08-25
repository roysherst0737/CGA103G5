package com.push_ads.model;

import oracle.sql.BLOB;

public class Push_Ads_VO implements java.io.Serializable{
	private Integer ads_no; 
	private Integer prod_no; 
	private String ads_content;
	private Integer act_no; 
	private Integer pub_no; 
	private BLOB ads_pic; 
	private Integer weights;
	
	public Integer getAds_no() {
		return ads_no;
	}
	public void setAds_no(Integer ads_no) {
		this.ads_no = ads_no;
	}
	public Integer getProd_no() {
		return prod_no;
	}
	public void setProd_no(Integer prod_no) {
		this.prod_no = prod_no;
	}
	public String getAds_content() {
		return ads_content;
	}
	public void setAds_content(String ads_content) {
		this.ads_content = ads_content;
	}
	public Integer getAct_no() {
		return act_no;
	}
	public void setAct_no(Integer act_no) {
		this.act_no = act_no;
	}
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public BLOB getAds_pic() {
		return ads_pic;
	}
	public void setAds_pic(BLOB ads_pic) {
		this.ads_pic = ads_pic;
	}
	public Integer getWeights() {
		return weights;
	}
	public void setWeights(Integer weights) {
		this.weights = weights;
	}
	
	
}
