package com.pub_pics.model;

import java.util.List;


public interface Pub_pics_DAO_interface {
    public void insert(Pub_pics_VO pub_pic_VO);
    public void update(Pub_pics_VO pub_pic_VO);
    public void delete(Pub_pics_VO pub_pic_VO);
    public Pub_pics_VO findByPrimaryKey(Integer pub_pic_no);
    public List<Pub_pics_VO> getAll(Integer pub_no);
}
