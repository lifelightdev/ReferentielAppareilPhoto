package life.light.common.form;

import java.util.List;

import org.apache.struts.action.ActionForm;

import life.light.common.bean.Modele;
import life.light.common.bean.Type;

public class AppareilForm extends ActionForm {

	private int idAppareil;

	private int idModele;
	private Modele modele;
	private List<Modele> modeles;

	private int idType;
	private Type type;
	private List<Type> types;

	public AppareilForm() {
		super();
	}

	public int getIdAppareil() {
		return idAppareil;
	}

	public void setIdAppareil(int idAppareil) {
		this.idAppareil = idAppareil;
	}

	public int getIdModele() {
		return idModele;
	}

	public void setIdModele(int idModele) {
		this.idModele = idModele;
	}

	public Modele getModele() {
		return modele;
	}

	public void setModele(Modele modele) {
		this.modele = modele;
	}

	public List<Modele> getModeles() {
		return modeles;
	}

	public void setModeles(List<Modele> modeles) {
		this.modeles = modeles;
	}

	public int getIdType() {
		return idType;
	}

	public void setIdType(int idType) {
		this.idType = idType;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public List<Type> getTypes() {
		return types;
	}

	public void setTypes(List<Type> types) {
		this.types = types;
	}

}