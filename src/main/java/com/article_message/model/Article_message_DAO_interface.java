package com.article_message.model;

import java.util.*;

public interface Article_message_DAO_interface{
	public void insert(Article_message_VO article_message_VO);
	public void update(Article_message_VO article_message_VO);
	public void delete(Integer art_msg_no);
	public Article_message_VO findByPrimaryKey(Integer art_msg_no);
	public List<Article_message_VO> getAll();
	
	public List<Article_message_VO> getAllfromfrm_art_no(Integer frm_art_no);
	
	public Integer ChangeStatus(Integer art_msg_no);
}