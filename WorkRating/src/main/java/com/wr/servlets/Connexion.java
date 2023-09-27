package com.wr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.wr.forms.ConnexionForm;
import com.wr.models.Utilisateurs;

public class Connexion extends HttpServlet {
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";
	public static final String VUE = "/WEB-INF/connexion.jsp";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*Preparation de l'objet formulaire*/
		ConnexionForm form = new ConnexionForm();
		/*Traitement de la requête et récupération du bean en résultant*/
		Utilisateurs utilisateur = form.connecterUtilisateur(req);
		
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
		
		this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		
	}
}









