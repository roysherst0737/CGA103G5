package com.order_detail.model;

import java.io.Serializable;

import com.prod.model.Prod_Service;
import com.prod.model.Prod_VO;
import com.prod_pic.model.Prod_pic_Service;
import com.prod_pic.model.Prod_pic_VO;

public class Order_detail_VO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer order_no;
	private Integer prod_no;
	private Integer prod_qty;
	private Integer prod_price;
	private Integer mem_no;
	
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
	public Integer getProd_qty() {
		return prod_qty;
	}
	public void setProd_qty(Integer prod_qty) {
		this.prod_qty = prod_qty;
	}
	public Integer getProd_price() {
		return prod_price;
	}
	public void setProd_price(Integer prod_price) {
		this.prod_price = prod_price;
	}
	public Integer getMem_no() {
		return mem_no;
	}
	public void setMem_no(Integer mem_no) {
		this.mem_no = mem_no;
	}
	
	// for join prod_name from prod_no
    public Prod_VO getProd_VO() {
    	Prod_Service prodSvc = new Prod_Service();
    	Prod_VO prodVO = prodSvc.getOneProd(prod_no);
	    return prodVO;
    }
    
    // for join prod_pic from prod_no
    public Prod_pic_VO getProd_pic_VO() {
    	Prod_pic_Service prod_picSvc = new Prod_pic_Service();
		Prod_pic_VO prod_picVO = prod_picSvc.getOneProd_pic(prod_no);
	    return prod_picVO;
    }
}
