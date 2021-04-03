package life.light.referentielAppareilPhoto.web.controller;

import life.light.referentielAppareilPhoto.dao.AppareilDao;
import life.light.referentielAppareilPhoto.model.Appareil;
import life.light.referentielAppareilPhoto.model.Marque;
import life.light.referentielAppareilPhoto.model.Modele;
import life.light.referentielAppareilPhoto.model.TypeAppareil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;

@WebMvcTest(AppareilController.class)
class AppareilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AppareilDao appareilDao;

    @Test
    void listeAppareil() throws Exception {
        List<Appareil> listeAppareil = new ArrayList<>();
        when(appareilDao.findAll()).thenReturn(listeAppareil);
        this.mockMvc.perform(get("/appareil")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
 }

    @Test
    void afficherUnAppareil() throws Exception {
        TypeAppareil typeAppareil = new TypeAppareil();
        typeAppareil.setId(1);
        typeAppareil.setNom("Argentique");
        Marque marque = new Marque();
        marque.setId(1);
        marque.setNom("Hasselblad");
        Modele modele = new Modele();
        modele.setId(1);
        modele.setNom("500CM");
        modele.setMarque(marque);
        Appareil appareil = new Appareil(1,1,modele,typeAppareil);
        when(appareilDao.findById(1)).thenReturn(appareil);
        this.mockMvc.perform(get("/Appareil/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"modeEmploie\":1,\"modele\":{\"id\":1,\"nom\":\"500CM\",\"marque\":{\"id\":1,\"nom\":\"Hasselblad\"}},\"typeAppareil\":{\"id\":1,\"nom\":\"Argentique\"}}")));
    }

    @Test
    void listeAppareilParModele() throws Exception {
        List<Appareil> listeAppareil = new ArrayList<>();
        TypeAppareil typeAppareil = new TypeAppareil();
        typeAppareil.setId(1);
        typeAppareil.setNom("Argentique");
        Marque marque = new Marque();
        marque.setId(1);
        marque.setNom("Hasselblad");
        Modele modele = new Modele();
        modele.setId(1);
        modele.setNom("500CM");
        modele.setMarque(marque);
        Appareil appareil = new Appareil(1,1,modele,typeAppareil);
        listeAppareil.add(appareil);
        when(appareilDao.findByModele(1)).thenReturn(listeAppareil);
        this.mockMvc.perform(get("/AppareilByModele/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"modeEmploie\":1,\"modele\":{\"id\":1,\"nom\":\"500CM\",\"marque\":{\"id\":1,\"nom\":\"Hasselblad\"}},\"typeAppareil\":{\"id\":1,\"nom\":\"Argentique\"}}]")));
    }

    @Autowired
    private AppareilController controller;

    @Test
    public void contexLoads() {
        assertThat(controller).isNotNull();
    }

}
