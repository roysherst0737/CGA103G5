package com.mem_coupon.model;

import java.util.List;

public class Mem_Coupon_Service {
	
	private Mem_Coupon_DAO_interface dao;

	public Mem_Coupon_Service() {
		dao = new Mem_Coupon_DAO();
	}

	public Mem_Coupon_VO addCoupon(Integer coupon_no,Integer mem_no
			,Integer remain_amount) {

		Mem_Coupon_VO memCouponVO = new Mem_Coupon_VO();

		memCouponVO.setCoupon_no(coupon_no);
		memCouponVO.setMem_no(mem_no);
		memCouponVO.setRemain_amount(remain_amount);

		dao.insert(memCouponVO);

		return memCouponVO;
	}

	public Mem_Coupon_VO updateCoupon(Integer coupon_no,Integer mem_no
			,Integer remain_amount) {

		Mem_Coupon_VO memCouponVO = new Mem_Coupon_VO();

		memCouponVO.setCoupon_no(coupon_no);
		memCouponVO.setMem_no(mem_no);
		memCouponVO.setRemain_amount(remain_amount);
		dao.update(memCouponVO);

		return memCouponVO;
	}

	public void deleteCoupon(Integer coupon_no,Integer mem_no) {
		dao.delete(coupon_no,mem_no);
	}

	public Mem_Coupon_VO getOneCoupon(Integer coupon_no,Integer mem_no) {
		return dao.findByPrimaryKey(coupon_no,mem_no);
	}

	public List<Mem_Coupon_VO> getAll() {
		return dao.getAll();
	}
	public List<Mem_Coupon_VO> getOneMemCoupon(Integer mem_no) {
		return dao.getOneMemCoupon(mem_no);
	}
}
