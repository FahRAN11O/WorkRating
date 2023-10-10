package com.wr.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wr.forms.InscriptionForm;
import com.wr.models.Utilisateurs;

public class Inscription extends HttpServlet {
	public static final String ATT_USER = "utilisateur";
	public static final String ATT_FORM = "form";
	public static final String VUE = "/WEB-INF/inscription.jsp";
	
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
		Utilisateurs utilisateur = form.inscrireUtilisateur(req);
		
		/*Stockage du formulaire et du bean dans l'objet request*/
		req.setAttribute(ATT_FORM, form);
		req.setAttribute(ATT_USER, utilisateur);
		
		//this.getServletContext().getRequestDispatcher(VUE).forward(req, resp);
		resp.getWriter().write("Reponse pour la methode GET");
	}

}
