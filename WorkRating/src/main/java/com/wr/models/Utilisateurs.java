package com.wr.models;

import java.util.List;

public class Utilisateurs {
	private String nom;
	private String motDePasse;
	private List<Evaluations> evaluations;
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
		this.motDePasse = motDePasse;
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
	private List<Objectifs> objectifs;
}
