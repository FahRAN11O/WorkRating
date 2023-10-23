package com.wr.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wr.forms.ConnexionForm;
import com.wr.models.Utilisateurs;
import com.wr.operations.WorkRatingDB;

public class Connexion extends HttpServlet {
	private static final String ATT_USER = "utilisateur";
	private static final String ATT_FORM = "form";
	private static final String ATT_SESSION_USER = "sessionUtilisateur";
	private static final String VUE = "/WEB-INF/connexion.jsp";
	private static final String VUE_ACCUEIL_UTILISATEUR="/WEB-INF/accueil";
	
	
	private static final String NOM_PARAMETRE_DRIVER_DATABASE = "jdbc-driver";
	private static final String NOM_PARAMETRE_URL_DATABASE ="db-url";
	private static final String NOM_PARAMETRE_USER_DATABASE ="db-user";
	
	private static WorkRatingDB workRatingDb = new WorkRatingDB();
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean motDePasseCorrecte;
		String username = req.getParameter("nom");
		String password = req.getParameter("motdepasse");
		
		/*Preparation de l'objet formulaire*/
		ConnexionForm form = new ConnexionForm();
		/*Traitement de la requête et récupération du bean en résultant*/
		Utilisateurs utilisateur;
		try {
			utilisateur = form.connecterUtilisateur(req);
			/*Recuperation de la session depuis la requête*/
			HttpSession session = req.getSession();
			
			/*
			 * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
			 * Utilisateur à la session, sinon suppression du bean de la session*/
			if(form.getErreurs().isEmpty()) {
				session.setAttribute(ATT_SESSION_USER, utilisateur);
			}else {
				session.setAttribute(ATT_SESSION_USER, null);
			}
			
			/*Stockage du formulaire et du bean dans l'objet request*/
			req.setAttribute(ATT_FORM, form);
			req.setAttribute(ATT_USER, utilisateur);
			dbInteraction();
			motDePasseCorrecte = workRatingDb.validationMotDePasse(utilisateur);
			if(motDePasseCorrecte) {
				this.getServletContext().getRequestDispatcher(VUE_ACCUEIL_UTILISATEUR).forward(req, resp);
				resp.getWriter().write("NOM="+utilisateur.getNom());
			}else {
				this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);

		}
		
		
	}
	
	private boolean authenticate(String username, String password) {
		
		return true;
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









