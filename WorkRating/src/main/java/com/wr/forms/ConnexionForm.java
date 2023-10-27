package com.wr.forms;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.wr.models.Utilisateurs;

public class ConnexionForm {
	private static final String CHAMP_PSEUDO = "pseudo";
	private static final String CHAMP_PASS = "motdepasse";
	
	private String resultat;
	private Map<String, String> erreurs = new HashMap();
	
	public String getResultat() {
		return resultat;
	}
	public Map<String, String> getErreurs() {
		return erreurs;
	}
	
	public Utilisateurs connecterUtilisateur(HttpServletRequest request) throws Exception {
		/*Récupération des champs du formulaire*/
		String pseudo = getValeurChamp(request, CHAMP_PSEUDO);
		String motDePasse = getValeurChamp(request, CHAMP_PASS);
		
		Utilisateurs utilisateur = new Utilisateurs();
		
		try {
			validationPseudo(pseudo);
		} catch (Exception e) {
			setErreur(pseudo, e.getMessage());
		}
		utilisateur.setNom(pseudo);
		
		try {
			validationMotDepasse(motDePasse);;
		} catch (Exception e) {
			setErreur(pseudo, e.getMessage());
		}
		utilisateur.setMotDePasseConnexion(motDePasse);
		
		
		return utilisateur;
	}
	
	private void validationPseudo(String pseudo) throws Exception {
		if(pseudo == null) {
			throw new Exception("Pseudo invalide, Verifier s'il vous plait!");
		}
	}
	
	private void validationMotDepasse(String motDePasse) throws Exception {
		if(motDePasse == null) {
			throw new Exception("Veuillez saisir le mot de passe!");
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
