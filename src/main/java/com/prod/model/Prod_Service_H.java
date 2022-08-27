package com.prod.model;

import java.util.List;
import java.util.Map;

import com.pub.service.CoreService;

public interface Prod_Service_H extends CoreService {
	
	Prod insert(Prod prod) ;
	Prod update(Prod prod) ;
	Prod updatePic(Prod prod) ;
	Prod findByPrimaryKey(Prod prod) ;
	List<Prod> getAll();
	List<Prod> getAll(Map<String, String[]> map); 
}