package com.article_message_report.model;

import java.util.*;

public interface Article_message_report_DAO_interface {
	public void insert(Article_message_report_VO article_message_report_VO);

	public void update(Article_message_report_VO article_message_report_VO);

	public void delete(Integer art_msg_rpt);

	public Article_message_report_VO findByPrimaryKey(Integer art_msg_rpt);

	public List<Article_message_report_VO> getAll();

	public void check(Article_message_report_VO article_message_report_VO);
}