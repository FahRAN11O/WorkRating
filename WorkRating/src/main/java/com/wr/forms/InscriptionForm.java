package com.wr.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wr.models.Utilisateurs;

public class InscriptionForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PASS = "motdepasse";
	private static final String CHAMP_CONF = "confirmation";
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap<>();
	
	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public Utilisateurs inscrireUtilisateur(HttpServletRequest request) {
		String nom = getValeurChamp(request, CHAMP_NOM);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		String confirmation = getValeurChamp(request, CHAMP_CONF);
		
		Utilisateurs utilisateur = new Utilisateurs();
		
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		return null;
	}
	
	private void validationNom(String nom) throws Exception {
		if(nom !=null) {
			if(nom.length()<3) {
				throw new Exception("Le nom d'utilisateur doit contenir au moins 3 caractères");
			}
		}else {
			throw new Exception("Merci d'entrer un nom d'utilisateur.");
		}
	}
	
	private static String getValeurChamp(HttpServletRequest request, String nomChamp) {
		
		String valeur = request.getParameter(nomChamp);
		if(valeur == null || valeur.trim().length() == 0) {
			return null;
		}else {
			return valeur;
		}
	}
	
}
