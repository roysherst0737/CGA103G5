package com.forum.model;

import java.util.*;

import com.forum_article.model.Forum_article_VO;

public interface Forum_DAO_interface {
	public void insert(Forum_VO forum_VO);

	public void update(Forum_VO forum_VO);

	public void delete(Integer frm_no);

	public Forum_VO findByPrimaryKey(Integer frm_no);

	public List<Forum_VO> getAll();

	public Set<Forum_article_VO> getForum_articleByForum(Integer frm_no);

}