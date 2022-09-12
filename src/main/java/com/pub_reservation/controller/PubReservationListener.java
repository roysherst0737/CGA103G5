package com.pub_reservation.controller;

import java.util.Timer;
import java.util.TimerTask;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import static com.pub_reservation.service.Pub_ReservationConstants.SERVICE;

@WebListener
public class PubReservationListener implements ServletContextListener{
	Timer timer;
//	private Logger logger = Logger.getLogger(PubReservationListener.class.getName());
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		timer.cancel();
		System.out.println("關閉排程器");
	}
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("***********************排程器啟動**************************");
		timer = new Timer();
//		logger.info("新增酒吧預約表");
//		logger.info("刪除過期酒吧預約表");
		timer.schedule(new PubReservationTimer(), 1000, 86400000);
		System.out.println("***********************排程器運行***********************");
	}
}
class PubReservationTimer extends TimerTask {

	@Override
	public void run() {
		SERVICE.setReservation();
		System.out.println("新增酒吧預約表");
		SERVICE.removeReservation();
		System.out.println("刪除過期酒吧預約表");
//		
//		RmOrderService rmOrderSvc = new RmOrderService();
//		rmOrderSvc.overdue();
//		System.out.println("逾期訂單狀態改為已完成");	
	}
}

