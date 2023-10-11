package com.wr.servlets;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DataConfig extends HttpServlet{
	
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
	
	public DataConfig(HttpServletRequest req) {
		setJdbcDriver(req.getServletContext().getInitParameter(nomParametreDriver));
		setJdbcUrl(req.getServletContext().getInitParameter(nomParametreUrl));
		setJdbcUser(req.getServletContext().getInitParameter(nomParametreUser));
		
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
