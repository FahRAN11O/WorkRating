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
	private static final String NOM_PARAMETRE_DRIVER_DATABASE = "jdbc-driver";
	private static final String NOM_PARAMETRE_URL_DATABASE ="db-url";
	private static final String NOM_PARAMETRE_USER_DATABASE ="db-user";
	
	private static WorkRatingDB workRatingDb = new WorkRatingDB();
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Affichage de la page d'inscription*/
		
		
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
			dbInteraction();
			workRatingDb.ajoutUtilisateur(utilisateur);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
						
		String nomData = req.getParameter("nom");
		String emailData = req.getParameter("email");
		String motdepasseData = req.getParameter("motdepasse");
		
		resp.getWriter().write("Reponse pour la methode POST nom = "+nomData +", email = "+emailData+", motDepasse = "+motdepasseData+"!");
	}

	
	public void dbInteraction() {
		String jdbcDriver = getServletContext().getInitParameter(NOM_PARAMETRE_DRIVER_DATABASE);
		String jdbcUrl = getServletContext().getInitParameter(NOM_PARAMETRE_URL_DATABASE);
		String jdbcUser = getServletContext().getInitParameter(NOM_PARAMETRE_USER_DATABASE);
		
		workRatingDb.setJdbcDriver(jdbcDriver);
		workRatingDb.setJdbcUrl(jdbcUrl);
		workRatingDb.setJdbcUser(jdbcUser);
		try {
			workRatingDb.connectDB();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
