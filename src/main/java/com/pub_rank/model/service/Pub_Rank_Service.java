package com.pub_rank.model.service;

import java.util.List;

import com.pub.model.Pub_Rank;
import com.pub.service.CoreService;

public interface Pub_Rank_Service extends CoreService{
	Pub_Rank setRate(Pub_Rank pub_Rank);
	List<Pub_Rank> getAll();
}
