package com.pub_rank.model.model;

import java.util.List;

import com.pub.model.Pub;
import com.pub_rank.entity.Pub_Rank;

public class Pub_Rank_DAOImpl implements Pub_Rank_DAO{

	@Override
	public int insert(Pub_Rank pojo) {
		getSession().saveOrUpdate(pojo);
		return 1;
	}

	@Override
	public int deleteById(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Pub_Rank pojo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Pub_Rank selectById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pub_Rank> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pub_Rank> selectAllByPub_no(Integer pub_no) {
		final String sql = "FROM Pub_Rank WHERE pub_no= :pub_no";
		return getSession().createQuery(sql, Pub_Rank.class).setParameter("pub_no", pub_no).list();
	}

}
