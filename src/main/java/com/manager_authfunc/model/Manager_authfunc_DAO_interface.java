package com.manager_authfunc.model;

import java.util.*;

public interface Manager_authfunc_DAO_interface {
    public void insert(Manager_authfunc_VO manager_VO);
    public void update(Manager_authfunc_VO manager_VO);
    public void delete(Integer mng_authfunc_no);
    public Manager_authfunc_VO findByPrimaryKey(Integer mng_authfunc_no);
    public List<Manager_authfunc_VO> getManager_authfuncAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<Manager_VO> getAll(Map<String, String[]> map);
}
