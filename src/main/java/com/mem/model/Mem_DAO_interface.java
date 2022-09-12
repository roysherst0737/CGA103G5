package com.mem.model;

import java.util.List;

import com.mem.model.Mem_VO;

public interface Mem_DAO_interface {
    public void insert(Mem_VO memVO);
    public void update(Mem_VO memVO);
    public void delete(Integer mem_no);
    public Mem_VO findByPrimaryKey(Integer mem_no);
    public Mem_VO findByPrimaryKey(String mem_account);
    public List<Mem_VO> getAll();
    public Mem_VO login(String mem_account,String mem_password);    
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
