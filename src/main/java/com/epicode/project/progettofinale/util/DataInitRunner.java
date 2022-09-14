package com.epicode.project.progettofinale.util;

import com.epicode.project.progettofinale.model.Comune;
import com.epicode.project.progettofinale.model.Provincia;
import com.epicode.project.progettofinale.repository.ComuneRepository;
import com.epicode.project.progettofinale.repository.ProvinciaRepository;
import com.opencsv.CSVReader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.Optional;

@Component
@Slf4j
public class DataInitRunner implements CommandLineRunner {
    @Autowired
    private ProvinciaRepository provinciaRep;

    @Autowired
    private ComuneRepository comuneRep;

    @Override
    public void run(String... args) throws Exception {
    loadProvincia();
    log.info("Province caricate");
    loadComune();
    log.info("Comuni Caricati");
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
}
