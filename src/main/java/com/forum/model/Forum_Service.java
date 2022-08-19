package com.forum.model;

import java.util.List;

//import com.forum.model.Forum_DAO;
//import com.forum.model.Forum_DAO_interface;
//import com.forum.model.Forum_VO;

public class Forum_Service {
	private Forum_DAO_interface dao;

	public Forum_Service() {
		dao = new Forum_DAO();
	}

	public Forum_VO addForum(Integer frm_no, String frm_name_no, Integer frm_status) {

		Forum_VO forumVO = new Forum_VO();

		forumVO.setFrm_no(frm_no);
		forumVO.setFrm_name_no(frm_name_no);
		forumVO.setFrm_status(frm_status);
		dao.insert(forumVO);

		return forumVO;
	}

	public Forum_VO updateForum(Integer frm_no, String frm_name_no, Integer frm_status) {

		Forum_VO forumVO = new Forum_VO();

		forumVO.setFrm_no(frm_no);
		forumVO.setFrm_name_no(frm_name_no);
		forumVO.setFrm_status(frm_status);
		dao.update(forumVO);

		return forumVO;
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
}