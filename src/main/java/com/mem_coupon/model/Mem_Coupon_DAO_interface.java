package com.mem_coupon.model;

import java.util.List;

public interface Mem_Coupon_DAO_interface {
    public void insert(Mem_Coupon_VO empVO);
    public void update(Mem_Coupon_VO empVO);
    public void delete(Integer coupon_no,Integer mem_no);
    public Mem_Coupon_VO findByPrimaryKey(Integer coupon_no,Integer mem_no);
    public List<Mem_Coupon_VO> getAll();
    public List<Mem_Coupon_VO> getOneMemCoupon(Integer mem_no);

    

//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
