package com.pub.model;

import java.util.List;
import java.util.stream.Collectors;

import com.pub_pics.model.model.Pub_pics_DAO_H_impl;
import com.util.GetBase64;

public class pub_Service_H_impl implements pub_Service_H{
	private Pub_DAO_H_impl_forWEB dao;
	private Pub_pics_DAO_H_impl pic_dao;
	public pub_Service_H_impl() {
		dao = new Pub_DAO_H_impl_forWEB();
		pic_dao = new Pub_pics_DAO_H_impl();
	}
	@Override
	public Pub register(Pub pub) {
		if (pub.getPub_name() == null) {
			pub.setMessage("酒吧名稱未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getPub_nop() == null) {
			pub.setMessage("預約人數未輸入");
			pub.setSuccessful(false);
			return pub;
		}

		if (pub.getPub_address() == null) {
			pub.setMessage("酒吧地址未輸入");
			pub.setSuccessful(false);
			return pub;
		}

		if (pub.getPub_detail() == null) {
			pub.setMessage("酒吧描述未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_name() == null) {
			pub.setMessage("廠商名稱未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_tel_no() == null) {
			pub.setMessage("酒吧電話未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_addr() == null) {
			pub.setMessage("廠商地址未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_email() == null) {
			pub.setMessage("廠商email未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_tax_id() == null) {
			pub.setMessage("統一編號未輸入");
			pub.setSuccessful(false);
			return pub;
		}
//		if (dao.selectByUsername(pub.getUsername()) != null) {
//			pub.setMessage("帳號重複");
//			pub.setSuccessful(false);
//			return pub;
//		}
		
		try {
			pub.setMem_no(1);
			final int resultCount = dao.insert(pub);
			Pub_pics pic= new Pub_pics();
			pic.setPub(pub);
			pic.setPub_pic(pub.getImg());
			final int pic_resultCount = pic_dao.insert(pic);
			if (resultCount < 1) {
				pub.setMessage("註冊錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}if (pic_resultCount < 1) {
				pub.setMessage("照片寫入錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}
			//commit();
		} catch (Exception e) {
			//rollback();
			e.printStackTrace();
		}
		
		pub.setMessage("註冊成功");
		pub.setSuccessful(true);
		return pub;
	}

	@Override
	public Pub update(Pub pub) {
		if (pub.getPub_name() == null) {
			pub.setMessage("酒吧名稱未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getPub_nop() == null) {
			pub.setMessage("預約人數未輸入");
			pub.setSuccessful(false);
			return pub;
		}

		if (pub.getPub_address() == null) {
			pub.setMessage("酒吧地址未輸入");
			pub.setSuccessful(false);
			return pub;
		}

		if (pub.getPub_detail() == null) {
			pub.setMessage("酒吧描述未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_name() == null) {
			pub.setMessage("廠商名稱未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_tel_no() == null) {
			pub.setMessage("酒吧電話未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_addr() == null) {
			pub.setMessage("廠商地址未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_email() == null) {
			pub.setMessage("廠商email未輸入");
			pub.setSuccessful(false);
			return pub;
		}
		if (pub.getFirm_tax_id() == null) {
			pub.setMessage("統一編號未輸入");
			pub.setSuccessful(false);
			return pub;
		}
//		if (dao.selectByUsername(pub.getUsername()) != null) {
//			pub.setMessage("帳號重複");
//			pub.setSuccessful(false);
//			return pub;
//		}
		
		try {
			pub.setMem_no(1);
			final int resultCount = dao.update(pub);
			Pub_pics pic= new Pub_pics();
			pic.setPub(pub);
			pic.setPub_pic(pub.getImg());
			final int pic_resultCount = pic_dao.update(pic);
			if (resultCount < 1) {
				pub.setMessage("註冊錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}if (pic_resultCount < 1) {
				pub.setMessage("照片寫入錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}
			//commit();
		} catch (Exception e) {
			//rollback();
			e.printStackTrace();
		}
		
		pub.setMessage("更新成功");
		pub.setSuccessful(true);
		return pub;
	}

	@Override
	public Pub updateRate(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub updateOpen(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub updateApplication(Pub pub) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pub findByPrimaryKey(Pub pub) {
		return dao.selectById(pub.getPub_no());
	}

	@Override
	public List<Pub> getAll() {
		return dao.selectAll();
	}
	@Override
	public List<Pub> check(Integer i) {
		return dao.selectAll().stream().filter(e->e.getPub_application()==i).collect(Collectors.toList());
	}
	@Override
	public List<Pub> getMemALL(Integer mem_no) {
		return dao.selectAll();
	}

}
