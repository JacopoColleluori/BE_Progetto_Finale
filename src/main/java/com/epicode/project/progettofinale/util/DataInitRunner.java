package com.epicode.project.progettofinale.util;

import com.epicode.project.progettofinale.model.*;
import com.epicode.project.progettofinale.repository.*;
import com.epicode.project.progettofinale.security.model.Role;
import com.epicode.project.progettofinale.security.model.Roles;
import com.epicode.project.progettofinale.security.model.User;
import com.epicode.project.progettofinale.security.repository.RoleRepository;
import com.epicode.project.progettofinale.security.repository.UserRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@Slf4j
public class DataInitRunner implements CommandLineRunner {
    @Autowired
    private ProvinciaRepository provinciaRep;

    @Autowired
    private ComuneRepository comuneRep;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private StatoRepository statoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ComuneRepository comuneRepository;

    @Override
    public void run(String... args) throws Exception {
        initStato();
        log.info("stati inizializzati");
        initTipo();
        log.info("tipi inizializzati");
        loadUtente();
        log.info("Utenti test caricati");
        loadProvincia();
        log.info("Province caricate");
        loadComune();
        log.info("Comuni Caricati");
        loadCliente();
        log.info("Clienti caricati");

    }

    //carichiamo le province passate dal file

    private void loadProvincia() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("province-italiane.csv"));
        String[] values = null;
        csvReader.readNext();
        while ((values = csvReader.readNext()) != null) {
            Provincia prov = new Provincia();
            prov.setNome(values[1]);
            prov.setSigla(values[0]);
            prov.setRegione(values[2]);
            provinciaRep.save(prov);

        }
    }

    //carichiamo i comuni passati dal file e gli passiamo la provincia riprendendola per il suo nome

    private void loadComune() throws Exception {
        CSVReader csvReader = new CSVReader(new FileReader("comuni-italiani.csv"));
        String[] values = null;
        csvReader.readNext();

        while ((values = csvReader.readNext()) != null) {
            Optional<Provincia> prov = provinciaRep.findByNomeIgnoreCase(values[3]);

            if (prov.isPresent()) {
                Comune com = new Comune();
                com.setNomeComune(values[2]);
                com.setNomeProvincia(values[3]);
                com.setProvincia(prov.get());
                comuneRep.save(com);
            }
        }
    }

    private void loadUtente() throws Exception {
        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        Role role = new Role();
        Role role2 = new Role();

        role2.setRoleName(Roles.ROLE_USER);
        role.setRoleName(Roles.ROLE_ADMIN);

        User user = new User();
        User user2 = new User();
        Set<Role> rolesAdmin = new HashSet<>();
        Set<Role> rolesUser = new HashSet<>();
        rolesAdmin.add(role);
        rolesUser.add(role2);

        user2.setUserName("user");
        user2.setPassword(bCrypt.encode("user"));
        user2.setEmail("user@gmail.com");
        user2.setRoles(rolesUser);
        user2.setActive(true);

        user.setUserName("admin");
        user.setPassword(bCrypt.encode("admin"));
        user.setEmail("admin@domain.com");
        user.setRoles(rolesAdmin);
        user.setActive(true);

        roleRepository.save(role2);
        roleRepository.save(role);

        userRepository.save(user);
        userRepository.save(user2);
    }

    private void initStato() throws Exception {
        Stato stato1 = new Stato();
        Stato stato2 = new Stato();

        stato1.setNome("Pagato");
        stato2.setNome("Non pagato");

        statoRepository.save(stato1);
        statoRepository.save(stato2);

    }

    private void initTipo() throws Exception {
        Tipo tipo1 = new Tipo();
        Tipo tipo2 = new Tipo();
        Tipo tipo3 = new Tipo();
        Tipo tipo4 = new Tipo();

        tipo1.setTipo(EnumTipo.PA);
        tipo2.setTipo(EnumTipo.SAS);
        tipo3.setTipo(EnumTipo.SPA);
        tipo4.setTipo(EnumTipo.SRL);

        tipoRepository.save(tipo1);
        tipoRepository.save(tipo2);
        tipoRepository.save(tipo3);
        tipoRepository.save(tipo4);

    }



    private void loadCliente() throws Exception {
        //creazione indirizzo
        Indirizzo i1 = new Indirizzo();
        i1.setCap("64025");
        i1.setCivico(25);
        i1.setLocalita("Pescara");
        i1.setVia("via Brombei");
        i1.setComune(comuneRepository.findByNomeComuneIgnoreCase("Pescara").get());

        Indirizzo i2 = new Indirizzo();
        i2.setCap("64030");
        i2.setCivico(60);
        i2.setLocalita("Teramo");
        i2.setVia("Via Marco Rossi");
        i2.setComune(comuneRepository.findByNomeComuneIgnoreCase("Teramo").get());

        Indirizzo i3 = new Indirizzo();
        i3.setCap("50489");
        i3.setCivico(180);
        i3.setLocalita("Agliè");
        i3.setVia("Via Giuseppe Verdi");
        i3.setComune(comuneRepository.findById(1l).get());

        //creazione cliente
        Cliente c1 = new Cliente();
        c1.setCognomeContatto("Pringles");
        c1.setDataInserimento(LocalDate.parse("2022-06-13"));
        c1.setDataUltimoContatto(LocalDate.parse("2022-11-17"));
        c1.setEmail("pringles.taste@gmail.com");
        c1.setEmailContatto("pringlesMan@gmail.com");
        c1.setFatturatoAnnuale(1500000l);
        c1.setNomeContatto("Marco");
        c1.setPartitaIva(12893542384l);
        c1.setPec("pringles@pec.com");
        c1.setRagioneSociale("Pringles");
        c1.setSedeLegale(i1);
        c1.setSedeOperativa(i2);
        c1.setTelefono(3678869087l);
        c1.setTelefonoContatto(33375911l);
        c1.setTipo(tipoRepository.findById(4l).get());

        Cliente c2 = new Cliente();
        c2.setCognomeContatto("Rossi");
        c2.setDataInserimento(LocalDate.parse("2021-06-07"));
        c2.setDataUltimoContatto(LocalDate.parse("2021-12-24"));
        c2.setEmail("riot.business@gmail.com");
        c2.setEmailContatto("marco.rossi@gmail.com");
        c2.setFatturatoAnnuale(1500000l);
        c2.setNomeContatto("\"Marco");
        c2.setPartitaIva(45893542384l);
        c2.setPec("riot@pec.com");
        c2.setRagioneSociale("Riot");
        c2.setSedeLegale(i3);
        c2.setSedeOperativa(i3);
        c2.setTelefono(3337869087l);
        c2.setTelefonoContatto(3333713921l);
        c2.setTipo(tipoRepository.findById(2l).get());

        clienteRepository.save(c1);
        clienteRepository.save(c2);
    }

}
