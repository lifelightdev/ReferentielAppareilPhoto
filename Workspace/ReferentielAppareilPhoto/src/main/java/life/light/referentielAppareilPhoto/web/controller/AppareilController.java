package life.light.referentielAppareilPhoto.web.controller;

import life.light.referentielAppareilPhoto.dao.AppareilDao;
import life.light.referentielAppareilPhoto.model.Appareil;
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

    // Récupérer la liste des appareils photo
    @RequestMapping(value = "/Appareil", method = RequestMethod.GET)
    public List<Appareil> listeAppareil(){
        return appareilDao.findAll();
    }

    // Récupérer un appareil photo par Id
    @RequestMapping(value = "/Appareil/{id}")
    public Appareil afficherUnAppareil(@PathVariable int id) {
        return appareilDao.findById(id);
    }

    // Ajouter un appareil photo
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
}
