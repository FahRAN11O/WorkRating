package com.wr.models;

import java.util.Date;

public class Evaluations {
	private String nom;
	private int note;
	private String remarque;
	private Date date;
	private Utilisateurs utilisateur;
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public String getRemarque() {
		return remarque;
	}

	public void setRemarque(String remarque) {
		this.remarque = remarque;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Utilisateurs getUtilisateur() {
		return utilisateur;
	}

	public Evaluations(Utilisateurs utilisateur) {

	}
}
