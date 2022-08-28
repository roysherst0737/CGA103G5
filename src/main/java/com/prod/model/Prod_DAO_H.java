package com.prod.model;

import java.util.List;
import java.util.Map;

public interface Prod_DAO_H {	
	public void insert(Prod prod);
	public void deleteById(Integer prod_no);
	public void update(Prod prod);
	public Prod selectById(Integer prod_no);
	public List<Prod> getAll();
	public List<Prod> getAll(Map<String, String[]> map);
}
