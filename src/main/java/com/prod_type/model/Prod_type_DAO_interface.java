package com.prod_type.model;

import java.util.*;

public interface Prod_type_DAO_interface {
	
	public void insert(Prod_type_VO prod_typeVO);
    public void update(Prod_type_VO prod_typeVO);
    public void delete(Integer prod_type_no);
    public Prod_type_VO findByPrimaryKey(Integer prod_type_no);
    public List<Prod_type_VO> getAll();

}