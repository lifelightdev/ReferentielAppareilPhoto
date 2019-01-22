package life.light.common.form;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

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
	
	private FormFile photo;	
	private String urlPhoto;
	
	private FormFile modeEmploie;
	private String urlModeEmploie;
	
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
	public FormFile getPhoto() {
		return photo;
	}
	public void setPhoto(FormFile photo) {
		this.photo = photo;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public FormFile getModeEmploie() {
		return modeEmploie;
	}
	public void setModeEmploie(FormFile modeEmploie) {
		this.modeEmploie = modeEmploie;
	}
	public String getUrlModeEmploie() {
		return urlModeEmploie;
	}
	public void setUrlModeEmploie(String urlModeEmploie) {
		this.urlModeEmploie = urlModeEmploie;
	}

	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		ActionErrors errors = new ActionErrors();

		if (getPhoto() != null) {
			if (getPhoto().getFileSize() > 0) {
				if (!"image/jpeg".equals(getPhoto().getContentType())) {
					errors.add("common.file.err.image", new ActionMessage("error.common.file.jpeg.only"));
				}
			}
		}
		
		if (getModeEmploie() != null) {
			if (getModeEmploie().getFileSize() > 0) {
				if (!"application/pdf".equals(getModeEmploie().getContentType())) {
					errors.add("common.file.err.pdf", new ActionMessage("error.common.file.pdf.only"));
				}
			}
		}

		return errors;
	}

}