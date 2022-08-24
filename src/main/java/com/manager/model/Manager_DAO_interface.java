package com.manager.model;

import java.util.*;

public interface Manager_DAO_interface {
    public void insert(Manager_VO manager_VO);
    public void update(Manager_VO manager_VO);
    public void delete(Integer mng_no);
    public Manager_VO findByPrimaryKey(Integer mng_no);
    public List<Manager_VO> getManagerAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<Manager_VO> getAll(Map<String, String[]> map);
}
