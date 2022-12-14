package com.forum_article.model;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

import com.article_message.model.Article_message_VO;
import com.forum_article_report.model.Forum_article_report_VO;

public class Forum_article_Service {

	private Forum_article_DAO_interface dao;

	public Forum_article_Service() {
		dao = new Forum_article_DAO();
	}

	public Forum_article_VO addForum_article(Integer frm_no, Integer mem_no, String art_title, String art_content) {

		Forum_article_VO forum_article_VO = new Forum_article_VO();

		forum_article_VO.setFrm_no(frm_no);
		forum_article_VO.setMem_no(mem_no);
		forum_article_VO.setArt_title(art_title);
		forum_article_VO.setArt_content(art_content);
		dao.insert(forum_article_VO);

		return forum_article_VO;
	}

	public Forum_article_VO updateForum_article(Integer frm_art_no, Integer frm_no, Integer mem_no, Timestamp art_time,
			String art_title, String art_content, byte[] art_img, Integer art_status) {

		Forum_article_VO forum_article_VO = new Forum_article_VO();

		forum_article_VO.setFrm_art_no(frm_art_no);
		forum_article_VO.setFrm_no(frm_no);
		forum_article_VO.setMem_no(mem_no);
		forum_article_VO.setArt_time(art_time);
		forum_article_VO.setArt_title(art_title);
		forum_article_VO.setArt_content(art_content);
		forum_article_VO.setArt_img(art_img);
		forum_article_VO.setArt_status(art_status);
		dao.update(forum_article_VO);

		return forum_article_VO;
	}

	public void deleteForum_article(Integer frm_art_no) {
		dao.delete(frm_art_no);
	}

	public Forum_article_VO getOneForum_article(Integer frm_art_no) {
		return dao.findByPrimaryKey(frm_art_no);
	}

	public List<Forum_article_VO> getAll() {
		return dao.getAll();
	}

	public Set<Article_message_VO> getArticle_messageByForum_article(Integer frm_art_no) {
		return dao.getArticle_messageByForum_article(frm_art_no);
	}

	public Integer ChangeStatus(Integer frm_art_no) {
		return dao.ChangeStatus(frm_art_no);
	}
}
