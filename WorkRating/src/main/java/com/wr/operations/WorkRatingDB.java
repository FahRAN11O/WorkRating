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

import com.mysql.jdbc.Driver;

import javax.servlet.ServletContextEvent;
import javax.servlet.http.HttpServletRequest;

import com.wr.models.Utilisateurs;

public class WorkRatingDB {
	String sql;
	HttpServletRequest request;
	
	private ResultSet result;
	private ResultSetMetaData resultMeta;
	private Connection connection;
	private Statement statement;
	private PreparedStatement preparedStatement;
	
	private String jdbcDriver;
	private String jdbcUser;
	private String jdbcUrl;
	

	public String getJdbcDriver() {
		return jdbcDriver;
	}


	public String getJdbcUser() {
		return jdbcUser;
	}

	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
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
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void connectDB() throws SQLException, ClassNotFoundException {
		System.out.println("trynna connect to the database...111");
		Class.forName(getJdbcDriver());
		connection = DriverManager.getConnection(getJdbcUrl(), getJdbcUser(), "");
		System.out.println("connection established!");
		statement = connection.createStatement();
	}
	
	private void closeResult() throws SQLException, Exception {
		if(!result.isClosed())
			result.close();
		else
		    throw new Exception("result already closed!");
		
	}
	
	private void closeStatement() throws SQLException, Exception {
		if(!statement.isClosed()) 
			statement.close();
		else
			throw new Exception("statement already closed!");
		
	}
	
	private void closeConnection() throws SQLException, Exception {
		if(!connection.isClosed())
			connection.close();
		else
			throw new Exception("connection already closed!");
		
	}
	
	public void closeDB() throws Exception{
		closeResult();
		closeStatement();
		closeConnection();
	}
	
	public void ajoutUtilisateur(Utilisateurs utilisateur) throws Exception {
		String nom = utilisateur.getNom();
		String motDePasse = utilisateur.getMotDePasse();
		String email = utilisateur.getEmail();
		sql = "INSERT INTO utilisateurs (nom, email, mot_de_passe) VALUES (?,?,?)";
		preparedStatement = connection.prepareStatement(sql);
		preparedStatement.setString(1, nom);
		preparedStatement.setString(2, email);
		preparedStatement.setString(3, motDePasse);
		preparedStatement.executeUpdate();
		System.out.println("Utilisateur Enregistré!");
	}
	
	public boolean connecteUtilisateur(Utilisateurs utilisateur) throws SQLException {
		String nom = utilisateur.getNom();
		String motDePasse = null;
		sql = "SELECT MotDePasse FROM Utilisateur where Nom = "+"'"+nom+"'";
		statement.executeQuery(sql);
		//Ajouter de script pour obtenir le mot de passe venant de la base de donnée
		
		return new DataCrypter().verifierCrypt(utilisateur.getMotDePasse(), motDePasse);
	}
}
