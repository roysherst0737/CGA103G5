package com.pub_rank.model;

import java.util.List;


public interface Pub_rank_DAO_interface {
	   public void insert(Pub_rank_VO pub_rank_VO);
	    public void update(Pub_rank_VO pub_rank_VO);
	    public void delete(Pub_rank_VO pub_rank_VO);
	    public Pub_rank_VO findByPrimaryKey(Integer pub_no,Integer mem_no);
	    public List<Pub_rank_VO> getMemAll(Integer mem_no);
	    public List<Pub_rank_VO> getPubAll(Integer pub_no);
}
