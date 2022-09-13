package com.latest_news.model;

import java.util.*;

public interface Latest_news_DAO_interface{
	public void insert(Latest_news_VO latest_news_VO);
	public void update(Latest_news_VO latest_news_VO);
	public void delete(Integer latest_news_no);
	public Latest_news_VO findByPrimaryKey(Integer latest_news_no);
	public List<Latest_news_VO> getAll();
}