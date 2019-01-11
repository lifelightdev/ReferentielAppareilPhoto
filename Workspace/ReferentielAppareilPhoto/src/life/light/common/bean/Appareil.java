package life.light.common.bean;

public class Appareil {

	private Integer id;
	private byte[] photo;
	private byte[] modeEmploie;
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

	public byte[] getModeEmploie() {
		return modeEmploie;
	}

	public void setModeEmploie(byte[] modeEmploie) {
		this.modeEmploie = modeEmploie;
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
