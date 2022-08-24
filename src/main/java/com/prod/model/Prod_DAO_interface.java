package com.prod.model;

import java.util.*;

public interface Prod_DAO_interface {
	
	public void insert(Prod_VO prodVO);
    public void update(Prod_VO prodVO);
    public void delete(Integer prod_no);
    public Prod_VO findByPrimaryKey(Integer prod_no);
    public List<Prod_VO> getAll();

}
