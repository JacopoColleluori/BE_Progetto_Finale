package com.epicode.project.progettofinale;

import com.epicode.project.progettofinale.model.*;
import com.epicode.project.progettofinale.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class FatturaControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    FatturaRepository fatturaRepository;
    @Autowired
    IndirizzoRepository indirizzoRepository;
    @Autowired
    TipoRepository tipoRepository;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    StatoRepository statoRepository;

    Cliente c1 = new Cliente();
    Cliente c2 = new Cliente();

    @BeforeEach
    public void contextInit() {
        log.info("Inizio Test Fattura");

        Stato stato1 = new Stato();
        stato1.setNome("Pagato");

        Stato stato2 = new Stato();
        stato2.setNome("Non pagato");

        Tipo tipo = new Tipo();
        tipo.setTipo(EnumTipo.PA);

        tipoRepository.save(tipo);
        statoRepository.save(stato1);
        statoRepository.save(stato2);

        Indirizzo i1 = new Indirizzo();
        i1.setCap("64025");
        i1.setCivico(13);
        i1.setLocalita("Teramo");
        i1.setVia("Via Marsala Rossa");

        Indirizzo i2 = new Indirizzo();
        i2.setCap("00001");
        i2.setCivico(64);
        i2.setLocalita("Ancona");
        i2.setVia("Via Della Vergogna");

        indirizzoRepository.save(i1);
        indirizzoRepository.save(i2);


        Fattura f1 = new Fattura();
        f1.setAnno(2022);
        f1.setData(LocalDate.parse("2022-06-09"));
        f1.setImporto(BigDecimal.valueOf(13589.99));
        f1.setNumero(128);
        f1.setStato(stato1);

        Fattura f2 = new Fattura();
        f2.setAnno(2021);
        f2.setData(LocalDate.parse("2022-02-13"));
        f2.setImporto(BigDecimal.valueOf(6523.65));
        f2.setNumero(598);
        f2.setStato(stato2);

        fatturaRepository.save(f1);

        List<Fattura> fatture = new ArrayList<>();
        fatture.add(f2);
        fatture.add(f1);


        c2.setCognomeContatto("Lennon");
        c2.setDataInserimento(LocalDate.parse("2022-06-13"));
        c2.setDataUltimoContatto(LocalDate.parse("2022-09-17"));
        c2.setEmail("hello@gmail.com");
        c2.setEmailContatto("lennon.jhon@gmail.com");
        c2.setFatturatoAnnuale(25000l);
        c2.setNomeContatto("Jhon");
        c2.setPartitaIva(69852231452l);
        c2.setPec("Beatles@pec.com");
        c2.setRagioneSociale("Paulo");
        c2.setSedeLegale(i1);
        c2.setSedeOperativa(i2);
        c2.setTelefono(36985301l);
        c2.setTelefonoContatto(33863221565l);
        c2.setTipo(tipo);

        c1.setCognomeContatto("Rossi");
        c1.setDataInserimento(LocalDate.parse("2022-06-07"));
        c1.setDataUltimoContatto(LocalDate.parse("2019-11-11"));
        c1.setEmail("ubisoft.contact@gmail.com");
        c1.setEmailContatto("marco.rossi@gmail.com");
        c1.setFatturatoAnnuale(100000000000l);
        c1.setFatture(fatture);
        c1.setNomeContatto("Marco");
        c1.setPartitaIva(361812121l);
        c1.setPec("ubisoft.contact@pec.com");
        c1.setRagioneSociale("Ubisoft");
        c1.setSedeLegale(i1);
        c1.setSedeOperativa(i2);
        c1.setTelefono(365654121l);
        c1.setTelefonoContatto(054632102151l);
        c1.setTipo(tipo);
        clienteRepository.save(c1);
        clienteRepository.save(c2);

        log.info("Fine Prova Fatture");
    }

    @Test
    @WithAnonymousUser
    public void getAllFatture() throws Exception {
        this.mockMvc.perform(get("/api/fattura/getAll")).andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void listaClientiWhenUtenteMockIsAuthenticated() throws Exception {
        this.mockMvc.perform(get("/api/fattura/getAll")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void deleteStudent() throws Exception {
        this.mockMvc.perform(delete("/api/fattura/delete/1")).andExpect(status().isAccepted());
    }
    @Test
    @WithMockUser(username = "user", password = "user", roles = "USER")
    public void deleteStudentNonAutorizzato() throws Exception {
        this.mockMvc.perform(delete("/api/fattura/delete/1")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void listaFatturePerRagioneSociale() throws Exception {
        this.mockMvc.perform(get("/api/fattura/filterByCliente/Paulo")).andExpect(status().isNotFound());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN")
    public void listaFatturePerData() throws Exception {
        this.mockMvc.perform(get("/api/fattura/filterByData/2020-04-04")).andExpect(status().isOk());
    }


}