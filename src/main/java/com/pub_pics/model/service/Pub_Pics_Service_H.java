package com.pub_pics.model.service;

import java.util.List;

import com.pub.model.Pub_pics;
import com.pub.service.CoreService;

public interface Pub_Pics_Service_H extends CoreService{
	Pub_pics inserPics(Pub_pics pub_pics) ;
	Pub_pics update(Pub_pics pub_pics) ;
	Pub_pics findByPrimaryKey(Pub_pics pub_pics) ;
	List<Pub_pics> getAll();

}
