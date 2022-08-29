package com.customer_feedback.model;

import java.util.List;

public class Customer_feedback_Service {

	private Customer_feedback_DAO_interface dao;

	public Customer_feedback_Service() {
		dao = new Customer_feedback_DAO();
	}

	public Customer_feedback_VO addCustomer_feedback(Integer mem_no, Integer order_no, Integer prod_no,
			Integer pub_no, Integer act_no, Integer mng_no, Integer feedback_status) {

		Customer_feedback_VO customer_feedback_VO = new Customer_feedback_VO();

		customer_feedback_VO.setMem_no(mem_no);
		customer_feedback_VO.setOrder_no(order_no);
		customer_feedback_VO.setProd_no(prod_no);
		customer_feedback_VO.setPub_no(pub_no);
		customer_feedback_VO.setAct_no(act_no);
		customer_feedback_VO.setMng_no(mng_no);
		customer_feedback_VO.setFeedback_status(feedback_status);
		dao.insert(customer_feedback_VO);

		return customer_feedback_VO;
	}

	public Customer_feedback_VO updateEmp(Integer SN, Integer mem_no, Integer order_no, Integer prod_no,
			Integer pub_no, Integer act_no, Integer mng_no, Integer feedback_status) {

		Customer_feedback_VO customer_feedback_VO = new Customer_feedback_VO();

		customer_feedback_VO.setSN(SN);
		customer_feedback_VO.setMem_no(mem_no);
		customer_feedback_VO.setOrder_no(order_no);
		customer_feedback_VO.setProd_no(prod_no);
		customer_feedback_VO.setPub_no(pub_no);
		customer_feedback_VO.setAct_no(act_no);
		customer_feedback_VO.setMng_no(mng_no);
		customer_feedback_VO.setFeedback_status(feedback_status);
		dao.update(customer_feedback_VO);

		return customer_feedback_VO;
	}

	public void deleteCustomer_feedback(Integer SN) {
		dao.delete(SN);
	}

	public Customer_feedback_VO getOneCustomer_feedback(Integer SN) {
		return dao.findByPrimaryKey(SN);
	}

	public List<Customer_feedback_VO> getCustomer_feedbackAll() {
		return dao.getCustomer_feedbackAll();
	}
}
