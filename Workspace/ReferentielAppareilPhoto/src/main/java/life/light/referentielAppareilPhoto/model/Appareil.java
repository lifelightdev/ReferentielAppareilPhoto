package life.light.referentielAppareilPhoto.model;

public class Appareil {

    private int id;
    private int modeEmploie;
    private int modele;

    public Appareil(){

    }

    public Appareil(int id, int modeEmploie, int modele) {
        this.id = id;
        this.modeEmploie = modeEmploie;
        this.modele = modele;
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

    @Override
    public String toString() {
        return "Appareil{" +
                "id=" + id +
                ", modeEmploie=" + modeEmploie +
                ", modele=" + modele +
                '}';
    }
}
