package com.coupon.model;

import java.util.List;

public interface Coupon_DAO_interface {
    public void insert(Coupon_VO couponVO);
    public void update(Coupon_VO couponVO);
    public void delete(Integer coupon_no);
    public Coupon_VO findByPrimaryKey(Integer coupon_no);
    public List<Coupon_VO> getAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}