package com.wr.models;

import java.util.Date;
import java.util.List;

public class Objectifs {
	private String nom;
	private String etat;
	private int note;
	private Date date; 
	private List<Chemins> chemins;
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public int getNote() {
		return note;
	}
	public void setNote(int note) {
		this.note = note;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public List<Chemins> getChemins() {
		return chemins;
	}
	public void setChemins(List<Chemins> chemins) {
		this.chemins = chemins;
	}
}
