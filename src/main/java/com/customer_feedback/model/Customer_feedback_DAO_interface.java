package com.customer_feedback.model;

import java.util.*;

public interface Customer_feedback_DAO_interface {
    public void insert(Customer_feedback_VO customer_feedback_VO);
    public void update(Customer_feedback_VO customer_feedback_VO);
    public void delete(Integer SN);
    public Customer_feedback_VO findByPrimaryKey(Integer SN);
    public List<Customer_feedback_VO> getCustomer_feedbackAll();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<Manager_VO> getAll(Map<String, String[]> map);
}
