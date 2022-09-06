package com.prod.model;

import java.util.*;

import com.prod_pic.model.Prod_pic_VO;

public interface Prod_DAO_interface {
	
	public void insert(Prod_VO prodVO);
    public void update(Prod_VO prodVO);
    public void delete(Integer prod_no);
    public Prod_VO findByPrimaryKey(Integer prod_no);
    public List<Prod_VO> getAll();
    public List<Prod_VO> getAll(Map<String, String[]> map);
    public Set<Prod_pic_VO> getProd_picsByProd(Integer prod_no);
}
