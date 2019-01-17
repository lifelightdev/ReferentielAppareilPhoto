package life.light.common.form;

import org.apache.struts.action.ActionForm;

public class MarqueForm extends ActionForm {

	private int idMarque;
	private String nom;

	public MarqueForm() {
		super();
	}

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}	

}