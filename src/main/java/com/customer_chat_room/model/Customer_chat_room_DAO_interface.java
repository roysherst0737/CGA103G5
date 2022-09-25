package com.customer_chat_room.model;

import java.util.*;

public interface Customer_chat_room_DAO_interface {
    public void insert(Customer_chat_room_VO Customer_chat_room_VO);
    public void update(Customer_chat_room_VO Customer_chat_room_VO);
    public void delete(Integer SN);
    public Customer_chat_room_VO findByPrimaryKey(Integer SN);
    public List<Customer_chat_room_VO> getAllCustomer_chat_room();
    //萬用複合查詢(傳入參數型態Map)(回傳 List)
  public List<Customer_chat_room_VO> getAllCustomer_chat_room(Map<String, String[]> map);
}
