package com.pub_rank.model.model;

import java.util.List;

import com.pub.service.CoreDao;
import com.pub_rank.entity.Pub_Rank;

public interface Pub_Rank_DAO extends CoreDao<Pub_Rank, Integer>{
	List<Pub_Rank> selectAllByPub_no(Integer pub_no);
}
