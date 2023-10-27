package com.wr.forms;

import java.net.http.HttpRequest;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.wr.models.Evaluations;

public class EvaluationsForm {
	private static final String PARAMETRE_FOCUS = "focus";
	private static final String PARAMETRE_LAZY = "lazy";
	private static final String PARAMETRE_MOTIVATION = "motivation";
	private static List<Evaluations> listEvaluations ;
	
	
	public List<Evaluations> getListEvaluations() {
		return listEvaluations;
	}


	public void ajouterEvaluation(Evaluations evaluation) {
		listEvaluations.add(evaluation);
	}
		
	
	public String getValeurChamp(HttpServletRequest request, String nomChamp) {
		String valeur = request.getParameter(nomChamp);
		if(valeur == null || valeur.trim().length() == 0) {
			return null;
		}else {
			return valeur;
		}	
	}
}
