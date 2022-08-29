package com.pub.model;

import java.util.List;


public interface Pub_DAO_interface {
    public void insert(Pub_VO pubVO);
    public void update(Pub_VO pubVO);
//    public void delete(Integer pub_no);//酒吧沒有刪除
    public void updateRate(Integer pub_no,Integer pub_rate_sum,Integer pub_ratetotal);
    public void updateOpen(Integer pub_no,Integer pub_open);
    public void updateApplication(Integer pub_no,Integer pub_application);
    public Pub_VO findByPrimaryKey(Integer pub_no);
    public List<Pub_VO> getAll();
}
