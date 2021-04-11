package life.light.referentielAppareilPhoto.model;

import javax.persistence.*;
import java.io.File;

@Entity
public class Appareil {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Modele modele;
    @ManyToOne
    private TypeAppareil typeAppareil;
    private File modeEmploie;
    private File photo;

    public Appareil(){

    }

    public Appareil(int id, Modele modele, TypeAppareil typeAppareil, File modeEmploie, File photo) {
        this.id = id;
        this.modele = modele;
        this.typeAppareil = typeAppareil;
        this.modeEmploie = modeEmploie;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public TypeAppareil getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(TypeAppareil typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    public File getModeEmploie() { return modeEmploie; }

    public void setModeEmploie(File modeEmploie) { this.modeEmploie = modeEmploie; }

    public File getPhoto() { return photo; }

    public void setPhoto(File photo) { this.photo = photo; }

    @Override
    public String toString() {
        return "Appareil{" +
                "id=" + id +
                ", modele=" + modele +
                ", NomTypeAppareil=" + typeAppareil.getNom() +
                ", NomModele=" + modele.getNom() +
                '}';
    }
}
