package com.jvwl.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("ctx", sce.getServletContext().getContextPath());
    }

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
	}
}
