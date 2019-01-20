package life.light.common.bean;

import java.io.File;

public class Appareil {

	private Integer id;
	private byte[] photo;
	private File image;
	private String urlPhoto;
	private String nomFichierPhoto;
	private byte[] modeEmploie;
	private File pdf;
	private String urlModeEmploie;
	private String nomFichierModeEmploie;
	private Type type;
	private Modele modele;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	public File getImage() {
		return image;
	}
	public void setImage(File image) {
		this.image = image;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public String getNomFichierPhoto() {
		return nomFichierPhoto;
	}
	public void setNomFichierPhoto(String nomFichierPhoto) {
		this.nomFichierPhoto = nomFichierPhoto;
	}
	public byte[] getModeEmploie() {
		return modeEmploie;
	}
	public void setModeEmploie(byte[] modeEmploie) {
		this.modeEmploie = modeEmploie;
	}
	public File getPdf() {
		return pdf;
	}
	public void setPdf(File pdf) {
		this.pdf = pdf;
	}
	public String getUrlModeEmploie() {
		return urlModeEmploie;
	}
	public void setUrlModeEmploie(String urlModeEmploie) {
		this.urlModeEmploie = urlModeEmploie;
	}
	public String getNomFichierModeEmploie() {
		return nomFichierModeEmploie;
	}
	public void setNomFichierModeEmploie(String nomFichierModeEmploie) {
		this.nomFichierModeEmploie = nomFichierModeEmploie;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public Modele getModele() {
		return modele;
	}
	public void setModele(Modele modele) {
		this.modele = modele;
	}	
}
