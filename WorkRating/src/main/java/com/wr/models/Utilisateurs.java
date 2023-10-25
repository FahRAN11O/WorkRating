package com.wr.models;

import java.util.List;

import com.wr.operations.DataCrypter;

public class Utilisateurs {
	private String nom;
	private String motDePasse;
	private String email;
	private String motDePasseConnexion;
	
	private List<Evaluations> evaluations;
	private List<Objectifs> objectifs;
	
	private DataCrypter dataCrypter ;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		dataCrypter = new DataCrypter();
		String motDePaseCrypted=dataCrypter.crypter(motDePasse);
		this.motDePasse = motDePaseCrypted;
	}
	
	public String getMotDePasseConnexion() {
		return motDePasseConnexion;
	}
	public void setMotDePasseConnexion(String motDePasseConnexion) {
		this.motDePasseConnexion = motDePasseConnexion;
	}
	
	public List<Evaluations> getEvaluations() {
		return evaluations;
	}
	public void setEvaluations(List<Evaluations> evaluations) {
		this.evaluations = evaluations;
	}
	public List<Objectifs> getObjectifs() {
		return objectifs;
	}
	public void setObjectifs(List<Objectifs> objectifs) {
		this.objectifs = objectifs;
	}
	
	
}
