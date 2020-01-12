package life.light.referentielAppareilPhoto.dao;

import life.light.referentielAppareilPhoto.model.Appareil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppareilDao extends JpaRepository<Appareil, Integer> {

    Appareil findById(int id);
    List<Appareil> findByModele(int modeleId);

}
