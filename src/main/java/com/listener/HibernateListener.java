package com.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.util.HibernateUtil;

@WebListener
public class HibernateListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		HibernateUtil.getSessionFactory();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		HibernateUtil.shutdown();
	}
}
