package com.pub_rank.service;

import java.util.List;

import com.pub.service.CoreService;
import com.pub_rank.entity.Pub_Rank;

public interface Pub_Rank_Service extends CoreService{
	Pub_Rank setRate(Pub_Rank pub_Rank);
	List<Pub_Rank> getAll();
}
