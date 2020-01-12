package life.light.referentielAppareilPhoto.dao;

import life.light.referentielAppareilPhoto.model.Appareil;

import java.util.List;

public interface AppareilDao {
    public List<Appareil> findAll();
    public Appareil findById(int id);
    public Appareil save(Appareil appareil);

}
