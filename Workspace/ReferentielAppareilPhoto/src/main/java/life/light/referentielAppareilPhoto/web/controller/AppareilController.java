package life.light.referentielAppareilPhoto.web.controller;

import life.light.referentielAppareilPhoto.dao.AppareilDao;
import life.light.referentielAppareilPhoto.model.Appareil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppareilController {

    @Autowired
    private AppareilDao appareilDao;

    @RequestMapping(value = "/Appareil", method = RequestMethod.GET)
    public List<Appareil> listeAppareil(){
        return appareilDao.findAll();
    }

    @RequestMapping(value = "/Appareil/{id}")
    public Appareil afficherUnAppareil(@PathVariable int id) {
        return appareilDao.findById(id);
    }
}
