package com.prod_pic.model;

import java.io.IOException;
import java.util.*;

public interface Prod_pic_DAO_interface {
	
	public void insert(Prod_pic_VO prod_picVO) throws IOException;
    public void update(Prod_pic_VO prod_picVO) throws IOException;
    public void delete(Integer prod_pic_no);
    public Prod_pic_VO findByPrimaryKey(Integer prod_pic_no);
    public List<Prod_pic_VO> getAll();

}
