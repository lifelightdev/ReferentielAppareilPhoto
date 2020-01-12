package life.light.referentielAppareilPhoto.dao;

import life.light.referentielAppareilPhoto.model.Appareil;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AppareilDaoImpl implements AppareilDao {

    public static List<Appareil> appareils = new ArrayList<>();
    static {
        appareils.add(new Appareil(1,1,1));
        appareils.add(new Appareil(2,2,2));
        appareils.add(new Appareil(3,3,3));
    }

    @Override
    public List<Appareil> findAll() {
        return appareils;
    }

    @Override
    public Appareil findById(int id) {
        // TODO : reécrir avec un stream
        for (Appareil appareil : appareils){
            if(appareil.getId() == id){
                return appareil;
            }
        }
        return null;
    }

    @Override
    public Appareil save(Appareil appareil) {
        appareils.add(appareil);
        return appareil;
    }
}
