package com.forum.model;

import java.util.List;
import java.util.Set;

import com.forum_article.model.Forum_article_VO;
import com.prod_pic.model.Prod_pic_VO;

public class Forum_Service {

	private Forum_DAO_interface dao;

	public Forum_Service() {
		dao = new Forum_DAO();
	}

	public Forum_VO addForum(String frm_name_no, Integer frm_status, byte[] frm_img) {

		Forum_VO forum_VO = new Forum_VO();

		forum_VO.setFrm_name_no(frm_name_no);
		forum_VO.setFrm_status(frm_status);
		forum_VO.setFrm_img(frm_img);
		dao.insert(forum_VO);

		return forum_VO;
	}

	public Forum_VO updateForum(Integer frm_no, String frm_name_no, Integer frm_status) {

		Forum_VO forum_VO = new Forum_VO();

		forum_VO.setFrm_no(frm_no);
		forum_VO.setFrm_name_no(frm_name_no);
		forum_VO.setFrm_status(frm_status);
		dao.update(forum_VO);

		return forum_VO;
	}

	public void deleteForum(Integer frm_no) {
		dao.delete(frm_no);
	}

	public Forum_VO getOneForum(Integer frm_no) {
		return dao.findByPrimaryKey(frm_no);
	}

	public List<Forum_VO> getAll() {
		return dao.getAll();
	}

	public Set<Forum_article_VO> getForum_articleByForum(Integer frm_no) {
		return dao.getForum_articleByForum(frm_no);
	}
}