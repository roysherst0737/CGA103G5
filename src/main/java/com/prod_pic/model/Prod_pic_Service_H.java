package com.prod_pic.model;

import java.util.List;
import java.util.Map;

import com.prod_pic.service.Prod_pic_CoreService;

public interface Prod_pic_Service_H extends Prod_pic_CoreService {
	
	Prod_pic insert(Prod_pic prod) ;
	Prod_pic update(Prod_pic prod) ;
	Prod_pic updatePic(Prod_pic prod) ;
	Prod_pic findByPrimaryKey(Prod_pic prod) ;
	List<Prod_pic> getAll();
	List<Prod_pic> getAll(Map<String, String[]> map); 
}