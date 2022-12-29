package com.forum_article_report.model;

import java.util.*;

public interface Forum_article_report_DAO_interface {
	public void insert(Forum_article_report_VO forum_article_report_VO);

	public void update(Forum_article_report_VO forum_article_report_VO);

	public void delete(Integer frm_art_rpt_no);

	public Forum_article_report_VO findByPrimaryKey(Integer frm_art_rpt_no);

	public List<Forum_article_report_VO> getAll();

	public void check(Forum_article_report_VO forum_article_report_VO);

}
