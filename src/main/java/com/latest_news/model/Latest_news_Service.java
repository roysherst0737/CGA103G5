package com.latest_news.model;

import java.util.List;


public class Latest_news_Service {
	private Latest_news_DAO_interface dao;

	public Latest_news_Service() {
		dao = new Latest_news_DAO();
	}

	public Latest_news_VO addLatest_news(String news_content, Integer news_status) {

		Latest_news_VO latest_news_VO = new Latest_news_VO();

//		latest_news_VO.setLatest_news_no(latest_news_no);
		latest_news_VO.setNews_content(news_content);
		latest_news_VO.setNews_status(news_status);
		dao.insert(latest_news_VO);

		return latest_news_VO;
	}

	public Latest_news_VO updateLatest_news(Integer latest_news_no, String news_content, Integer news_status) {

		Latest_news_VO latest_news_VO = new Latest_news_VO();

		latest_news_VO.setLatest_news_no(latest_news_no);
		latest_news_VO.setNews_content(news_content);
		latest_news_VO.setNews_status(news_status);
		dao.update(latest_news_VO);

		return latest_news_VO;
	}
	
//	public void updateLatest_news	(Latest_news_VO latest_news_VO) {
//		dao.update(latest_news_VO);
//	}

	public void deleteLatest_news(Integer latest_news_no) {
		dao.delete(latest_news_no);
	}

	public Latest_news_VO getOneLatest_news(Integer latest_news_no) {
		return dao.findByPrimaryKey(latest_news_no);
	}

	public List<Latest_news_VO> getAll() {
		return dao.getAll();
	}
}