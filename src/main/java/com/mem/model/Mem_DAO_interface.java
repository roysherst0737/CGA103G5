package com.mem.model;

import java.util.List;

public interface Mem_DAO_interface {
    public void insert(Mem_VO memVO);
    public void update(Mem_VO memVO);
    public void delete(Integer mem_no);
    public Mem_VO findByPrimaryKey(Integer mem_no);
    public List<Mem_VO> getAll();
<<<<<<< HEAD
    //�U�νƦX�d��(�ǤJ�Ѽƫ��AMap)(�^�� List)
=======
    public Mem_VO login(String mem_account,String mem_password);
    
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
>>>>>>> origin/David_hsin
//  public List<EmpVO> getAll(Map<String, String[]> map); 
}
