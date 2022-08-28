package com.latest_news.model;

public class Latest_news_VO implements java.io.Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer latest_news_no;
	private String news_content;
	private Integer news_status;
	public Integer getLatest_news_no() {
		return latest_news_no;
	}
	public void setLatest_news_no(Integer latest_news_no) {
		this.latest_news_no = latest_news_no;
	}
	public String getNews_content() {
		return news_content;
	}
	public void setNews_content(String news_content) {
		this.news_content = news_content;
	}
	public Integer getNews_status() {
		return news_status;
	}
	public void setNews_status(Integer news_status) {
		this.news_status = news_status;
	}
	
}