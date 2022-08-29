package com.customer_chat_room.model;

import java.sql.Timestamp;
import java.util.List;

public class Customer_chat_room_Service {

	private Customer_chat_room_DAO_interface dao;

	public Customer_chat_room_Service() {
		dao = new Customer_chat_room_DAO();
	}

	public Customer_chat_room_VO addCustomer_chat_room(Integer mng_no, Integer mem_no, Integer prod_no,
			String message, byte[] mem_question_pic, Timestamp message_chat_time, Integer chat_direction) {

		Customer_chat_room_VO customer_chat_room_VO = new Customer_chat_room_VO();

		customer_chat_room_VO.setMng_no(mng_no);
		customer_chat_room_VO.setMem_no(mem_no);
		customer_chat_room_VO.setProd_no(prod_no);
		customer_chat_room_VO.setMessage(message);
		customer_chat_room_VO.setMem_question_pic(mem_question_pic);
		customer_chat_room_VO.setMessage_chat_time(message_chat_time);
		customer_chat_room_VO.setChat_direction(chat_direction);
		dao.insert(customer_chat_room_VO);

		return customer_chat_room_VO;
	}

	public Customer_chat_room_VO updateEmp(Integer SN, Integer mng_no, Integer mem_no, Integer prod_no,
			String message, byte[] mem_question_pic, Timestamp message_chat_time, Integer chat_direction) {

		Customer_chat_room_VO customer_chat_room_VO = new Customer_chat_room_VO();

		customer_chat_room_VO.setSN(SN);
		customer_chat_room_VO.setMng_no(mng_no);
		customer_chat_room_VO.setMem_no(mem_no);
		customer_chat_room_VO.setProd_no(prod_no);
		customer_chat_room_VO.setMessage(message);
		customer_chat_room_VO.setMem_question_pic(mem_question_pic);
		customer_chat_room_VO.setMessage_chat_time(message_chat_time);
		customer_chat_room_VO.setChat_direction(chat_direction);
		dao.update(customer_chat_room_VO);

		return customer_chat_room_VO;
	}

	public void deleteCustomer_chat_room(Integer SN) {
		dao.delete(SN);
	}

	public Customer_chat_room_VO getOneCustomer_chat_room(Integer SN) {
		return dao.findByPrimaryKey(SN);
	}

	public List<Customer_chat_room_VO> getCustomer_chat_roomAll() {
		return dao.getCustomer_chat_roomAll();
	}
}
