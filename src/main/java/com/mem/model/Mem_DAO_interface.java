package com.mem.model;

import java.util.List;

public interface Mem_DAO_interface {
    public void insert(Mem_VO memVO);
    public void update(Mem_VO memVO);
    public void delete(Integer mem_no);
    public Mem_VO findByPrimaryKey(Integer mem_no);
    public List<Mem_VO> getAll();
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
