package com.wr.servlets;

import javax.servlet.http.HttpServlet;

public class DataConfig extends HttpServlet{
	
	private String nomParametreDriver= "jdbc-driver";
	private String nomParametreUrl = "db-url";
	private String nomParametreUser = "db-user";
	
	
	private String jdbcDriver;
	private String jdbcUser;
	private String jdbcUrl;
	
	public DataConfig() {
		setJdbcDriver(getServletContext().getInitParameter(nomParametreDriver));
		setJdbcUrl(getServletContext().getInitParameter(nomParametreUrl));
		setJdbcUser(getServletContext().getInitParameter(nomParametreUser));
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
