package com.manager_auth.model;

import java.util.*;

public interface Manager_auth_DAO_interface {
    public void insert(Manager_auth_VO manager_auth_VO);
    public void update(Manager_auth_VO manager_auth_VO);
    public void delete(Manager_auth_VO manager_auth_VO);
    public Manager_auth_VO findByPrimaryKey(Integer mng_no,Integer mng_authfunc_no);
    public List<Manager_auth_VO> getManagerAll(Integer mng_no);
    public List<Manager_auth_VO> getManager_authfuncAll(Integer mng_authfunc_no);
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<Manager_VO> getAll(Map<String, String[]> map);
}
