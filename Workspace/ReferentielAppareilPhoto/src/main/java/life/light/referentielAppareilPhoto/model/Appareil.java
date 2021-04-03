package life.light.referentielAppareilPhoto.model;

import javax.persistence.*;

@Entity
public class Appareil {

    @Id
    @GeneratedValue
    private int id;

    private int modeEmploie;
    private int modele;
    @ManyToOne
    private TypeAppareil typeAppareil;

    public Appareil(){

    }

    public Appareil(int id, int modeEmploie, int modele, TypeAppareil typeAppareil) {
        this.id = id;
        this.modeEmploie = modeEmploie;
        this.modele = modele;
        this.typeAppareil = typeAppareil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getModeEmploie() {
        return modeEmploie;
    }

    public void setModeEmploie(int modeEmploie) {
        this.modeEmploie = modeEmploie;
    }

    public int getModele() {
        return modele;
    }

    public void setModele(int modele) {
        this.modele = modele;
    }

    public TypeAppareil getTypeAppareil() {
        return typeAppareil;
    }

    public void setTypeAppareil(TypeAppareil typeAppareil) {
        this.typeAppareil = typeAppareil;
    }

    @Override
    public String toString() {
        return "Appareil{" +
                "id=" + id +
                ", modeEmploie=" + modeEmploie +
                ", modele=" + modele +
                ", NomTypeAppareil=" + typeAppareil.getNom() +
                '}';
    }
}
