package com.wr.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wr.models.Utilisateurs;

public class InscriptionForm {
	private static final String CHAMP_NOM = "nom";
	private static final String CHAMP_PASS = "motdepasse";
	private static final String CHAMP_CONF = "confirmation";
	private static final String CHAMP_EMAIL = "email";
	
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
		String email = getValeurChamp(request, CHAMP_EMAIL);
		
		Utilisateurs utilisateur = new Utilisateurs();
		
		try {
			validationNom(nom);
		} catch (Exception e) {
			setErreur(CHAMP_NOM, e.getMessage());
		}
		
		utilisateur.setNom(nom);
		
		try {
			validationMotDePasse(motDePasse, confirmation);
		} catch (Exception e) {
			setErreur(CHAMP_PASS, e.getMessage());
			setErreur(CHAMP_CONF, null);
		}
		utilisateur.setMotDePasse(motDePasse);
		
		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		utilisateur.setEmail(email);
		
		
		if(erreurs.isEmpty()) {
			resultat = "succès de l'inscriprtion";
		} else {
			resultat = "Echec de l'inscription";
		}
		
		return utilisateur;
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
	
	private void validationMotDePasse(String motDePasse, String confirmation) throws Exception {
		if(motDePasse != null && confirmation !=null) {
			if(motDePasse.equals(confirmation)) {	
				throw new Exception("Les mots de passe entrés sont différents, merci de les saisir à nouveau.");
			}else if(motDePasse.length()<3) {
				throw new Exception("Les mots de passe doivent contenir au moins 3 caractères.");
			}
		} else {
			throw new Exception("Merci de saisir et confirmer votre mot de passe.");
		}
	}
	
	
	private void validationEmail(String email) throws Exception {
		if(email !=null && !email.matches("([^.@]+) (\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
			throw new Exception("Merci de saisir une adresse mail valide");
		}
	}
	
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
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
