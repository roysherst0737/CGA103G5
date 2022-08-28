package com.mem.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Mem_VO implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer mem_no; 
	private String mem_account; 
	private String mem_password;
	private Integer mem_gender; 
	private String mem_last_name; 
	private String mem_first_name; 
	private String mem_nickname; 
	private String mem_tel_no; 
	private String mem_cel_no; 
	private String mem_email; 
	private String mem_id; 
	private Date mem_birth; 
	private String mem_addr; 
	private Integer mem_permission; 
	private Integer status; 
	private Timestamp mem_build_time; 
	private Integer mem_cert_status;
	
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	public String getMem_account() {
		return mem_account;
	}
	public void setMem_account(String mem_account) {
		this.mem_account = mem_account;
	}
	public String getMem_password() {
		return mem_password;
	}
	public void setMem_password(String mem_password) {
		this.mem_password = mem_password;
	}
	public Integer getMem_gender() {
		return mem_gender;
	}
	public void setMem_gender(Integer mem_gender) {
		this.mem_gender = mem_gender;
	}
	public String getMem_last_name() {
		return mem_last_name;
	}
	public void setMem_last_name(String mem_last_name) {
		this.mem_last_name = mem_last_name;
	}
	public String getMem_first_name() {
		return mem_first_name;
	}
	public void setMem_first_name(String mem_first_name) {
		this.mem_first_name = mem_first_name;
	}
	public String getMem_nickname() {
		return mem_nickname;
	}
	public void setMem_nickname(String mem_nickname) {
		this.mem_nickname = mem_nickname;
	}
	public String getMem_tel_no() {
		return mem_tel_no;
	}
	public void setMem_tel_no(String mem_tel_no) {
		this.mem_tel_no = mem_tel_no;
	}
	public String getMem_cel_no() {
		return mem_cel_no;
	}
	public void setMem_cel_no(String mem_cel_no) {
		this.mem_cel_no = mem_cel_no;
	}
	public String getMem_email() {
		return mem_email;
	}
	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public Date getMem_birth() {
		return mem_birth;
	}
	public void setMem_birth(Date mem_birth) {
		this.mem_birth = mem_birth;
	}
	public String getMem_addr() {
		return mem_addr;
	}
	public void setMem_addr(String mem_addr) {
		this.mem_addr = mem_addr;
	}
	public Integer getMem_permission() {
		return mem_permission;
	}
	public void setMem_permission(Integer mem_permission) {
		this.mem_permission = mem_permission;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Timestamp getMem_build_time() {
		return mem_build_time;
	}
	public void setMem_build_time(Timestamp mem_build_time) {
		this.mem_build_time = mem_build_time;
	}
	public Integer getMem_cert_status() {
		return mem_cert_status;
	}
	public void setMem_cert_status(Integer mem_cert_status) {
		this.mem_cert_status = mem_cert_status;
	}
	
	
}
