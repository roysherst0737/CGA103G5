package com.push_ads.model;

import java.util.List;

public interface Push_Ads_DAO_interface{
    public void insert(Push_Ads_VO pushAdsVO);
    public void update(Push_Ads_VO pushAdsVO);
    public void delete(Integer ads_no);
    public Push_Ads_VO findByPrimaryKey(Integer ads_no);
    public List<Push_Ads_VO> getAll();
  //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}