package com.coupon.model;

import java.util.List;

public interface Coupon_DAO_interface {
    public void insert(Coupon_VO couponVO);
    public void update(Coupon_VO couponVO);
    public void delete(Integer coupon_no);
    public Coupon_VO findByPrimaryKey(Integer coupon_no);
    public List<Coupon_VO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
    
    public Coupon_VO getCouponDiscount(String coupon_code);
}