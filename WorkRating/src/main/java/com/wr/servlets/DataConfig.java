package com.wr.servlets;


import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wr.operations.WorkRatingDB;

public class DataConfig {
	
	/**
	 * 
	 */
	private String nomParametreDriver= "jdbc-driver";
	private String nomParametreUrl = "db-url";
	private String nomParametreUser = "db-user";
	
	public String getNomParametreDriver() {
		return nomParametreDriver;
	}
	public String getNomParametreUrl() {
		return nomParametreUrl;
	}
	public String getNomParametreUser() {
		return nomParametreUser;
	}
	
	
	

	

	
}
