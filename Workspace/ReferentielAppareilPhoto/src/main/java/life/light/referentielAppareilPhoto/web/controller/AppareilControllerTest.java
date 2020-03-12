package life.light.referentielAppareilPhoto.web.controller;

import life.light.referentielAppareilPhoto.dao.AppareilDao;
import life.light.referentielAppareilPhoto.model.Appareil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

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
        this.mockMvc.perform(get("/Appareil")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[]")));
 }

    @Test
    void afficherUnAppareil() throws Exception {
        Appareil appareil = new Appareil(1,1,1);
        when(appareilDao.findById(1)).thenReturn(appareil);
        this.mockMvc.perform(get("/Appareil/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("{\"id\":1,\"modeEmploie\":1,\"modele\":1}")));
    }

    @Test
    void listeAppareilParModele() throws Exception {
        List<Appareil> listeAppareil = new ArrayList<>();
        Appareil appareil = new Appareil(1,1,1);
        listeAppareil.add(appareil);
        when(appareilDao.findByModele(1)).thenReturn(listeAppareil);
        this.mockMvc.perform(get("/AppareilByModele/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"modeEmploie\":1,\"modele\":1}]")));
    }

    @Autowired
    private AppareilController controller;

    @Test
    public void contexLoads() {
        assertThat(controller).isNotNull();
    }

}
