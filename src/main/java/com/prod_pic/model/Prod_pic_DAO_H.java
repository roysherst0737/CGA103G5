package com.prod_pic.model;

import java.util.List;
import java.util.Map;

import com.prod_pic.service.Prod_pic_CoreDao;

public interface Prod_pic_DAO_H extends Prod_pic_CoreDao<Prod_pic, Integer> {
	public int insert(Prod_pic pojo);
	public int deleteById(Integer id);
	public int update(Prod_pic pojo);
	public Prod_pic selectById(Integer id);
	public List<Prod_pic> selectAll();
	public List<Prod_pic> getAll(Map<String, String[]> map);
}
