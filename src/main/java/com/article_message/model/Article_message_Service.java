package com.article_message.model;

import java.sql.Timestamp;
import java.util.List;

public class Article_message_Service {
	private Article_message_DAO_interface dao;

	public Article_message_Service() {
		dao = new Article_message_DAO();
	}

	public Article_message_VO addArticle_message(Integer mem_no, Integer frm_art_no,
			String msg_content) {

		Article_message_VO article_message_VO = new Article_message_VO();

		
		article_message_VO.setMem_no(mem_no);
		article_message_VO.setFrm_art_no(frm_art_no);
//		article_message_VO.setMsg_time(msg_time);
		article_message_VO.setMsg_content(msg_content);
//		article_message_VO.setMsg_status(msg_status);
		dao.insert(article_message_VO);

		return article_message_VO;
	}

	public Article_message_VO updateArticle_message(Integer art_msg_no, Integer mem_no, Integer frm_art_no, Timestamp msg_time,
			String msg_content,Integer msg_status) {

		Article_message_VO article_message_VO = new Article_message_VO();

		article_message_VO.setArt_msg_no(art_msg_no);
		article_message_VO.setMem_no(mem_no);
		article_message_VO.setFrm_art_no(frm_art_no);
		article_message_VO.setMsg_time(msg_time);
		article_message_VO.setMsg_content(msg_content);
		article_message_VO.setMsg_status(msg_status);
		dao. update(article_message_VO);

		return article_message_VO;
	}


	public void deleteArticle_message(Integer art_msg_no) {
		dao.delete(art_msg_no);
	}

	public Article_message_VO getOneArticle_message(Integer art_msg_no) {
		return dao.findByPrimaryKey(art_msg_no);
	}

	public List<Article_message_VO> getAll() {
		return dao.getAll();
	}
	
	public List<Article_message_VO> getAllfromfrm_art_no(Integer frm_art_no) {
		return dao.getAllfromfrm_art_no(frm_art_no);
	}

	public Integer ChangeStatus(Integer art_msg_no) {
			return dao.ChangeStatus(art_msg_no);
		}
}