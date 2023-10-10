package com.wr.operations;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.wr.servlets.DataConfig;


public class WorkRatingDB {
	String sql;
	
	private DataConfig dataConfig;
	
	private ResultSet result;
	private ResultSetMetaData resultMeta;
	private Connection connection;
	private Statement statement;
	
	public WorkRatingDB() throws ClassNotFoundException { 
		Class.forName(dataConfig.getJdbcDriver());
		System.out.println("trynna connect to the database...");
	}
	
	public void connectDB() throws SQLException {
		connection = DriverManager.getConnection(dataConfig.getJdbcUrl(), dataConfig.getJdbcUser(), "");
		System.out.println("connection established!");
		statement = connection.createStatement();
	}
	
	public void closeDB(){
		
	}

}
