package life.light.common.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import life.light.common.bean.Marque;

public class ModeleForm extends ActionForm {

	private int idModele;
	private String nom;
	
	private int idMarque;
	private Marque marque;
	private List<Marque> marques;

	public ModeleForm() {
		super();
	}

	public int getIdModele() {
		return idModele;
	}

	public void setIdModele(int idModele) {
		this.idModele = idModele;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getIdMarque() {
		return idMarque;
	}

	public void setIdMarque(int idMarque) {
		this.idMarque = idMarque;
	}

	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}

	public List<Marque> getMarques() {
		return marques;
	}

	public void setMarques(List<Marque> marques) {
		this.marques = marques;
	}
	
}