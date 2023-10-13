package com.wr.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;


import com.wr.forms.InscriptionForm;
import com.wr.models.Utilisateurs;
import com.wr.operations.DataConfigWay;
import com.wr.operations.WorkRatingDB;

public class Inscription extends HttpServlet {
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/inscription.jsp";
	
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Affichage de la page d'inscription*/
		DataConfig dataConfig = new DataConfig();
		String jdbcDriver = getServletContext().getInitParameter(dataConfig.getNomParametreDriver());
		String jdbcUrl = getServletContext().getInitParameter(dataConfig.getNomParametreUrl());
		String jdbcUser = getServletContext().getInitParameter(dataConfig.getNomParametreUser());
		
		WorkRatingDB workRatingDb = new WorkRatingDB();
		workRatingDb.setJdbcDriver(jdbcDriver);
		workRatingDb.setJdbcUrl(jdbcUrl);
		workRatingDb.setJdbcUser(jdbcUser);
		try {
			workRatingDb.connectDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Préparation de l'objet formulaire*/
		InscriptionForm form = new InscriptionForm();
		
		/*Appel au traitement et validation de la requête, et récuperation du bean en resultant*/
		Utilisateurs utilisateur;
		try {
			utilisateur = form.inscrireUtilisateur(req);
			req.setAttribute(ATT_FORM, form);
			req.setAttribute(ATT_USER, utilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*Stockage du formulaire et du bean dans l'objet request*/
		
		
		//this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		
		String data = req.getParameter("data1");
		
		
		resp.getWriter().write("Reponse pour la methode POST data =");
	}

}
