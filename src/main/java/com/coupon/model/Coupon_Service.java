package com.coupon.model;

import java.sql.Timestamp;
import java.util.List;


public class Coupon_Service  {

	private Coupon_DAO_interface dao;

	public Coupon_Service() {
		dao = new Coupon_DAO();
	}

	public Coupon_VO addEmp(String coupon_name,String coupon_code, String coupon_content
,Double coupon_discount,Integer coupon_amount , Timestamp launch_time ,Timestamp off_time 
,Timestamp coupon_build_time,Integer status) {

		Coupon_VO couponVO = new Coupon_VO();

		couponVO.setCoupon_name(coupon_name);
		couponVO.setCoupon_code(coupon_code);
		couponVO.setCoupon_content(coupon_content);
		couponVO.setCoupon_discount(coupon_discount);
		couponVO.setCoupon_amount(coupon_amount);
		couponVO.setLaunch_time(launch_time);
		couponVO.setOff_time(off_time);
		couponVO.setCoupon_build_time(coupon_build_time);
		couponVO.setStatus(status);
		
		dao.insert(couponVO);

		return couponVO;
	}

	public Coupon_VO updateEmp(String coupon_name,String coupon_code, String coupon_content
			,Double coupon_discount,Integer coupon_amount , Timestamp launch_time ,Timestamp off_time 
			,Timestamp coupon_build_time,Integer status,Integer coupon_no) {

		Coupon_VO couponVO = new Coupon_VO();
		
		couponVO.setCoupon_name(coupon_name);
		couponVO.setCoupon_code(coupon_code);
		couponVO.setCoupon_content(coupon_content);
		couponVO.setCoupon_discount(coupon_discount);
		couponVO.setCoupon_amount(coupon_amount);
		couponVO.setLaunch_time(launch_time);
		couponVO.setOff_time(off_time);
		couponVO.setCoupon_build_time(coupon_build_time);
		couponVO.setStatus(status);
		couponVO.setCoupon_no(coupon_no);
		dao.update(couponVO);

		return couponVO;
	}

	public void deleteEmp(Integer coupon_no) {
		dao.delete(coupon_no);
	}

	public Coupon_VO getOneEmp(Integer coupon_no) {
		return dao.findByPrimaryKey(coupon_no);
	}

	public List<Coupon_VO> getAll() {
		return dao.getAll();
	}
}

