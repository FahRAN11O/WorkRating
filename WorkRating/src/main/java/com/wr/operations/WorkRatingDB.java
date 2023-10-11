package com.wr.operations;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import com.wr.servlets.DataConfig;


public class WorkRatingDB {
	String sql;
	HttpServletRequest request;
	
	private DataConfig dataConfig;
	
	private ResultSet result;
	private ResultSetMetaData resultMeta;
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	
	public WorkRatingDB() throws ClassNotFoundException { 
		 dataConfig = new DataConfig();
		Class.forName(dataConfig.getJdbcDriver());
		System.out.println("trynna connect to the database...");
	}
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void connectDB() throws SQLException {
		connection = DriverManager.getConnection(dataConfig.getJdbcUrl(), dataConfig.getJdbcUser(), "");
		System.out.println("connection established!");
		statement = connection.createStatement();
	}
	
	public void closeDB() throws Exception{
		
			if(!result.isClosed())
				result.close();
			else
			    throw new Exception("result already closed!");

			
			if(!statement.isClosed()) 
				statement.close();
			else
				throw new Exception("statement already closed!");
		
			if(!connection.isClosed())
				connection.close();
			else
				throw new Exception("connection already closed!");
			
	}
	
	public void ajoutUtilisateur(String nom, String motDePasse, String email) throws Exception {
		sql = "INSERT INTO utilisateur (nom, email, motDePasse) VALUES (?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, nom);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, motDePasse);
		preparedStatement.executeUpdate();
		closeDB();
	}

}
