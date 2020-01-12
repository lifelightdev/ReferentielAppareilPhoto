package life.light.referentielAppareilPhoto.web.controller;

import life.light.referentielAppareilPhoto.dao.AppareilDao;
import life.light.referentielAppareilPhoto.model.Appareil;
import life.light.referentielAppareilPhoto.web.exceptions.AppareilIntrouvableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;
import java.net.URI;

@RestController
public class AppareilController {

    @Autowired
    private AppareilDao appareilDao;

    // Récupére la liste des appareils photo
    @RequestMapping(value = "/Appareil", method = RequestMethod.GET)
    public Iterable<Appareil> listeAppareil(){
        return appareilDao.findAll();
    }

    // Récupére un appareil photo par Id
    @RequestMapping(value = "/Appareil/{id}")
    public Appareil afficherUnAppareil(@PathVariable int id) throws AppareilIntrouvableException {
        Appareil appareil = appareilDao.findById(id);
        if (appareil == null) {
            throw new AppareilIntrouvableException("L'appareil photo " + id + " est introuvable.");
        }
        return appareil;
    }

    // Récupére les appareils d'un modéle
    @RequestMapping(value = "/AppareilByModele/{id}")
    public List<Appareil> listeAppareilParModele(@PathVariable int id) {
        return appareilDao.findByModele(id);
    }

    // Ajoute un appareil photo
    @PostMapping(value = "/Appareil")
    public ResponseEntity<Void> ajouterAppareil(@RequestBody Appareil appareil){
        Appareil appareilAjouter = appareilDao.save(appareil);
        if (appareilAjouter == null){
            return ResponseEntity.noContent().build();
        }
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(appareilAjouter.getId())
                .toUri();

        return  ResponseEntity.created(location).build();
    }

    // Mise à jour d'un appareil photo
    @PutMapping (value = "/Appareil" )
    public void updateAppareil(@RequestBody Appareil appareil){
        appareilDao.save(appareil);
    }
}
