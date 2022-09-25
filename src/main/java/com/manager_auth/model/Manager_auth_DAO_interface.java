package com.manager_auth.model;

import java.util.*;

public interface Manager_auth_DAO_interface {
    public void insert(Manager_auth_VO manager_auth_VO);
    public void update(Manager_auth_VO manager_auth_VO);
    public void delete(Integer mng_no, Integer mng_authfunc_no);
    public void deleteAll(Integer mng_no);
    public Manager_auth_VO findByPrimaryKey(Integer mng_no);
    public List<Manager_auth_VO> getAllManager_auth();
    public List<Manager_auth_VO> getAuthfunc(Integer mng_no);
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
  public List<Manager_auth_VO> getAllManager_auth(Map<String, String[]> map);
}