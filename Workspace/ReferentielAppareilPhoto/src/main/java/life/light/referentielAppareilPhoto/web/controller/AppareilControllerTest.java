package life.light.referentielAppareilPhoto.web.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class AppareilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void listeAppareil() throws Exception {
        this.mockMvc.perform(get("/Appareil")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"modeEmploie\":1,\"modele\":1},{\"id\":2,\"modeEmploie\":2,\"modele\":2},{\"id\":3,\"modeEmploie\":1,\"modele\":3}]")));
    }

    @Test
    void afficherUnAppareil() throws Exception {
        this.mockMvc.perform(get("/AppareilByModele/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"modeEmploie\":1,\"modele\":1}]")));
    }

    @Test
    void listeAppareilParModele() throws Exception {
        this.mockMvc.perform(get("/AppareilByModele/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("[{\"id\":1,\"modeEmploie\":1,\"modele\":1}]")));
    }

}
