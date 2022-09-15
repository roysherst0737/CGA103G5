package com.pub_pics.dao;

import com.pub.service.CoreDao;
import com.pub_pics.entity.Pub_pics;

public interface Pub_pics_DAO_H extends CoreDao<Pub_pics, Integer> {
	Pub_pics findByPubNo(Integer pub_no);

}
