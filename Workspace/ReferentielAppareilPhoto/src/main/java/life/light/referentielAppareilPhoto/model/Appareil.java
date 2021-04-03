package life.light.referentielAppareilPhoto.model;

import javax.persistence.*;

@Entity
public class Appareil {

    @Id
    @GeneratedValue
    private int id;

    private int modeEmploie;
    @ManyToOne
    private Modele modele;
    @ManyToOne
    private TypeAppareil typeAppareil;

    public Appareil(){

    }

    public Appareil(int id, int modeEmploie, Modele modele, TypeAppareil typeAppareil) {
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

    @Override
    public String toString() {
        return "Appareil{" +
                "id=" + id +
                ", modeEmploie=" + modeEmploie +
                ", modele=" + modele +
                ", NomTypeAppareil=" + typeAppareil.getNom() +
                ", NomModele=" + modele.getNom() +
                '}';
    }
}
