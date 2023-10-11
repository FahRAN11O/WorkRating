package com.wr.servlets;

import java.net.http.HttpRequest;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wr.operations.DataConfigWay;

public class DataConfig implements ServletContextListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nomParametreDriver= "jdbc-driver";
	private String nomParametreUrl = "db-url";
	private String nomParametreUser = "db-user";
	
	
	private String jdbcDriver;
	private String jdbcUser;
	private String jdbcUrl;
	
	DataConfigWay dataConfigway;

	public DataConfig(DataConfigWay dataConfigway) {
		this.dataConfigway = dataConfigway;
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		
		setJdbcDriver(context.getInitParameter(nomParametreDriver));
		setJdbcUrl(context.getInitParameter(nomParametreUrl));
		setJdbcUser(context.getInitParameter(nomParametreUser));
		
	}
	
	public String getJdbcDriver() {
		return jdbcDriver;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public String getJdbcUser() {
		return jdbcUser;
	}

	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}
}
