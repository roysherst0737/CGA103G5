package com.pub.model;

import java.util.List;

import com.pub.entity.Pub;
import com.pub.service.CoreService;

public interface pub_Service_H extends CoreService{

	Pub register(Pub pub) ;
	Pub update(Pub pub) ;
	Pub updateRate(Pub pub) ;
	Pub updateOpen(Pub pub) ;
	Pub updateApplication(Pub pub) ;
	Pub findByPrimaryKey(Pub pub) ;
	List<Pub> getMemALL(Integer mem_no);
	List<Pub> getAll();
	List<Pub> check (Integer state);//(2:審核失敗1:審核通過0:待審核)

}
