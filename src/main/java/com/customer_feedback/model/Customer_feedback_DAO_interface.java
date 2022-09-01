package com.customer_feedback.model;

import java.util.*;

public interface Customer_feedback_DAO_interface {
    public void insert(Customer_feedback_VO customer_feedback_VO);
    public void update(Customer_feedback_VO customer_feedback_VO);
    public void delete(Integer SN);
    public Customer_feedback_VO findByPrimaryKey(Integer SN);
    public List<Customer_feedback_VO> getAllCustomer_feedback();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
  public List<Customer_feedback_VO> getAllCustomer_feedback(Map<String, String[]> map);
}
