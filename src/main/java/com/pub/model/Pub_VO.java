package com.pub.model;

import java.io.Serializable;
import java.sql.Date;

public class Pub_VO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pub_no;
	private Integer mem_no;
	private Boolean pub_status;
	private Integer pub_nop;
	private Integer pub_rate_sum;
	private Integer pub_ratetotal;
	private Date pub_time;
	private Integer pub_application;
	private String pub_address;
	private String pub_open;
	private String pub_detail;
	private String pub_name;
	private Double pub_lng;
	private Double pub_lat;
	private String firm_name;
	private String firm_addr;
	private String firm_tel_no;
	private String firm_email;
	private String firm_tax_id;
	public Integer getPub_no() {
		return pub_no;
	}
	public void setPub_no(Integer pub_no) {
		this.pub_no = pub_no;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public Boolean getPub_status() {
		return pub_status;
	}
	public void setPub_status(Boolean pub_status) {
		this.pub_status = pub_status;
	}
	public Integer getPub_nop() {
		return pub_nop;
	}
	public void setPub_nop(Integer pub_nop) {
		this.pub_nop = pub_nop;
	}
	public Integer getPub_rate_sum() {
		return pub_rate_sum;
	}
	public void setPub_rate_sum(Integer pub_rate_sum) {
		this.pub_rate_sum = pub_rate_sum;
	}
	public Integer getPub_ratetotal() {
		return pub_ratetotal;
	}
	public void setPub_ratetotal(Integer pub_ratetotal) {
		this.pub_ratetotal = pub_ratetotal;
	}
	public Date getPub_time() {
		return pub_time;
	}
	public void setPub_time(Date pub_time) {
		this.pub_time = pub_time;
	}
	public Integer getPub_application() {
		return pub_application;
	}
	public void setPub_application(Integer pub_application) {
		this.pub_application = pub_application;
	}
	public String getPub_address() {
		return pub_address;
	}
	public void setPub_address(String pub_address) {
		this.pub_address = pub_address;
	}
	public String getPub_open() {
		return pub_open;
	}
	public void setPub_open(String pub_open) {
		this.pub_open = pub_open;
	}
	public String getPub_detail() {
		return pub_detail;
	}
	public void setPub_detail(String pub_detail) {
		this.pub_detail = pub_detail;
	}
	public String getPub_name() {
		return pub_name;
	}
	public void setPub_name(String pub_name) {
		this.pub_name = pub_name;
	}
	public Double getPub_lng() {
		return pub_lng;
	}
	public void setPub_lng(Double pub_lng) {
		this.pub_lng = pub_lng;
	}
	public Double getPub_lat() {
		return pub_lat;
	}
	public void setPub_lat(Double pub_lat) {
		this.pub_lat = pub_lat;
	}
	public String getFirm_name() {
		return firm_name;
	}
	public void setFirm_name(String firm_name) {
		this.firm_name = firm_name;
	}
	public String getFirm_addr() {
		return firm_addr;
	}
	public void setFirm_addr(String firm_addr) {
		this.firm_addr = firm_addr;
	}
	public String getFirm_tel_no() {
		return firm_tel_no;
	}
	public void setFirm_tel_no(String firm_tel_no) {
		this.firm_tel_no = firm_tel_no;
	}
	public String getFirm_email() {
		return firm_email;
	}
	public void setFirm_email(String firm_email) {
		this.firm_email = firm_email;
	}
	public String getFirm_tax_id() {
		return firm_tax_id;
	}
	public void setFirm_tax_id(String firm_tax_id) {
		this.firm_tax_id = firm_tax_id;
	}

}
