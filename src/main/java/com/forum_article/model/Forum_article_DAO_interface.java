package com.forum_article.model;

import java.util.*;

import com.article_message.model.Article_message_VO;
import com.forum_article_report.model.Forum_article_report_VO;

public interface Forum_article_DAO_interface{
	public void insert(Forum_article_VO forum_article_VO);
	public void update(Forum_article_VO forum_article_VO);
	public void delete(Integer frm_art_no);
	public Forum_article_VO findByPrimaryKey(Integer frm_art_no);
	public List<Forum_article_VO> getAll();
	public Set<Article_message_VO> getArticle_messageByForum_article(Integer frm_art_no);
}