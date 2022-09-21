package com.pub.service;

import java.util.List;
import java.util.stream.Collectors;

import com.pub.dao.Pub_DAO_H_impl_forWEB;
import com.pub.entity.Pub;
import com.pub.model.pub_Service_H;
import com.pub_pics.dao.Pub_pics_DAO_H_impl;
import com.pub_pics.entity.Pub_pics;
import com.pub_reservation.dao.Pub_Reservation_DAOImpl;

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
			final int resultCount = dao.insert(pub);
			Pub_pics pic= new Pub_pics();
			pic.setPub(pub);
			pic.setPub_pic(pub.getImg());
			dao.getSession().flush();
			final int pic_resultCount = pic_dao.insert(pic);
			if (resultCount < 1) {
				pub.setMessage("註冊錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}
			if (pic_resultCount < 1) {
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
			final Pub oldPub =  dao.selectById(pub.getPub_no());
			pub.setPub_rate_sum(oldPub.getPub_rate_sum());
			pub.setPub_ratetotal(oldPub.getPub_ratetotal());
			pub.setPub_time(oldPub.getPub_time());
//			解決永久化問題
			dao.getSession().clear();
			final int resultCount = dao.update(pub);
			final Pub_pics oldPubPics =  pic_dao.findByPubNo(pub.getPub_no());
			Pub_pics pic= new Pub_pics();
			pic.setPub(pub);
			pic.setPub_pic(pub.getImg());
			pic.setPub_pic_no(oldPubPics.getPub_pic_no());
//			解決永久化問題
			final int pic_resultCount = pic_dao.update(pic);
//			final int pic_resultCount = 1;
			if (resultCount < 1) {
				pub.setMessage("更新錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}if (pic_resultCount < 1) {
				pub.setMessage("照片更新寫入錯誤，請聯絡管理員!");
				pub.setSuccessful(false);
				return pub;
			}
			//commit();
		} catch (Exception e) {
			//rollback();
			e.printStackTrace();
			pub.setMessage("更新失敗");
			pub.setSuccessful(false);
			return pub;
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
